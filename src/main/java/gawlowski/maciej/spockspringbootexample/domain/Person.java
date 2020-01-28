package gawlowski.maciej.spockspringbootexample.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Getter
@Setter(value = AccessLevel.PRIVATE)
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_generator")
    @SequenceGenerator(name = "person_generator", sequenceName = "person_sequence", allocationSize = 1)
    private Long id;

    @Embedded
    private Name name;

    @Embedded
    private Surname surname;

    public Person(Long id, Name name, Surname surname) {
        if (name == null)
            throw new RuntimeException("Name is null");
        if (surname == null)
            throw new RuntimeException("Surname is null");
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public static Person of(Name name, Surname surname) {
        return new Person(null, name, surname);
    }

    public static Person update(Person person, Name name, Surname surname) {
        return new Person(person.id, name, surname);
    }
}
