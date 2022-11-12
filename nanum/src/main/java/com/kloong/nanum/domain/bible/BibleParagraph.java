package com.kloong.nanum.domain.bible;

import lombok.Data;

@Data
public class BibleParagraph {
    private BibleVerseIndex startIndex;
    private BibleVerseIndex endIndex;
    private String paragraph;

    public BibleParagraph(BibleVerseIndex startIndex, BibleVerseIndex endIndex, String paragraph) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.paragraph = paragraph;
    }
}
