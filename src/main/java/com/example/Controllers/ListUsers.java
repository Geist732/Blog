//package com.example.Controllers;
//
//import com.example.Models.User;
//import com.example.Models.Users;
//import org.hibernate.Session;
//import org.hibernate.Transaction;
//
///**
// * Created by Nick on 1/9/17.
// */
//public class ListUsers implements Users {
//    private Session session;
//
//    public ListUsers(Session session) {this.session = session;}
//
//    @Override
//    public void save(User user){
//        Transaction tx = session.beginTransaction();
//        session.save(user);
//        tx.commit();
//    }
//
//
//
//
//}
