package gawlowski.maciej.spockspringbootexample.service;

import gawlowski.maciej.spockspringbootexample.domain.*;
import gawlowski.maciej.spockspringbootexample.dto.*;
import gawlowski.maciej.spockspringbootexample.repository.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public List<Person> getAll() {
        return repository.findAll();
    }

    public Person get(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Person with id #" + id + " does not exist"));
    }

    @Transactional
    public Person create(PersonDTO dto) {
        log.info("Creating new person {}", dto.toString());
        Person person = repository.save(Person.of(Name.of(dto.getName()), Surname.of(dto.getSurname())));
        log.info("Person created {}", person.toString());
        return person;
    }

    @Transactional
    public Person update(Long id, PersonDTO dto) {
        log.info("Updating person with id #{}. New content: {}", id, dto.toString());
        Person person = repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Person with id #" + id + " does not exist"));
        person = repository.save(Person.update(person, Name.of(dto.getName()), Surname.of(dto.getSurname())));
        log.info("Person updated {}", person.toString());
        return person;
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
        log.info("Person deleted with id #{} deleted", id);
    }
}
