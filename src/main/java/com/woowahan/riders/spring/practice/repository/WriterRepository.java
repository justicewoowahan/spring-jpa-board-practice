package com.woowahan.riders.spring.practice.repository;

import com.woowahan.riders.spring.practice.domain.Writer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
public interface WriterRepository extends JpaRepository<Writer, Long> {
}
