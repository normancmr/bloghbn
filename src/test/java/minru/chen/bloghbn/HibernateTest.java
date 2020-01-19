package minru.chen.bloghbn;

import minru.chen.bloghbn.Utils.HibernateUtils;
import minru.chen.bloghbn.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class HibernateTest {

    @Test
    public void testDB() {
        Session session=HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            User user= new User();
            user.setNickname("Mi2nru");
            user.setUsername("minru");
            user.setPassword("123");
            session.save(user);
            transaction.commit();
        }catch (HibernateException e){
            System.out.println();
            e.printStackTrace();
        }


    }
}

