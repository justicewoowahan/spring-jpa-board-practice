package com.woowahan.riders.spring.practice.repository;

import com.woowahan.riders.spring.practice.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
public interface BoardRepository extends JpaRepository<Board, Long> {
    Board findByName(String name);
}
