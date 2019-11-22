package minru.chen.bloghbn.Utils;

/**
 * Author: minru
 * Date: 11/14/19
 * Time: 7:39 PM
 */

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtils {

    private static final Logger log = LoggerFactory.getLogger(HibernateUtils.class);

    /*
     * Since we will be using annotated classes, it is best to maintain a list
     * of such classes so we add them up easily
     */
    @SuppressWarnings({"unchecked", "rawtypes", "serial"})
    private static final List<Class<?>> classList = new ArrayList() {{
        add(minru.chen.bloghbn.model.User.class);
        add(minru.chen.bloghbn.model.Blog.class);
        add(minru.chen.bloghbn.model.Comment.class);
        add(minru.chen.bloghbn.model.Category.class);
        add(minru.chen.bloghbn.model.Type.class);
        add(minru.chen.bloghbn.model.Icon.class);

    }};
    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        /*
         * Load up the configuration using the hibernate.cfg.xml
         */
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        /*
         * Build the registry using the properties in the configuration
         */
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();

        /*
         * Now load the classes
         */
        for (Class<?> pojoClass : classList) {
            log.info("Adding annotated class : " + pojoClass.getCanonicalName());
            configuration.addAnnotatedClass(pojoClass);
        }

        /*
         * and finally buils the session factory
         */
        return configuration.buildSessionFactory(serviceRegistry);
    }
    public static Session getSession(){return sessionFactory.openSession();}

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

    /**
     * The main utility method to be used to retreive the transaction.
     *
     * @return {@link Transaction} The transaction of the current session
     */
    public static Transaction getTransaction() throws Exception {
        Session s = getSessionFactory().getCurrentSession();
        Transaction tx = s.beginTransaction();
        tx.setTimeout(10);
        return tx;
        //return getSessionFactory().getCurrentSession().beginTransaction();;
    }

}
