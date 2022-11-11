package com.kloong.nanum.domain.bible;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class BibleBookIdNameMapper {

    private final String[] bibleBookNames = new String[67];

    public BibleBookIdNameMapper() {
        initBibleBookNames();
    }

    private void initBibleBookNames() {
        ClassPathResource bibleBookNamesResource = new ClassPathResource("data/bible/bibleBookNames.txt");
        List<String> bibleBookNameList = null;

        try {
            Path bibleBookNamesResourcePath = Paths.get(bibleBookNamesResource.getURI());
            bibleBookNameList = Files.readAllLines(bibleBookNamesResourcePath);
        } catch (IOException e) {
            throw new IllegalStateException("Error! 성경 이름 파일을 찾을 수 없습니다.", e);
        }

        for (int id = 1; id < bibleBookNames.length; id++) {
            bibleBookNames[id] = bibleBookNameList.get(id - 1);
        }
    }

    public String getBibleBookName(int bookId) {
        if (bookId < 1 || bookId > 66) {
            throw new IllegalArgumentException("Error! bookId 범위는 1~66 이어야합니다.");
        }
        return bibleBookNames[bookId];
    }
}
