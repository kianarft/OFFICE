package com.mftplus.office.model.service;

import java.util.List;
import java.io.Serializable;
import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import com.mftplus.office.model.entity.Phase;
import jakarta.enterprise.context.spi.Context;
import jakarta.persistence.PersistenceContext;
import jakarta.enterprise.context.ApplicationScoped;
import com.mftplus.office.model.entity.Organization;


@ApplicationScoped
public class PhaseService implements Serializable {

    @PersistenceContext(unitName = "office")
    private EntityManager entityManager;

    public static PhaseService getService() {return null;}

    @Transactional
    public Phase save(Phase phase) throws Exception {
        entityManager.persist(phase);
        return phase;
    }

    @Transactional
    public void edit(Phase phase) throws Exception {
        Phase foundPerson = entityManager.find(Phase.class, phase.getId());
        if (foundPerson != null) {
            entityManager.merge(phase);
        }
    }

    @Transactional
    public void remove(Long id) throws Exception {
        Phase phase = entityManager.find(Phase.class, id);
        if (phase != null) {
            phase.setDeleted(true);
            entityManager.merge(phase);
        }
    }

    @Transactional
    public List<Phase> findAll() throws Exception {
        return entityManager
                .createQuery("select oo from phaseEntity oo where oo.deleted = false", Phase.class)
                .getResultList();
    }

    @Transactional
    public Phase findById(Long id) throws Exception {
        return entityManager.find(Phase.class, id);
    }

    @Transactional
    public Phase findByName(String phaseName) throws Exception {
        return entityManager
                .createQuery("select oo from phaseEntity oo where oo.phaseName =: phaseName", Phase.class)
                .setParameter("phaseName", phaseName)
                .getSingleResult();
    }
}
