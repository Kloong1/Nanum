package com.kloong.nanum.repository.bible;

import com.kloong.nanum.domain.bible.BibleVerse;
import com.kloong.nanum.domain.bible.BibleVerseIndex;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class BibleRepositoryTest {

    @Autowired
    BibleRepository bibleRepository;

    @Test
    void findBibleVerseByBibleVerseIndex() {
        //given
        BibleVerseIndex bibleVerseIndex = new BibleVerseIndex(1, 1, 1);

        //when
        Optional<BibleVerse> result = bibleRepository.findBibleVerseByBibleVerseIndex(bibleVerseIndex);

        //then
        BibleVerse findVerse = result.orElseThrow();

        BibleVerseIndex expectedIndex = new BibleVerseIndex(1, 1, 1);
        BibleVerse expectedVerse = new BibleVerse(expectedIndex, "태초에 하나님이 천지를 창조하시니라");
        assertThat(findVerse).isEqualTo(expectedVerse);
    }

    @Test
    void findBibleVersesByBibleVerseIndexRange() {
        //given
        BibleVerseIndex startIndex = new BibleVerseIndex(1, 1, 1);
        BibleVerseIndex endIndex = new BibleVerseIndex(1, 1, 3);

        //when
        List<BibleVerse> result = bibleRepository.findBibleVersesByBibleVerseIndexRange(startIndex, endIndex);
        BibleVerse bibleVerse1 = bibleRepository.findBibleVerseByBibleVerseIndex(new BibleVerseIndex(1, 1, 1)).orElseThrow();
        BibleVerse bibleVerse2 = bibleRepository.findBibleVerseByBibleVerseIndex(new BibleVerseIndex(1, 1, 2)).orElseThrow();
        BibleVerse bibleVerse3 = bibleRepository.findBibleVerseByBibleVerseIndex(new BibleVerseIndex(1, 1, 3)).orElseThrow();

        //then
        assertThat(result).containsExactly(bibleVerse1, bibleVerse2, bibleVerse3);
    }
}