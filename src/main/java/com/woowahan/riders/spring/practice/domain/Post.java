package com.woowahan.riders.spring.practice.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
@Entity
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    private Writer writer;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;

    private Post() {}


    public static Post of (String title, String content, Writer writer ){
        Post post = new Post();

        post.title = title;
        post.content = content;
        post.writer = writer;
        post.createdDateTime = new Date();
        writer.appendPost(post);

        return post;

    }
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Writer getWriter() {
        return writer;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void appendComment(Comment comment) {
        comments.add(comment);
    }
}
