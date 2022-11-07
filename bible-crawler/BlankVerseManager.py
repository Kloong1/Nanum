BLANK_VERSES_FILE = "blank_verses.csv"

class BlankVerseManager:
    __blank_verses = []

    with open(BLANK_VERSES_FILE, "r") as blank_verses_file:
        for blank_verse_line in blank_verses_file.readlines():
            book_id, chapter_num, verse_num = blank_verse_line.strip().split(',')
            __blank_verses.append({"book_id" : int(book_id), "chapter_num" : int(chapter_num), "verse_num" : int(verse_num)})

    @classmethod
    def has_blank_verses_in_book(cls, book_id):
        return any(blank_verse["book_id"] == book_id for blank_verse in cls.__blank_verses)

    @classmethod
    def fill_blank_verse_in_book(cls, book_id, verses_of_book):
        blank_verses_of_book = list(filter(lambda blank_verse: blank_verse["book_id"] == book_id, cls.__blank_verses))

        #list.insert(verse_num) 을 사용해서 blank verse를 채워넣기 때문에, verse_num이 더 작은 blank_verse가 항상 먼저 와야 한다
        blank_verses_of_book.sort(key=lambda blank_verse: (blank_verse["chapter_num"], blank_verse["verse_num"]))

        for blank_verse in blank_verses_of_book:
            chapter_num = blank_verse["chapter_num"]
            verse_num = blank_verse["verse_num"]
            
            verses_of_book[chapter_num - 1].insert(verse_num - 1, [verse_num, "(없음)"])
