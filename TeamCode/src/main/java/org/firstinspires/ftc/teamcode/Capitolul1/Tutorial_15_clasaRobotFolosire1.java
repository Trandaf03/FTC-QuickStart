package org.firstinspires.ftc.teamcode.Capitolul1;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Capitolul1.Tutorial_15_clasaRobot;


/**
 * Acum sa va arat cum functioneaza clasaRobot:
 * */
@Disabled
@TeleOp
public class Tutorial_15_clasaRobotFolosire1 extends LinearOpMode {


    //in acest moment, am spus codului ca noi folosim clasaRobot aici. Tot ce se afla in aceasta clasa, avem si aici.
    Tutorial_15_clasaRobot robot = new Tutorial_15_clasaRobot();


    @Override
    public void runOpMode() throws InterruptedException {

        /**
         * Cum apelam lucrurile create in aceasta clasa ?
         * este foarte simplu:
         * in primul rand, spunem codului ca vrem o anumita clasa aici ( deja am facut-o)
         * (nume_clasa)  nume_variabila = new (nume_clasa);
         *
         * De ce am zis nume_variabila si nu altceva? Pentru ca, in acest moment, toata clasa va deveni o variabila, un obiect cu mai multe informatii.
         * pentru a accesa aceste informatii (variabile,functii,etc) o facem astfel:
         * nume_variabila.nume_informatie;      unde nume_informatie este variabila/functia pe care vrem sa o accesam.
         * Exemplu:
         * */
        robot.stangaFata.setPower(0);
        /**
         * Ce am facut aici ? avem variabila robot, care este defapt o clasa cu mai multe variabile si functii declarate.
         * Am cautat un motor de acolo, mai exact, stangaFata, si apoi i-am spus sa isi seteze puterea 0
         * pentru a va juca cu asta, scrieti
         *
         *          robot.     , iar mai apoi o sa vedeti ca va apar mai multe lucruri pe care le puteti accesa.
         *          Totusi, nu putem accesa motorPrivatExemplu, din acea clasa, deoarece este de tip 'private',
         *          deci putem sa ne "jucam" cu el doar in clasa respectiva.
         *
         * */


        //acum initializam robotul, trimitand hardwareMap-ul specific doar aici ca parametru in acea clasa unde nu exista HardwareMap.
        robot.initializare(hardwareMap);


        // in acest moment avem robotul deja declarat si initializat, putem sa incepem programarea!
        waitForStart();
        while(opModeIsActive()){

        }


    }
}
