package app.vezba10;

import java.util.function.BiConsumer;

/**
 * ExceptionLambdaSolution
 */
public class ExceptionLambdaSolution {

    public static void main(String[] args) {
        
        int[] someValues = {1,2,3,4};
        int key = 0;

        process( someValues , key , (a,b) -> System.out.println(a+b));
        
        // ovo baca gresku za key=0 - kako ostaviti jednostavnu lambdu u jednom redu , a vatati gresku
        // resenje je wraper lambda u koju ubacujemo nasu lambdu
        process( someValues,  key, wraperLambda3((a,b) -> System.out.println(a/b)));
    }

    private static void process(int[] v, int k, BiConsumer<Integer,Integer> consumer) {
        for (int i : v) {
            consumer.accept(i, k);
        }
    }

    // korak1 - wraper prima lambdu kao parametar i vraca istu kao povratnu vrednost - oba su tipa BiConsumer interfejsa
    private static BiConsumer<Integer,Integer> wraperLambda1( BiConsumer<Integer,Integer> consumer) {
        return consumer;        
    }

    // korak2 - wraper prima lambdu kao parametar i vraca neku drugu lambdu koja radi nesto drugo
    // primi kao parametar lamdu koja deli , a u stvari sabere
    private static BiConsumer<Integer,Integer> wraperLambda2( BiConsumer<Integer,Integer> consumer) {
        return (a,b) -> System.out.println(a+b);        
    }

    // korak3 - wraper prima lambdu kao parametar i vraca neku drugu lambdu koja izvrsava onu koju je dobila tj. consumer.accept
    // sada to uvijemo u try catch i ukrasimo kako hocemo
    // PITANJE - koja je dobit od ovog ako gomilu koda premestimo sa jednog na drugo mesto 
    // ODGOVOR - main ostaje elegantan - Sve ovo je upitno - sta je bolje , ali greske se svakako vataju sa resenje2 ili resenje3
    private static BiConsumer<Integer,Integer> wraperLambda3( BiConsumer<Integer,Integer> consumer) {
        return (a,b) -> {
           try {
            consumer.accept(a, b);
           } catch (ArithmeticException e) {
               System.out.println("Doslo je do greske");
           }
           
             
        } ;      
    }


}