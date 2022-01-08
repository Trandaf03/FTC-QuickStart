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
 */
@Disabled
public class Tutorial_12_primulTeleOP2 extends LinearOpMode {

    DcMotor stanga = null;
    DcMotor dreapta = null;
    Servo unServo = null;

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
            // codul pentru sasiu, ignoram
            if(this.gamepad1.left_stick_y != 0){
                stanga.setPower(this.gamepad1.left_stick_y);
            } else stanga.setPower(0);

            if(this.gamepad1.right_stick_y != 0){
                dreapta.setPower(this.gamepad1.right_stick_y);
            } else dreapta.setPower(0);

            /**
             * Codul pentru miscarea bratului. Din nou, implenetarea este diferita. Eu am preferat sa pun cele 3 miscari pe dpad-uri:
             * daca il apas pe cel de jos, bratul se duce jos (pe teren)
             * daca il apas pe cel de sus, bratul se duce sus ( la 20 cm fata de teren)
             * daca il apas pe cel din stanga, bratul se duce la mijloc ( la 10 cm fata de teren)
             * */
            if(this.gamepad1.dpad_down == true){
                unServo.setPosition(0);
            }
            if(this.gamepad1.dpad_left == true){
                unServo.setPosition(0.5);
            }
            if(this.gamepad1.dpad_up == true){
                unServo.setPosition(1);
            }


        }
    }
}
