package com.woowahan.riders.spring.practice.repository;

import com.woowahan.riders.spring.practice.SpringPracticeApplication;
import com.woowahan.riders.spring.practice.domain.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringPracticeApplication.class)
@WebAppConfiguration
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void 게시판이_정상적으로_생성되어야_한다() {
        Board board = Board.of("테스트게시판");
        board = boardRepository.save(board);
        Board savedBoard = boardRepository.findOne(board.getId());
        assertNotNull("새로운 게시판이 저장 되어야 한다", savedBoard);
    }

}