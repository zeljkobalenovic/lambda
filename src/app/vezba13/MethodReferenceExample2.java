package app.vezba13;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import app.vezba8.Person;


 public class MethodReferenceExample2 {

   
    public static void main(String[] args) {
        
        List<Person> people = Arrays.asList(
        new Person("Charles", "Dickens", 60),
        new Person("Lewis", "Carroll", 42),
        new Person("Thomas", "Carlyle", 51),
        new Person("Charlotte", "Bronte", 45),
        new Person("Matthew", "Arnold", 39)
    );
   
    
    System.out.println("Stampaj celu listu");
    // ovde isto moze method reference - imamo lambdu koja ima jedan argument p i metodu koja se izvrsava za taj jedan argument
    printConditionally2(people, p -> true , p -> System.out.println(p));   
    // sa method reference krace - println je metoda instance System.out
    // kako zna da treba da odstampa p - tako sto je na mestu consumera a on ima person argument
    printConditionally2(people, p -> true, System.out::println );
    
    }
    
    private static void printConditionally2(List<Person> people , Predicate<Person> predicate , Consumer<Person> consumer) {
        for(Person p : people) {
            if ( predicate.test(p) ){
                consumer.accept(p);
                
            }
            
        }
    }

    

    
}

