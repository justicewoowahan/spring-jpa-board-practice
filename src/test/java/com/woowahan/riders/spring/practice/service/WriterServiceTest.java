package com.woowahan.riders.spring.practice.service;

import com.woowahan.riders.spring.practice.SpringPracticeApplication;
import com.woowahan.riders.spring.practice.domain.Writer;
import com.woowahan.riders.spring.practice.dto.WriterSignupForm;
import com.woowahan.riders.spring.practice.exception.DuplicatedUseridAlreadyExistsException;
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
public class WriterServiceTest {

    @Autowired
    private WriterService writerService;
    @Autowired
    private WriterRepository writerRepository;

    @Test
    public void 회원가입이_정상적으로_되어야_한다() {
        WriterSignupForm form = WriterSignupForm.of("userid", "nickname");
        Writer writer = writerService.signup(form);

        assertNotNull("회원가입이 정상적으로 되어야 한다", writer);
        assertEquals("회원의 userid는 userid여야 한다", form.getUserid(), writer.getUserid());
        assertEquals("회원의 nickname은 nickname이어야 한다", form.getNickname(), writer.getNickname());
    }

    @Test(expected = DuplicatedUseridAlreadyExistsException.class)
    public void userid가_중복되면_예외가_발생해야_한다() {

        //Given
        WriterSignupForm form = WriterSignupForm.of("userid", "nickname");
        Writer writer = Writer.of(form.getUserid(), form.getNickname());
        writerRepository.save(writer);

        //When & Then
        WriterSignupForm duplicatedUser = WriterSignupForm.of("userid", "nickname");
        writerService.signup(form);
    }
}