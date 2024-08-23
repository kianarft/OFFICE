package com.mftplus.office.model.service;

import com.mftplus.office.model.entity.SalarySlip;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.io.Serializable;
import java.util.List;

@ApplicationScoped
public class SalarySlipService implements Serializable {

    @PersistenceContext(unitName = "office")
    private EntityManager entityManager;

    @Transactional
    public SalarySlip save(SalarySlip salarySlip) throws Exception {
        entityManager.persist(salarySlip);
        return salarySlip;
    }

    @Transactional
    public void edit(SalarySlip salarySlip) throws Exception {

        SalarySlip foundSalarySlip = entityManager.find(SalarySlip.class, salarySlip.getId());
        if (foundSalarySlip != null) {
            entityManager.merge(salarySlip);
        }
    }

    @Transactional
    public void remove(Long id) throws Exception {
        SalarySlip salarySlip = entityManager.find(SalarySlip.class, id);
        if (salarySlip != null) {
            salarySlip.setDeleted(true);
            entityManager.merge(salarySlip);
        }
    }

    @Transactional
    public List<SalarySlip> findAll() throws Exception {
        return entityManager
                .createQuery("select s from salarySlipEntity s where s.deleted = false", SalarySlip.class)
                .getResultList();
    }

    @Transactional
    public SalarySlip findById(Long id) throws Exception {
        return entityManager.find(SalarySlip.class, id);
    }

    @Transactional
    public SalarySlip FindByTotalSalary(String totalSalary) throws Exception {
        return entityManager
                .createQuery("select S from salarySlipEntity   S where S.totalSalary =: totalSalary", SalarySlip.class)
                .setParameter("totalSalary", totalSalary)
                .getSingleResult();
    }

    @Transactional
    public SalarySlip FindByTotalHours(String totalHours) throws Exception {
        return entityManager
                .createQuery("select S from salarySlipEntity   S where S.totalHours =: totalHours", SalarySlip.class)
                .setParameter("totalHours", totalHours)
                .getSingleResult();
    }

    @Transactional
    public SalarySlip FindByMonth(String month) throws Exception {
        return entityManager
                .createQuery("select S from salarySlipEntity   S where S.month =: month", SalarySlip.class)
                .setParameter("month", month)
                .getSingleResult();
    }

    @Transactional
    public SalarySlip FindByBonus(String bonus) throws Exception {
        return entityManager
                .createQuery("select S from salarySlipEntity   S where S.bonus =: bonus", SalarySlip.class)
                .setParameter("bonus", bonus)
                .getSingleResult();
    }

}