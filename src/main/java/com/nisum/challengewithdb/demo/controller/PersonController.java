package com.nisum.challengewithdb.demo.controller;

import com.nisum.challengewithdb.demo.model.Person;
import com.nisum.challengewithdb.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v2/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/all")
    public List<Person> allPeople(){
        return personService.getPeople();
    }

    @GetMapping("/filtered")
    public List<Person> filterPeople(){
        return personService.filterPeople();
    }

    @PostMapping
    public void registerNewPerson(@RequestBody Person person){
        personService.createNewPerson(person);
    }

    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable("personId") Long id){
        personService.deletePerson(id);
    }

    @PutMapping(path = "{personId}")
    public void updatePerson(@PathVariable("personId") Long id, @RequestParam(required = false) String name, @RequestParam(required = false) String lastname,
                             @RequestParam(required = false) String rut, @RequestParam(required = false) Integer age){
        personService.updatePerson(id,name,lastname,rut, age);
    }
}
