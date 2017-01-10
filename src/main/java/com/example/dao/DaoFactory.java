package com.example.dao;

//import com.example.Controllers.ListUsers;
import com.example.Models.Posts;
import com.example.Models.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DaoFactory {

    private static SessionFactory sessionFactory = HibernatePostsDao.getSessionFactory();
    private static Session session = sessionFactory.openSession();

//    private static Posts postsDao;
    private static Users usersDao;

//    public static Posts getPostsDao(){
//        if (postsDao == null){
//            postsDao = new ListPosts(session);
//        }
//        return postsDao;
//    }

//    public static Users getUserDao(){
//        if ( usersDao == null){
//            usersDao = new ListUsers(session);
//        }
//        return usersDao;
//    }


}
