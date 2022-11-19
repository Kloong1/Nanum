package com.kloong.nanum.repository.bible;

import com.kloong.nanum.domain.bible.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BibleRepository {

    private final BibleMapper bibleMapper;

    public BibleRepository(BibleMapper bibleMapper) {
        this.bibleMapper = bibleMapper;
    }

    public Optional<BibleVerse> findBibleVerseByBibleVerseIndex(BibleVerseIndex index) {
        return bibleMapper.findBibleVerseByBibleVerseIndex(index);
    }

    public List<BibleVerse> findBibleVersesByBibleVerseIndexRange(BibleVerseIndex startIndex, BibleVerseIndex endIndex) {
        return bibleMapper.findBibleVersesByBibleVerseIndexRange(startIndex, endIndex);
    }

    public Optional<BibleChapter> findBibleChapterByBibleChapterIndex(BibleChapterIndex index) {
        Optional<BibleChapterInfo> foundBibleChapterInfo = bibleMapper.findBibleChapterInfoByBibleChapterIndex(index);

        if (foundBibleChapterInfo.isEmpty()) {
            return Optional.empty();
        }

        List<BibleVerse> bibleVerses = bibleMapper.findBibleVersesByBibleChapterIndex(index);
        BibleChapter bibleChapter = new BibleChapter(new BibleChapterIndex(index.getBookId(), index.getChapter()), bibleVerses);

        return Optional.of(bibleChapter);
    }

    public Optional<BibleChapterInfo> findBibleChapterInfoByBibleChapterIndex(BibleChapterIndex index) {
        return bibleMapper.findBibleChapterInfoByBibleChapterIndex(index);
    }

    public Optional<BibleBookInfo> findBibleBookInfoByBookId(int bookId) {
        return bibleMapper.findBibleBookInfoByBookId(bookId);
    }

    public Optional<BibleBookInfo> findBibleBookInfoByBookName(String bookName) {
        return bibleMapper.findBibleBookInfoByBookName(bookName);
    }
}
