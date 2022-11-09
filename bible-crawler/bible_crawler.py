import getbiblev2_api as getbible
import parser
from BlankVerseManager import BlankVerseManager
from BibleRepository import BibleRepository

def request_verses_of_book(book_id, max_chapter):
    verses_of_book = []

    for chapter_num in range(1, max_chapter + 1):
        verses_json = getbible.request_verses_of_chapter(book_id, chapter_num)
        verses_of_chapter = parser.extract_verses(verses_json)
        verses_of_book.append(verses_of_chapter)

    return verses_of_book

def main():
    first_book_id = 1
    last_book_id = 66

    print("Connect to db...")

    bibleRepository = BibleRepository()
    bibleRepository.connect("./db/db_connect.json")

    print("Connected.")

    for book_id in range(first_book_id, last_book_id + 1):
        print()
        print(f"Book id = {book_id}")

        print("Request chapter information...")
        chapters_json = getbible.request_chapters_of_book(book_id)
        max_chapter = parser.extract_max_chapter(chapters_json)

        print("Request verses of book...")
        verses_of_book = request_verses_of_book(book_id, max_chapter)

        if BlankVerseManager.has_blank_verses_in_book(book_id):
            print("Fill in blank verses...")
            BlankVerseManager.fill_blank_verse_in_book(book_id, verses_of_book)

        print("Save verses in db...")
        bibleRepository.save_verses_of_book(book_id, max_chapter, verses_of_book)
    
    print("Disconnect to db...")
    bibleRepository.close()


if __name__ == "__main__":
    main()
