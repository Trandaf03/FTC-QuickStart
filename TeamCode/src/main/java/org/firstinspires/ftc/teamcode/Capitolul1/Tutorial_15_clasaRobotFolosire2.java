package org.firstinspires.ftc.teamcode.Capitolul1;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Capitolul1.Tutorial_15_clasaRobot;

/**
 * Pentru a vedea cu adevarat dimensiunea codului, am scos comentariile de la ultima clasa
 * */
@Disabled
@TeleOp
public class Tutorial_15_clasaRobotFolosire2 extends LinearOpMode {

    Tutorial_15_clasaRobot robot = new Tutorial_15_clasaRobot();

    @Override
    public void runOpMode() throws InterruptedException {

        robot.initializare(hardwareMap);


        // in acest moment avem robotul deja declarat si initializat, putem sa incepem programarea!
        waitForStart();
        while(opModeIsActive()){

        }
    }
}


/**
 * Vedeti? In acet moment am folosit clasaRobot in 2 alte clase: deci am evitat posibile greseli de copiere, si am economisit si timp
 *
 * Cam atat au fot cu tutorialele basic, incep cele mai complicate :)
 * */