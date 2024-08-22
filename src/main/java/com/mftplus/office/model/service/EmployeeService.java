package com.mftplus.office.model.service;

import com.mftplus.office.model.entity.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class EmployeeService implements Serializable {

    @PersistenceContext(unitName = "office")
    private EntityManager entityManager;

    public Employee save(Employee employee) throws Exception {
        entityManager.persist(employee);
        return employee;
    }

    public Employee edit(Employee employee) throws Exception {
        Employee foundCardPayment = entityManager.find(Employee.class, employee.getId());
        if (foundCardPayment != null) {
            entityManager.merge(employee);
        }
        return employee;
    }

    public Employee remove(Long id) throws Exception {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            employee.setDeleted(true);
            entityManager.merge(employee);
        }
        return employee;
    }

    public List<Employee> findAll() throws Exception {
        return entityManager
                .createQuery("select e from employeeEntity e where e.deleted = false", Employee.class)
                .getResultList();
    }

    public Employee FindByName(String nameEmployee) throws Exception {
        return entityManager
                .createQuery("select e from employeeEntity e where e.nameEmployee =: nameEmployee", Employee.class)
                .setParameter("nameEmployee", nameEmployee)
                .getSingleResult();
    }

    public Employee FindByPosition (String positionEmployee) throws Exception {
        return entityManager
                .createQuery("select e from employeeEntity e where e.positionEmployee =: positionEmployee", Employee.class)
                .setParameter("positionEmployee", positionEmployee)
                .getSingleResult();
    }
}

