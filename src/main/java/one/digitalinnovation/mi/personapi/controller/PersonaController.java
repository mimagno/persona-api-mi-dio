package one.digitalinnovation.mi.personapi.controller;

import one.digitalinnovation.mi.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.mi.personapi.entity.Person;
import one.digitalinnovation.mi.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/miv1/people")
public class PersonaController {

    private PersonService personService;

    @Autowired
    public PersonaController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String getTest() {
        return "API Online";
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
}
