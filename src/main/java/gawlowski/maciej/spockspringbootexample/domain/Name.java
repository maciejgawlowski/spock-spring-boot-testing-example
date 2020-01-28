package gawlowski.maciej.spockspringbootexample.domain;

import lombok.*;
import org.springframework.util.*;

import javax.persistence.*;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Name {

    @Column(name = "name", nullable = false)
    private String value;

    private Name(String name) {
        if (StringUtils.isEmpty((name)))
            throw new RuntimeException("Empty name");
        this.value = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }
}
