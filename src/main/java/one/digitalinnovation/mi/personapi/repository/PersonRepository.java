package one.digitalinnovation.mi.personapi.repository;

import one.digitalinnovation.mi.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
