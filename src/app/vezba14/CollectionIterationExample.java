package app.vezba14;

import java.util.Arrays;
import java.util.List;

import app.vezba8.Person;

/**
 * CollectionIterationExample
 */
public class CollectionIterationExample {

    public static void main(String[] args) {
        
        List<Person> people = Arrays.asList(
        new Person("Charles", "Dickens", 60),
        new Person("Lewis", "Carroll", 42),
        new Person("Thomas", "Carlyle", 51),
        new Person("Charlotte", "Bronte", 45),
        new Person("Matthew", "Arnold", 39)
    );    
    // PRE jave 8 iteracija kroz kolekcije 
    for (int i = 0; i < people.size(); i++) {
        System.out.println(people.get(i));
    }
    // ili ( takozvana for in iteracija)
    for (Person p : people) {
        System.out.println(p);
    }
    // java8 ima nove metode iteracije kroz kolekcije zasnovane na lambdi
    people.forEach(p->System.out.println(p));       // Consumer intefejs je funkcionalan i zato lambda
    // ili jos krace zapisana lambda kao method reference
    people.forEach(System.out::println);
    }

    // VAZNO - Uvek treba koristiti ovaj novi nacin 
    // Stari nacini su zasnovani na eksternoj iteraciji gde se iteracija odvija nezavisno od onoga sta se radi - tesko za multitasking
    // Novi nacin je zasnovan na internoj iteraciji koju je lako baciti u multitreding
    // savremeni kompajleri i procesori ladno ubrzavaju ove iteracije , recimo bace dva persona u jedan thread , a tri u drugi
    // pa ih izvrsavaju ( naravno kad je nesto stvarno komplikovano , a ne samo system.out.println)

    // Java8 uvodi puno novih metoda za rad sa kolekcijama , ne samo foreach , a sve se zasnivaju na konceptu streamova
}