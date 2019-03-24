package com.trivedi.RestAPI.service;

import com.trivedi.RestAPI.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.model.Person;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(@RequestBody Person person){
        return personDao.addPerson(person);
    }
}
