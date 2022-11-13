package com.kloong.nanum.domain.bible;

import lombok.Data;

@Data
public class BibleChapterIndex {
    private int bookId;
    private int chapter;

    public BibleChapterIndex(int bookId, int chapter) {
        this.bookId = bookId;
        this.chapter = chapter;
    }
}
