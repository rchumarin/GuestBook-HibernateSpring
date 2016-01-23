
package ru.icl.test.entity;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.icl.test.dao.MessageDao;
import ru.icl.test.dao.MessageDao;
import ru.icl.test.dao.MessageDaoImpl;
import ru.icl.test.dao.UserDao;
import ru.icl.test.dao.UserDao;
import ru.icl.test.dao.UserDaoImpl;
import ru.icl.test.entity.Message;

public class Main {
 
    private MessageDao messagedao;
    private UserDao userdao;

    public MessageDao getMessagedao() {
        return messagedao;
    }
    public void setMessagedao(MessageDao messageDao) {
        this.messagedao = messageDao;
    }

    public UserDao getUserdao() {
        return userdao;
    }
    public void setUserdao(UserDao userDao) {
        this.userdao = userDao;
    }

    public static void main(String[] args) throws SQLException {
           
//        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
//        BeanFactory factory = (BeanFactory) context;
//        Main myBean = (Main) factory.getBean("mainbean");        
//        
//        for (Message msg : myBean.getMessagedao().getMessages()){        
//            System.out.println(msg.getId() + "\t"
//                    + msg.getUser().getClientid() + "\t"
//                    + msg.getMessage());
//            System.out.println();
//        }
        
System.out.println();
//        Session sessionFactory = null;
//        try{
//            sessionFactory = HibernateUtil.getSessionFactory().openSession();
//            sessionFactory.beginTransaction();  
//
//            Criteria criteria = sessionFactory.createCriteria(Message.class);
//            List<Message> messageList = criteria.list();

//            MessageDao messageDao = new MessageDaoImpl();
//            for (Message msg : messageList) {
//                System.out.println(msg.getId() + "\t"
//                            + msg.getUser().getClientid() + "\t"
//                            + msg.getMessage());
//                System.out.println();
//    }            
//            System.out.println("====================================================");
//
//            List<User> regionList = sessionFactory.createQuery("from User").list();
//
//            for (User r : regionList) {
//                System.out.println("Region name: {}" + r);
//                for (Message c : r.getMessages()) {
//                    System.out.println("     City name: {}" + c);
//                }
//                System.out.println();
//            }
//
//            sessionFactory.getTransaction().commit();
//        } catch(Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            if((sessionFactory != null) && (sessionFactory.isOpen()))
//                sessionFactory.close();                
//        }       
//    }
//        
    }
    
}


     