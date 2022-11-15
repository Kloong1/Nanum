package com.kloong.nanum.domain.bible;

import lombok.Data;

@Data
public class BibleBookInfo {
    private int bookId;
    private int maxChapter;

    public BibleBookInfo() {}

    public BibleBookInfo(int bookId, int maxChapter) {
        this.bookId = bookId;
        this.maxChapter = maxChapter;
    }
}
