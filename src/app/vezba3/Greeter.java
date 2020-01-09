package app.vezba3;

/**
 * Greeter
 */
public class Greeter {


    public void greet(Greeting greeting) {
        greeting.action();
    }

    public static void main(String[] args) {

        Greeter greeter = new Greeter();
        Greeting greetingImpl1 = new GreetingImpl1();
        greeter.greet(greetingImpl1);

        // ovo gornje radi znaci imamo interfejs i njegovu implementaciju, kako to isto preko lambde
        /* znzci ovo je akcija - metod
        public void action() {
            System.out.println("prva implementacija stampe");    
        }
        lambda koja menja gornji metod je */

        // koji je tip te lambda funkcije ??
        // korak 1 pravimo interfejs i lambda funkcija je tipa tog interfejsa 
        // obavezno je da taj interfejs ima SAMO JEDNU METODU , i da ta metoda ima isti otisak kao
        // metoda koju menja nasa lambda funkcija (nema argumenata , a vraca void)
        // posto je ime interfejsa nebitno i ime metoda u njemu takodje mozemo koristiti i neki
        // postojeci interfejs u nasem slucaju Greeting.java zato sto on ispunjava uslove
        // ima samo jednu metodu , i ona ima otisak koji nam treba (nema argumenata , a vraca void )
        // tako da NE MORAMO praviti interfejs , ako ga imamo tj. korak 1 je opcioni

     //   Greeting myLambdaFunction = () -> System.out.println("lambda funkcija akcija");

        // kako se gornje razlikuje od ovog dole - vezba 4        
     //   Greeting greetingImpl = new GreetingImpl1();
        
        
    }   

    // public interface MyLambda {
    //     void blabla();  
    //     }
    
    
}

