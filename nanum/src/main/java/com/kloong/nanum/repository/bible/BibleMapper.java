package com.kloong.nanum.repository.bible;

import com.kloong.nanum.domain.bible.BibleVerse;
import com.kloong.nanum.domain.bible.BibleVerseIndex;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BibleMapper {
    Optional<BibleVerse> findBibleVerseByBibleVerseIndex(BibleVerseIndex index);

    List<BibleVerse> findBibleVersesByBibleVerseIndexRange(@Param("startIndex") BibleVerseIndex startIndex, @Param("endIndex") BibleVerseIndex endIndex);
}
