package gawlowski.maciej.spockspringbootexample.domain

import spock.lang.Specification


class SurnameTest extends Specification {

    def "Should create object for correct string passed to constructor"() {
        expect:
        Surname.of("Kowalski").value == "Kowalski"
    }

    def "Should throw exception if string passed to constructor is null"() {
        when:
        Surname.of(null)

        then:
        RuntimeException ex = thrown()
    }

    def "Should throw exception if string passed to constructor is empty"() {
        when:
        Surname.of("")

        then:
        RuntimeException ex = thrown()
    }
}

