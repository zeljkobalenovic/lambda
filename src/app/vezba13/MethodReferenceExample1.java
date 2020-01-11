package app.vezba13;

/**
 * MethodReferenceExample
 */
public class MethodReferenceExample1 {

    public static void printMessage() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        
       printMessage();

       Thread t = new Thread( () -> printMessage());
       // ova lambda nema parametara i izvrsava metodu bez parametara onda moze metod referenc
       Thread t2 = new Thread( MethodReferenceExample1::printMessage ); // naziv klase :: naziv metoda ( varijanta sa static metodom )
       t.start();
       t2.start();
    }
}

