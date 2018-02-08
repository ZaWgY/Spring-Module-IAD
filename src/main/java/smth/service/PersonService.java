package smth.service;


import smth.domain.Person;

import java.util.List;

public interface PersonService {
    List<Person> listAll();

    Person getPersonByName(Long id);

    Person getPersonById(Long id);

    void delete(Long id);

    void deleteByName(String name);

    int checkUser(Person person);

    void save(Person person);

    void clear();

    boolean checkAvailible(String name);
}
