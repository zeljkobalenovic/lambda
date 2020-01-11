package app.vezba11;

/**
 * ClosuresExample
 */
public class ClosuresExample {

    public static void main(String[] args) {
        int a=5;
        int b=20;
                
        // inner anonimus implementacija
        doProcess(a, new Process(){

            @Override
            public void process(int i) {
                System.out.println(i + b);                
            }            
        });

        // Closures - isto je i u gornjoj java7 implementaciji i sa lambda java8 implementacijom
        // Odnosi se na bilo kakve varijable ( ovde a i b ). One su vidljive u main , iz main se poziva metoda 
        // koja je van njega doProcess pa a i b nebi trebalo da budu vidljive , ali jesu. Kada inner anonimna implementacija
        // ili lambda ( koje jesu u main ) koriste takvu promenjivu oni prave svoju kopiju u koju smestaju njenu vrednost i to prosledjuju spoljnoj 
        // metodi kao parametar ( sama lambda je parametar ), pa spoljna metoda moze da ih koristi.
        // VAZNO - da bi to radilo , a ne izazvalo probleme takve promenjive ukoliko se tako koriste u lambdi ili inner anonimus
        // implementaciji interfejsa moraju biti final (do jave7 eksplicitno ) ili se ponasati kao final ( efektivno final implicitno od jave8)
        // to znaci da se NE MOGU menjati ni u main ni u doProcess da nebi doslo do konfuzije;        
        
        // lambda implementacija
        doProcess(a, i -> System.out.println(i + b));
    } 

    // metoda koja nesto radi sa i - sta zavisi kako implementiramo procces interfejs- process metodu
    public static void doProcess(int i, Process p ) {
        p.process(i);
    }  
    
}

interface Process {
    void process(int i);
}