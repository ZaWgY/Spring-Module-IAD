package smth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import smth.domain.Person;
import smth.service.PersonService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PersonController {
    private PersonService personService;


    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/person")
    public List<Person> getAllPerson(){
        return personService.listAll();
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public ResponseEntity addPerson(@RequestBody Person input){
        System.out.println("Проверка" + input);
        if (personService.checkAvailible(input.getNameous())){
        personService.save(new Person(input.getNameous(),input.getHashMD5(input.getPasswordious())));
        }else{
            System.out.println("ВСЕ РАБОТАЕТ ЕБЫТА!");
            return ResponseEntity.ok(HttpStatus.CONFLICT);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @RequestMapping(value = "/clearPerson", method = RequestMethod.GET)
    public void clearPerson(){
        personService.clear();
        personService.save(new Person("Proverka",new Person().getHashMD5("Zvuka")));
    }

    @RequestMapping(value = "/addExamplePerson", method = RequestMethod.GET)
    public void addTrying(){
        personService.save(new Person("Proverka",new Person().getHashMD5("Zvuka")));
    }

    @RequestMapping(value = "/checkPassword",method = RequestMethod.POST)
    public ResponseEntity checkUser(@RequestBody Person input){
        System.out.println("Проверка" + input);
        int result = personService.checkUser(input);
        System.out.println("Результат равен = " + result);
        if (result == 0){
            return ResponseEntity.ok(HttpStatus.NOT_FOUND);
        }
        if (result == 1){
            return ResponseEntity.ok(HttpStatus.EXPECTATION_FAILED);
        }
        if (result == 2){
            return ResponseEntity.ok(HttpStatus.FOUND);
        }
        return ResponseEntity.ok(HttpStatus.BAD_GATEWAY);
    }

}
