package app.vezba8;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Person>{

    @Override
    public int compare(Person a, Person b) {
         return a.getLastName().compareToIgnoreCase(b.getLastName());
    }

}
