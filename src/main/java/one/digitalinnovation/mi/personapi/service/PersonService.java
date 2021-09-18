package one.digitalinnovation.mi.personapi.service;

import one.digitalinnovation.mi.personapi.repository.PersonRepository;
import one.digitalinnovation.mi.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.mi.personapi.dto.request.PersonDTO;
import one.digitalinnovation.mi.personapi.entity.Person;
import one.digitalinnovation.mi.personapi.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
