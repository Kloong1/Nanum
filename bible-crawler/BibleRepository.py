import pymysql
import os.path
import json

class BibleRepository:

    def __init__(self):
        self.conn = None

    def connect(self, db_connect_filename):
        if not os.path.isfile(db_connect_filename):
            raise FileNotFoundError(f"에러! 존재하지 않는 파일입니다. {db_connect_filename}")

        with open(db_connect_filename, "r") as db_connect_file: 
            db_connect_dict = json.load(db_connect_file)

            host = db_connect_dict["host"]
            user = db_connect_dict["user"]
            password = db_connect_dict["password"]
            db = db_connect_dict["db"]
            charset = db_connect_dict["charset"]

            self.__connect(host, user, password, db, charset)

    def __connect(self, host, user, password, db, charset):
        self.conn = pymysql.connect(host=host, user=user, password=password, db=db, charset=charset)

    def close(self):
        if self.conn:
            self.conn.close()

    def save_verses_of_book(self, book_id, max_chapter, verses_of_book):
        self.__save_book_info(book_id, max_chapter)

        for chapter_num in range(1, max_chapter + 1):
            self.__save_chapter_info(book_id, chapter_num, verses_of_book)
            self.__save_verses_of_chapter(book_id, chapter_num, verses_of_book[chapter_num - 1])

    def __save_book_info(self, book_id, max_chapter):
        sql = "insert into bible_book(book_id, book_max_chapter) values(%s, %s)"
        params = (book_id, max_chapter)

        cursor = self.conn.cursor()
        cursor.execute(sql, params)

        self.conn.commit()

    def __save_chapter_info(self, book_id, chapter_num, verses_of_book):
        chapter_max_verse = len(verses_of_book[chapter_num - 1])

        sql = "insert into bible_chapter(chapter_num, chapter_book_id, chapter_max_verse) values(%s, %s, %s)"
        params = (chapter_num, book_id, chapter_max_verse)

        cursor = self.conn.cursor()
        cursor.execute(sql, params)

        self.conn.commit()

    def __save_verses_of_chapter(self, book_id, chapter_num, verses_of_chapter):
        sql = "insert into bible_verse(verse_book_id, verse_chapter_num, verse_num, verse_content) values(%s, %s, %s, %s)"

        cursor = self.conn.cursor()

        for verse in verses_of_chapter:
            params = (book_id, chapter_num, verse[0], verse[1])
            cursor.execute(sql, params)

        self.conn.commit()
