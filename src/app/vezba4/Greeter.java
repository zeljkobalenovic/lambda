package app.vezba4;

/**
 * Greeter
 */
public class Greeter {


    public void greet(Greeting greeting) {
        greeting.action();
    }

    public static void main(String[] args) {

        Greeter greeter = new Greeter();
        
        Greeting myLambdaFunction = () -> System.out.println("lambda funkcija akcija");
        // gornje je lambda funkcija tipa Greeting interfejsa 
        // kako se gornje razlikuje od ovog dole - vezba 4        
        // donje je instanca custom implementacije Greeting interfejsa
        Greeting greetingImpl = new GreetingImpl1(); 

        // ovako se poziva metoda koja je implementirana
           greetingImpl.action(); 

        // potpuno isto se poziva i lambda funkcija ( znaci ime promenjive , pa naziv metoda iz interfejsa)   
           myLambdaFunction.action();   
           
        // impementacija Greeting interfejsa moze i direktno preko inner anonimne klase
        // onda se vidi vise slicnosti sa lambdom - VAZNO slicno je ali nije isto
        
        Greeting innerGreetingImpl = new Greeting() {

            @Override
            public void action() {
                System.out.println("inner anonimus class akcija");
            }

        };

        // ovako onda pozivamo metodu inner anonimne klase
        innerGreetingImpl.action();


// ovako se pocetni problem iz vezbe 1 moze na 3 razlicita nacina resiti - lambda najbolje
        greeter.greet( innerGreetingImpl );
        greeter.greet( greetingImpl );
        greeter.greet( myLambdaFunction );

 

        
        
        
    }   

    
    
    
}

