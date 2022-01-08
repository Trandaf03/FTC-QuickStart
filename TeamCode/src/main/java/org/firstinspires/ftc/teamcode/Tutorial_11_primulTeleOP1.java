package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "PrimulTeleop")
public class Tutorial_11_primulTeleOP1 extends LinearOpMode {
    /**
     * Spre deosebire de o autonomie unde lucrurile se desfasoara pentru ced mai mare parte din programatori la fel, TeleOP-ul mai are
     * o variabila foarte importanta pe care trebuie sa o ia in considerare : Driverii
     * Acestia decid comenzile, iar un programator ar trebui sa fie pregatit sa ii faca pe plac. Asta nu inseamna ca si el are dreptate!
     * Nu mereu ce doreste un driver poate sa si functioneze, noi fiind limitati de feedback-ul butoanelor de pe controlere.
     *
     * pot fi minim un driver si maxim doi, diferenta din cod este reprezentata de numarul de ordine al controlerului:
     * gamepad1.(nume_buton) si gamepad2.(nume_buton).
     *
     * Butoanele specifice controllerului:
     * */

    //left stick, care are doua axe : X si Y, fiecare ofera valori intre -1 si 1
    double a1 = gamepad1.left_stick_x;
    double a2 = gamepad1.left_stick_y;

    //right stick, care are doua axe : X si Y, fiecare ofera valori intre -1 si 1
    double a3 = gamepad1.right_stick_x;
    double a4 = gamepad1.right_stick_y;

    /**
     * Daca nu apesi un stick, atunci a1/a2/a3/a4 vor primi valoarea 0.
     * sa zicem ca impingem stick-ul stanga in fata pentru jumatate din cat poate fi el impins.
     * atunci valoarea a2 (left_stick_y) va primi valoarea 0.5
     * Daca il impingem doar 1/4 din distanta, atunci a2 va primi valoarea 0.25, iar exemplele pot continua
     * */

    //trigger-urile iau valori intre 0 si 1, functioneaza asemanator cu stickurile
    double a5 = gamepad1.left_trigger;
    double a6 = gamepad1.right_trigger;

    /**
     * Daca apasam pe buton jumatate din distanta pe care o poate merge, atunci a5 sau a6 va lua valoarea 0.5
     * */

    // butoanele fizice a/b/x/y sau , in cazul in care folositi un controler de ps4 : triunchi,cerculet,cruce,patrat returneaza doar
            // doua valori : FALSE daca butonul nu este apasat si TRUE daca butonul este apasat
    boolean b1 = gamepad1.a;
    boolean b2 = gamepad1.b;
    boolean b3 = gamepad1.x;
    boolean b4 = gamepad1.y;

    // la fel ca butoanele a/b/x/y , dpad_urile returneaza valoarea FALSE daca nu sunt apasate si TRUE daca sunt apasate
    boolean b5 = gamepad1.dpad_up;
    boolean b6 = gamepad1.dpad_left;
    boolean b7 = gamepad1.dpad_right;
    boolean b8 = gamepad1.dpad_down;

    // la fel ca celelalte butoane, bumper-urile returneaza valoarea FALSE daca nu sunt apasate si TRUE daca sunt apasate
    boolean b9 = gamepad1.left_bumper;
    boolean b10 = gamepad1.right_bumper;

    // nu foarte folosite, in cazul in care apesi pe un stick controlerul citeste acea miscare ca fiind un buton:
    // daca nu este apasat, b11 are valoarea FALSE, daca este apasat, primeste valoarea TRUE
    boolean b11 = gamepad1.left_stick_button;
    boolean b12 = gamepad1.right_stick_button;


    /**
     * Astfel, pe un controller exista 16 moduri prin care un Driver poate oferi feedback:
     * - 4 modalitati de e primi valori intre -1 si 1
     * - 2 modalitati de a primi valori intre 0 si 1
     * - 12 modalitati de a primi valori de TRUE sau FALSE
     * */


    DcMotor stanga = null;
    DcMotor dreapta = null;

    @Override
    public void runOpMode() throws InterruptedException {

        stanga = hardwareMap.get(DcMotor.class, "stanga");
        dreapta = hardwareMap.get(DcMotor.class, "dreapta");

        stanga.setDirection(DcMotorSimple.Direction.FORWARD);
        dreapta.setDirection(DcMotorSimple.Direction.REVERSE);

        stanga.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        dreapta.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        stanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

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
         * Acum intervine problema Driverilor. Cum programam robotul? unii driveri ar prefera sa controleze motorul din stanga cu stick-ul
         * din stanga, iar pe cel din dreapta cu stick-ul din dreapta.
         * Iar aceasta ar fi cam si cea mai usoara varianta:
         * - daca dam de ambele stick-uri in fata, robotul se misca in fata
         * - daca dam de ambele stick-uri in spate, robotul se misca in spate
         * - daca dam de stick-ul din stanga in fata si de cel din dreapta in spate, viram spre dreapta
         * - daca dam de stick-ul din dreapta in fata si de cel din stanga in spate, viram spre stanga
         *
         * */
        waitForStart();
        while(opModeIsActive()){

            if(this.gamepad1.left_stick_y != 0){
                stanga.setPower(this.gamepad1.left_stick_y);
            } else stanga.setPower(0);

            if(this.gamepad1.right_stick_y != 0){
                dreapta.setPower(this.gamepad1.right_stick_y);
            } else dreapta.setPower(0);

            /**
             *  Iar acesta a fost tot TeleOP-ul. Foarte putin, nu? Da!
             *  Cum functioneaza?
             *  verificam daca gamepad1.left_stick_y a fost miscat in orice directie.
             *      in cazul in care a fost miscat, atunci motorului din stanga ii dam puterea cu care a fost apasat acel stick
             *      in cazul contrar, setam puterea motorului 0 !! foarte important sa nu uitam de asta, altfel motorul niciodata nu
             *      o sa se opreasca, si o sa se invarta cu ultima valoarea a sa diferita de 0 : de ex 0.0000001 , care, poate ziceti ca
             *      este foarte mica, dar motorul inca primeste voltaj si un tiuit puternic o sa se auda de la motor. Acest tiuit o sa mai
             *      intervina si atunci cand o sa ne jucam cu encoderele. Dar am gasit si acolo o rezolvare.
             *  Pentru motorul din dreapta, ce se intampla cu motorul din stanga, se intampla si cu el. Doar ca in loc sa primeasca feedback-ul
             *  oferit de stick-ul din stanga, primeste de la cel din dreapta.
             *
             * */

        }




    }
}
