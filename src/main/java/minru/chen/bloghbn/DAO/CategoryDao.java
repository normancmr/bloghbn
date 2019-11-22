package minru.chen.bloghbn.DAO;

import minru.chen.bloghbn.model.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> listCateByUserId(Long user_id);
    boolean insertCate(Category category);
    boolean updateCate(Category category);
    boolean deleteCate(Category category);
}
