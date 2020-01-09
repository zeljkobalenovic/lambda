package app.vezba7;

/**
 * RunableExample
 */

 // JEDINI uslov da koristimo lambdu umesto implementacije nekog interfejsa na klasican nacin je da taj interfejs 
 // ima samo JEDNU metodu za implementaciju - to su tzv. funkcionalni interfejsi 

 // jedan primer su tread-ovi , oni implementiraju runnable interfejs koji ima samo jednu metodu run - znaci moze lambda

public class RunableExample {

    public static void main(String[] args) {
        
        // nacin 1 Thread gde je interfejs externo implementiran extendovan obican pa overajd run metode 
        Thread clasicThread = new MyThread();
        clasicThread.run();

        // nacin 2 Thread implementiran u inner anonimus class
        Thread innerThread = new Thread( new Runnable(){
        
            @Override
            public void run() {
                System.out.println("Inner Thread");
            }
        });
        innerThread.run();

        // nacin 3 Lambda thread - mora da ima isti otisak kao run metoda u runnable interfejsu - kao gore
        // new Thread() ocekuje konkretnu implementaciju runnable interfejsa kao u nacinu 2 , a lambda je
        // bas to jer je ona sa istim otiskom kao i metoda run() u runnable interfejsu, tj. lambda zahvaljujuci
        // tome sto je interfejs tipa moze da se koristi sa kodom iz starije jave
        Thread lambdaThread = new Thread(() -> System.out.println("Lambda Thread")) ;
        lambdaThread.run();

    }

    
}