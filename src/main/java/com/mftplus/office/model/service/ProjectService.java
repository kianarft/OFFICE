package com.mftplus.office.model.service;

import com.mftplus.office.model.entity.Project;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class ProjectService implements Serializable {

    @PersistenceContext(unitName = "office")
    private EntityManager entityManager;

    public static boolean getService() {
        return false;
    }

    @Transactional
    public Project save(Project project) throws Exception {
        entityManager.persist(project);
        return project;
    }

    @Transactional
    public void edit(Project project) throws Exception {
        Project foundProject = entityManager.find(Project.class, project.getId());
        if (foundProject != null) {
            entityManager.merge(project);
        }
    }

    @Transactional
    public void remove(Long id) throws Exception {
        Project project = entityManager.find(Project.class, id);
        if (project != null) {
            project.setDeleted(true);
            entityManager.merge(project);
        }
    }

    @Transactional
    public List<Project> findAll() throws Exception {
        return entityManager
                .createQuery("select p from projectEntity p where p.deleted = false", Project.class)
                .getResultList();
    }

    @Transactional
    public Project findById(Long id) throws Exception {
        return entityManager.find(Project.class, id);
    }

    @Transactional
    public Project FindByName(String projectName) throws Exception {
        return entityManager
                .createQuery("select p from projectEntity p where p.projectName =: projectName", Project.class)
                .setParameter("projectName", projectName)
                .getSingleResult();
    }

    @Transactional
    public Project FindByStartDate (LocalDateTime startDate) throws Exception {
        return entityManager
                .createQuery("select p from projectEntity p where p.startDate =: startDate", Project.class)
                .setParameter("startDate", startDate)
                .getSingleResult();
    }

    @Transactional
    public Project FindByEndDate (LocalDateTime endDate) throws Exception {
        return entityManager
                .createQuery("select p from projectEntity p where p.endDate =: endDate", Project.class)
                .setParameter("endDate", endDate)
                .getSingleResult();
    }

}

