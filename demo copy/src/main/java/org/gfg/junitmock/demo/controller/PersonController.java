package org.gfg.junitmock.demo.controller;

import org.gfg.junitmock.demo.model.Person;
import org.gfg.junitmock.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/redis-demo")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/create-one-Person")
    public void addOnePerson(@RequestBody Person person){
        personService.addOnePerson(person);
    }

    @PostMapping("/create-multiple-persons")
    public void addMultiplePersons(@RequestBody List<Person> person){
        personService.addMultiplePersons(person);
    }

    @GetMapping("/get-person")
    public Person getPerson(@RequestParam("email") String email){
       return personService.getPersonDetails(email);
    }

    @GetMapping("/get-multiple-persons")
    public List<Person> getMultiplePersons(@RequestParam("country") String country,
                                           @RequestParam( value = "start" , required = false, defaultValue = "0") String start,
                                           @RequestParam(value = "end" , required = false, defaultValue = "-1") String end){
        return personService.getMultiplePersons(country, start, end);
    }

    @GetMapping("/get-redis-persons-data")
    public Map<String ,Object> getRedisPersonsData(){
        return personService.getRedisPersonsData();
    }


}
