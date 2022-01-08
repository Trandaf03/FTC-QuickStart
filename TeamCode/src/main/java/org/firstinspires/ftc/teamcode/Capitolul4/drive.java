package org.firstinspires.ftc.teamcode.Capitolul4;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

public class drive {

    private double     COUNTS_PER_MOTOR_REV    = 386.2 ;    // Cate tics face un motor pe o singura revolutie
    private double     DRIVE_GEAR_REDUCTION    = 1 ;       // Reductia roata/motor     !Atentie, reductia motorului nu se pune!
    private double     WHEEL_DIAMETER_CM  = 10.0 ;     // Diametrul rotii, in centimetrii
    private  double     COUNTS_PER_CM        = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_CM * 3.1415);

    private DcMotor stangaFata = null;
    private DcMotor stangaSpate = null;
    private DcMotor dreaptaFata = null;
    private DcMotor dreaptaSpate = null;

    // imuSensor
    private BNO055IMU imuSensor;
    private Orientation grade;
    private double globalAngle;

    public void initializare(HardwareMap hardwareMap){

        stangaFata = hardwareMap.get(DcMotor.class,"stangaFata");
        stangaSpate = hardwareMap.get(DcMotor.class,"stangaSpate");
        dreaptaFata = hardwareMap.get(DcMotor.class,"dreaptaFata");
        dreaptaSpate = hardwareMap.get(DcMotor.class,"dreaptaSpate");


        stangaFata.setDirection(DcMotorSimple.Direction.FORWARD);
        stangaSpate.setDirection(DcMotorSimple.Direction.FORWARD);
        dreaptaFata.setDirection(DcMotorSimple.Direction.REVERSE);
        dreaptaSpate.setDirection(DcMotorSimple.Direction.REVERSE);

        stangaFata.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        stangaSpate.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        dreaptaFata.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        dreaptaSpate.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        stangaFata.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        stangaSpate.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dreaptaFata.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dreaptaSpate.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        stangaFata.setPower(0);
        stangaSpate.setPower(0);
        dreaptaFata.setPower(0);
        dreaptaSpate.setPower(0);

        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        //parameters.calibrationDataFile = "BNO055IMUCalibration.json";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";

        imuSensor = hardwareMap.get(BNO055IMU.class, "imu");
        imuSensor.initialize(parameters);

    }

    public void robotMovement(double left_stick_x, double left_stick_y, double right_stick_x){
        double r = Math.hypot(left_stick_x, -left_stick_y);
        double robotAngle = Math.atan2(left_stick_y, -left_stick_x) - Math.PI / 4;
        double rightX = -right_stick_x;
        final double v1 = (r * Math.cos(robotAngle) + rightX);
        final double v2 = (r * Math.sin(robotAngle) - rightX);
        final double v3 = (r * Math.sin(robotAngle) + rightX);
        final double v4 = (r * Math.cos(robotAngle) - rightX);

        stangaFata.setPower(v1);
        dreaptaFata.setPower(v2);
        stangaSpate.setPower(v3);
        dreaptaSpate.setPower(v4);

    }
    public void moveForwardBackward(double distanta, double speed) throws InterruptedException {
        int distantaDeParcurs = (int)(distanta * COUNTS_PER_CM);
        stangaSpate.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        dreaptaSpate.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        dreaptaFata.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        stangaFata.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        stangaSpate.setTargetPosition(distantaDeParcurs);
        dreaptaSpate.setTargetPosition(distantaDeParcurs);
        dreaptaFata.setTargetPosition(distantaDeParcurs);
        stangaFata.setTargetPosition(distantaDeParcurs);

        stangaSpate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        dreaptaSpate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        dreaptaFata.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        stangaFata.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        stangaSpate.setPower(speed);
        dreaptaSpate.setPower(speed);
        dreaptaFata.setPower(speed);
        stangaFata.setPower(speed);

        while (stangaSpate.isBusy() && dreaptaSpate.isBusy() && dreaptaFata.isBusy() && stangaFata.isBusy()){

        }

        stangaSpate.setPower(0);
        dreaptaSpate.setPower(0);
        stangaFata.setPower(0);
        dreaptaFata.setPower(0);

        stangaSpate.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dreaptaSpate.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dreaptaFata.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        stangaFata.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void moveLeftRight(double distanta, double speed) throws InterruptedException {

        int distantaDeParcurs = (int)(distanta * COUNTS_PER_CM);
        stangaSpate.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        dreaptaSpate.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        dreaptaFata.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        stangaFata.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        stangaSpate.setTargetPosition(-distantaDeParcurs);
        dreaptaSpate.setTargetPosition(distantaDeParcurs);
        dreaptaFata.setTargetPosition(-distantaDeParcurs);
        stangaFata.setTargetPosition(distantaDeParcurs);

        stangaSpate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        dreaptaSpate.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        dreaptaFata.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        stangaFata.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        stangaSpate.setPower(speed);
        dreaptaSpate.setPower(speed);
        dreaptaFata.setPower(speed);
        stangaFata.setPower(speed);

        while (stangaSpate.isBusy() && dreaptaSpate.isBusy() && dreaptaFata.isBusy() && stangaFata.isBusy()){

        }

        stangaSpate.setPower(0);
        dreaptaSpate.setPower(0);
        stangaFata.setPower(0);
        dreaptaFata.setPower(0);

        stangaSpate.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dreaptaSpate.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dreaptaFata.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        stangaFata.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void stopRobot(){
        stangaFata.setPower(0);
        stangaSpate.setPower(0);
        dreaptaFata.setPower(0);
        dreaptaSpate.setPower(0);
    }
    public void resetAngle() {
        grade = imuSensor.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);
        globalAngle = 0;
    }
    public double getAngle() {

        Orientation angles = imuSensor.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.XYZ, AngleUnit.DEGREES);

        double gradeAici = angles.firstAngle - grade.firstAngle;
        if (gradeAici < -180)
            gradeAici += 360;
        else if (gradeAici > 180)
            gradeAici -= 360;
        globalAngle += gradeAici;
        grade = angles;
        return globalAngle;
    }
    public double checkDirection() {
        double corectie, unghi, unghi_corectie = .10;

        unghi = getAngle();

        if (unghi == 0)
            corectie = 0;
        else
            corectie = -unghi;

        corectie = corectie * unghi_corectie;
        return corectie;
    }
    public void rotatie(int degrees, double power) {

        double  lp, rp;
        resetAngle();

        if (degrees < 0)
        {   // rotire dreapta
            lp = power;
            rp = -power;
        }
        else if (degrees > 0)
        {   // rotire stanga
            lp = -power;
            rp = power;
        }
        else return;

        stangaSpate.setPower(lp);
        dreaptaSpate.setPower(rp);
        stangaFata.setPower(lp);
        dreaptaFata.setPower(rp);

        if (degrees < 0)
        {
            // rotire la dreapta
            while (getAngle() == 0) {}

            while (getAngle() > degrees) {}
        }
        else   // rotire la stanga
            while (getAngle() < degrees) {}


        stopRobot();
        resetAngle();
    }
    
}
