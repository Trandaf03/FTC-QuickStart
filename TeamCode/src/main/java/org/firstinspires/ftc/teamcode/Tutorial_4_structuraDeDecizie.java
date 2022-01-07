package org.firstinspires.ftc.teamcode;

public class Tutorial_4_structuraDeDecizie {

    /**
     * Una dintre cele mai importante si folosite structuri pe care o sa le invatam este structura de decizie.
     * In functie de o conditie, daca este adevarata, face un locru, iar daca este falsa face un alt lucru
     *
     *   if(conditie){
     *       EXECUTA DACA CONDITIA ESTE ADEVARATA
     *   } ELSE {
     *       EXECUTA DACA CONDITIA ESTE FALSA
     *  }
     * */

    // Exemplul 1

    void ceva(){ // din nou, ignoram aceasta linie pentru moment

        int ana = 10;
        int maria = 20;

        if(ana > maria){
            maria = maria * 2;
        } else {
            ana = ana * 2;
        }

        /**
         * Ce am facut?
         * am initializat 2 valori, sa zicem ca ana are 10 mere si maria are 20
         *
         * In cazul in care ana are mai multe mere ca maria (conditia este adevarata)
         *                  , maria o sa primeasca de doua ori mai multe mere decat avea initial
         * In cazul inc are ana are mai putine mere ca maria (conditia este falsa)
         *                  , ana o sa primeasca de doua ori mai multe mere decat avea initial.
         *
         * Astfel, dupa executarea liniilor 20 - 26
         * ana o sa aiba valoarea de 20, iar maria tot de 20.
         *
         *
         * OPERATORI PENTRU CONDITII:
         *  <    <- mai mic
         *  >    <- mai mare
         *  <=   <- mai mic sau egal
         *  >=   <- mai mare sau egal
         *  ==   <- egal
         *
         *
         *
         * Ce facem daca avem mai multe conditii de pus ?
         * Aici intervin alti doi operatori, specifici conditiilor:
         *
         *  &&  <- SI ( conditia_1 SI conditia_2)
         *  ||  <- SAU ( conditia_1 SAU conditia_2)
         *  Exemplu:
         * */
        int a = 10, b = 11, c  = 12, d = 12;
        if(a < b && c < d){
            a = b;
        } else {
            b = a;
        }
        /*
        * Avem doua conditii: a < b adica 10 < 11, care este ADEVARATA
        *                     c < d adica 12 < 12, care este FALSA ( pentru a fi adevarata trebuia c <= d)
        * astfel Adevarat Si Fals rezulta o conditie FALSA
        *       deci dupa executarea acelui if, am fi intrat pe cazul ELSE, iar b ar fi primit valoarea lui a, adica 10
        *
        * */


        if(a < b || c < d){
            a = b;
        } else {
            b = a;
        }
        /*
         * Avem doua conditii: a < b adica 10 < 11, care este ADEVARATA
         *                     c < d adica 12 < 12, care este FALSA ( pentru a fi adevarata trebuia c <= d)
         * astfel Adevarat sau Fals rezulta o conditie ADEVARATA
         *       deci dupa executarea acelui if, am fi intrat pe primul caz, iar a ar fi primit valoarea lui b, adica 11
         *
         * */


        // alte exemple:
        if (a == b){
            // daca a este egal cu b, atunci executam asta
        } else {
            // daca a nu este egal cu b, aatunci executam asta
        }


        // De asemena, ELSE poate fi obtional. Exemplu
        if (a == b){
            // executam daca a este egal cu b
        }
        // in acest caz, executam acest if DOAR daca a este egal cu b

        // Pot exista si mai multe if() else if() else !
        if(a > b){
            //executa daca a mai mare ca b
        } else if(a < b){
            // executa daca b mai mare ca a
        }else {
            // executa daca a nu este mai mare ca b si nici b nu este mai mare ca a, adica
            // executa daca a == b
        }
        // lista de if() else if() poate fi lungita la infint
        // de asemena, exista o alta metoda de a scrie mai multe if else:

        int camion = 5;
        switch (camion){
            case 1:
                // executam ceva daca camion este 1
                break;
            case 2:
                // executam ceva daca camion este 2
                break;
            case 10:
                // executam ceva daca camion este 10
                break;
            case 20:
                // executam ceva daca camion este 20
                break;
            default:
                // executam ceva daca camion nu este nici 1, nici 2, nici 10, nici 20
                break;
        }

        /**
         * Switch-ul este folositor in cazul in care trebuie sa verificam daca o variabila are diferite valori pe care deja
         * le stim. de ex, in switch-ul anterior, in cazul in care variabila "camion" era egala cu 1 sau 2 sau 10 sau 20 ("CASE")executam
         * pasi diferiti, in caz contrar, executam pasul "DEFAULT".
         * break -> dupa cum ii spune si numele, opreste ceva. Ce anume? Opreste switch-ul in cazul in care am gasit valoarea pe care o cautam
         * De ex, daca camion avea valoarea 10, am fi verificat daca era egala cu 1, cu 2, iar mai apoi cu 10.
         *      Deoarece 10 == 10 atunci am fi executat pasii regasiti aici. Daca nu exista "Break" la final, am fi cautat in continuare un caz
         *      in care camion ar fi fost egal cu 10. Deoarece nu ar fi gasit nimic, switch-ul ar fi intrat pe cazul default si ar fi executat
         *      si ce se afla acolo. De aceea, este important sa nu uitam de break; in cazul in care folosim switch
         *
         * Switch-ul nu este foarte folosit,rar dam de cazuri in care avem nevoie de el.
         * Acest switch, daca trebuia scris cu if() else ar fi aratat asa:
         * */
        if(camion == 1){
            //executa daca camion este egal cu 1
        } else if(camion == 2){
            //executa daca camion este egal cu 2
        }else if(camion == 10){
            //executa daca camion este egal cu 10
        }else if(camion == 20){
            //executa daca camion este egal cu 20
        } else {
            //executa daca camion nu este egal cu 1,cu 2, cu 10 sau cu 20.
        }


        /**
         * Inca un lucru important este operatorul !  -> NOT . acesta negeaza o conditie
         * exemplu:
         *  */
        int gica = 10, gina = 10;
        if(gina == gica){
            // executa ceva daca gina are valoarea egala cu gica
        }
        if(gina != gica){
            // executa ceva daca gina are valoarea egala cu gina
        }
        if(!(gica < gina)){
            //Conditia initiala este daca gica este mai mic (strict) ca gina, executa, insa
            // operatorul ! schimba conditia cu totul, astfel noua conditie va fi:
            // if(gica >= gina) -> executa
        }

    }

