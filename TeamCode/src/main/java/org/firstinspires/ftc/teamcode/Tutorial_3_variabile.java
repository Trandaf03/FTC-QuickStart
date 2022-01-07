package org.firstinspires.ftc.teamcode;

public class Tutorial_3_variabile {

    /**
     * Variabilele sunt modul prin care informatiile sunt stocate intr-un limbaj de programare.
     * <p>
     * Exista mai multe tipuri de variabile, iar fiecare stocheaza informatii de tipuri diferite.
     * <p>
     * Modul de declarare al unei informatii/variabile este urmatorul:
     * <p>
     * tip_variabila nume_variabila = informatie;
     * Exemplu:
     */

    int unNumar = 10;
    /**
     * Variabila de tip "int" numita "unNumar" primeste valoarea "10"
     * */


    /**
     * TIPURI DE VARIABILE (cele mai folosite)
     * int - stocheaza numere Intregi (Z)
     * double - stocheaza numere Reale (R)
     * float - stocheaza numere de tip Float (?poftim?)    - nu foarte folosit
     * boolean - stocheaza TRUE sau FALSE
     * char - stocheaza un caracter (caracter ASCII, de ex o litera din alfabet)
     * String - stocheaza un cuvant, o propozitie, o fraza, etc (un sir de caractere)
     */

    int a = 77;

    double b = 55.5431;

    float c = 44.1234f; //in cazul in care acel "f" nu exista la final, float c o sa fie defapt stocata ca double c
    //! float nu este foarte folosit in Java, cel putin noi o sa il folosim foarte rar, daca nu, chiar deloc.
    //Totusi, merita mentionat

    boolean esteAdevarat = false;
    boolean afaraNinge = true;
    char primaLitera = 'a';

    String text = "Ana are mere";

    /**
     * De asemenea, din cate se poate observa, la sfarsitul fiecarei linii am pus ";". Astfel, codul nostru va sti ca
     * acolo se afla sfarsitul de linie.
     * */

    /**
     * ! Putem declara mai multe varibile de acelasi tip in acelasi timp !
     * aceasta se realizeaza folosindu-ne de ","
     */
    int x = 10, y = 20, z = 30;

    /**
     * Ce putem face cu variabilele?
     */

    //Sa presupunem ca robotul nostru are o lungime de 40cm
    int lungime_robot = 40; // daca robotul avea 40.5cm , trebuia sa inlocuim "int" cu "double"

    //Acum , vrem sa parcurgem o distanta de 100cm, distanta masurandu-se de la sfarsitul robotului.
    int distanta_pentru_parcurs = 100;

    // Dar avem o problema, daca o sa parcurgem 100cm in acest moment, noi defapt o sa mergem 140cm
    // (am zis ca distanta se masoara din spatele robotului)

    int distanta = distanta_pentru_parcurs - lungime_robot;
    /** astfel, in variabila "distanta" am scazut lungimea robotului din distanta pentru parcurs
     * in acest moment, "distanta" are valoarea de 100-40 = 60cm
     * Acum o sa spuneti: "Bine, dar nu puteam sa scad singur asta?"
     * Desigur, puteai sa o faci. Dar ce faceai daca tu nu stiai defapt distanta care trebuie parcursa,
     * iar aceasta provenea defapt dintr-un senzor al robotului?
     *
     * Astfel, folosindu-ne de variabile putem sa operam cu informatii pe care nu le avem in momentul
     * programarii, iar acestea o sa ajunga dupa citirea unui servo, etc. O sa intelegi mai bine in viitor.
     * */

    /**
     * De asemenea, putem sa schimbam valorile din variabile:
     */

    void schimbareValori() { // momentan ignorati aceasta linie , o sa discutam mai tarziu despre ce inseamna


        int gigel = 12, marcel = 20;
        // am declarat pe gigel cu 12 si pe marcel cu 20

        gigel = 15;
        // acum gigel o sa aibe valoarea de 15

        marcel = 50;
        // acum marcel o sa aibe valoarea de 50

        gigel = marcel;
        // acum gigel o sa aibaa valoarea lui marcel, adica si gigel o sa aibe 50

        marcel = gigel;
        // acum marcel o sa aiba valoarea lui gigel, adica si marcel o sa aibe 50

        gigel = 10;
        // acum gigel o sa aive valoarea de 10

        //FINAL : gigel are val de 10, iar marcel de 50

    }

    /**
     * OPERATORII
     * ca si la matematica, avem mai multi operatori :
     * +  -> adunare
     * -  -> scadere
     * *  -> inmultire
     *
     * La acestea, se mai adauga inca doi operatori
     * %  -> MOD
     * /  -> DIV (de ce nu impartire? o sa vedem asta imediat)
     */
    void ignora() {

        int ceva = 40;
        ceva = ceva +ceva;    // in acest moment ceva are valoarea de 40 + 40 = 80

        ceva += ceva;  // echivalent cu operatia anterioara, ceva are valoarea de 80+40 = 120 acum.

        ceva = ceva - 100; // ceva primeste valoarea lui ceva - 100, adica 120 - 100 = 20. Ceva memoreaza 20 acum.

        ceva = ceva * ceva; // ceva primeste 20*20 = 400;        primeste <=> memoreaza (echivalente)

        /**
         * Acum problema intervine la DIV si MOD
         *
         * DIV "returneaza" catul impartirii a doua numere
         * MOD "returneaza restul impartirii a doua numere
         * Exemple
         * */

        int o = 12;
        int p = 5;

        int cat = o / p; // valoarea cat memoreaza catul impartirii lui 12 la 5, adica 2
        int rest = o % p; // valoarea rest memoreaza restul impartirii lui 12 la 5, adica tot 2;

        /**
         * !!OPERATORUL MOD functioneaza doar pe variabilele de tip "int"
         *
         * !!OPERATORUL DIV functioneaza normal( impartire ) pe variabilele de tip "double"
         * */

        double maimuta = 121.5;
        maimuta = 121.5 / 5; // in acest moment, variabila maimuta memoreaza 24.3



}

/** RECAPITULARE/ DE RETINUT !
 *      int - stocheaza numere Intregi (Z)
 *      double - stocheaza numere Reale (R)
 *      boolean - stocheaza TRUE sau FALSE
 *      String - stocheaza un cuvant, o propozitie, o fraza, etc (un sir de caractere)
 *
 *      OPERATORII
 *       +  -> adunare
 *       -  -> scadere
 *       *  -> inmultire
 *       %  -> MOD
 *       /  -> DIV
 */


}
