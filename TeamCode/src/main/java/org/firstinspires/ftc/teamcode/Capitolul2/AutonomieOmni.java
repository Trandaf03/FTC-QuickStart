package org.firstinspires.ftc.teamcode.Capitolul2;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Disabled
@Autonomous(name="AutonomiBLUE",group = "Autonomie Completa")
public class AutonomieOmni extends LinearOpMode {

    RobotOmni costel = new RobotOmni();

    @Override
    public void runOpMode() throws InterruptedException {

        costel.init(hardwareMap);

        waitForStart();
        if(opModeIsActive()){}
        costel.skystone.setPosition(1);
        moveForwardBackward(3500,1);

        sleep(500);
        if(costel.senzsk.red() < 37 && costel.senzsk.green() < 60&& costel.senzsk.blue() < 50 && costel.senzsk.alpha() < 152)
        {
            moveForwardBackward(450,0.5);
            costel.skystone.setPosition(0.5);
            moveForwardBackward(-1100,0.75);
            moveLeftRight(5000,1);
            costel.skystone.setPosition(1);
            sleep(250);
            moveLeftRight(-7150,1);
            moveForwardBackward(1500,0.5);
            sleep(500);
            costel.skystone.setPosition(0.5);
            moveForwardBackward(-1200,1);
            moveLeftRight(7600,1);
            costel.skystone.setPosition(1);
            moveLeftRight(-2000,1);

        }
        else{
            moveLeftRight(-800,0.5);
            sleep(500);
            if(costel.senzsk.red() < 35 && costel.senzsk.green() < 55 && costel.senzsk.blue() < 47){
                //                   49                             62                          51                            165
                moveForwardBackward(1000,0.5);
                costel.skystone.setPosition(0.5);
                moveForwardBackward(-1700,1);
                moveLeftRight(5000,1);
                costel.skystone.setPosition(1);
                sleep(250);
                moveLeftRight(-7200,1);
                moveForwardBackward(1300,0.5);
                sleep(500);
                costel.skystone.setPosition(0.5);
                moveForwardBackward(-2000,1);
                moveLeftRight(7600,1);
                costel.skystone.setPosition(1);
                moveLeftRight(-2000,1);
            } else
            {
                moveLeftRight(-800,0.5);
                moveForwardBackward(500,0.5);
                sleep(150);
                costel.skystone.setPosition(0.5);
                sleep(500);
                moveForwardBackward(-1500,1);
                moveLeftRight(6000,1);
                costel.skystone.setPosition(1);
                sleep(250);
                moveLeftRight(-2000,1);
            }

        }

    }


    private void moveForwardBackward(int distance, double speed) throws InterruptedException {
        Thread.sleep(100);
        costel.backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        costel.backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        costel.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        costel.frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Thread.sleep(100);
        costel.backLeft.setTargetPosition(-distance);
        costel.backRight.setTargetPosition(-distance);
        costel.frontRight.setTargetPosition(-distance);
        costel.frontLeft.setTargetPosition(-distance);

        costel.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        costel.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        costel.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        costel.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        costel.backRight.setPower(speed);
        costel.backLeft.setPower(speed);
        costel.frontLeft.setPower(speed);
        costel.frontRight.setPower(speed);

        while (costel.backLeft.isBusy() && costel.backRight.isBusy() && costel.frontRight.isBusy() && costel.frontLeft.isBusy()){

        }
        telemetry.clearAll();

        costel.backLeft.setPower(0);
        costel.backRight.setPower(0);
        costel.frontLeft.setPower(0);
        costel.frontRight.setPower(0);

        costel.backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        costel.backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        costel.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        costel.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }
    private void moveLeftRight(int distance, double speed) throws InterruptedException {
        Thread.sleep(100);
        costel.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        costel.backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        costel.frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        costel.backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        Thread.sleep(100);

        costel.frontRight.setTargetPosition(-distance);
        costel.backLeft.setTargetPosition(-distance);
        costel.frontLeft.setTargetPosition(distance);
        costel.backRight.setTargetPosition(distance);

        costel.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        costel.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        costel.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        costel.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        costel.backRight.setPower(speed);
        costel.backLeft.setPower(speed);
        costel.frontLeft.setPower(speed);
        costel.frontRight.setPower(speed);

        while (costel.backLeft.isBusy() && costel.backRight.isBusy() && costel.frontRight.isBusy() && costel.frontLeft.isBusy()) {

        }

        costel.backLeft.setPower(0);
        costel.backRight.setPower(0);
        costel.frontLeft.setPower(0);
        costel.frontRight.setPower(0);

        costel.backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        costel.backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        costel.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        costel.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    private void rotatie(int distance, double speed) throws InterruptedException {
        Thread.sleep(100);
        costel.frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        costel.backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        costel.frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        costel.backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        Thread.sleep(100);
        costel.frontRight.setTargetPosition(distance);
        costel.backLeft.setTargetPosition(-distance);
        costel.frontLeft.setTargetPosition(-distance);
        costel.backRight.setTargetPosition(distance);

        costel.backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        costel.backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        costel.frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        costel.frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        costel.backRight.setPower(speed);
        costel.backLeft.setPower(-speed);
        costel.frontLeft.setPower(-speed);
        costel.frontRight.setPower(speed);

        while (costel.backLeft.isBusy() && costel.backRight.isBusy() && costel.frontRight.isBusy() && costel.frontLeft.isBusy()) {

        }

        costel.backLeft.setPower(0);
        costel.backRight.setPower(0);
        costel.frontLeft.setPower(0);
        costel.frontRight.setPower(0);

        costel.backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        costel.backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        costel.frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        costel.frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
