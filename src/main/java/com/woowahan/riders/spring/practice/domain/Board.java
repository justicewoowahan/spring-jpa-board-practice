package com.woowahan.riders.spring.practice.domain;

import javax.persistence.*;
import java.util.Date;

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

    public static Board of(String name) {
        Board board = new Board();
        board.name = name;
        board.createdDateTime = new Date();
        return board;
    }
}
