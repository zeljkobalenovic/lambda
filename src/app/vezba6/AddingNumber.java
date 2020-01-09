package app.vezba6;

/**
 * AddingNumber
 */
public class AddingNumber {

    // vezba 6 - dosad predjeno hocemo sumu niza brojeva , ali na razne nacine sa raznim rezultatima
    

    public static void main(String[] args) {     
        
        int[] nizbrojeva = {2,5,8,7};

        
        // nacin 1 - klasican interfejs implementiran u spoljnoj klasi - dodaje 100
        AddingNumberInterface extImpl = new AddingNumberInterfaceImpl();
        System.out.println(extImpl.addnum(nizbrojeva)); 
        
        // nacin 2 - interfejs implementiran inner class anonimna - dodaje 200
        AddingNumberInterface intImpl = new AddingNumberInterface() {
        
                @Override
                public int addnum(int[] niz) {
                    int suma = 0;
                    for (int i = 0; i < niz.length; i++) {
                        suma = suma + niz[i];
                    }
                    return suma + 200;
                }
        };

        
        System.out.println(intImpl.addnum(nizbrojeva)); 

        // nacin 3 lambda funkcija sa istim otiskom kao jedina metoda interfejsa - dodaje 300
        AddingNumberInterface lambdaImpl = niz -> {
            int suma = 0;
            for (int i = 0; i < niz.length; i++) {
                suma = suma + niz[i];
            }
            return suma + 300;
        };

        System.out.println(lambdaImpl.addnum(nizbrojeva)); 

    }

    
    public interface AddingNumberInterface {
        int addnum(int[] niz);
    }

    
       
        


    }

    
    
    

    
