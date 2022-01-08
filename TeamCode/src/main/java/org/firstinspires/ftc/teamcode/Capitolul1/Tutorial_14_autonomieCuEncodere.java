package org.firstinspires.ftc.teamcode.Capitolul1;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
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
 * -> miscare fata pentru 50cm cu viteza 1,
 * -> miscare spate pentru 30cm cu viteza 0.5,
 * -> miscare fata pentru 20cm cu viteza 0.94
 *
 * */
@Disabled
@Autonomous (name = "autoEncodere")
public class Tutorial_14_autonomieCuEncodere extends LinearOpMode {

    // o sa presupune ca folosim aceste motoare : https://www.gobilda.com/5202-series-yellow-jacket-planetary-gear-motor-13-7-1-ratio-435-rpm-3-3-5v-encoder/
    double     COUNTS_PER_MOTOR_REV    = 386.2 ;    // Cate tics face un motor pe o singura revolutie
    double     DRIVE_GEAR_REDUCTION    = 1 ;       // Reductia roata/motor     !Atentie, reductia motorului nu se pune!
    double     WHEEL_DIAMETER_CM  = 10.0 ;     // Diametrul rotii, in centimetrii
    // folosindu-ne de valorile de mai sus, calculam de cate ori se invarte motorul nostru pentru a merge un centimetru
    double     COUNTS_PER_CM        = (COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION) / (WHEEL_DIAMETER_CM * 3.1415);

    DcMotor stanga = null;
    DcMotor dreapta = null;

    @Override
    public void runOpMode() throws InterruptedException {

        stanga = hardwareMap.get(DcMotor.class, "stanga");
        dreapta = hardwareMap.get(DcMotor.class, "dreapta");

        stanga.setDirection(DcMotorSimple.Direction.FORWARD);
        dreapta.setDirection(DcMotorSimple.Direction.REVERSE);

        stanga.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        dreapta.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        stanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        waitForStart();
        if(opModeIsActive());
        /** Pentru a ne deplasa ne folosim de functia moveByEncoder, de tip void (nu returneaza nimic), si cu 2 parametrii:
         * distantaDeParcurs -> distanta pe care vrem sa o parcurgem, in centimetrii, astfel:
         *                                     -> daca vrem sa mergem in fata, punem o valoare pozitiva
         *                                     -> daca vrem sa mergem in spate, punem o valoare negativa
         * viteza, care trebuie sa ia valori intre 0 si 1
         */
        moveByEncoder(50,1);
        moveByEncoder(30,0.5);
        moveByEncoder(20,0.94);


    }


    public void moveByEncoder(double distantaDeParcurs, double viteza){
        // incepem prin a calcula distanta in ticuri pentru motoare
        int distanta = (int)(distantaDeParcurs * COUNTS_PER_CM);

        // Poate o sa va intrebati, de ce am distanta ca double, counts per cm ca double, dar distanta de parcurs drept int?
        // pai encoderele nu functioneaza cu virgula, sa spun asa. Nu pot unui encoder sa imi mearga 10.5 ticuri, pot sa ii zic sa mearga ori 10, ori 11.
        // am asteptat atat de mult sa calculam distanta in int deoarece eroare o sa fie cat mai mica.


        // resetam encoderele
        stanga.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        dreapta.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // deoarce le-am si oprit, le pornim, de aceea am putut initializa encoderele original si cu RUN WITHOUT ENCODER
        // !Atentie! Daca initializati motoarele cu RUN_USING_ENCODER intr-un teleop, o sa observati ca nu mai functioneaza, dar
        //                daca sunt initializate cu RUN WITHOUT ENCODER, o sa functioneze. De ce? Pentru ca RUN USING ENCODER asteapta mereu
        //                                                                            si un setTargetPosition() care nu o sa apara.
        stanga.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        dreapta.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // setam ca target position distanta de mai devreme
        stanga.setTargetPosition(distanta);
        dreapta.setTargetPosition(distanta);

        // le spunem encoderelor sa mearga distanta pe care am zis-o mai devreme
        stanga.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        dreapta.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // le spunem motoarelor cu ce viteza sa mearga, folosindu-ne de functia Math.abs care returneaza valoarea pozitiva a vitezei. Poate uitati ca viteza este mereu pozitiva,
        //                      deci folosindu-ne de Math.abs poate fi o masura de precautie, optionala.
        stanga.setPower(Math.abs(viteza));
        dreapta.setPower(Math.abs(viteza));


        /**
         * Oprim tot codul cat timp motoarele functioneaza. De ce?
         * Mereu timpul de deplasare o sa fie diferit. In principal, variaza in functie de distanta si de viteza. Ca sa nu ne complicam cu calcule degeaba,
         * ne folosim de comanda .isBusy() care returneaza TRUE sau FALSE.
         * Practic, cat timp motorul functioneaza, nu facem nimic. In cazul in care vrem sa facem ceva pe timpul deplasarii, o facem in interiorul while-ului
         * */
        while(stanga.isBusy() && dreapta.isBusy()){
            // daca vrei sa faci ceva pe timpul deplasarii, fa-o aici
        }
        // am terminat deplasarea, ne oprim
        stanga.setPower(0);
        dreapta.setPower(0);

        // am terminat de folosit encoderele, le oprim (optional in cazul in care in autonomie se afla doar deplasari pe encodere, in caz contrar, este necesar)
        stanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    }
    /**
     * Functia moveByEncoder este limitata la miscari fata/spate deoarece suntem limitati in primul rand de modul de constructie al sasiului.
     * Daca vrem sa ne rotim, nu putem face asta pe loc, ci o sa o facem intr-un arc de cerc, deci rotirea cu encodere ar fi destul de complicata,
     * mai ales daca am avea nevoie de o rotatie de fix 90 de grade de ex. Pentru asta, o sa folosim giroscopul din ControlHub/ExpansionHub.
     * !ExpansionHub-urile livrate din Decembrie 2021 nu au un giroscop integrat in ele.
     *
     * */


}
