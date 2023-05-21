package org.gfg.junitmock.demo.service;

import org.gfg.junitmock.demo.model.Person;

import java.util.List;
import java.util.Map;

public interface PersonServiceInterface {
    public List<Person> filterPersonByName(String name1, String name2);

    void addOnePerson(Person person);

    public void addMultiplePersons(List<Person> person);

    Person getPersonDetails(String email);

    List<Person> getMultiplePersons(String country, String start, String end);

    Map<String ,Object> getRedisPersonsData();
}
