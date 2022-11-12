package com.kloong.nanum.domain.bible;

import lombok.Data;

@Data
public class BibleVerseIndex {
    private int bookId;
    private int chapter;
    private int verse;
    private int seq;

    public BibleVerseIndex(int bookId, int chapter, int verse, int seq) {
        this.bookId = bookId;
        this.chapter = chapter;
        this.verse = verse;
        this.seq = seq;
    }
}
