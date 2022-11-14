package com.kloong.nanum.domain.bible;

import lombok.Data;

@Data
public class BibleVerseIndex {
    private int bookId;
    private int chapter;
    private int verse;

    public BibleVerseIndex() {}

    public BibleVerseIndex(int bookId, int chapter, int verse) {
        this.bookId = bookId;
        this.chapter = chapter;
        this.verse = verse;
    }
}
