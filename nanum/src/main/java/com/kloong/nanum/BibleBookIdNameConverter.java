package com.kloong.nanum;

import com.kloong.nanum.constant.bible.BibleConst;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class BibleBookIdNameMapper {

    private final Map<Integer, String> idToName = new HashMap<>(BibleConst.BOOK_MAX_ID * 2);
    private final Map<String, Integer> nameToId = new HashMap<>(BibleConst.BOOK_MAX_ID * 2);

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

        for (int id = BibleConst.BOOK_MIN_ID; id <= BibleConst.BOOK_MAX_ID; id++) {
            idToName.put(id, bibleBookNameList.get(id - 1));
            nameToId.put(bibleBookNameList.get(id - 1), id);
        }
    }

    public String getBibleBookName(int bookId) {
        if (!idToName.containsKey(bookId)) {
            throw new IllegalArgumentException("Error! 잘못된 bookId 입니다.");
        }
        return idToName.get(bookId);
    }

    public int getBibleBookId(String bookName) {
        if (!nameToId.containsKey(bookName)) {
            throw new IllegalArgumentException("Error! 잘못된 bookName 입니다.");
        }
        return nameToId.get(bookName);
    }
}
