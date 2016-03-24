package com.woowahan.riders.spring.practice.dto;

import com.woowahan.riders.spring.practice.domain.Writer;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
public class WriterSignupForm {
    private String userid;
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public String getUserid() {
        return userid;
    }

    public static WriterSignupForm of(String userid, String nickname) {
        WriterSignupForm form = new WriterSignupForm();
        form.userid = userid;
        form.nickname = nickname;
        return form;

    }
}
