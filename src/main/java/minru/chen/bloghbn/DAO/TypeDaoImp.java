package minru.chen.bloghbn.DAO;

import lombok.extern.slf4j.Slf4j;
import minru.chen.bloghbn.Utils.HibernateUtils;
import minru.chen.bloghbn.model.Category;
import minru.chen.bloghbn.model.Type;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: minru
 * Date: 11/22/19
 * Time: 4:39 PM
 */
@Slf4j
@Repository
public class TypeDaoImp implements TypeDao {
    @Override
    public List<Type> listTypebyUserId(Long userId) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Type as T where T.id=:user_id";
        Query query = session.createQuery(hql);
        query.setParameter("user_id", userId);
        List<Type> Types = query.list();
        return Types;
    }

    @Override
    public boolean insertType(Type type) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(type);
            transaction.commit();
            log.info("Successful add Type: " + type.toString());
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
    public boolean updateType(Type type) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(type);
            transaction.commit();
            log.info("Successful updated Type: " + type.toString());
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
    public boolean deleteType(Type type) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(type);
            transaction.commit();
            log.info("Successful deleted Type: " + type.toString());
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
