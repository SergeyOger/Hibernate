package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry serviceRegistry;

    static {
	try {
	    serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
	    MetadataSources metadataSource = new MetadataSources(serviceRegistry);
	    Metadata metadata = metadataSource.getMetadataBuilder().build();
	    sessionFactory = metadata.getSessionFactoryBuilder().build();
	} catch (Exception e) {
	    if (serviceRegistry != null) {
		StandardServiceRegistryBuilder.destroy(serviceRegistry);
	    }
	}
    }

    public static SessionFactory getSessionFactory() {
	return sessionFactory;
    }

}
