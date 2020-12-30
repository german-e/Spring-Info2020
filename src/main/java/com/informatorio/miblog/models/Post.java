package com.informatorio.miblog.models;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    @Size(min = 4, message = "La cantidad minima es 4 caracteres")
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(name = "Published")
    private Boolean published;

    @Column(nullable = false)
    private String content;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "author")
    private User user;


    public Post() { }

    public Post(String title, String description, Boolean published, User user, String content) {

        this.title = title;
        this.description = description;
        this.published = published;
        this.user = user;
        this.content = content;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() { return content; }

    public void setContent(String content) {this.content = content; }

    public Boolean getPublished() {return published;}

    public void setPublished(Boolean published) {this.published = published;}

    public User getUser() {return user; }

    //public void setUser(User user) {this.user = user; }

    public Date getCreationDate() {return creationDate;}

    public void setCreationDate(Timestamp creationDate) {this.creationDate = creationDate; }

    
}
