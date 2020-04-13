package cz.lender.jmsdemo.dao;

import cz.lender.jmsdemo.dto.Person;
import cz.lender.jmsdemo.jpa.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PersonDao {


    private final PersonRepository personRepository;

    public PersonDao(@Autowired PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person add(Person person) {
        cz.lender.jmsdemo.entity.Person entity = new cz.lender.jmsdemo.entity.Person();
        BeanUtils.copyProperties(person, entity);
        personRepository.save(entity);
        return person;
    }

    public Person update(Person person) {
        cz.lender.jmsdemo.entity.Person entity = personRepository.findPersonByIdentifier(person.getIdentifier());
        if (entity == null) {
            throw new IllegalArgumentException("Person not found");
        }
        BeanUtils.copyProperties(person, entity);
        personRepository.save(entity);
        return person;
    }

    public List<Person> findAll() {
        return  StreamSupport.stream(personRepository.findAll().spliterator(), false)
                .map(p -> entityToDto(p))
                .collect(Collectors.toList());
    }

    private cz.lender.jmsdemo.entity.Person dtoToEntity(Person dto) {
        cz.lender.jmsdemo.entity.Person entity = new cz.lender.jmsdemo.entity.Person();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
    private Person entityToDto(cz.lender.jmsdemo.entity.Person entity) {
        Person dto = new Person();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
