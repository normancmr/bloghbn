package minru.chen.bloghbn.DAO;

import minru.chen.bloghbn.model.User;

public interface UserDao {
    User getUserByUsername(String username);

    boolean checkUser(String username, String password);
    boolean insertUser(User user);
    boolean deleteUser(User user);
    boolean updataUser(User user);
}
