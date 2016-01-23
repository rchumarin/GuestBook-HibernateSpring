package ru.icl.test.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User  implements java.io.Serializable {
    
    @Id
    @Column(name = "clientid", unique=true, nullable=false)
    private String clientid;
    
    @Column(name = "fname")
    private String fname;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usr")    
    @OrderBy(value = "message")
    List<Message> messages = new ArrayList<Message>(); 
    
    public User() {
    }	
    public User(String clientid) {        
        this.clientid = clientid;
    }

    public String getClientid() {
        return this.clientid;
    }
    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getFname() {
        return this.fname;
    }    
    public void setFname(String fname) {
        this.fname = fname;
    }
    
    public List<Message> getMessages() {
        return this.messages;
    }    
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

}


