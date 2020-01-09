package app.vezba8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


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
       
    }

    private static void printConditionally(List<Person> people , Condition condition) {
        for(Person p : people) {
            if ( condition.test(p)) {
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

