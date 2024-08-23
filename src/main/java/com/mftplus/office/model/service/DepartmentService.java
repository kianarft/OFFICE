package com.mftplus.office.model.service;

import com.mftplus.office.model.entity.Department;
import com.mftplus.office.model.entity.Role;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class DepartmentService {
    @PersistenceContext(unitName = "office")
    private EntityManager entityManager;

    @Transactional
    public Department save(Department department) throws Exception {
        entityManager.persist(department);
        return department;
    }

    @Transactional
    public Department edit(Department department) throws Exception {
        Department foundPerson = entityManager.find(Department.class, department.getId());
        if (foundPerson != null) {
            entityManager.merge(department);
        }
        return department;
    }

    @Transactional
    public Department remove(Long id) throws Exception {
        Department department = entityManager.find(Department.class, id);
        if (department != null) {
            department.setDeleted(true);
            entityManager.merge(department);
        }
        return department;
    }

    @Transactional
    public List<Department> findAll() throws Exception {
        return entityManager
                .createQuery("select oo from departmentEntity oo where oo.deleted=false", Department.class)
                .getResultList();
    }

    @Transactional
    public Department findById(Long id) throws Exception {
        Department department = entityManager.find(Department.class, id);
        return department;
    }

    @Transactional
    public Department findByName(String departmentName) throws Exception {
        return entityManager
                .createQuery("select oo from departmentEntity oo where oo.departmentName =:departmentName", Department.class)
                .setParameter("departmentName", departmentName)
                .getSingleResult();
    }

    @Transactional
    public Department findByDescription(String descriptionDepartment) throws Exception {
        return entityManager
                .createQuery("select oo from departmentEntity oo where oo.descriptionDepartment =:descriptionDepartment", Department.class)
                .setParameter("descriptionDepartment", descriptionDepartment)
                .getSingleResult();
    }
}
