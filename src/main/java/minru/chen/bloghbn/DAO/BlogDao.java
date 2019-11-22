package minru.chen.bloghbn.DAO;

import minru.chen.bloghbn.model.Blog;

import java.util.List;

public interface BlogDao {
    List<Blog> listBlogByUserId(Long userId);
    List<Blog> PageableBlog(Long userId,int pageNum,int total);
    int countBlog(Long userId);
    boolean insertBlog(Blog blog);
    boolean updateBlog(Blog blog);
    boolean deleteBlog(Blog blog);
    List<Blog> listHotBlog();
}
