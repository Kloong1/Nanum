import json

def extract_max_chapter(chapters_json):
    chapters_dict = json.loads(chapters_json)

    chapter_nums = chapters_dict.keys()
    chapter_nums = list(map(int, chapter_nums))

    return max(chapter_nums)
