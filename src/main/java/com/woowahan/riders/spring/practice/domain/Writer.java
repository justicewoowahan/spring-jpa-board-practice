package com.woowahan.riders.spring.practice.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
@Entity
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userid;
    private String nickname;
    @OneToMany(mappedBy = "writer")
    private List<Post> posts = new ArrayList<>();
    @OneToMany(mappedBy = "writer")
    private List<Comment> comments = new ArrayList<>();

    private Writer() {}

    public Long getId() {
        return id;
    }

    public String getUserid() {
        return userid;
    }

    public String getNickname() {
        return nickname;
    }

    public static Writer of (String userid, String nickname){
        Writer writer  = new Writer();
        writer.userid = userid;
        writer.nickname = nickname;


        return writer;

    }

    public void appendPost (Post post){
        this.posts.add(post);
    }

    public void appendComment(Comment comment){
        this.comments.add(comment);
    }
}
