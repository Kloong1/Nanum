import getbiblev2_api as getbible
import parser

#  response = requests.get("https://getbible.net/v2/korean/1/1.json")
#  dict = json.loads(response.text)
#
#  print(dict)

#  for key in dict.keys():
#      print(key)

def main():
    first_book_id = 1
    last_book_id = 66

    for book_id in range(first_book_id, last_book_id + 1):
        chapters_json = getbible.request_chapters_of_book(book_id)
        max_chapter = parser.extract_max_chapter(chapters_json)
        break


if __name__ == "__main__":
    main()
