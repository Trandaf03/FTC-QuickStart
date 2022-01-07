package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


/**
 * Am invatat tot ce este necesar pentru a putea incepe sa programam un robot. Fiti atenti aici, deoarece aceste lucruri
 * o sa fie folosite foarte des
 * */

// clasa cu numele Tutorial_7_introducereFTC extinde LinearOpMode -> Poftim?
public class Tutorial_7_introducereFTC extends LinearOpMode {
    // LinearOpMode vine de la "OpMode" -> adica un fel de operation mode, care este executat liniar
    // adica mai pe romaneste, aici scriem codul pentru robot. In momentul acesta, clasele create pana acum,
    // deoarece nu extind LinearOpMode, nu sunt recunoscute de cod ca fiind posibile autonomii sau teleop-uri.

    /**
     * Autonomie = perioada de miscare a robotului fara interventie umana
     * TeleOP = perioada de miscare a robotului cu interventie umana
     * */


    /**
     * Odata ce am scris ca aceasta clasa extinde LinearOpMode, este obligatoriu sa avem si functia de mai jos
     * in aceasta clasa. Aceasta este "constructorul" clasei, in sensul ca aceasta are prioritate cand vine vorba de
     * executie a codului. Oricat de multe functii am avea in aceasta clasa, runOpMode() o sa fie MEREU prima care este executata
     *
     * Putem observa ca functia numita "runOpMode" este de tipul void ( nu returneaza nimic), nu are niciun parametru, si se foloseste
     * de throws InterruptedException: adica putem folosi comenzi precum sleep(); sau this.sleep(); -> comenzi care pun pauza codului,
     * despre care o sa vorbim intr-un alt tutorial.
     * */


    @Override
    public void runOpMode() throws InterruptedException {
        /**
         * Asadar, din cate am zis mai sus, orice  scriem aici are prioritate, si de asemenea, aici o sa scriem si o parte
         * din codul robotului, mai precis, partea de control, restul, o sa invatam sa le scriem diferit, pentru a diviza codul
         * cat mai mult. Cu cat divizarea este mai mare, cu atat putem sa modificam din ce in ce mai usor codul.
         * */

        /**
         * Una dintre cele mai importante comenzi, waitForStart(); spune codului ca executia in continuare nu este posibila
         * pana cand pe aplicatia de "Driver Station" nu a fost apasat pe butonul de "Start" al perioadei de Autonomie/TeleOP selectate
         * !!
         * Pentru a putea fi citita de Driver Station ca o autonomie sau teleop, inainte de inceputul clasei se va pune:
         *
         * @Autonomous , in cazul in care vrem ca aceasta clasa sa fie o autonomie
         * sau
         * @TeleOp , in cazul in care vrem ca aceasta clasa sa fie un teleop.
         *
         * Acestea sunt urmate de doi parametrii: numele si grupa
         * Ex:      @TeleOp(name = "TeleOpRobot", group = "Testing"), unde
         *              name reprezinta numele afisat pe aplicatia de Driver Station
         *              group reprezinta grupul din care face parte teleop-ul/autonomia respectiva.
         *
         *     Daca exista mai multe autonomii, de ex, pentru a testa lucruri, daca cream un group = "Testing"
         *     toate aceste autonomii o sa fie diferentiate pe driver station de restul autonomiilor.
         *
         *
         *
         * Odata selectata autonomia/teleop-ul respectiv, apasati pe butonul "INIT". In acel moment, orice cod aflat intre inceputul
         * functiei runOpMode() si comanda waitForStart()  va fi executat. Astfel, vom numi aceasta "Zona de initializare", unde o sa
         * initializam variabilele folosite. Atentie! Initializarea nu inseamna neaparat si declararea acestor variabile!!
         * */
        waitForStart();


        /**
         * Odata ce am am apasat si pe cel de-al doilea buton, adica cel de "PLAY", codul robotului nostru poate insfarsit sa inceapa.
         * Acum exista 2 moduri in care acesta poate continua, si difera daca acesta este o autonomie sau un teleop.
         * */


        /**AUTONOMIE
         * In general, autonomiile sunt gandite astfel incat sa incapa in intervalul de 30 de secunde al acestei perioade.
         * Asadar, trebuie sa facem o singura verificare la inceput, pentru a vedea daca aceasta perioada a inceput
         * Mai exact, un singur if:
         * Exista mai multe variante pentru a putea fi implementat
         * */
        // VARIANTA 1 - codul se afla in interiorul if-ului
        if(opModeIsActive()){
            // COD AUTONOMIE
        }
        // VARIANTA 2 - folosim un if gol, iar acest if functioneaza ca un baraj pentru cod, daca nu este indeplinita conditia, nu trece mai departe
        if(opModeIsActive()){}
        // COD AUTONOMIE

        // VARIANTA 3 - Asemanatoare cu varianta 2
        if(opModeIsActive());
        // COD AUTONOMIE



        /**TeleOP
         * Spre deosebire de autonomie, tele-op-ul trebuie sa se realizeze intr-un loop. Comenzile de pe controler trebuie sa fie
         * verificate constant in timpul acestei perioade, iar codul fiind unul liniar ( se executa de la linia 1 la ultima linie )
         * nu poate reveni la un punct anume fara sa folosim un loop ( o structura repetitiva )
         * */
        while(opModeIsActive()){
            // COD TELEOP
        }
        /**
         * Acum poate o sa va intrebati, de ce nu am folosit un do{}while(); ? Nu trebuie sa executam acest cod cel putin odata?
         * Ba da. Trebuie sa il executam. Problema este alta: ar fi trebuit sa asteptam pana opModeIsActive() sa fie adevarat
         * pentru a incepe do{}while(). Adica sa verificam conditia lui do{}while() intr-un if inainte de aceasta, ceea ce inseamna,
         * de fapt, un while. Acesta functioneaza si ca un baraj: pana ce opModeIsActive este adevarat, codul nu continua. In momentul
         * in care acesta o sa fie activ, incepe executarea codului din while().
         * */
    }
}
