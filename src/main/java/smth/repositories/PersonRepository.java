package smth.repositories;

import org.springframework.data.repository.CrudRepository;
import smth.domain.Person;


public interface PersonRepository extends CrudRepository<Person, Long> {
}
