package com.mftplus.office.model.service;

import com.mftplus.office.model.entity.Role;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class RoleService {

    @PersistenceContext(unitName = "office")
    private EntityManager entityManager;

    public Role save(Role role) throws Exception {
        entityManager.persist(role);
        return role;
    }

    @Transactional
    public void edit(Role role) throws Exception {
        Role foundRole = entityManager.find(Role.class, role.getId());
        if (foundRole != null) {
            entityManager.merge(role);
        }
    }

    @Transactional
    public Role remove(Long id) throws Exception {
        Role role = entityManager.find(Role.class, id);
        if (role != null) {
            role.setDeleted(true);
            entityManager.merge(role);
        }
        return role;
    }

    @Transactional
    public List<Role> findAll() throws Exception {
        return entityManager
                .createQuery("select r from roleEntity r where r.deleted = false", Role.class)
                .getResultList();
    }

    @Transactional
    public Role findById(Long id) throws Exception {
        return entityManager.find(Role.class, id);
    }

    @Transactional
    public Role findByName(String nameRole) throws Exception {
        return entityManager
                .createQuery("select r from roleEntity r where r.nameRole =:nameRole", Role.class)
                .setParameter("nameRole", nameRole)
                .getSingleResult();
    }

    @Transactional
    public Role findByDescription(String descriptionRole) throws Exception {
        return entityManager
                .createQuery("select r from roleEntity r where r.descriptionRole =:descriptionRole", Role.class)
                .setParameter("descriptionRole", descriptionRole)
                .getSingleResult();
    }
}
