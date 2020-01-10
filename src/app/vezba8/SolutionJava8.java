package app.vezba8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;


 public class SolutionJava8 {

   
    public static void main(String[] args) {
        
        List<Person> people = Arrays.asList(
        new Person("Charles", "Dickens", 60),
        new Person("Lewis", "Carroll", 42),
        new Person("Thomas", "Carlyle", 51),
        new Person("Charlotte", "Bronte", 45),
        new Person("Matthew", "Arnold", 39)
    );
   
    // sort list by last name

    // Collections.sort(people,new Comparator<Person>() {

    //         @Override
    //         public int compare(Person o1, Person o2) {
    //             return o1.getLastName().compareToIgnoreCase(o2.getLastName());
    //         }
    // });

    Collections.sort(people, (p1, p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName()));  // puno krace od onog iznad
        
    // create a method that prints all elements in the  list
    System.out.println("Stampaj celu listu");
    // printAll(people);
    printConditionally(people, p -> true);  // moze umesto printAll
    
    
    
    // create a method that prints all people that have last name beginning with C
    System.out.println("Stampaj koji pocinju sa c");
    // printConditionally(people , new Condition(){
    
    //     @Override
    //     public boolean test(Person p) {
    //         return p.getLastName().startsWith("C") ;
    //     }
    // });

    printConditionally(people,  p -> p.getLastName().startsWith("C"));   // puno krace od onog iznad
    printConditionally2(people,  p -> p.getLastName().startsWith("C"));   // sa ugradjenim predicate interfejsom
    }
    // drugi parametar ove funkcije je tipa interfejsa condition i zato mu mozemo proslediti lambdu 
    // sa istim otiskom metode test ( prima objekat Person , vraca boolean)
    private static void printConditionally(List<Person> people , Condition condition) {
        for(Person p : people) {
            if ( condition.test(p)) {
                System.out.println(p);
            }
            
        }
    }

    // NOVO - VAZNO Java8 
    // Java8 ima gomilu interfejsa spremnih za upotrebu za sve uobicajene potrebe , koji se mogu koristiti umesto
    // da sami pisemo , samo da bi upotrebili lambdu - nalaze se u java.util.function 
    // Predicate interfejs je jedan koji je kao nas stari condition , ima metod test koji prima objekat , a vraca boolean
    // sada vidimo da za vecinu potreba nije nuzno da sami pisemo interfejs nego koristimo onaj koji nama treba
    // sada samo zamenimo funkcije printConditionally i printConditionally2 - java ostaje ista

    private static void printConditionally2(List<Person> people , Predicate<Person> predicate) {
        for(Person p : people) {
            if ( predicate.test(p) ){
                System.out.println(p);
            }
            
        }
    }

    private static void printAll(List<Person> people) {
        for(Person p : people) {
            System.out.println(p);
        }
    }

    
}

