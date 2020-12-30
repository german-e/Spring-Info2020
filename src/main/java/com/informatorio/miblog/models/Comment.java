package com.informatorio.miblog.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date creationDate;

    @Column(nullable = false)
    @Size(max=200, message = "El comentario no puede exceder los 200 caracteres")
    private String comment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "post")
    private Post post;



    @ManyToOne(optional = false)
    @JoinColumn(name = "authorComment")
    private User author;

    private Comment() { }

    public Comment(String comment, User author) {
        this.author = author;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Post getPost() {return post;}

    public void setPost(Post post) {this.post = post; }

}
