package org.gfg.junitmock.demo.org.gfg.junitmock.demo.org.gfg.junitmock.demo.service;

import org.gfg.junitmock.demo.model.Person;
import org.gfg.junitmock.demo.service.PersonServiceInterface;

import java.util.List;
import java.util.Map;

public class PersonServiceTest implements PersonServiceInterface {
    @Override
    public List<Person> filterPersonByName(String name1, String name2) {
        return null;
    }

    @Override
    public void addOnePerson(Person person) {

    }

    @Override
    public void addMultiplePersons(List<Person> person) {

    }

    @Override
    public Person getPersonDetails(String email) {
        return Person.builder().name("john").email(email).build();
    }

    @Override
    public List<Person> getMultiplePersons(String country, String start, String end) {
        return null;
    }

    @Override
    public Map<String, Object> getRedisPersonsData() {
        return null;
    }
}
