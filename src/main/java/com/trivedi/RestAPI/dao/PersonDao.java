package com.trivedi.RestAPI.dao;

import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID id, com.example.demo.model.Person person);
    default int addPerson(com.example.demo.model.Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }

}
