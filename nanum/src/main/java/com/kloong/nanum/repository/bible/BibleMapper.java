package com.kloong.nanum.repository.bible;

import com.kloong.nanum.domain.bible.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BibleMapper {
    Optional<BibleVerse> findBibleVerseByBibleVerseIndex(BibleVerseIndex index);

    List<BibleVerse> findBibleVersesByBibleVerseIndexRange(@Param("startIndex") BibleVerseIndex startIndex, @Param("endIndex") BibleVerseIndex endIndex);

    List<BibleVerse> findBibleVersesByBibleChapterIndex(BibleChapterIndex index);

    Optional<BibleChapterInfo> findBibleChapterInfoByBibleChapterIndex(BibleChapterIndex index);

    Optional<BibleBookInfo> findBibleBookInfoByBibleBookId(int bookId);
}
