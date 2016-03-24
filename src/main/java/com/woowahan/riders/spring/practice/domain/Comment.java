package com.woowahan.riders.spring.practice.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    @ManyToOne
    private Writer writer;
    @ManyToOne
    private Post post;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;


    private Comment() {}


    public static Comment of(String content, Writer writer, Post post){
        Comment comment = new Comment();
        comment.content = content;
        comment.writer = writer;
        comment.post = post;
        comment.createdDateTime = new Date();
        post.appendComment(comment);
        writer.appendComment(comment);

        return comment;
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public Writer getWriter() {
        return writer;
    }

    public Post getPost() {
        return post;
    }
}
