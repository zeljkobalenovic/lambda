package app.vezba10;

import java.util.function.BiConsumer;

/**
 * ExceptionLambda
 */
public class ExceptionLambda {

    // primer je sledeci: nizbrojeva , key broj i akcija koja se radi nad svakim parom brojeva (clan niza i key)
    // akcija moze biti npr. sabiranje , mnozenje ili deljenje
    // ako je lambda deljenje , a key je 0 imamo gresku - PITANJE - gde se sve i kako mozemo vatati sa try-catch

    public static void main(String[] args) {
        
        int[] someNumbers = {1,2,3,4};
        int key = 0;

        // ovo ne baca exception
        process(someNumbers, key, (a,b) -> System.out.println(a+b) );

        // ovo baca ArithmeticException koji uredno hvatamo i obradjujemo
        // resenje 2 - bolje gresku hvatamo u lambdi ( problem je sto onda lambda vise nije lepa - jedna linija , ali moze)
        process( someNumbers , key, (a,b) -> {
            try {
                System.out.println(a/b);
            } catch (ArithmeticException e) {
                System.out.println("Greska aritmeticka");
            } 
                 
        } );

        // resenje 3 - vidi u ExceptionLambdaSolution
            
    }
    // BiConsumer je ugradjeni funkcionalni interfejs sa metodom accept koja prima dva integera u mom slucaju i nista nevraca - void
    // takva treba i da je lambda . Radi sa genericima , pa ne moraju biti dva integera moze bilo sta npr. objekti i sl. ali nije bitno
    
    private static void process(int[] v, int k , BiConsumer<Integer,Integer> consumer) {
        for (int i : v) {
            // resenje 1 - moze , ali nevalja - nevalja zato sto ce consumeru biti prosledjena lambda
            // sta ako se prosledi neki deugi izraz koji ne baca ArithmeticException nego radi nesto drugo 
            // i baca sasvim drugaciji tip greske 
            // morao bi catch da hvata sve zive moguce greske kojih moze biti milion u zavisnosti od toga
            // sta lambda expresion radi i kakve greske hvata - ovako NIKAD ne raditi
     //       try {
                consumer.accept(i, k);
     //       } catch (ArithmeticException e) {
                // nesto uradi sa uhvacenomk greskom
    //        }
            
        }
    }
}