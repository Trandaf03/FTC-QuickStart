package org.firstinspires.ftc.teamcode.Capitolul2;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp(name = "TeleOpOmni")
public class TeleOpOmni extends LinearOpMode {

    public RobotOmni costel = new RobotOmni();
    double speedCutie = 1;
    @Override
    public void runOpMode() throws InterruptedException {
        costel.init(hardwareMap);


        waitForStart();
        while(opModeIsActive() && !isStopRequested()) {

            if(gamepad1.dpad_up){ //Forward
                costel.frontLeft.setPower(-speedCutie);
                costel.backLeft.setPower(-speedCutie);
                costel.backRight.setPower(-speedCutie);
                costel.frontRight.setPower(-speedCutie);
            }
            else if(gamepad1.dpad_left){ //Left
                costel.frontLeft.setPower(speedCutie);
                costel.backLeft.setPower(-speedCutie);
                costel.backRight.setPower(speedCutie);
                costel.frontRight.setPower(-speedCutie);
            }
            else if(gamepad1.dpad_down){ //Back
                costel.frontLeft.setPower(speedCutie);
                costel.backLeft.setPower(speedCutie);
                costel.backRight.setPower(speedCutie);
                costel.frontRight.setPower(speedCutie);
            }
            else if(gamepad1.dpad_right){ //Right
                costel.frontLeft.setPower(-speedCutie);
                costel.backLeft.setPower(speedCutie);
                costel.backRight.setPower(-speedCutie);
                costel.frontRight.setPower(speedCutie);

            }
            else if(gamepad1.right_stick_x != 0){
                //Rotation
                int abcdDa = 1;
                if(this.gamepad1.right_stick_x < 0 )
                    abcdDa = -1;
                if(this.gamepad1.right_stick_x > 0)
                    abcdDa = 1;

                costel.frontLeft.setPower(-speedCutie*abcdDa);
                costel.backLeft.setPower(-speedCutie*abcdDa);
                costel.backRight.setPower(speedCutie*abcdDa);
                costel.frontRight.setPower(speedCutie*abcdDa);
            }
            else{
                costel.frontLeft.setPower(0);
                costel.backLeft.setPower(0);
                costel.backRight.setPower(0);
                costel.frontRight.setPower(0);
            }


            if (this.gamepad1.y) {
                costel.skystone.setPosition(1);
                Thread.sleep(200);
            }
            if (this.gamepad1.a) {
                costel.skystone.setPosition(0.3);
                Thread.sleep(200);
            }
            if (this.gamepad2.y) {
                costel.skystone.setPosition(1);
                Thread.sleep(200);
            }
            if (this.gamepad2.a) {
                costel.skystone.setPosition(0.3);
                Thread.sleep(200);
            }
            if (this.gamepad1.left_trigger != 0) {
                speedCutie = 0.25;
                telemetry.addData("Viteza: ", speedCutie);
                telemetry.update();
            }
            if (this.gamepad1.right_trigger != 0) {
                speedCutie = 1;
                telemetry.addData("Viteza: ", speedCutie);
                telemetry.update();
            }



        }
    }
}
