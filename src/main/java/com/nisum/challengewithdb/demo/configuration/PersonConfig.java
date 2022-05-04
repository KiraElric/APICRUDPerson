package com.nisum.challengewithdb.demo.configuration;

import com.nisum.challengewithdb.demo.model.Person;
import com.nisum.challengewithdb.demo.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PersonConfig {
    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository){
        return args -> {
            List<Person> people = new ArrayList<>();
            Person person1 = new Person("Kyle","Broflovski","10554345-1",10);
            people.add(person1);
            Person person2 = new Person("Stan","Marsh","10446789-1",10);
            people.add(person2);
            Person person3 = new Person("Eric","Cartman","10665432-8",10);
            people.add(person3);
            Person person4 = new Person("Kenny","McCormick","10775378-2",10);
            people.add(person4);
            Person person5 = new Person("Butters","Stotch","11776537-1",10);
            people.add(person5);
            Person person6 = new Person("Clyde","Donovan","12556345-1",10);
            people.add(person6);
            Person person7 = new Person("Craig","Tucker","15667456-8",10);
            people.add(person7);
            Person person8 = new Person("Jimmy","Valmer","15435674-2",10);
            people.add(person8);
            Person person9 = new Person("Randy","Marsh","18776392-1",45);
            people.add(person9);
            Person person10 = new Person("Gerald","Broflovski","18773627-1",42);
            people.add(person10);
            Person person11 = new Person("Jimbo","Kern","19773629-8",38);
            people.add(person11);
            Person person12 = new Person("Stephen","Stotch","18773623-2",40);
            people.add(person12);

            repository.saveAll(people);
        };
    }
}
