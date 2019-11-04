package minru.chen.bloghbn;

import minru.chen.bloghbn.Utils.HibernateUtil;
import minru.chen.bloghbn.model.Blog;
import minru.chen.bloghbn.model.User;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

public class HibernateTest {


    @Test
    public void testDB(){
        Session session=null;
        try {
            session=HibernateUtil.getSession();
            session.beginTransaction();
            User user=new User();
            user.setNickname("minru");
            user.setPassword("dsf");
            session.save(user);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            HibernateUtil.closeSession(session);
        }
    }

}


