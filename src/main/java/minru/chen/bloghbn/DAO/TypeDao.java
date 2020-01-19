package minru.chen.bloghbn.DAO;

import minru.chen.bloghbn.model.Comment;
import minru.chen.bloghbn.model.Type;

import java.util.List;

public interface TypeDao {
    List<Type> listTypebyUserId(Long userId);
    boolean insertType(Type type);
    boolean updateType(Type type);
    boolean deleteType(Type type);
}
