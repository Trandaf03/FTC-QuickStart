package org.firstinspires.ftc.teamcode.Capitolul3;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Disabled
@Autonomous (name = "Autonomie")
public class autoMecanum extends LinearOpMode {

    robotMecanum robot = new robotMecanum();

    @Override
    public void runOpMode() throws InterruptedException {

        robot.initializare(hardwareMap);

        waitForStart();
        if(opModeIsActive());

        //fie o autonomie in care mergem 10cm in fata cu puterea 1, 20 la dreapta cu 0.5, 100 in spate cu 1, 40 la stanga cu 0.4

        robot.moveForwardBackward(10,1);
        robot.moveLeftRight(20,0.5);
        robot.moveForwardBackward(-100,1);
        robot.moveLeftRight(-40,0.4);

        robot.stopRobot();
    }
}
