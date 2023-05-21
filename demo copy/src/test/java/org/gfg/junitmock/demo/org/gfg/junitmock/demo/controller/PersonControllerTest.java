package org.gfg.junitmock.demo.org.gfg.junitmock.demo.controller;

import org.gfg.junitmock.demo.model.Person;
import org.gfg.junitmock.demo.org.gfg.junitmock.demo.org.gfg.junitmock.demo.service.PersonServiceTest;
import org.junit.Assert;
import org.junit.Test;

public class PersonControllerTest {

    PersonServiceTest personServiceTest  = new PersonServiceTest();

    @Test
    public void testGetPersonDetails(){
        String email = "user1@gmail.com";
        Person p = personServiceTest.getPersonDetails(email);
        Assert.assertNotNull(p);

    }
}
