package com.mftplus.office.model.service;

import com.mftplus.office.model.entity.Worklog;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.io.Serializable;

@ApplicationScoped
@Singleton
public class WorklogService implements Serializable
{
    @PersistenceContext(unitName = "office")
    private EntityManager entityManager;

    @Transactional
    public Worklog save (Worklog worklog) throws Exception{
        entityManager.persist(worklog);
        return worklog;
    }
    @Transactional
    public Worklog edit(Worklog worklog) throws Exception {
        Worklog foundWorklog = entityManager.find(Worklog.class, Worklog.getId());
        if (foundWorklog != null) {
            entityManager.merge(worklog);
        }
        return worklog;
    }

    @Transactional
    public Worklog remove(Long id) throws Exception {
        Worklog worklog = entityManager.find(Worklog.class, id);
        if (worklog != null) {
            worklog.s(true);
            entityManager.merge(worklog);
        }
        return worklog;
    }

}
