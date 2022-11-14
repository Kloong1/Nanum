package com.kloong.nanum.repository.bible;

import com.kloong.nanum.domain.bible.BibleVerse;
import com.kloong.nanum.domain.bible.BibleVerseIndex;
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

}
