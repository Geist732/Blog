package com.example.Models;

import java.util.List;

/**
 * Created by Nick on 1/5/17.
 */
public interface Posts  {
    List<Post> all();
    Post getPostById(int id);
    void deletePost(Post post);
    Post editPost(Post post);
    void save(Post post);

}
