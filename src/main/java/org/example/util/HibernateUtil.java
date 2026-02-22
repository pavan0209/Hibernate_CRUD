package org.example.util;

import org.example.entity.Employee;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static final SessionFactory factory = new Configuration()
            .addAnnotatedClass(Employee.class)
            .configure()
            .buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return factory;
    }
}
