package com.mftplus.office.model.service;

import java.util.List;
import java.io.Serializable;

import com.mftplus.office.model.entity.Department;
import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.mftplus.office.model.entity.Section;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SectionService implements Serializable {

    @PersistenceContext
    private EntityManager entityManager;

    public static SectionService getService() {return null;}

    @Transactional
    public Section save(Section section) throws Exception {
        entityManager.persist(section);
        return section;
    }

    @Transactional
    public void edit(Section section) throws Exception {
        Section foundPerson = entityManager.find(Section.class, section.getId());
        if (section != null) {
            section.setDeleted(true);
            entityManager.merge(section);
        }
    }

    @Transactional
    public void remove(Long id) throws Exception {
        Section section = entityManager.find(Section.class, id);
        if (section != null) {
            section.setDeleted(true);
            entityManager.merge(section);
        }
    }

    @Transactional
    public List<Section> findAll() throws Exception {
        return entityManager
                .createQuery("select oo from sectionEntity oo where oo.deleted = false", Section.class)
                .getResultList();
    }

    @Transactional
    public Section findById(Long id) throws Exception {
        return entityManager.find(Section.class, id);
    }

    @Transactional
    public Section findByTitle(String titleSection) throws Exception {
        return entityManager
                .createQuery("select oo from sectionEntity oo where oo.titleSection =: titleSection", Section.class)
                .setParameter("titleSection", titleSection)
                .getSingleResult();
    }
}
