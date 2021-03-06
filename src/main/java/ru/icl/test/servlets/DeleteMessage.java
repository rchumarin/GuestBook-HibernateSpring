package ru.icl.test.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.icl.test.dao.MessageDao;
import ru.icl.test.dao.MessageDaoImpl;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.icl.test.dao.UserDao;

@WebServlet(name = "DeleteMessage", urlPatterns = {"/delete"})
//@Transactional
public class DeleteMessage extends HttpServlet {
    
    //SpringBean
    private MessageDao delete_msgdao;
    private UserDao delete_usrdao;
    public MessageDao getDelete_msgdao() {
        return delete_msgdao;
    }
    public void setDelete_msgdao(MessageDao delete_msgdao) {
        this.delete_msgdao = delete_msgdao;
    }
    public UserDao getDelete_usrdao() {
        return delete_usrdao;
    }
    public void setDelete_usrdao(UserDao delete_usrdao) {
        this.delete_usrdao = delete_usrdao;
    }

    @Override
//    @Transactional
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        
        //Spring-Hibernate
        ApplicationContext context = new ClassPathXmlApplicationContext("springContext.xml");
        BeanFactory factory = (BeanFactory) context;
        DeleteMessage deleteBean = (DeleteMessage) factory.getBean("deletebean");
        
        try {
            deleteBean.getDelete_msgdao().deleteMessage(deleteBean.getDelete_msgdao().getMessage(id));            
        } catch (SQLException ex) {
            Logger.getLogger(DeleteMessage.class.getName()).log(Level.SEVERE, null, ex);
        } 
        response.sendRedirect(request.getContextPath()+"/allmessage");
        
//        try {
//            MessageDao messageDao = new MessageDaoImpl();  
//            messageDao.deleteMessage(messageDao.getMessage(id));
//        } catch (SQLException ex) {
//            Logger.getLogger(DeleteMessage.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//        response.sendRedirect(request.getContextPath()+"/allmessage");
    }
    
}