    /**
     * Caz particular pentru MOD
     * Fie a un numar intreg oarecare. Pentru a verifica daca a este un numar par:
     * if(a % 2 == 0)
     *     // atunci numarul a este par
     * else
     *     // atunci numarul a este impar
     *
     * De ce? Orice numar care se imparte exact la 2 (fara rest) este un numar par.
     * Exemplul poate continua:
     * if(a % 3 == 0)
     *    // atunci numarul se imparte exact la 3;
     * else
     *    // numarul nu se imparte exact la 3;
     *
     * */



    /** RECAPITULARE/ DE RETINUT !
     * if(conditie){
     *     executa daca conditia este adevarata
     * }
     *
     * if(conditie){
     *     executa daca conditia este adevarata
     * } else {
     *     executa daca conditia este falsa
     * }
     *
     * Operatori:
     *  <    <- mai mic
     *  >    <- mai mare
     *  <=   <- mai mic sau egal
     *  >=   <- mai mare sau egal
     *  ==   <- egal
     *  %%   <- si
     *  ||   <- sau
     *  !    <- NOT
     *  !=   <- diferit
     *
     *
     *  !(conditie && conditie) == (!conditie || !conditie)
     *  !(conditie && conditie) == (!conditie && !conditie)
     *  !( a > b )  == ( a <= b)
     *  !( a < b )  == ( a >= b)
     *  !( a == b)  == ( a != b)
     *  !( a <= b)   == ( a > b)
     *  !( a >= b)   == ( a < b)

     * */

}
