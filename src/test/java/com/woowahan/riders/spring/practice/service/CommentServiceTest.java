package com.woowahan.riders.spring.practice.service;

import com.woowahan.riders.spring.practice.SpringPracticeApplication;
import com.woowahan.riders.spring.practice.domain.Board;
import com.woowahan.riders.spring.practice.domain.Comment;
import com.woowahan.riders.spring.practice.domain.Post;
import com.woowahan.riders.spring.practice.domain.Writer;
import com.woowahan.riders.spring.practice.dto.CommentWriteForm;
import com.woowahan.riders.spring.practice.dto.PostWriteForm;
import com.woowahan.riders.spring.practice.repository.BoardRepository;
import com.woowahan.riders.spring.practice.repository.CommentRepository;
import com.woowahan.riders.spring.practice.repository.WriterRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by justicehoop on 2016. 3. 24..
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringPracticeApplication.class)
@WebAppConfiguration
public class CommentServiceTest {


    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private WriterRepository writerRepository;


//    @Test
//    public void 댓글이_정상적으로_생성된다(){
//        //Given
//        Board board = Board.of("테스트게시판");
//
//
//        board = boardRepository.save(board);
//        Writer writer = writerRepository.save(Writer.of("userid", "nickname"));
//
//
//        //When
//        PostWriteForm form = PostWriteForm.of(board.getId(), "게시글제목", "게시글내용");
//        Post post = postService.write(form, writer);
//
//        CommentWriteForm commentWriteForm = CommentWriteForm.of()
//
//        //Then
//        assertNotNull("게시글이 정상적으로 작성되어야 한다", post);
//        assertEquals("게시글의 제목은 '게시글제목'이어야 한다", "게시글제목", post.getTitle());
//        assertEquals("게시글의 제목은 '게시글내용'이어야 한다", "게시글내용", post.getContent());
//    }


}
