package app.vezba1;

/**
 * Greeter
 */
public class Greeter {

    // ova metoda ce uvek isto isprintati kad se pozove
    public void greet1() {
        System.out.println("Java greeting");
    }

    // sta ako hocemo da radi razlicite stvari u zavisnosti od parametra
    // moze ovako , ali nije lepo    

    public void greet2(int i){
        switch (i) {
            case 1:
            System.out.println("prva opcija stampe");
            break;
            case 2:
            System.out.println("druga opcija stampe");
            break;
            case 3:
            System.out.println("treca opcija stampe");
            break;
            default:
            System.out.println("default opcija stampe");
            break;
        }
        
    }

    // pre jave 8 najelegantnije je napraviti interfejs i njega proslediti kao parametar 
    // ovako ce metoda raditi bilosta sto joj onaj koji je implementirao taj interfejs naredi
    // primer je sa 2 implementacije interfejsa , ali moze bezbroj 
    // ovo je klasican polimorfizam u oop  - ovako se do jave8 radilo
    

    public void greet3(Greeting greeting) {
        greeting.action();
    }



    public static void main(String[] args) {

        Greeter greeter = new Greeter();
        GreetingImpl1 greetingImpl1 = new GreetingImpl1();
        GreetingImpl2 greetingImpl2 = new GreetingImpl2();

        greeter.greet3(greetingImpl1);
        greeter.greet3(greetingImpl2);
        
    }
}


