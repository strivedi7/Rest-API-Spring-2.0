package com.trivedi.RestAPI.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class PersonDataAceessService implements  PersonDao {

    private static List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, com.example.demo.model.Person person) {
        DB.add(new com.example.demo.model.Person(id,person.getName()));
        return 1;
    }


}
