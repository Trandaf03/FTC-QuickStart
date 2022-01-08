package org.firstinspires.ftc.teamcode.Capitolul1;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
@Disabled
@Autonomous(name = "Autonomie")
public class Tutorial_8_variabileFTC extends LinearOpMode {
    /**
     * Cel mai des o sa fie folosite motoarele,servo-urile si functiile care vin odata cu acestea.
     * */
    // precum o variabila de tip intreg se declara ca fiind int a = valoare, asa se declara si motoarele

    DcMotor motor = null;  // acum avem un motor declarat cu numele "motor"
    DcMotorEx motorEx = null;
    /**
     * DcMotorEx este acelasi lucru ca un DcMotor, diferenta este ca DcMotorEx este o varianta mult mai avansata
     * a unui DcMotor. Astfel, DcMotorEx introduce functii noi precum .setVelocity(), care inlocuieste .setPower()
     * si o imbunatateste, dar este folosita cu alti parametrii. Mai multe informatii,  mai jos .
     * */


    /**
     * Spre deosebire de DcMotor si DcMotorEx, Servo si CRServo reprezinta doua lucruri total diferite:
     * Servo - declararea pentru un servo care se roteste maxim 180 de grade. (?depinde de servo)
     * CRServo - Continous Rotation Servo - declararea pentru un servo cu rotatie continua
     * */
    Servo servo = null;
    CRServo crServo = null;

    @Override
    public void runOpMode() throws InterruptedException {
        /**
         * Avem deja variabilele declarate, acum trebuie sa le si initializam. O sa ma rezum la a folosi DcMotorEx, deoarece este acelasi
         * lucru cu DcMotor
         * */


        motorEx = hardwareMap.get(DcMotorEx.class, "numeMotor");
        /**
         * Acesta este modul prin care initializam motorul, si observam mai multe lucruri noi:
         *
         *  hardwareMap -> dupa cum zice si numele, este un "Map" al tuturor componentelor hardware ale robotului.
         *                 Acest hardwareMap se creeaza configurand robotul din driver station
         *  .get -> functie specifica hardwareMap, prin care cerem un motor, mai exact, cerem un motor cu numele
         *          "numeMotor" din clasa de DcMotorEx, regasit in hardwareMap.
         *  DcMotorEx.class -> tipul de informatie pe care o returneaza hardwareMap.get(), in acest caz, un DcMotorEx
         *  deviceName "numeMotor" -> numele trecut in configuratia robotului. Trebuie sa fie exact acelasi nume.
         * */

        servo = hardwareMap.get(Servo.class, "servo");
        crServo = hardwareMap.get(CRServo.class, "aicieunservo");
        /**
         * Asemanator ca la motorEx, observam ca hardwareMap.get atribuie variabilei noastre "servo" un Servo din hardwareMap-ul
         * robotului numit "servo"
         *
         * Asemanator ca la motorEx, observam ca hardwareMap.get atribuie variabilei noastre "crservo" un CRServo din hardwareMap-ul
         * robotului numit "aicieunservo"
         *
         * */

        /**
         * COMENZI SPECIFICE SERVO
         * cea mai folosita este .setPositon(pozitie), unde pozitie este o valoare intre 0 si 1 care reprezinta gradul de rotatie al
         * servo-ului. de ex , setPosition(0) muta servo in pozitia 0 sau 0 grade
         *                     setPosition(0.5) muta servo in pozitia 0.5 sau 90 de grade
         *                     setPosition(1) muta servo in pozitia 1 sau 180 de grade
         * */
        servo.setPosition(1);

        /**
         * COMENZI SPECIFICE CRSERVO
         * Spre deosebire de servo normal unde setam pozitia, crservo fiind continuu ii setam puterea de rotatie (intre -1 si 1, unde 0
         * inseamna STOP)
         * */
        crServo.setPower(1);


        /**
         * COMENZI SPECIFICE DCMOTOR
         * */
        // setDirection seteaza directia de rotatie a motorului FORWORD pentru fata, REVERSE pentru spate
        motor.setDirection(DcMotorSimple.Direction.FORWARD);

        // setZeroPowerBehavior seteaza modul de franare al robotului - BRAKE pune frana atunci cand motorul are setPower(0)
        //                                                            - FLOAT lasa motorul liber atunci cand motorul are setPower(0)
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        /* setMode are 4 moduri, 3 dintre ele controleaza modul de control (oprit/pornit/stop/reset al encoderului motorului)
        * RUN WITHOUT ENCODER    -> nu folosim encoderele din motor
        * RUN USING ENCODER      -> folosim encoderele din motor
        * STOP AND RESET ENCODER -> oprim si resetam encoderul
        * */
        motor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        /*
        * Cel de-al 4lea mod al setMode este RUN TO POSITION
        * Acesta merge "mana in mana" cu .setTargetPostion:
        *
        * Presupunem ca encoderele sunt pornite.
        * setam un target postion ( masurat in ticuri )
        * setam modul encoderelor pe RUN TO POSITION, asa ca le spunem sa mearga positia spusa mai devreme
        * */
        motor.setTargetPosition(100);
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);


        // comanda folosita pentru a seta puterea motoarelor, primeste valori intre -1 si 1
        motor.setPower(1);


        /**
         * Ce sunt encoderele? Encoderele sunt senzori integrati in aproximativ fiecare motor, care masoara rotatia la ax
         * a acestuia.
         * De ex, sa ziem ca axul unui motor face o rotatie completa, astfel, encoderul o sa mearga x ticuri.
         * Acestea nu le masuram noi, si le gasim pe site-ul producatorului
         * De ex, motorul goBilda de 435RPM are 386.2 ticuri pentru o rotatie a axului motorului.
         *
         * Deci, ticurile sunt unitatea de masura pentru rotatia axului motorului.
         *      Atunci cand spunem motor.setTargetPosition(3862);, practic ii spunem motorului sa se invarta
         *      exact de 10 ori ( o rotatie are 386.2, deci 3862/386.2 = 10 rotatii)
         * */

        /**
         * COMENZI SPECIFICE DCMOTOREX
         *
         * sunt toate comezile de la DcMotor, plus una foarte folositoare: setVelocity
         * */

        double speed = 1; // viteza pe care o setam motorului
        double RPM = 435; // cate rotatii pe minut face motorul
        double GEAR_REDUCTION = 1/2; // reductia motor - roata, daca exista una (normal e 1)
        double WHEEL_RADIUS = 10; // diametrul rotii in cm

        double motorMaximumVelocity = RPM * GEAR_REDUCTION * 2 * Math.PI * WHEEL_RADIUS /60.0;
        // velocitatea maxima pe care o poate lua robotul

        motorEx.setVelocity(speed * motorMaximumVelocity);


        /**
         * DIFERENTA DINTRE SETPOWER SI SETVELOCITY
         *
         * Chiar daca setPower este mult mai usor de folosit, acesta are si un mare dezavantaj:
         *      daca setam setPower(0.5), motorul va primi doar 0.5 din toata puterea pe care o poate lua el
         *                                              (viteza cat si "cai putere")
         * In cazul in care folosim setVelocity(0.5 * motorMaximumVelocity) lucrurile se schimba:
         *                                 o sa folosim o viteza de 0.5, dar la putere maxima
         *                                 ("caii putere sunt la maxim")
         *
         * */

        waitForStart();
        if(opModeIsActive());
        /**
         * Am declarat motoarele si servo-urile, acum putem sa le folosim :)
         * */
    }

}
