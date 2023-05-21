package org.gfg.junitmock.demo.org.gfg.junitmock.demo.controller;

import org.gfg.junitmock.demo.controller.PersonController;
import org.gfg.junitmock.demo.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PersonControllerTest2 {

    @InjectMocks
    private PersonController personController;

    @Mock
    private PersonService personService;

    @Test
    public void testGetPersonDetails(){
        String email = "user1@gmail.com";
        Mockito.when(personService.getPersonDetails(email)).thenReturn(null);
        Assert.assertNull(personController.getPerson(email));
    }



}
