package com.example.dao;

import com.example.Controllers.ListPosts;
import com.example.Models.Posts;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DaoFactory {

    private static SessionFactory sessionFactory = HibernatePostsDao.getSessionFactory();
    private static Session session = sessionFactory.openSession();

    private static Posts postsDao;

    public static Posts getPostsDao(){
        if (postsDao == null){
            postsDao = new ListPosts(session);
        }
        return postsDao;
    }
}
