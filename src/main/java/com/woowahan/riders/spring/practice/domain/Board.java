package com.woowahan.riders.spring.practice.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
@Entity
public class Board {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDateTime;
    @OneToMany(mappedBy = "board")
    private List<Post> posts = new ArrayList<>();

    private Board() { }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void addPost(Post post) {
        post.amendBoard(this);
        posts.add(post);
    }

    public static Board of(String name) {
        Board board = new Board();
        board.name = name;
        board.createdDateTime = new Date();
        return board;
    }
}
