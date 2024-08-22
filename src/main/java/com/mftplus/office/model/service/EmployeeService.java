package com.mftplus.office.model.service;

import com.mftplus.office.model.entity.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Entity;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class EmployeeService {

    @PersistenceContext(unitName = "office")
    private EntityManager entityManager;

    public Employee save(Employee employee) throws Exception {
        entityManager.persist(employee);
        return employee;
    }

    @Transactional
    public Employee edit(Employee employee) throws Exception {
        Employee foundEmployee = entityManager.find(Employee.class, employee.getId());
        if (foundEmployee != null) {
            entityManager.merge(employee);
        }
        return employee;
    }

    @Transactional
    public Employee remove(Long id) throws Exception {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            employee.setDeleted(true);
            entityManager.merge(employee);
        }
        return employee;
    }

    @Transactional
    public List<Employee> findAll() throws Exception {
        return entityManager
                .createQuery("select e from employeeEntity e where e.deleted = false", Employee.class)
                .getResultList();
    }

    @Transactional
    public Employee findByName(String employeeName) throws Exception {
        return entityManager
                .createQuery("select oo from employeeEntity oo where oo.employeeName =:employeeName", Employee.class)
                .setParameter("employeeName", employeeName)
                .getSingleResult();
    }

    @Transactional
    public Employee findByPosition(String employeePosition) throws Exception {
        return entityManager
                .createQuery("select oo from employeeEntity oo where oo.employeePosition =:employeePosition", Employee.class)
                .setParameter("employeePosition", employeePosition)
                .getSingleResult();
    }
}
