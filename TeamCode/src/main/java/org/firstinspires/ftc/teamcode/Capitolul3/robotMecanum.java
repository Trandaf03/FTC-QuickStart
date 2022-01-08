package org.firstinspires.ftc.teamcode.Capitolul3;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Disabled
public class robotMecanum {

    private double     COUNTS_PER_MOTOR_REV    = 386.2 ;    // Cate tics face un motor pe o singura revolutie
    private double     DRIVE_GEAR_REDUCTION    = 1 ;       // Reductia roata/motor     !Atentie, reductia motorului nu se pune!
    private double     WHEEL_DIAMETER_CM  = 10.0 ;     // Diametrul rotii, in centimetrii
    private  double     COUNTS_PER_CM        = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_CM * 3.1415);

    private DcMotor stangaFata = null;
    private DcMotor stangaSpate = null;
    private DcMotor dreaptaFata = null;
    private DcMotor dreaptaSpate = null;

    // functia de initializare
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
    }


    /**
     * O functie prin care, pe stick-ul din stanga, putem sa controlam sasiul mecanum in orice directie posibila.
     * Din stick-ul din dreapta se realizeaza rotatia stanga/dreapta.
     * */
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

    /**
     * Functii cu encodere de mers fata/spate si stanga/dreapta, deoarece difera distantele parcurse de motoare.
     * Cea mai usoara metoda de a rezolva asta a fost sa facem 2 functii diferite pentru aceste 2 tipuri de deplasari.
     * */
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


    // functie de oprit robotul
    public void stopRobot(){
        stangaFata.setPower(0);
        stangaSpate.setPower(0);
        dreaptaFata.setPower(0);
        dreaptaSpate.setPower(0);
    }
}
