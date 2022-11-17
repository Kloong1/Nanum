package com.kloong.nanum.dto.bible;

import lombok.Data;

@Data
public class BibleChapterIndexDto {
    private String bookName;
    private int chapter;

    public BibleChapterIndexDto(String bookName, int chapter) {
        this.bookName = bookName;
        this.chapter = chapter;
    }
}
