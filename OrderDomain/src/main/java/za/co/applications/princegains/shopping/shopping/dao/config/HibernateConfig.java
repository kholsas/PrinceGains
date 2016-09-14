package za.co.applications.princegains.shopping.shopping.dao.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import za.co.applications.princegains.shopping.shopping.model.*;

/**
 * Created by kholofelo on 2016/06/20.
 */


@SuppressWarnings("deprecation")
public class HibernateConfig {

    private static final SessionFactory sessionFactory;

    static {
        try {
            AnnotationConfiguration configuration = new AnnotationConfiguration().configure();
            configuration.addAnnotatedClass(Catalog.class);
            configuration.addAnnotatedClass(CatalogItem.class);
            configuration.addAnnotatedClass(Order.class);
            configuration.addAnnotatedClass(OrderItem.class);
            configuration.addAnnotatedClass(StockItem.class);
            configuration.addAnnotatedClass(SystemUser.class);
            configuration.addAnnotatedClass(UserProfile.class);

            sessionFactory = configuration.buildSessionFactory();

        } catch (Throwable ex) {
            System.err.println("Session Factory could not be created." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}