package gawlowski.maciej.spockspringbootexample.repository;

import gawlowski.maciej.spockspringbootexample.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
