package com.woowahan.riders.spring.practice.service;

import com.woowahan.riders.spring.practice.domain.Board;
import com.woowahan.riders.spring.practice.domain.Post;
import com.woowahan.riders.spring.practice.domain.Writer;
import com.woowahan.riders.spring.practice.dto.PostWriteForm;
import com.woowahan.riders.spring.practice.exception.ResourceNotFoundException;
import com.woowahan.riders.spring.practice.repository.BoardRepository;
import com.woowahan.riders.spring.practice.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public Post write(PostWriteForm form, Writer writer) {
        Optional<Board> boardOptional = Optional.ofNullable(boardRepository.findOne(form.getBoardId()));
        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            Post post = Post.of(board, form.getTitle(), form.getContent(), writer);
            return postRepository.save(post);
        }
        throw new ResourceNotFoundException(String.format("board [id:%d] does not exists!", form.getBoardId()));
    }
}
