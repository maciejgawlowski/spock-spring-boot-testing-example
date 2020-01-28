package gawlowski.maciej.spockspringbootexample.domain;

import lombok.*;
import org.springframework.util.*;

import javax.persistence.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Surname {

    @Column(name = "name", nullable = false)
    private String value;

    private Surname(String name) {
        if (StringUtils.isEmpty((name)))
            throw new RuntimeException("Empty surname");
        this.value = name;
    }

    public static Surname of(String name) {
        return new Surname(name);
    }
}
