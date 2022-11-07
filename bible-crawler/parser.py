import json

def extract_max_chapter(chapters_json):
    chapters_dict = json.loads(chapters_json)

    chapter_nums = chapters_dict.keys()
    chapter_nums = list(map(int, chapter_nums))

    return max(chapter_nums)

def extract_verses(verses_json):
    verses_dict = json.loads(verses_json)

    verses = verses_dict["verses"]
    verses = list(map(lambda verse: [verse["verse"], verse["text"].rstrip()], verses))

    verses.sort(key=lambda verse: verse[0])
    
    return verses

