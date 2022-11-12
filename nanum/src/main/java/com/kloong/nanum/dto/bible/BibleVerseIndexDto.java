package com.kloong.nanum.dto.bible;

import lombok.Data;

@Data
public class BibleVerseIndexDto {
    private String bookName;
    private int chapter;
    private int verse;

    public BibleVerseIndexDto(String bookName, int chapter, int verse) {
        this.bookName = bookName;
        this.chapter = chapter;
        this.verse = verse;
    }
}
