package com.trivedi.RestAPI.dao;

import com.example.demo.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class PersonDataAceessService implements  PersonDao {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, com.example.demo.model.Person person) {
        DB.add(new com.example.demo.model.Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonByID(UUID id) {
        Optional<Person> personMaybe = selectPersonById(id);
        if(personMaybe.isPresent()){
            DB.remove(personMaybe.get());
            return 1;
        }
        return 0;
    }

    @Override
    public int updatePersonByID(UUID id, Person newPerson) {
        return selectPersonById(id).map(
                person -> {
                    int indexOfPersonToDelete = DB.indexOf(person);
                    if(indexOfPersonToDelete >= 0){
                        DB.set(indexOfPersonToDelete, new Person(id, newPerson.getName()));
                        return 1;
                    }
                    return 0;
                }).orElse(0);
    }


}
