package app.vezba6;

import app.vezba6.AddingNumber.AddingNumberInterface;

public class AddingNumberInterfaceImpl implements AddingNumberInterface {

    @Override
    public int addnum(int[] niz) {
        int suma = 0;
        for (int i = 0; i < niz.length; i++) {
            suma = suma + niz[i];
        }
        return suma + 100;
    
    }

}
