package org.gfg.junitmock.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.gfg.junitmock.demo.Repository.PersonRepository;
import org.gfg.junitmock.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PersonService implements PersonServiceInterface{

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public List<Person> filterPersonByName(String name1, String name2){
        List<Person> result = new ArrayList<>();
        List<Person> persons  = personRepository.findAll();
        for (Person p : persons){
            if(p.getName().equalsIgnoreCase(name1) || p.getName().equalsIgnoreCase(name2)) {
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public void addOnePerson(Person person) {
        Person person1 = personRepository.findByEmail(person.getEmail());
        if(person1 == null){
            person1 = personRepository.save(person);
        }
        storeDataToRedis(person1);
    }

    @Override
    public void addMultiplePersons(List<Person> person) {
       List<Person> personList=  personRepository.saveAll(person);
        for(Person person1: personList){
            storeDataToRedis(person1);
        }
    }

    @Override
    public Person getPersonDetails(String email) {
        Person person = (Person) redisTemplate.opsForValue().get(email);
        if(person != null){
            return person;
        }
        Person person1 = personRepository.findByEmail(email);
        storeDataToRedis(person1);
        return person1;
    }

    @Override
    public List<Person> getMultiplePersons(String country , String start, String end) {
       List<Person> list = redisTemplate.opsForList().range(country,Integer.valueOf(start),Integer.valueOf(end));
       if(!list.isEmpty()){
           return list;
       }
        List<Person> pList =personRepository.findByCountry(country);
       for(Person pData:pList) {
           storeDataToRedis(pData);
       }
       return pList;
    }

    @Override
    public Map<String,Object> getRedisPersonsData() {
        return redisTemplate.opsForHash().entries("person_data");
    }

    private void storeDataToRedis(Person person){

        redisTemplate.opsForHash().putAll("person_data", objectMapper.convertValue(person, Map.class));
        redisTemplate.opsForValue().set(person.getEmail(), person);
        redisTemplate.opsForList().leftPush(person.getCountry(),person);
    }
}

// personData: gmail ->
//               country ->

