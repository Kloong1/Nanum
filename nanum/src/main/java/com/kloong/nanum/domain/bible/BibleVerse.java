package com.kloong.nanum.domain.bible;

import lombok.Data;

@Data
public class BibleVerse {
    private BibleVerseIndex index;
    private String content;

    public BibleVerse() {}

    public BibleVerse(BibleVerseIndex index, String content) {
        this.index = index;
        this.content = content;
    }
}
