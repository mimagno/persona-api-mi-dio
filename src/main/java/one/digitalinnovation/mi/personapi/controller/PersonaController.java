package one.digitalinnovation.mi.personapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.mi.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.mi.personapi.dto.request.PersonDTO;
import one.digitalinnovation.mi.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.mi.personapi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("api/miv1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@CrossOrigin
public class PersonaController {

    private PersonService personService;

    @GetMapping
    public String getTest() {
        return "API Online";
    }


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @GetMapping("/getall")
    public List<PersonDTO> listAll(){
       return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    public MessageResponseDTO deleteById(@PathVariable Long id) throws PersonNotFoundException {
       return personService.deleteById(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
       return personService.updateById(id, personDTO);
    }
}
