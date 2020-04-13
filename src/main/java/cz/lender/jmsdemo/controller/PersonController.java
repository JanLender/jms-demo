package cz.lender.jmsdemo.controller;

import cz.lender.jmsdemo.dao.PersonDao;
import cz.lender.jmsdemo.dto.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/person")
public class PersonController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private PersonDao personDao;

    @PutMapping(path = "add")
    public Person add(@RequestBody Person person) {
        return personDao.add(person);
    }

    @GetMapping(path="list")
    public List<Person> list() {
        return personDao.findAll();
    }

    @PostMapping(path="update")
    public Person update(@RequestBody Person person) {
        return personDao.update(person);
    }


}
