package com.mftplus.office.model.service;

import java.util.List;
import java.io.Serializable;
import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.mftplus.office.model.entity.Organization;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrganizationService implements Serializable{

    @PersistenceContext(unitName = "office")
    private EntityManager entityManager;

    public static OrganizationService getService() {return null;}

    @Transactional
    public Organization save(Organization organization) throws Exception {
        entityManager.persist(organization);
        return organization;
    }

    @Transactional
    public void edit(Organization organization) throws Exception {
        Organization foundPerson = entityManager.find(Organization.class, organization.getId());
        if (foundPerson != null) {
            entityManager.merge(organization);
        }
    }

    @Transactional
    public void remove(Long id) throws Exception {
        Organization organization = entityManager.find(Organization.class, id);
        if (organization != null) {
            organization.setDeleted(true);
            entityManager.merge(organization);
        }
    }

    @Transactional
    public List<Organization> findAll() throws Exception {
        return entityManager
                .createQuery("select oo from organizationEntity oo where oo.deleted = false", Organization.class)
                .getResultList();
    }

    @Transactional
    public Organization findById(Long id) throws Exception {
        return entityManager.find(Organization.class, id);
    }

    @Transactional
    public Organization findByName(String organizationName) throws Exception {
        return entityManager
                .createQuery("select oo from organizationEntity oo where oo.organizationName =:organizationName", Organization.class)
                .setParameter("organizationName", organizationName)
                .getSingleResult();
    }
}
