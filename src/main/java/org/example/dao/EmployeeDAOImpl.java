package org.example.dao;

import org.example.entity.Employee;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeDAOImpl implements EmployeeDAO {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

    @Override
    public void save(Employee employee) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            logger.error("Failed to save employee", e);
            throw new RuntimeException("Could not save employee", e);
        }
    }
}
