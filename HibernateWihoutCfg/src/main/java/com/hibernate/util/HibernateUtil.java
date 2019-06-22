package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import java.util.HashMap;
import java.util.Map;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry standardServiceRegistry;

    static {
        // Creating  StandardServiceRegistryBuilder
        StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();

        // Equivalent to hibernate.cfg.xml
        Map<String, String> dbSettings = new HashMap<>();
        dbSettings.put(Environment.URL, "jdbc:postgresql:hibernate");
        dbSettings.put(Environment.USER, "oher");
        dbSettings.put(Environment.PASS, "21225896");
        dbSettings.put(Environment.DRIVER, "org.postgresql.Driver");
        dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQL94Dialect");

        // Apply database settings
        standardServiceRegistryBuilder.applySettings(dbSettings);

        // Creating registry
        standardServiceRegistry = standardServiceRegistryBuilder.build();

        // Creating metadata sources
        MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);

        // Creating metadata

        Metadata metadata = metadataSources.getMetadataBuilder().build();

        // Create session factory
        sessionFactory = metadata.getSessionFactoryBuilder().build();

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
