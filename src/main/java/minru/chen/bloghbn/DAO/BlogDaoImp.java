package minru.chen.bloghbn.DAO;

import lombok.extern.slf4j.Slf4j;
import minru.chen.bloghbn.Utils.HibernateUtils;
import minru.chen.bloghbn.model.Blog;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: minru
 * Date: 11/15/19
 * Time: 4:48 PM
 */
@Slf4j
@Repository
public class BlogDaoImp implements BlogDao {
    private final int pageSize = 10;

    @Override
    public List<Blog> listBlogByUserId(Long userId) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Blog as B where B.user_id=:user_id";
//        String hql = "from Blog";
        Query query = session.createQuery(hql);
        query.setParameter("user_id", userId);
        List<Blog> blogs = query.list();
        return blogs;
    }

    @Override
    public List<Blog> PageableBlog(Long userId, int pageNum, int total) {
        int countSize = countBlog(userId);
        int totalPageNum = (int) Math.ceil(countSize / pageSize);
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.getTransaction();
        String hql = "from Blog as B where B.user_id=:user_id";
        Query pageQuery = session.createQuery(hql);
        pageQuery.setParameter("user_id", userId);
        pageQuery.setFirstResult((pageNum-1)*pageSize);
        pageQuery.setMaxResults(pageSize);
        return pageQuery.list();
    }

    @Override
    public int countBlog(Long userId) {
        Session session = HibernateUtils.getSession();
        Transaction transaction = session.getTransaction();
        String count = "select count(*) from Blog as B where B.user_id=:user_id";
        Query countQuery = session.createQuery(count);
        countQuery.setParameter("user_id", userId);
        int countSize = (int) countQuery.uniqueResult();
        return countSize;
    }

    @Override
    public boolean insertBlog(Blog blog) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(blog);
            transaction.commit();
            log.info("Successful added Blog: " + blog.toString());
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
    public boolean updateBlog(Blog blog) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(blog);
            transaction.commit();
            log.info("Successful updated Blog: " + blog.toString());
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
    public boolean deleteBlog(Blog blog) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(blog);
            transaction.commit();
            log.info("Successful delete Blog: " + blog.toString());
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
    public List<Blog> listHotBlog() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Query query=session.createQuery("from Blog b order by b.visited");
            query.setMaxResults(20);
            List result=query.list();
            transaction.commit();
            log.info("Got top "+result.size()+" Blog list!");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }
}
