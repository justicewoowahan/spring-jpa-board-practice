package com.woowahan.riders.spring.practice.service;

import com.woowahan.riders.spring.practice.domain.Board;
import com.woowahan.riders.spring.practice.exception.DuplicatedBoardAlreadyExistsException;
import com.woowahan.riders.spring.practice.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public Board create(String boardName) {
        Board board = Board.of(boardName);
        checkDuplicatedBoard(boardName);

        return boardRepository.save(board);
    }


    private void checkDuplicatedBoard(String name) {
        Board duplicatedBoard = boardRepository.findByName(name);

        if (duplicatedBoard != null) {
            throw new DuplicatedBoardAlreadyExistsException();
        }


    }
}
