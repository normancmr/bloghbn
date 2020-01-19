package minru.chen.bloghbn.DAO;

import lombok.extern.slf4j.Slf4j;
import minru.chen.bloghbn.Utils.HibernateUtils;
import minru.chen.bloghbn.model.Blog;
import minru.chen.bloghbn.model.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author: minru
 * Date: 11/22/19
 * Time: 4:23 PM
 */
@Slf4j
@Repository
public class CategoryDaoImp implements CategoryDao {
    @Override
    public List<Category> listCateByUserId(Long user_id) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Category as C where C.user_id=:user_id";
        Query query = session.createQuery(hql);
        query.setParameter("user_id", user_id);
        List<Category> categories = query.list();
        return categories;
    }

    @Override
    public boolean insertCate(Category category) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(category);
            transaction.commit();
            log.info("Successful add Category: " + category.toString());
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
    public boolean updateCate(Category category) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(category);
            transaction.commit();
            log.info("Successful update Blog: " + category.toString());
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
    public boolean deleteCate(Category category) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(category);
            transaction.commit();
            log.info("Successful deleted Blog: " + category.toString());
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
