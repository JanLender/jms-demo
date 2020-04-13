package cz.lender.jmsdemo.jpa;

import cz.lender.jmsdemo.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface PersonRepository extends CrudRepository<Person, Long> {

    public Person findPersonByIdentifier(String identifier);

}
