package app.vezba9;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import app.vezba8.Person;


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
    Collections.sort(people, (p1, p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName()));      
    // create a method that prints all elements in the  list
    System.out.println("Stampaj celu listu");
    // printAll(people);
    printConditionally2(people, p -> true , p -> System.out.println(p));        
    // create a method that prints all people that have last name beginning with C
    System.out.println("Stampaj koji pocinju sa c");     
    printConditionally2(people,  p -> p.getLastName().startsWith("C"),p -> System.out.println(p) );   // sa ugradjenim predicate interfejsom
    // sad lako menjamo sta da se uradi - konkretno drugacija stampa
    printConditionally2(people,  p -> p.getLastName().startsWith("C"),p -> System.out.println(p.getFirstName()) ); 
}
    
    
    // ovako ce metoda uvek stampati persone koji zadovoljavaju uslov 
    // dodajemo jos jedan parametar - ustvari interfejs koji odredjuje sta ce se raditi, nemora uvek ista stampa
    // gore kao parametar dodajemo lambdu koja ima isti otisak kao accept metoda consumer interfejsa
    private static void printConditionally2(List<Person> people , Predicate<Person> predicate , Consumer<Person> consumer) {
        for(Person p : people) {
            if ( predicate.test(p) ){
                consumer.accept(p);
                
            }
            
        }
    }

    

    
}

