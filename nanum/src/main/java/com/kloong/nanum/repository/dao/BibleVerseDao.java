package com.kloong.nanum.repository.dao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "bible_verse")
public class BibleVerseDao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "verse_seq")
    private int seq;

    @Column(name = "verse_book_id")
    private int bookId;

    @Column(name = "verse_chapter_num")
    private int chapter;

    @Column(name = "verse_num")
    private int verse;

    @Column(name = "verse_content")
    private String content;

    public BibleVerseDao() {}
}
