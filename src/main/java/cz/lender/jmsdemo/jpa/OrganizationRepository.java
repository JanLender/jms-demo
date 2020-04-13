package cz.lender.jmsdemo.jpa;

import cz.lender.jmsdemo.entity.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface OrganizationRepository extends CrudRepository<Organization, Long> {

    public Organization findOrganizationByIdentifier(String identifier);

}
