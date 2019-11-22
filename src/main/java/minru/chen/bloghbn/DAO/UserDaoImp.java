package minru.chen.bloghbn.DAO;

import minru.chen.bloghbn.Utils.HibernateUtils;
import minru.chen.bloghbn.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * Author: minru
 * Date: 11/15/19
 * Time: 12:50 PM
 */
@Repository
public class UserDaoImp implements UserDao {
    Logger logger = LoggerFactory.getLogger(UserDaoImp.class);

    @Override
    public User getUserByUsername(String username) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "From User where username= :username";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        User user = (User) query.uniqueResult();
        return user;
    }

    @Override
    public boolean checkUser(String username, String password) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "From User where username= :username and password= :password";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        query.setParameter("password", password);
        User user = (User) query.uniqueResult();
        if (user != null)
            return true;
        else
            return false;
    }

    @Override
    public boolean insertUser(User user) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
            transaction.commit();
            logger.info("Success add User: " + user.toString());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            logger.error(e.getMessage());
            return false;
        } finally {
            session.close();
        }

    }

    @Override
    public boolean deleteUser(User user) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean updataUser(User user) {

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(user);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }
}
