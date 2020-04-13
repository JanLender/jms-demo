package cz.lender.jmsdemo.controller;

import cz.lender.jmsdemo.dao.OrganizationDao;
import cz.lender.jmsdemo.dto.Organization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/organization")
public class OrganizationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

    @Autowired
    private OrganizationDao organizationDao;

    @PutMapping(path = "add")
    public Organization add(@RequestBody Organization organization) {
        return organizationDao.add(organization);
    }

    @GetMapping(path="list")
    public List<Organization> list() {
        return organizationDao.findAll();
    }

    @PostMapping(path="update")
    public Organization update(@RequestBody Organization organization) {
        return organizationDao.update(organization);
    }


}
