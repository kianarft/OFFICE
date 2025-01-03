package com.mftplus.office.model.service;

import  java.util.List;
import java.io.Serializable;
import jakarta.transaction.Transactional;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.mftplus.office.model.entity.Attachment;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AttachmentService implements Serializable {

    @PersistenceContext(unitName = "office")
    private EntityManager entityManager;

    public static AttachmentService getService() {return null;}

    @Transactional
    public Attachment save(Attachment attachment) throws Exception {
        entityManager.persist(attachment);
        return attachment;
    }

    @Transactional
    public void edit(Attachment attachment) throws Exception {
        Attachment foundPerson = entityManager.find(Attachment.class, attachment.getId());
        if (foundPerson != null) {
            entityManager.merge(attachment);
        }
    }

    @Transactional
    public void remove(Long id) throws Exception {
        Attachment attachment = entityManager.find(Attachment.class, id);
        if (attachment != null) {
//            attachment.setDeleted(true);
            entityManager.merge(attachment);
        }
    }

//    @Transactional
//    public List<Attachment> findAll() throws Exception {
//        return entityManager
//                .createQuery("select oo from attachmentEntity oo where oo.deleted=false", Attachment.class)
//                .getResultList();
//    }

    @Transactional
    public Attachment findById(Long id) throws Exception {
        return entityManager.find(Attachment.class, id);
    }
}
