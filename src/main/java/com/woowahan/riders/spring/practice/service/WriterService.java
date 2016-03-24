package com.woowahan.riders.spring.practice.service;

import com.woowahan.riders.spring.practice.domain.Writer;
import com.woowahan.riders.spring.practice.dto.WriterSignupForm;
import com.woowahan.riders.spring.practice.exception.DuplicatedUseridAlreadyExistsException;
import com.woowahan.riders.spring.practice.repository.WriterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
@Service
public class WriterService {

    @Autowired
    private WriterRepository writerRepository;

    @Transactional
    public Writer signup(WriterSignupForm form) {
        Writer writer = Writer.of(form.getUserid(), form.getNickname());
        checkDuplicatedUserid(form.getUserid());
        return writerRepository.save(writer);
    }

    private void checkDuplicatedUserid(String userid) {
        Writer duplicatedWriter= writerRepository.findByUserid(userid);

        if (duplicatedWriter != null) {
            throw new DuplicatedUseridAlreadyExistsException();
        }


    }
}
