package gawlowski.maciej.spockspringbootexample.controller;

import gawlowski.maciej.spockspringbootexample.domain.*;
import gawlowski.maciej.spockspringbootexample.dto.*;
import gawlowski.maciej.spockspringbootexample.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.MediaType.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonController {

    private final PersonService service;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Person>> getPersons() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getPerson(@PathVariable("id") Long id) {
        Person person = service.get(id);
        return ResponseEntity.ok().body(person);
    }

    @ResponseStatus(CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> createPerson(@RequestBody PersonDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @ResponseStatus(OK)
    @PutMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id, @RequestBody PersonDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        service.delete(id);
    }
}
