package org.firstinspires.ftc.teamcode.Capitolul4;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class simpleAutoWithGyro extends LinearOpMode {

    drive robot = new drive();


    @Override
    public void runOpMode() throws InterruptedException {
        robot.initializare(hardwareMap);

        waitForStart();
        if(opModeIsActive());

        // resetam unghiul de inceput
        robot.resetAngle();
        // mergem 100cm in fata
        robot.moveForwardBackward(100,1);
        // rotim robotul atat cat s-a miscat, daca s-a miscat, ca sa avem avelasi unghi de inceput si de sfarsit
        robot.rotatie((int) robot.checkDirection(),1);
        robot.stopRobot();


        /**
         * !Aceasta autonomie nu a fost niciodata testata, deci poate sa nu functioneze!
         * Totusi, conceptul este acesta, functiile au fost testate, strict ce se afla intre randurile
         * 20 si 25 din strict aceasta clasa nu stiu daca o sa functioneze asa cum trebuie
         * */

    }
}
