package dao;

import java.util.List;
import beans.Post;

public interface PostDAO {

    List<Post> findAll();
    List<Post> findById();
    List<Post> findByName();
    boolean insertPost(Post post);
    boolean updatePost(Post post);
    boolean deletePost(Post post);

}

