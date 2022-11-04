import requests

BASE_URL = "https://getbible.net/v2/korean"

def request_chapters_of_book(book_id):
    request_url = BASE_URL + "/" + str(book_id) + "/chapters.json"
    response = requests.get(request_url)
    return response.text
