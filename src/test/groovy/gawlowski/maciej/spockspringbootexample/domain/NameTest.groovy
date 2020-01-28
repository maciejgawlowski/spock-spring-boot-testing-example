package gawlowski.maciej.spockspringbootexample.domain

import spock.lang.Specification


class NameTest extends Specification {

    def "Should create object for correct string passed to constructor"() {
        expect:
        Name.of("Andrzej").value == "Andrzej"
    }

    def "Should throw exception if string passed to constructor is null"() {
        when:
        Name.of(null)

        then:
        RuntimeException ex = thrown()
    }

    def "Should throw exception if string passed to constructor is empty"() {
        when:
        Name.of("")

        then:
        RuntimeException ex = thrown()
    }
}

