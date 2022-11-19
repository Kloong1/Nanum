package com.kloong.nanum.domain.bible;

import lombok.Data;

@Data
public class BibleBookInfo {
    private int bookId;
    private String bookName;
    private int maxChapter;

    public BibleBookInfo() {}

    public BibleBookInfo(int bookId, String bookName, int maxChapter) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.maxChapter = maxChapter;
    }
}
