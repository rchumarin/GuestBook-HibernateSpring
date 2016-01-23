package ru.icl.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.icl.test.entity.HibernateUtil;
import ru.icl.test.entity.User;

public class UserDaoImpl implements UserDao{
    
    @Override
    public void addUser(User user) throws SQLException {
        Session sessionFactory = null;
        try{
            sessionFactory = HibernateUtil.getSessionFactory().openSession();
            sessionFactory.beginTransaction();
            sessionFactory.save(user);
            sessionFactory.getTransaction().commit();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if((sessionFactory != null) && (sessionFactory.isOpen()))
                sessionFactory.close();
        }    
    }

    @Override
    public void deleteMessage(User user) throws SQLException {
        Session sessionFactory = null;
        try{
            sessionFactory = HibernateUtil.getSessionFactory().openSession();
            sessionFactory.beginTransaction();
            sessionFactory.delete(user);
            sessionFactory.getTransaction().commit();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if((sessionFactory != null) && (sessionFactory.isOpen()))
                sessionFactory.close();
        }     
    }

    @Override
    public User getUser(int id) throws SQLException {
        Session sessionFactory = null;
        User result = null;        
        try{
            sessionFactory = HibernateUtil.getSessionFactory().openSession();
            result = (User) sessionFactory.get(User.class, id);
            
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if((sessionFactory != null) && (sessionFactory.isOpen()))
                sessionFactory.close();
        } 
        return result;   
    }

    @Override
    public List<User> getUsers() throws SQLException {
        Session sessionFactory = null;        
        List<User> users = new ArrayList<User>();               
        try{
            sessionFactory = HibernateUtil.getSessionFactory().openSession();
            users = sessionFactory.createCriteria(User.class).list();
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
            if((sessionFactory != null) && (sessionFactory.isOpen()))
                sessionFactory.close();
        }
        return users;
    }
      
//    @Autowired
//    SessionFactory sessionFactory;
//    
//    @Override
//    public void addUser(User user) throws SQLException {
//        sessionFactory.getCurrentSession().save(user);    
//    }
//
//    @Override
//    public void deleteMessage(User user) throws SQLException {
//        sessionFactory.getCurrentSession().delete(user);            
//    }
//
//    @Override
//    public User getUser(int id) throws SQLException {        
//        User result = null;                
//        result = (User) sessionFactory.getCurrentSession().get(User.class, id);
//        return result;   
//    }
//
//    @Override
//    public List<User> getUsers() throws SQLException {       
//        List<User> users = new ArrayList<User>();                       
//        users = sessionFactory.getCurrentSession().createCriteria(User.class).list();
//        return users;
//    }
 
}
