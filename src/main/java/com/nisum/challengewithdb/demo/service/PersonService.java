package com.nisum.challengewithdb.demo.service;

import com.nisum.challengewithdb.demo.model.Person;
import com.nisum.challengewithdb.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPeople() {
        return personRepository.findAll();
    }

    public List<Person> filterPeople() {
        List<Person> allPeople = personRepository.findAll();;
        List<Person> filteredByAge = new ArrayList<>();
        for(Person p : allPeople){
            if(p.getAge() > 18){
                filteredByAge.add(p);
            }
        }
        return filteredByAge;
    }

    public void createNewPerson(Person person) {
        Optional<Person> personByRut = personRepository.findPersonByRut(person.getRut());
        if(personByRut.isPresent()){
            throw new IllegalStateException("This person's rut already exist in the data base!");
        }
        personRepository.save(person);
    }

    public void deletePerson(Long id) {
        boolean personExist = personRepository.existsById(id);
        if(!personExist){
            throw new IllegalStateException("The person does not exist in the data base");
        }
        personRepository.deleteById(id);
    }

    public void updatePerson(Long id, String name, String lastname, String rut, Integer age) {
        boolean personExist = personRepository.existsById(id);
        if(!personExist){
            throw new IllegalStateException("The person does not exist in the data base");
        }
        Person person = personRepository.findById(id).get();
        if(name != null && name.length() > 0 && !Objects.equals(person.getName(), name)){
            person.setName(name);
        }
        if(lastname != null && lastname.length() > 0 && !Objects.equals(person.getLastname(), lastname)){
            person.setLastname(lastname);
        }
        Optional<Person> personByRut = personRepository.findPersonByRut(person.getRut());
        if(personByRut.isPresent()){
            throw new IllegalStateException("This person's rut already exist in the data base!");
        }
        person.setRut(rut);
        if(age != null && age > 0 && !Objects.equals(person.getAge(), age)){
            person.setAge(age);
        }
    }
}
