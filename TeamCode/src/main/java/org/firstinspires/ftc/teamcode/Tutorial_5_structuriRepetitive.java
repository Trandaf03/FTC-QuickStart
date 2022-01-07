package org.firstinspires.ftc.teamcode;

public class Tutorial_5_structuriRepetitive {

    /**
     * In limbajele de programare exista 3 tipuri de structuri repetitive:
     * ------------------------------
     * while(conditie){
     * // EXECUTA
     * }
     * ------------------------------
     * do{
     * // EXECUTA
     * }while(conditie);
     * ------------------------------
     * for(int i = 1 ; i <= n ; i++)
     * ------------------------------
     * <p>
     * Structurile repetitive se impart dupa mai multe categorii:
     * I. Dupa modul de realizare al testului
     * - test initial : while(), for()
     * - test final : do{}while();
     * II. Dupa numarul de pasi
     * - numar de pasi necunoscut: while(), do{}while();
     * - numar de pasi cunoscut : for
     */
    void ignora() {
        /**
         *   STRUCTURA REPETITIVA WHILE
         *   cea mai folosita structura repetitiva, cu test initial si numar necunoscut de pasi
         * */
        int contor = 0, suma = 0;
        while (contor <= 10) {
            suma += 20;
            contor++;
        }
        /**
         * avem un contor care porneste de la 0 si o suma initializata cu 0
         * cat timp contorul este mai mic sau egal cu 10, executam:
         * adunam 20 la suma
         * marim contorul cu 1
         * verificam daca contorul este mai mic ca 10 ( 1 <= 10 ADEVARAT)
         * adunam 20 la suma
         * marim contorul cu 1
         * verificam daca contorul este mai mic ca 10 ( 2 <= 10 ADEVARAT)
         * ......
         * adunam 20 la suma
         * marim contorul cu 1
         * verificam daca contorul este mai mic ca 10 ( 10 <= 10 ADEVARAT)
         * adunam 20 la suma
         * marim contorul cu 1
         * verificam daca contorul este mai mic ca 10 ( 11 <= 10 FALS)
         *
         * in acest moment, conditia este falsa, deci codul o sa iasa din while()
         * am executat acest while de 0 -> 1 -> 2 -> 3 -> ... -> 10 ori
         * asadar, suma la final o sa fie 20*11 = 220 (am pornit de la 0 si am ajuns la 10, deci avem 10-0+1 = 11 pasi;
         *
         * */


        /**
         * STRUCTURA REPETITIVA DO(){}WHILE;
         * spre deosebire de while nu este foarte folosita, are test final si numar necunoscut de pasi
         * spre deosebire de while, care prima data verifica, iar mai apoi executa, aceasta executa si apoi verifica
         * */
        int contor2 = 20, suma2 = 0;
        do {
            contor2++;
            suma2 += 100;
        } while (contor2 <= 10);
        /**
         * avem un contor care porneste de la 20 si o suma initializata cu 0
         * Adunam 1 la contor
         * Adunam 100 la suma
         * Verificam daca contorul este mai mic sau egal ca 10 ( 21 <= 0 F)
         *
         * in acest moment, conditia este falsa, deci codul o sa iasa din do{}while();
         * do{}while este folositor atunci cand vrem ca o structura care trebuie sa se repete sa se execute minim odata.
         * pentru a transforma un do{}while in while{}, tot ce trebuie sa facem este sa verificam conditia la inceput:
         * */
        int contor3 = 20, suma3 = 0;
        if (contor3 <= 10) {
            do {
                contor3++;
                suma3 += 100;
            } while (contor3 <= 10);
        }

        /**
         * STRUCTURA REPETITIVA FOR
         * folosita atunci cand stim numarul de pasi:
         *
         * for(valoare_de_inceput ; valoare_final ; incrementare)
         * */
        int suma4 = 0;
        for (int i = 0; i <= 10; i++) {
            suma4 += 20;
        }
        /** spre deosebire de while si do{}while, for are un contor implementat: in acest caz, i este contorul nostru,
         * care trebuie declarat si inializat cu pozitia de inceput, urmatorul "parametru" este conditia de executare al
         * for-ului, cati de multi pasi va avea acesta, iar ultimul "parametru" este reprezentat de incrementarea contorului
         * In acet caz, dupa executarea codului, contorul va creste cu 1. Daca voiam sa creasca cu 2 de exemplu, i++ trebuia
         * inlocuit cu i = i + 2;
         *
         * Dupa executare, suma va fi egala cu 220. (Executam 10-0+1 = 11 pasi, 20*11 = 220)
         * */


        /** !Putem sa avem si mai multe conditii, asemanator unui if:
         * Operatorii sunt tot && si ||
         * */
        int x = 0, y = 0, suma5 = 0;
        while (x <= 10 && y <= 5) {
            suma++;
            x++;
            y++;
        }
        // in acest caz o sa executam pana y este mai mic sau egal ca 5

        while (x <= 10 || y <= 5) {
            suma++;
            x++;
            y++;
        } // in acest caz o sa executam pana x este mai mic sau egal ca 10




        /**
         * CAZURI PARTICULARE DIV SI MOD!
         * <p>
         * Fie int a = 12345;
         * int ultima_cifra = a % 10;
         * int numarul_fara_ultima_cifra = a/10;
         * <p>
         * Astfel, in variabilele ultima_cifra se va afla 5, iar in numarul_fara_ultima_cifra se va afla 1234
         * Exemplu: suma cifrelor unui numar
         */
        int ab = 123456, sumaCif=0;
        while(ab !=0)
        {
            sumaCif += ab % 10; // adaugam ultima cifra la suma
            ab = ab / 10;   // eliminam ultima cifra a lui ab
        }

        // dupa executare, ab va fi 0, iar sumaCif va fi 21.
    }




}
