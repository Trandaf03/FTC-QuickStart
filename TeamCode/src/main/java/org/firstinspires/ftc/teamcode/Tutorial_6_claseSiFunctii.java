package org.firstinspires.ftc.teamcode;
//2. Clasa noastra se afla in package-ul de mai sus. Proietul este impartit in doua,
// TeamCode - unde programam noi, si FtcRobotController - aplicatia propriu-zisa, de care nu o sa ne atingem
// Acestea se afla intr-un fisier mai mare (in acest caz, FTC-QuickStart, instalat de voi, iar
// comanda de mai sus practic ii spune codului pozitia clasei acesteia din proiect


/**
 * 1. Acum ca avem o oarecare idee despre cum functioneaza bazele programarii cam in orice limbaj,
 * ar trebui sa revenim la Java.
 *
 * Din cate a-ti putut observa pana acum, fiecare tutorial a fost intr-un "fisier" diferit.
 * Acesta se numeste clasa: este un "document text", cu extensia .java, unde scriem codul.
 *
 * Pentru a urmari mai usor, am sa numerotez comentariile, pentru a fi citite mai usor.
 *
 * */


/** 3.
 * public class Tutorial_6_claseSiFunctii reprezinta tipul clasei (public, toate clasele sunt publice)
 * si numele acesteia : Tutorial_6_claseSiFunctii
 * ATENTIE! Numele clasei din cod ( de mai jos ) trebuie sa fie exact acelasi cu numele documentului .java (cel din stanga, pe care
 * ati apasat pentru a deschide aceast tutorial
 *  */
public class Tutorial_6_claseSiFunctii { // 4. Clasa este delimitata de '{' si de '}' , incepe aici

    /**
     * 6. Codul nostru va fi creat in interiorul unei clase.
     * Nu inainte, nu dupa. In interior.
     * */


    /**
     * 7. Intr-o clasa pot exista mai multe functii.
     * Principala functie care va fi executata este functia constructor. Aceasta este de tip void, si are acelasi nume cu numele clasei
     * Ea are prioritate in executarea codului.
     * */
    void Tutorial_6_claseSiFunctii(){

    }
    /**
     * 8. O functie are urmatoarea structura:
     *      tip_functie nume_functie(parametrii){
     *        // COD
     *        return valoare;
     *      }
     *      unde:
     *      - tip functie este reprezentat de:
     *      int,boolean,double,float,char,String, etc -> toate variabilele existente
     *      void -> functia care nu returneaza nimic
     *      - nume functie este reprezentat de numele functiei, precum numele unei variabile, acesta poate fi orice
     *      - parametrii - acestia sunt obtionali
     *      - return valoare :
     *          cu exceptia functiilor de tip void, orice functie returneaza informatii de acelasi tip cu numele functiei
     * */

    /**9.
     * Functia cu numele "suma" de tip "int" cere drept parametrii doua numere de tip "int" (a si b)
     * si returneaza suma acestor doua numere
     * */
    int suma(int a,int b){
        return a+b;
    }
    /**10.
     * Functia cu numele "medie" de tip "double" (media a doua numere in unele cazuri nu este numar intreg) cere
     * drept parametrii doua numere de tip "int" (a si b) si returneaza suma acestor doua numere
     * */
    double medie(int a, int b){
        return (a+b)/2;
    }
    /**11.
     * Functia cu numele "esteNumarPar" cere drept parametru un numar intreg a si returneaza adevarat daca acesta este
     * un numar par, respectiv fals daca un numar este fals
     * */
    boolean esteNumarPar(int a){
        if(a % 2 == 0){
            return true;
        } else return false;
    }
    /**12.
     * În exemplele de mai sus ne-am folosit de variabile locale. Ce sunt acestea?
     * Sunt valori existente doar in functia respectiva, care nu pot fi accesate din alta functie.
     * de exemplu, daca vrem sa accesam oricare dintre variabilele "a" de mai sus, nu o sa putem face asta.
     * */

    int varGlobala = 10;

    /**13.
     * Variabila de tip intreg (int) varGlobala este o variabila globala:
     * - aceasta nu se afla intr-o nicio alta functie
     * - aceasta se afla in intermediul clasei "Tutorial_6_claseSiFunctii"
     * - aceasta poate fi accesata din oricare alta functie
     * */

    void modifica(){
        varGlobala = 100;
    }
    /**
     * 14 .Functia de tip "void" numita "modifica", la fel cum ii spune si numele, modifica valoarea globala varGlobala
     * din oricat ar fi fost ea in 100. Puteti observa ca nu am returnat nimic, iar varGlobala nu a fost ceruta nici
     * drept parametru
     * */

} // 5. si se termina aici
// ! Aveti grija la {}, ele sunt extrem de importante. Daca stergeti una poate duce la erori.
