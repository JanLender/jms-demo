package cz.lender.jmsdemo.jms;

import cz.lender.jmsdemo.dao.OrganizationDao;
import cz.lender.jmsdemo.dto.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrganizationChangeListener {

    private final OrganizationDao organizationDao;

    public OrganizationChangeListener(@Autowired OrganizationDao organizationDao) {
        this.organizationDao = organizationDao;
    }

    @JmsListener(destination = "basic_registers_data_change_queue",
    selector = "entityName='organization' and eventType='entity_created'")
    public void organizationCreated(@Headers Map headers, @Payload Organization organization) {
        organizationDao.add(organization);
    }

    @JmsListener(destination = "basic_registers_data_change_queue",
    selector = "entityName='organization' and eventType='entity_changed'")
    public void organizationChanged(@Headers Map headers, @Payload Organization organization) {
        organizationDao.update(organization);
    }
}
