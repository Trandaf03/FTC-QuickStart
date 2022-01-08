package org.firstinspires.ftc.teamcode.Capitolul3;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Disabled
@TeleOp(name = "TeleOpMecanum")
public class teleOpMecanum extends LinearOpMode {

    robotMecanum robot = new robotMecanum();

    @Override
    public void runOpMode() throws InterruptedException {

        robot.initializare(hardwareMap);

        waitForStart();
        while(opModeIsActive() && !isStopRequested()){

            robot.robotMovement(this.gamepad1.left_stick_x,this.gamepad1.left_stick_y,this.gamepad1.right_stick_x);

        }

    }
}
