package app.vezba2;

/**
 * Greeter
 */
public class Greeter {

    
    // pre jave 8 najelegantnije je napraviti interfejs i njega proslediti kao parametar 
    // ovako ce metoda raditi bilosta sto joj onaj koji je implementirao taj interfejs naredi      

/*    public void greet(Greeting greeting) {
        greeting.action();
    }

    public static void main(String[] args) {

        Greeter greeter = new Greeter();
        GreetingImpl1 greetingImpl1 = new GreetingImpl1();
        greeter.greet(greetingImpl1);       
        
    }
    */

    // hocemo da se izvrsi neka akcija mi prosledjujemo instancu objekta koji ima implementiranu tu akciju
    // sta ako hocemo da se prosledi kao parametar samo akcija i da se ona izvrsi bez objekata, klasa i sl.
    // moze sa lambda . sama akcija koju hocemo da izvrsimo je ustvari blok koda  {blok koda} koji dodeljujemo
    // nekoj promenljivoj kao i bilo koji drugi objekat , ili string ili nesto slicno

    // String s = "Neki string";
    // int i = 14;

    // da li onda moze
    /* blokkoda = {
        ...
        ...
    }
    */
    /* kako da od donjeg metoda napravimo gornje 
    public void action() {
        System.out.println("prva implementacija stampe");
    }
    */

    // blokkoda = public void action() {
    //    System.out.println("prva implementacija stampe");
    //  }

    // korak 1 - ne treba nam access modifajer jer funkcija pripada onom ko je zove , nije u klasi
    // blokkoda = void action() {
    //    System.out.println("prva implementacija stampe");
    //  }
    // korak 2 - ne treba nam ime jer koristimo imepromenljive za poziv (kod mene blokkoda), netreba jos jedno ime
    // blokkoda = void () {
    //    System.out.println("prva implementacija stampe");
    //  }
    // korak 4 - izmedju parametra metode i tela MORA se dodati -> sto oznacava lambda izraz
    // blokkoda =  () -> {
    //    System.out.println("prva implementacija stampe");
    //  }

    // Na gornji nacin se SVAKA metoda po starom moze napisati kao lambda izraz po novom i kao takva 
    // pridruziti nekoj promenjivoj ili proslediti kao parametar
    // SAMO AKO je telo metode jedan red nemora ni zagrade {}
    // blokkoda = () -> System.out.println("prva implementacija stampe");

    /* jos primera kako se od metode pravi lambda izraz
        public int addNumber(int a, int b){
            return a+b;
        }
        postaje
        addNumberFunction = (int a,int b) -> a+b        // ako je blokkoda jedna linija osim {} netreba ni return
        public double divideNumber(int a,int b){
            if (b==0) return 0;
            return a/b;
        }
        postaje
        divideNumber = (int a, int b) -> {
            if (b==0) return 0;
            return a/b
        }
        public int lenghtOffString (String s) {
            return s.lenght();
        }
        postaje
        duzinaStringa = (String s) -> s.lenght();

        // zasad je problem sto sve te promenljive kojima pridruzujemo lambda izraz nemaju tip 
        // duzinaStringa je promenljiva , ali kojeg tipa i kako da izvrsimo tu funkciju
        // vezba 3

    */
    public static void main(String[] args) {
        
    }
    









    
}


