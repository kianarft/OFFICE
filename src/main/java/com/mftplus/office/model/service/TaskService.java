package com.mftplus.office.model.service;

import java.util.List;
import java.io.Serializable;
import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.mftplus.office.model.entity.Task;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaskService implements Serializable {

    @PersistenceContext(unitName = "office")
    private EntityManager entityManager;

    public static TaskService getService() {return null;}

    @Transactional
    public Task save(Task task) throws Exception {
        entityManager.persist(task);
        return task;
    }

    @Transactional
    public void edit(Task task) throws Exception {
        Task foundPerson = entityManager.find(Task.class, task.getId());
        if (task != null) {
            task.setDeleted(true);
            entityManager.merge(task);
        }
    }

    @Transactional
    public void remove(Long id) throws Exception {
        Task task = entityManager.find(Task.class, id);
        if (task != null) {
            task.setDeleted(true);
            entityManager.merge(task);
        }
    }

    @Transactional
    public List<Task> findAll() throws Exception {
        return entityManager
                .createQuery("select oo from taskEntity oo where oo.deleted = false", Task.class)
                .getResultList();
    }

    @Transactional
    public Task findById(Long id) throws Exception {
        return entityManager.find(Task.class, id);
    }

    @Transactional
    public Task findByName(String taskName) throws Exception {
        return entityManager
                .createQuery("select oo from taskEntity oo where oo.taskName =: taskName", Task.class)
                .setParameter("taskName", taskName)
                .getSingleResult();
    }
}
