package com.example.Controllers;

import com.example.Models.Post;
import com.example.Models.Posts;
import com.example.dao.HibernatePostsDao;
import javafx.geometry.Pos;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by Nick on 1/5/17.
 */
public class ListPosts implements Posts {
    private Session session;

    public ListPosts(Session session){
        this.session = session;
    }

    @Override
    public List<Post> all(){
        return session.createQuery("from Post").list();
    }

    @Override
    public Post getPostById(int id) {
        Query query = session.createQuery("FROM Post u WHERE u.id = :id ");
        query.setParameter("id", id);
        return (Post) query.getSingleResult();

    }

    @Override
    public void deletePost(Post post){
        Transaction tx = session.beginTransaction();
        session.delete(post);
        tx.commit();
    }

    @Override
    public Post editPost(Post post){
        Transaction tx = session.beginTransaction();
        session.update(post);
        tx.commit();
        return null;
    }


    @Override
    public void save(Post post){
        Transaction tx = session.beginTransaction();
        session.save(post);
        tx.commit();
    }


}

