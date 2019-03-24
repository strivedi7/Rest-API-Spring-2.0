package com.trivedi.RestAPI.dao;

import com.example.demo.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, com.example.demo.model.Person person);
    default int addPerson(com.example.demo.model.Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }
    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonByID(UUID id);

    int updatePersonByID(UUID id, Person person);
}
