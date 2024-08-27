package com.mftplus.office.model.service;

import com.mftplus.office.model.entity.Employee;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class EmployeeService implements Serializable {

    @PersistenceContext(unitName = "office")
    private EntityManager entityManager;

    public static EmployeeService getService() {
        return null;
    }

    @Transactional
    public Employee save(Employee employee) throws Exception {
        entityManager.persist(employee);
        return employee;
    }

    @Transactional
    public void edit(Employee employee) throws Exception {
        Employee foundEmployee = entityManager.find(Employee.class, employee.getId());
        if (foundEmployee != null) {
            entityManager.merge(employee);
        }
    }

    @Transactional
    public void remove(Long id) throws Exception {
        Employee employee = entityManager.find(Employee.class, id);
        if (employee != null) {
            employee.setDeleted(true);
            entityManager.merge(employee);
        }
    }

    @Transactional
    public List<Employee> findAll() throws Exception {
        return entityManager
                .createQuery("select e from employeeEntity e where e.deleted = false", Employee.class)
                .getResultList();
    }

    @Transactional
    public Employee findById(Long id) throws Exception {
        return entityManager.find(Employee.class, id);
    }

    @Transactional
    public Employee FindByName(String nameEmployee) throws Exception {
        return entityManager
                .createQuery("select e from employeeEntity e where e.nameEmployee =: nameEmployee", Employee.class)
                .setParameter("nameEmployee", nameEmployee)
                .getSingleResult();
    }

    @Transactional
    public Employee FindByPosition (String positionEmployee) throws Exception {
        return entityManager
                .createQuery("select e from employeeEntity e where e.positionEmployee =: positionEmployee", Employee.class)
                .setParameter("positionEmployee", positionEmployee)
                .getSingleResult();
    }

    @Transactional
    public Employee FindByHourlyPayment (int hourlyPayment) throws Exception {
        return entityManager
                .createQuery("select e from employeeEntity e where e.hourlyPayment =: hourlyPayment", Employee.class)
                .setParameter("hourlyPayment", hourlyPayment)
                .getSingleResult();
    }
}

