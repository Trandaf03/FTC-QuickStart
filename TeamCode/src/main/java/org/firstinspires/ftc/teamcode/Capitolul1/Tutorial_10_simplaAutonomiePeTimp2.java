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
 * -> miscare fata pentru 10 secunde cu viteza 1
 * -> rotire stanga pentru 5 secunde cu viteza 0.25
 * -> miscare spate pentru 3.5 secunde cu viteza 0.75
 * -> rotire dreapta pentru 7 secunde cu viteza 0.3
 * -> miscare fata pentru 4.5secunde cu viteza 0.9
 *
 * */
@Disabled
@Autonomous (name = "autoTimp2")
public class Tutorial_10_simplaAutonomiePeTimp2 extends LinearOpMode {

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

        // O alternativa la codul din tutorialul anterior este sa cream o functie pentru a ne ajuta sa mergem: mersRobot
        // aceasta se afla dupa terminarea functiei runOpMode() si cere 3 parametrii : vitezele motorului din stanga,
        // viteza robotului din dreapta si timpul de mers in milisecunde.
        mersRobot(1,1,10000);
        mersRobot(-0.25,0.25,5000);
        mersRobot(-1,-1,3500);
        mersRobot(0.3,-0.3,7000);
        mersRobot(0.9,0.9, 4500);

        // Astfel, lungimea codului nostru s-a micsorat substantial, si nu trebuie sa stam sa scriem manual de fiecare data
        // fiecare miscare a robotului. Daca dam copy paste exista riscul sa o facem gresit.

    }
    public void mersRobot(double powerStanga, double powerDreapta, int milisecunde) throws InterruptedException  {
        // setam puterea motoarelor
        stanga.setPower(powerStanga);
        dreapta.setPower(powerDreapta);
        // dam freeze la cod pentru x milisecunde
        sleep(milisecunde);
        // am mers in directia stabilita timp de x milisecunde, oprim.
        stanga.setPower(0);
        dreapta.setPower(0);
    }


}
