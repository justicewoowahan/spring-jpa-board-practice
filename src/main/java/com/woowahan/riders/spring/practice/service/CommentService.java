package com.woowahan.riders.spring.practice.service;

import com.woowahan.riders.spring.practice.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;


}
