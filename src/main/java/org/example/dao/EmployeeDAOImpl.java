package org.example.dao;

import org.example.entity.Employee;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Optional;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public void save(Employee employee) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Failed to save employee " + e);
            throw new RuntimeException("Could not save employee", e);
        }
    }

    @Override
    public Optional<Employee> getById(int id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Employee emp = session.find(Employee.class, id);
            if (emp != null) {
                System.out.println("Employee retrieved: " + emp);
            } else {
                System.out.println("Employee not found with id: " + id);
            }
            return Optional.ofNullable(emp);
        } catch (Exception e) {
            System.out.println("Failed to retrieve employee with id " + id + e);
            throw new RuntimeException("Could not retrieve employee ", e);
        }
    }

    @Override
    public void update(Employee employee) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Failed to update employee " + e);
            throw new RuntimeException("Could not update employee", e);
        }
    }

    @Override
    public void delete(Employee employee) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.remove(employee);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            System.out.println("Failed to delete employee " + e);
            throw new RuntimeException("Could not delete employee", e);
        }
    }
}
