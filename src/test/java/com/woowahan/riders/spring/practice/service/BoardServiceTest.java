package com.woowahan.riders.spring.practice.service;

import com.woowahan.riders.spring.practice.SpringPracticeApplication;
import com.woowahan.riders.spring.practice.domain.Board;
import com.woowahan.riders.spring.practice.exception.DuplicatedBoardAlreadyExistsException;
import com.woowahan.riders.spring.practice.repository.BoardRepository;
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
public class BoardServiceTest {

    @Autowired
    private BoardService boardService;
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void 게시판이_정상적으로_생성된다() {
        String boardName = "테스트용 게시판";
        Board savedBoard = boardService.create(boardName);

        assertNotNull("게시판이 정상적으로 생성되어야 한다", savedBoard);
        assertEquals("게시판이름은 '테스트용 게시판'이어야 한다", boardName, savedBoard.getName());
    }

    @Test(expected = DuplicatedBoardAlreadyExistsException.class)
    public void 게시판이_중복되면_예외가_발생해야_한다() {

        //Given
        String name = "신규 게시판";

        Board board = Board.of(name);

        boardRepository.save(board);

        //When & Then
        String duplicatedName = "신규 게시판";
        boardService.create(duplicatedName);
    }
}
