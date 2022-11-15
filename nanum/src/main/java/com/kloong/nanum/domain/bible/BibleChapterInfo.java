package com.kloong.nanum.domain.bible;

import lombok.Data;

@Data
public class BibleChapterInfo {
    private int bookId;
    private int chapter;
    private int maxVerse;

    public BibleChapterInfo() {}

    public BibleChapterInfo(int bookId, int chapter, int maxVerse) {
        this.bookId = bookId;
        this.chapter = chapter;
        this.maxVerse = maxVerse;
    }
}
