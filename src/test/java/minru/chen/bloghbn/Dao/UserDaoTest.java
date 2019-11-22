package minru.chen.bloghbn.Dao;

import minru.chen.bloghbn.DAO.UserDao;
import minru.chen.bloghbn.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Time;
import java.util.Date;

/**
 * Author: minru
 * Date: 11/15/19
 * Time: 10:58 PM
 */
@SpringBootTest
public class UserDaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void insertTest(){
        User user=new User();
        user.setUsername("t_minru");
        user.setPassword("root");
        user.setNickname("Norman");
        user.setEmail("normancmr@gmail.com");
        user.setCreateTime(new Date());
        user.setLoginTime(new Date());
        userDao.insertUser(user);
    }
}
