package com.example;

import com.google.gson.Gson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import java.util.List;

public class HibernateUtils {
    static {
        Configuration configuration = new Configuration().configure();
        configuration.setProperty("hibernate.connection.username", System.getenv("username"));
        configuration.setProperty("hibernate.connection.password", System.getenv("password"));
        configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/%s".formatted(System.getenv("database")));
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        sessionFactory = configuration.buildSessionFactory(registryBuilder.build());
    }
    private static final SessionFactory sessionFactory;

    public static void addFormBean(FormBean bean){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(bean);
        transaction.commit();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public static List<FormBean> getAllResults() {
        Session session = sessionFactory.openSession();
        return session.createCriteria(com.example.FormBean.class).list();
    }

    public static String getAllResultsJson(){
        List<FormBean> results = getAllResults();
        Gson gson = new Gson();
        return gson.toJson(results);
    }
}
