BLANK_VERSES_FILE = "blank_verses.csv"

class BlankVerseManager:
    __blank_verses = []

    with open(BLANK_VERSES_FILE, "r") as blank_verses_file:
        print("init __blank_verses")
        for blank_verse_line in blank_verses_file.readlines():
            book_id, chapter_num, verse_num = blank_verse_line.strip().split(',')
            __blank_verses.append({"book_id" : int(book_id), "chapter_num" : int(chapter_num), "verse_num" : int(verse_num)})

    @classmethod
    def has_blank_verse_in_book(cls, book_id):
        return any(blank_verse["book_id"] == book_id for blank_verse in cls.__blank_verses)
