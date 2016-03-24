package com.woowahan.riders.spring.practice.dto;

/**
 * Created by justicehoop on 2016. 3. 24..
 */
public class PostWriteForm {
    private Long boardId;
    private String title;
    private String content;

    public Long getBoardId() {
        return boardId;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public static PostWriteForm of(Long boardId, String title, String content) {
        PostWriteForm form = new PostWriteForm();
        form.boardId = boardId;
        form.title = title;
        form.content = content;
        return form;
    }
}
