package minru.chen.bloghbn.DAO;

import minru.chen.bloghbn.model.Comment;

import java.util.List;

/**
 * Author: minru
 * Date: 11/22/19
 * Time: 4:35 PM
 */
public class CommnetDaoImp implements CommentDao {
    @Override
    public List<Comment> listCommentbyBlogId(Long blogId) {
        return null;
    }

    @Override
    public boolean insertComm(Comment comment) {
        return false;
    }

    @Override
    public boolean updateComm(Comment comment) {
        return false;
    }

    @Override
    public boolean deleteComm(Comment comment) {
        return false;
    }
}
