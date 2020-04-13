package cz.lender.jmsdemo.jms;

import cz.lender.jmsdemo.dao.PersonDao;
import cz.lender.jmsdemo.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PersonChangeListener {

    private final PersonDao personDao;

    public PersonChangeListener(@Autowired PersonDao personDao) {
        this.personDao = personDao;
    }

    @JmsListener(destination = "basic_registers_data_change_queue",
    selector = "entityName='person' and eventType='entity_created'")
    public void personCreated(@Headers Map headers, @Payload Person person) {
        personDao.add(person);
    }

    @JmsListener(destination = "basic_registers_data_change_queue",
    selector = "entityName='person' and eventType='entity_changed'")
    public void personChanged(@Headers Map headers, @Payload Person person) {
        personDao.update(person);
    }
}
