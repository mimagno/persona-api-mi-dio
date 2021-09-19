package one.digitalinnovation.mi.personapi.service;

import one.digitalinnovation.mi.personapi.exception.PersonNotFoundException;
import one.digitalinnovation.mi.personapi.repository.PersonRepository;
import one.digitalinnovation.mi.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.mi.personapi.dto.request.PersonDTO;
import one.digitalinnovation.mi.personapi.entity.Person;
import one.digitalinnovation.mi.personapi.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO
                .builder()
                .message("Created person with ID " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        //Optional<Person> optionalPerson =
        Person person = verifyIfExists(id);

        return personMapper.toDTO(person);

    }

    public MessageResponseDTO deleteById(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
        return MessageResponseDTO.builder().message("Deleted person with ID " + id).build();
    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }
}
