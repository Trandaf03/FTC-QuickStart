package org.firstinspires.ftc.teamcode.Capitolul1;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Din cate am observaat in ultimele 7 tutoriale, am stat sa declaram de fiecare data motoarele. Nu este foarte complicat, deoarece avem putin de copiat.
 * Totusi, cu timpul, o sa adaugam din ce in ce mai multe sisteme pe robot, deci si posibil hardware pe robot. De asemenea, o sa vrem sa testam din ce
 * in ce mai mult, si de fiecare data trebuie sa stam sa copiem aceleasi lucru mereu si mereu.
 *
 * De asta, acum o sa invatam despre programarea orientata pe obiecte. Acum, o sa facem un obiect denumit Tutorial_15_clasaRobot pe care o sa il folosim
 * mereu de acum in viitor.
 * De asemenea, o sa incepem sa programam un sasasiu cu roti mecanum : https://www.gobilda.com/strafer-chassis-kit-v4/
 * */

@Disabled
public class Tutorial_15_clasaRobot {

    public DcMotor stangaFata = null;
    public DcMotor stangaSpate = null;
    public DcMotor dreaptaFata = null;
    public DcMotor dreaptaSpate = null;

    private DcMotor motorPrivatExemplu = null;
    /**
     * De acum in colo o sa avem 4 motoare, cate unul pentru fiecare roata.
     * A aparut inca un lucru nou : public si private.
     * In momentul in care declaram o variabila, oricare ar fi ea, de tip 'public', inseamna ca atunci cand o sa apelam aceasta clasa pentru a o folosi
     *          in alta clasa putem accesa acea variabila.
     *          Daca o declaram de tip 'private' , inseamna ca nu o putem accesa din alta clasa.
     *
     *
     * Am observat ca pana acum, partea comuna a fiecarei clase a fost declararea si initializarea. Am declarat, acum urmeaza sa initializam
     * */

    public void initializare(HardwareMap hardwareMap){
        // din cate am observat, avem nevoie de hardwareMap ca parametru, deoarece aceasta variabila este specifica doar unui LinearOpMode,
        // iar aceasta clasa am zis ca o sa fie un obiect, deci nu avem nevoie de functia void runOpMode() aici.

        // intializam motoarele
        stangaFata = hardwareMap.get(DcMotor.class,"stangaFata");
        stangaSpate = hardwareMap.get(DcMotor.class,"stangaSpate");
        dreaptaFata = hardwareMap.get(DcMotor.class,"dreaptaFata");
        dreaptaSpate = hardwareMap.get(DcMotor.class,"dreaptaSpate");

        // setam directia motoarelor, in acest caz, dreapta este iarasi cu reverse
        stangaFata.setDirection(DcMotorSimple.Direction.FORWARD);
        stangaSpate.setDirection(DcMotorSimple.Direction.FORWARD);
        dreaptaFata.setDirection(DcMotorSimple.Direction.REVERSE);
        dreaptaSpate.setDirection(DcMotorSimple.Direction.REVERSE);

        // setan modul de franare, optional, puteti seta ce vreti
        stangaFata.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        stangaSpate.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        dreaptaFata.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        dreaptaSpate.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // le spunem motoarelor ca nu folosim encodere, asadar putem folosi aceasta clasa si intr-un teleop, dar si intr-o autonomie
        stangaFata.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        stangaSpate.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dreaptaFata.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        dreaptaSpate.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        // oprim motoarele, pentru a fi sigur ca robotul nu incepe sa o ia de nebun pe teren
        stangaFata.setPower(0);
        stangaSpate.setPower(0);
        dreaptaFata.setPower(0);
        dreaptaSpate.setPower(0);
    }
    // si atat a fost cu clasa de robot. putem sa scriem aici orice functie folositoare, de ex:
    public void stopRobot(){
        stangaFata.setPower(0);
        stangaSpate.setPower(0);
        dreaptaFata.setPower(0);
        dreaptaSpate.setPower(0);
    }
    // aceasta functie opreste motoarele robotului
}
