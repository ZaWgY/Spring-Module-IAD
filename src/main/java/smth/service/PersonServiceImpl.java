package smth.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smth.domain.Person;
import smth.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{
    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> listAll() {
        List<Person> list = new ArrayList<>();
        personRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Person getPersonByName(Long id) {
        return null;
    }

    @Override
    public Person getPersonById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public int checkUser(Person person) {
        int returnValue = 0;
        List<Person> list = new ArrayList<>();
        personRepository.findAll().forEach(list::add);
        for (Person p :list) {
            if (p.getNameous().equals(person.getNameous())){
                returnValue = 1;
                if(p.getPasswordious().equals(person.getPasswordious())){
                    returnValue = 2;
                }
            }
        }
        return returnValue;
    }

    @Override
    public void clear(){
        personRepository.deleteAll();
    }
    @Override
    public void save(Person person) {
        personRepository.save(person);
    }
    @Override
    public boolean checkAvailible(String name){
        boolean isAvaliable = false;
        List<Person> list = new ArrayList<>();
        personRepository.findAll().forEach(list::add);
        for (Person p:list) {
            if (p.getNameous() == null || p.getNameous().isEmpty() ){
                continue;
            }
            if (name.equals(p.getNameous())){
                isAvaliable = true;
                break;
            }
        }
        return !isAvaliable;
    }

}
