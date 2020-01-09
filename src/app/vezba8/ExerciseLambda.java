package app.vezba8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ExerciseLambda
 */

 // VAZNO . Da bi se koristila lambda potreban je interfejs sa samo JEDNOM metodom i da lambda ima isti otisak kao ta
 // metoda (iste parametre po broju i tipu i isti tip povratne vrednosti) - npr kao u vezbi 7

 // JAVA8 - dozvoljava da interfejs sadrzi i metode sa napisanom implementacijom , pa vazi da takav interfejs
 // moze da se koristi samo ako ima tacno jednu APSTRKTNU metodu ciji otisak onda lambda sledi
 // ako interfejs ima vise od jedne metode pre jave 8 ili vise od jedne apstraktne metode od jave 8 onda to
 // nemoze biti funkcionalni interfejs - interfejs koji se moze koristiti za lambdu
 // ako se interfejs ne moze koristiti za lambdu onda MORAMO kao i pre jave 8 da pisemo implementaciju 
 // externu u posebnoj klasi ili inline u klasi gde ga koristimo ( inner anonimus klasa)
 // sta ako mi napisemo ili koristimo neki interfejs koji je ok za lambdu , a neko posle doda jos metoda 
 // resenje je @FunctionalInterface anotacija - opciona je - ali ako je stavimo na interfejs kompajler nece
 // dozvoliti dodavanje metoda u interfejs - od jave 8 se PREPORUCUJE stavljanje ove anotacije npr. runnable interfejs
 // je ima sto se moze videti u njegovom kodu 

 // za vezbu cemo raditi sa objektom Person - klasika 3 atributa, geteri, seteri, tostring, i allargs construktor

 public class ExerciseLambda {

   
    public static void main(String[] args) {
        
        List<Person> people = Arrays.asList(
        new Person("Charles", "Dickens", 60),
        new Person("Lewis", "Carroll", 42),
        new Person("Thomas", "Carlyle", 51),
        new Person("Charlotte", "Bronte", 45),
        new Person("Matthew", "Arnold", 39)
    );

    // Zadatci za vezbu
    // sort list by last name
    // create a method that prints all elements in the  list
    // create a method that prints all people that have last name beginning with C
    // Na oba nacina pre jave 8 kao inner impl interfejsa i posle jave 8 sa lambda ekspresion
       
    // Zadatak1 inner anonimus klasa koja implementira interfejs zadatak1
    Zadatak1 z1stari = new Zadatak1(){
    
            @Override
            public List<Person> izvrsi(List<Person> people) {
                Collections.sort(people, new LastNameComparator());
                return people;
            }
    };
    
    
    System.out.println("Stari nacin zadatak 1");
    System.out.println(people); // za proveru people pre sortiranja - pocetna
    z1stari.izvrsi(people);
    System.out.println(people); // za proveru people posle sortiranja - krajnja
    
    // Zadatak1 lambda koja je tipa interfejsa Zadatak1 sa istim otiskom kao jedina metoda izvrsi 

    Zadatak1 z1lambda = people1 -> {
        Collections.sort(people1, new LastNameComparator());
        return people1;
    };

    System.out.println("Novi lambda nacin zadatak 1");
    System.out.println(people); // za proveru people pre sortiranja - pocetna
    z1lambda.izvrsi(people);
    System.out.println(people); // za proveru people posle sortiranja - krajnja
    
    
       

    }

    interface Zadatak1 {
        List<Person> izvrsi( List<Person> people);
    }
}