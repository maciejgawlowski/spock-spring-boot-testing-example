package gawlowski.maciej.spockspringbootexample.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id;
    private String name;
    private String surname;
}
