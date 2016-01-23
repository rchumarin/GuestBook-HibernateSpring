package ru.icl.test.entity;

import javax.persistence.*;
import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name = "message")
public class Message implements java.io.Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique=true, nullable=false)
    private int id;
    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "clientid")
    private User usr;
    
    @Column(name = "message")
    private String message;

    public Message() {
    }
	
    public Message(int id) {
        this.id = id;
    }
    public Message(int id, User user, String message) {
       this.id = id;
       this.usr = user;
       this.message = message;
    }
    
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
    public User getUser() {
        return this.usr;
    }
    public void setUser(User user) {
        this.usr = user;
    }

    public String getMessage() {
        return this.message;
    }    
    public void setMessage(String message) {
        this.message = message;
    }

}


