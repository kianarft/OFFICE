package com.mftplus.office.model.service;

import com.mftplus.office.model.entity.Department;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@ApplicationScoped
public class DepartmentService {
    @PersistenceContext(unitName = "office")
    private EntityManager entityManager;

    public Department save(Department department) throws Exception {
        entityManager.persist(department);
        return department;
    }

    public Department edit(Department department) throws Exception {
        Department foundPerson = entityManager.find(Department.class, department.getId());
        if (foundPerson != null) {
            entityManager.merge(department);
        }
        return department;
    }

    public Department remove(Long id) throws Exception {
        Department department = entityManager.find(Department.class, id);
        if (department != null) {
            department.setDeleted(true);
            entityManager.merge(department);
        }
        return department;
    }

    public List<Department> findAll() throws Exception {
        return entityManager
                .createQuery("select oo from departmentEntity oo where oo.deleted=false", Department.class)
                .getResultList();
    }

    public Department findById(Long id) throws Exception {
        Department department = entityManager.find(Department.class, id);
        return department;
    }

//    public List<Department> findByNameAndFamily(String name, String family) throws Exception {
//        return entityManager
//                .createQuery("select p from departmentEntity p where p.name like :name and p.family like :family", Department.class)
//                .setParameter("name", name + "%")
//                .setParameter("family", family + "%")
//                .getResultList();
//    }
//
//    public Department findByPhoneNumber(String phoneNumber) throws Exception {
//        return entityManager
//                .createQuery("select p from departmentEntity p where p.phoneNumber =:phoneNumber", Department.class)
//                .setParameter("phoneNumber", phoneNumber)
//                .getSingleResult();
//    }
}
