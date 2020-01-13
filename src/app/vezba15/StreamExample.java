package app.vezba15;

import java.util.Arrays;
import java.util.List;

import app.vezba8.Person;

/**
 * StreamExample
 */
public class StreamExample {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
        new Person("Charles", "Dickens", 60),
        new Person("Lewis", "Carroll", 42),
        new Person("Thomas", "Carlyle", 51),
        new Person("Charlotte", "Bronte", 45),
        new Person("Matthew", "Arnold", 39)
    );

    people.stream()
        .filter(p->p.getLastName().startsWith("C"))
        .forEach(p->System.out.println(p.getFirstName()));

    people.parallelStream()  // za multitasking potencijalni paralel stream ispadne i drugaciji rezultat ali ok posto redosled nije bitan
        .filter(p->p.getLastName().startsWith("C"))
        .forEach(p->System.out.println(p.getFirstName()));
    }
    
}

// VAZNO - stream je izuzetno koristan pattern za multitasking - ako se nad kolekcijom sprovodi vise od jedne metode

// Najbolja analogija je proizvodna traka za automobile - kolekcija su automobili npr njih 10 komada
// Metode su recimo stavi tocak , stavi motor i stavi gumu
// glupo je da svaki od tri metoda (radnika) prolazi celu kolekciju i stavlja svoje , pa sledeci i tako dalje
// bolje je da se automobili stave na traku ( stream ) , a da radnici obavljaju svako svoju metodu kad aut dodje do njih

// gore imamo dve metode , jedna filtrira a druga stampa. Bez strima bi prvo filtrirali CELU kolekciju pa bi rezultat 
// izfiltriranu kolekciju prosledili dalje na stampu , ovako sve ide u jednom prolazu , a lako je za multitasking
// mogu dva persona u jedan task , a tri u drugi i sve se radi pararelno

// VAZNO - svaka metoda MOZE DA MODIFIKUJE elemenat streama sa kojim radi
// u nasem slucaju prva metoda filter jednostavno izbacuje persone sa trake i oni neidu na stampu, mogla je i nesto drugo da radi