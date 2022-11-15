package com.kloong.nanum.domain.bible;

import lombok.Data;

import java.util.List;

@Data
public class BibleChapter {
    private BibleChapterIndex index;
    private List<BibleVerse> verses;

    public BibleChapter() {}

    public BibleChapter(BibleChapterIndex index, List<BibleVerse> verses) {
        this.index = index;
        this.verses = verses;
    }
}
