package cz.lender.jmsdemo.dao;

import cz.lender.jmsdemo.dto.Organization;
import cz.lender.jmsdemo.jpa.OrganizationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrganizationDao {


    private final OrganizationRepository organizationRepository;

    public OrganizationDao(@Autowired OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization add(Organization organization) {
        cz.lender.jmsdemo.entity.Organization entity = new cz.lender.jmsdemo.entity.Organization();
        BeanUtils.copyProperties(organization, entity);
        organizationRepository.save(entity);
        return organization;
    }

    public Organization update(Organization organization) {
        cz.lender.jmsdemo.entity.Organization entity = organizationRepository.findOrganizationByIdentifier(organization.getIdentifier());
        if (entity == null) {
            throw new IllegalArgumentException("Organization not found");
        }
        BeanUtils.copyProperties(organization, entity);
        organizationRepository.save(entity);
        return organization;
    }

    public List<Organization> findAll() {
        return  StreamSupport.stream(organizationRepository.findAll().spliterator(), false)
                .map(p -> entityToDto(p))
                .collect(Collectors.toList());
    }

    private cz.lender.jmsdemo.entity.Organization dtoToEntity(Organization dto) {
        cz.lender.jmsdemo.entity.Organization entity = new cz.lender.jmsdemo.entity.Organization();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
    private Organization entityToDto(cz.lender.jmsdemo.entity.Organization entity) {
        Organization dto = new Organization();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }
}
