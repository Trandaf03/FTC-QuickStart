package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

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
 * fie inca un servo care ridica un mecanism. in pozitia 0, mecanismul sta jos, pe teren,
 *                                            in pozitia 0.5, mecanismul se ridica pentru 10cm de la teren,
 *                                            in pozitia 0.1, mecanismul se ridica pentru 20cm de la teren.
 *
 * fie cutieViteze o cutie de vieteze pentru sasiu. Daca apas un buton, indiferent de pozitia stick-ului merg cu o viteza, iar daca
 *                                                       apas alt buton, indiferent de pozitia stick-ului merg cu o alta viteza
 */

public class Tutorial_12_primulTeleOP3 extends LinearOpMode {

    DcMotor stanga = null;
    DcMotor dreapta = null;

    Servo unServo = null;

    double cutieViteze = 1;
    @Override
    public void runOpMode() throws InterruptedException {
        stanga = hardwareMap.get(DcMotor.class, "stanga");
        dreapta = hardwareMap.get(DcMotor.class, "dreapta");

        unServo = hardwareMap.get(Servo.class,"servoBrat");

        stanga.setDirection(DcMotorSimple.Direction.FORWARD);
        dreapta.setDirection(DcMotorSimple.Direction.REVERSE);


        stanga.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        dreapta.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        stanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        waitForStart();
        while(opModeIsActive()){

            // codul pentru sasiu, in loc sa ne miscam "progresiv", ne miscam cu o viteza FIXA: cea data de cutia de viteze
            if(this.gamepad1.left_stick_y > 0){
                stanga.setPower(cutieViteze);
            } else if(this.gamepad1.left_stick_y < 0){
                stanga.setPower(-cutieViteze);
            } else stanga.setPower(0);

            if(this.gamepad1.right_stick_y > 0){
                dreapta.setPower(cutieViteze);
            } else if(this.gamepad1.right_stick_y < 0){
                dreapta.setPower(-cutieViteze);
            } else dreapta.setPower(0);

            // codul pentru brat, ignoram
            if(this.gamepad1.dpad_down == true){
                unServo.setPosition(0);
            }
            if(this.gamepad1.dpad_left == true){
                unServo.setPosition(0.5);
            }
            if(this.gamepad1.dpad_up == true){
                unServo.setPosition(1);
            }


            // programarea cutiei de viteza
            if(this.gamepad1.left_bumper){
                cutieViteze = 0.25;
                this.sleep(200);
            }
            if(this.gamepad1.right_bumper){
                cutieViteze = 1;
                this.sleep(200);
            }
            /**
             * Pentru a programa cutia de viteze am preferat ca atunci cand apasam bumper-ul din stanga sa ne miscam cu o viteza mica,
             * iar atunci cand il apasam pe cel din dreapta sa ne miscam cu cea mai mare viteza
             * Din cate se poate observa, de data aceasta am tratat diferit valorile returnate de stick-ul respectiv:
             *      - daca valoarea este mai mica de 0, inseamna ca mergem in spate, deci valoarea -cutieViteze (adica -0.25, respectiv -1)
             *      - daca valoarea este mai mare de 0, inseamna ca mergem in fata, deci valoarea cutieViteze (adica 0.25, respectiv 1)
             *      - daca valoarea este 0, atunci stam pe loc.
             * Care este treaba cu acel this.sleep(200) ?
             * Daca ne amintim bine, sleep() da freeze la tot codul.
             *      this.sleep() tot freeze da, dar nu la tot codul, ci la ultima componenta apelata in cod.
             *      O sa ziceti ca aceasta este cutieViteze, dar defapt ultima este this.gamepad1.(buton) -> doarece si aceasta este
             *      apelata cu this:
             *      Cum functioneaza acest this?
             *      if(this.gamepad1.(buton)) codul stie ca cautam exact acel buton (this)
             *      this.sleep() codul a retinut exact butonul pe care il cautam, asadar stie sa ii dea freeze doar acelui buton cautat mai devreme
             *
             *
             *      ! explicatia this. este strict pentru a intelege cum functioneaza. Aceasta are alt "meaning" defapt.
             *
             *      Si la ce ne foloseste acest this.sleep?
             *      Pai, controlerele au o problema numita ghosting (intalnita doar la butoanele care returneaza TRUE sau FALSE)
             *      Ce inseamna ghosting? Eu apas pe un buton o singura data, dar telefonul inregistreaza ca acesta a fost apasat
             *      de fapt, de 2 ori, ceea ce poate duce la stricarea functionalitatii butonului.
             *      Aceasta problema se intalneste atunci cand vrem sa facem cutia de viteze doar pe un buton:
             *
             * */
            // programarea cutiei de viteze, alternativ, pe un buton:
            if(this.gamepad1.a){
                if(cutieViteze == 1){
                    cutieViteze = 0.25;
                } else {
                    cutieViteze = 1;
                }
                this.sleep(200);
            }
            /**
             * In cazul in care acest this.sleep(200) nu ar fi existat, atunci cutia de viteze nu ar fi mers cum trebuie.
             * Puteti sa testati singuri ce sa intampla daca pui acel this.sleep si daca nu il pui, pentru a observa singuri
             * ce se intampla.
             * */

        }
    }
}
