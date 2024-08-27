package com.mftplus.office.model.service;

import com.mftplus.office.model.entity.WorkLog;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class WorkLogService implements Serializable {
    @PersistenceContext(unitName = "office")
    private EntityManager entityManager;

    public static WorkLogService getService() {
        return null;
    }

    @Transactional
    public WorkLog save(WorkLog worklog) throws Exception {
        entityManager.persist(worklog);
        return worklog;
    }

    @Transactional
    public WorkLog edit(WorkLog workLog) throws Exception {
        WorkLog foundWorklog = entityManager.find(WorkLog.class, workLog.getId());
        if (foundWorklog != null) {
            entityManager.merge(workLog);
        }
        return workLog;
    }

    @Transactional
    public WorkLog remove(Long id) throws Exception {
        WorkLog workLog = entityManager.find(WorkLog.class, id);
        if (workLog != null) {
            workLog.setDeleted(true);
            entityManager.merge(workLog);
        }
        return workLog;
    }

    @Transactional
    public List<WorkLog> findAll() throws Exception {
        return entityManager
                .createQuery("select w from worklogEntity Entity w where w.deleted = false", WorkLog.class)
                .getResultList();
    }

    @Transactional
    public WorkLog findById(Long id) throws Exception {
        return entityManager.find(WorkLog.class, id);
    }

    @Transactional
    public WorkLog FindByCheckInTime(String checkInTime) throws Exception {
        return entityManager
                .createQuery("select w from worklogEntity   w where w.checkInTime =: checkInTime", WorkLog.class)
                .setParameter("checkInTime", checkInTime)
                .getSingleResult();
    }

    @Transactional
    public WorkLog FindByCheckOutTime(String checkOutTime) throws Exception {
        return entityManager
                .createQuery("select w from worklogEntity   w where w.checkOutTime =: checkOutTime", WorkLog.class)
                .setParameter("checkOutTime", checkOutTime)
                .getSingleResult();
    }
}

