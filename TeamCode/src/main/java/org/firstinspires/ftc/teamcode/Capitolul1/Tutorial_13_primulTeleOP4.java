package org.firstinspires.ftc.teamcode.Capitolul1;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
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
 * fie un al 3lea motor care se invarte la apasarea unui buton.
 * fie cutieViteze o cutie de vieteze pentru sasiu. Daca apas un buton, indiferent de pozitia stick-ului merg cu o viteza, iar daca
 *                                                       apas alt buton, indiferent de pozitia stick-ului merg cu o alta viteza
 */
@Disabled
public class Tutorial_13_primulTeleOP4 extends LinearOpMode {

    DcMotor stanga = null;
    DcMotor dreapta = null;
    DcMotor motorRotatie = null;
    Servo unServo = null;

    boolean motorulSeInvarte = false;
    double cutieViteze = 1;
    @Override
    public void runOpMode() throws InterruptedException {
        stanga = hardwareMap.get(DcMotor.class, "stanga");
        dreapta = hardwareMap.get(DcMotor.class, "dreapta");
        motorRotatie = hardwareMap.get(DcMotor.class, "rotatie");
        unServo = hardwareMap.get(Servo.class,"servoBrat");

        stanga.setDirection(DcMotorSimple.Direction.FORWARD);
        dreapta.setDirection(DcMotorSimple.Direction.REVERSE);
        motorRotatie.setDirection(DcMotorSimple.Direction.FORWARD);

        stanga.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        dreapta.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorRotatie.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);


        stanga.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dreapta.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorRotatie.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


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

            // programarea cutiei de viteze doar pe un buton
            if(this.gamepad1.a){
                if(cutieViteze == 1){
                    cutieViteze = 0.25;
                } else {
                    cutieViteze = 1;
                }
                this.sleep(200);
            }

            //programarea motorului de rotatie. Pentru a face asta o sa ne folosim de variabila globala motorulSeInvarte
            if(this.gamepad1.b){
                motorulSeInvarte = !motorulSeInvarte;
                this.sleep(200);
            }
            /**
             * Sa zicem ca motorulSeInvarte are valoarea false (intial)
             * la apasarea butonuli b, motorulSeInvarte primeste valoarea negativa a lui motorulSeInvarte, in acest caz,
             * motorulSeInvarte primeste !false adica primeste true.
             *
             * De asemenea, if(this.gamepad1.b) este echivalent cu if(this.gamepad1.b == true). De ce?
             * pentru ca this.gamepad1.b primeste valoarea false, constant. Eu nu am niciun else pentru care sa pot face ceva, deci
             * if-ul nu se executa. In momentul in care this.gamepad1.b va fi true, atunci se executa if-ul.
             * */

            // cod echibalent pentru cel de sus.
             if(this.gamepad1.b){
                if(motorulSeInvarte == true){
                    motorulSeInvarte = false;
                } else motorulSeInvarte = true;
                this.sleep(200);
            }

             // acum verificam constant daca motorulSeInvarte are valoarea true. In cazul in care o are, atunci pornim motorul.
             // in caz contrar, oprim motorul.
             if(motorulSeInvarte){
                 motorRotatie.setPower(1);
             } else {
                 motorRotatie.setPower(0);
             }
             /**
              * Din exeperienta ma observat ca metoda de mai sus este cea mai eficienta:
              * avem o valoare modificata la apasarea unui buton, si verificam constant acea valoare pentru
              * a sti daca pornim/oprim motorul ( poate chiar si un alt sistem, etc )
              *
              * Varianta alternativa ar fi sa pornim motorul direct prin apasarea butonului. Totusi, tot o sa avem nevoie de aacea valoare:
              * */

             if(this.gamepad1.b){
                 if(motorulSeInvarte == true){
                     motorRotatie.setPower(0);
                     motorulSeInvarte = false;
                 } else {
                     motorRotatie.setPower(1);
                     motorulSeInvarte = true;
                 }
                 this.sleep(200);
             }
        }
    }
}
