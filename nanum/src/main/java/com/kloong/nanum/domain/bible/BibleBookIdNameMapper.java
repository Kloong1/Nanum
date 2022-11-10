package com.kloong.nanum.domain.bible;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BibleBookIdNameMapper {

    public BibleBookIdNameMapper() {
        ClassPathResource bibleBookNamesResource = new ClassPathResource("data/bible/bibleBookNames.txt");
        try {
            System.out.println(bibleBookNamesResource.getURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
