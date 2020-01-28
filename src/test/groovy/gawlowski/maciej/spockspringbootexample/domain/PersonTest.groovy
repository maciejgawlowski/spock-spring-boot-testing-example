package gawlowski.maciej.spockspringbootexample.domain

import spock.lang.Specification


class PersonTest extends Specification {

    def "Should create object for correct arguments"() {
        given:
        Name name = Name.of("Andrzej")
        Surname surname = Surname.of("Kowalski")

        when:
        Person person = Person.of(name, surname)

        then:
        person.id == null
        person.name == name
        person.surname == surname
    }

    def "Should throw exception if name passed to constructor is null "() {
        given:
        Name name = null
        Surname surname = Surname.of("Kowalski")

        when:
        Person.of(name, surname)

        then:
        RuntimeException ex = thrown()
    }

    def "Should throw exception if surname passed to constructor is null"() {
        given:
        Name name = Name.of("Andrzej")
        Surname surname = null

        when:
        Person.of(name, surname)

        then:
        RuntimeException ex = thrown()
    }
}

