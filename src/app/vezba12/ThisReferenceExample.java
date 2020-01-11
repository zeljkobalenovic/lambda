package app.vezba12;

// prikazuje razliku izmedju inner anonimus implementacije i lambde u tretiranju kljucne reci this

// this referenca nekog objekta uvek pokazuje referencu na samu instancu tog objekta !!!

public class ThisReferenceExample {

    // isto kao u prosloj vezbi samo sad nije static metod , nego instnsni metod
    public void doProcess(int i, Process p) {
        p.process(i);
    }

    // sad je lambda u
    public void execute() {
        // posto lambda nedira this onda ce stampati ovaj this , a to je instanca
        // objekta koji je pozvao metodu execute
        doProcess(10, (i) -> {
            System.out.println("Value of i is : " + i);
            System.out.println(this);
        });
    }

    public static void main(String[] args) {
        ThisReferenceExample thisReferenceExample = new ThisReferenceExample();

        // System.out.println(this); ovo ne moze jer nema this u static kontekstu

        thisReferenceExample.doProcess(10, new Process() {

            @Override
            public void process(int i) {
                System.out.println("Value of i is : " + i);
                System.out.println(this); // this pokazuje na instancu ove Process klase koja je upravo implementirana
            }

            // znaci napravi se instanca te inner anonimus klase i this sad pokazuje na nju
            // , a van nema thisa jer je static kontext
            @Override
            public String toString() {
                return "This is anonymous inner class";
            }
        });

        // sad lambda VAZNO - lambda ne dira this tj. pokazuje na onaj this koji je van
        // lambde , a vidimo da ga ovde nema
        thisReferenceExample.doProcess(10, (i) -> {
            System.out.println("Value of i is : " + i);
            // System.out.println(this); // greska cannot use in static context sto dokazuje
            // da lambda ne utice na this tj.isti je
        });

        //

        thisReferenceExample.execute();
    }

    @Override
    public String toString() {
        return "This is instance of ThisReferenceExample class";
    }


    

   
}



interface Process {
    void process(int i);
}