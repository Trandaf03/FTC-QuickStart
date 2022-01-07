package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 *       fata
 * {|||         |||}
 *   ||         ||
 *   ||         ||
 *st ||||||||||||| dr
 *   ||         ||
 *   ||         ||
 * {|||-(=) (=)-|||}
 *       spate
 *
 * fie robotul de mai sus, cu 4 roti (  {||| reprezinta o roata)
 * si doua motoare, motoarele fiind montate pe rotile din spate ale robotului :    {|||-(=) reprezinta o roata angrenata de un motor
 *
 *
 * Sa se creeze urmatoare autonomie:
 * -> miscare fata pentru 10 secunde cu viteza 1
 * -> rotire stanga pentru 5 secunde cu viteza 0.25
 * -> miscare spate pentru 3.5 secunde cu viteza 0.75
 * -> rotire dreapta pentru 7 secunde cu viteza 0.3
 * -> miscare fata pentru 4.5secunde cu viteza 0.9
 *
 * */

@Autonomous (name = "autoTimp1")
public class Tutorial_9_simplaAutonomiePeTimp1 extends LinearOpMode {

    // declaram motoarele pe care o sa le folosim
    DcMotor stanga = null;
    DcMotor dreapta = null;

    @Override
    public void runOpMode() throws InterruptedException {

        //intializam motoarele
        stanga = hardwareMap.get(DcMotor.class, "stanga");
        dreapta = hardwareMap.get(DcMotor.class, "dreapta");

        //setam directia motoarelor
        stanga.setDirection(DcMotorSimple.Direction.FORWARD);
        dreapta.setDirection(DcMotorSimple.Direction.REVERSE);
        /*
        * Mereu motoarele puse pe dreapta robotului se vor invarti in sens invers fata de cele din stanga.
        * */

        // spunem motoarelor sa continue miscare din inertie la setPower 0
        stanga.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        dreapta.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        // spunem motoarelor ca nu folosim encodere
        stanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // asteptam sa inceapa meciul
        waitForStart();
        // daca a inceput, incepem autonomia
        if(opModeIsActive());

        // miscare fata pentru 10 secunde cu viteza 1
        stanga.setPower(1);
        dreapta.setPower(1);
        sleep(10000);


        /**
         * Va amintiti de cand am spus ce face  throws InterruptedException din antetul functiei?
         * (antet == randul in care zicem tipul si numele functiei + parametrii daca exista)
         * Este vremea sa "il folosim"
         * functia sleep(milisecunde) ingheata codul pentru x milisecunde
         * tot ce am spus inainte de acest sleep, va functiona (linearitatea programului -> LinearOpMode)
         * Astfel, setam puterea motoarelor la 1, deci mergem in fata, si dam freeze la cod pentru 10 secunde.
         * Rezulta o miscare in fata cu viteza 1 timp de 10 secunde
         * */

        // am mers 10 secunde in fata, oprim
        stanga.setPower(0);
        dreapta.setPower(0);


        // rotire stanga pentru 5 secunde cu viteza 0.25
        stanga.setPower(-0.25);
        dreapta.setPower(0.25);
        sleep(5000);
        // am rotit la stanga timp de 5 secunde, oprim
        stanga.setPower(0);
        dreapta.setPower(0);


        // miscare spate pentru 3.5 secunde cu viteza 0.75
        stanga.setPower(-0.75);
        dreapta.setPower(-0.75);
        sleep(3500);
        // am mers in spate timp de 3.5 secunde, oprim
        stanga.setPower(0);
        dreapta.setPower(0);


        // rotire dreapta pentru 7 secunde cu viteza 0.3
        stanga.setPower(0.3);
        dreapta.setPower(-0.3);
        sleep(7000);
        // am rotit la dreapta timp de 7 secunde, oprim
        stanga.setPower(0);
        dreapta.setPower(0);


        // miscare fata pentru 4.5secunde cu viteza 0.9
        stanga.setPower(0.9);
        dreapta.setPower(0.9);
        sleep(4500);
        // am rotit la dreapta timp de 7 secunde, oprim
        stanga.setPower(0);
        dreapta.setPower(0);
    }


}
