import requests

BASE_URL = "https://getbible.net/v2/korean"

def request_chapters_of_book(book_id):
    request_url = BASE_URL + "/" + str(book_id) + "/chapters.json"
    response = requests.get(request_url)
    return response.text

def request_verses_of_chapter(book_id, chapter_num):
    request_url = BASE_URL + "/" + str(book_id) + "/" + str(chapter_num) + ".json"
    response = requests.get(request_url)
    return response.text
