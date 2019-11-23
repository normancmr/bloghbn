package minru.chen.bloghbn.DAO;

import minru.chen.bloghbn.model.Category;
import minru.chen.bloghbn.model.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> listCommentbyBlogId(Long blogId);
    boolean insertComm(Comment comment);
    boolean updateComm(Comment comment);
    boolean deleteComm(Comment comment);
}
