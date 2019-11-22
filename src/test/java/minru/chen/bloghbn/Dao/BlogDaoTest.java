package minru.chen.bloghbn.Dao;

import minru.chen.bloghbn.DAO.BlogDao;
import minru.chen.bloghbn.model.Blog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Base64;
import java.util.Date;
import java.util.List;

/**
 * Author: minru
 * Date: 11/15/19
 * Time: 11:11 PM
 */
@SpringBootTest
public class BlogDaoTest {
    @Autowired
    BlogDao blogDao;

    @Test
    public void listBlogByUserID() throws CloneNotSupportedException {
        Blog blog1=new Blog();
        blog1.setCreateTime(new Date());
        blog1.setUpateTime(new Date());
        blog1.setFilename(Base64.getEncoder().encode("test1".getBytes()).toString());
        blog1.setTitle("test1");
        blog1.setUser_id(1L);
        blog1.setSummary("my summary: hello");
        Blog blog2=new Blog();
        blog2.setCreateTime(new Date());
        blog2.setUpateTime(new Date());
        blog2.setFilename(Base64.getEncoder().encode("test1".getBytes()).toString());
        blog2.setTitle("test1");
        blog2.setUser_id(2L);
        blog2.setSummary("my summary: hello");
        Blog blog3=new Blog();
        blog3.setCreateTime(new Date());
        blog3.setUpateTime(new Date());
        blog3.setFilename(Base64.getEncoder().encode("test1".getBytes()).toString());
        blog3.setTitle("test1");
        blog3.setUser_id(1L);
        Blog blog4=new Blog();
        blog4.setUser_id(2L);
        Blog blog5=blog1.clone();
        blog5.setUser_id(5L);


        blogDao.insertBlog(blog1);
        blogDao.insertBlog(blog2);
        blogDao.insertBlog(blog3);
        blogDao.insertBlog(blog4);
        blogDao.insertBlog(blog5);
        List<Blog> blogs=blogDao.listBlogByUserId(1L);
        for(Blog blog:blogs){
            System.out.println(blog.toString());
        }


    }
}
