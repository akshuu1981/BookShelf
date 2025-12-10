package com.akshat.bookshelfapp.data.model

import kotlinx.serialization.Serializable

/* Sample JSON response
"kind": "books#volume",
      "id": "J9G50L3c14QC",
      "etag": "IRe0sxhVxSM",
      "selfLink": "https://www.googleapis.com/books/v1/volumes/J9G50L3c14QC",
      "volumeInfo": {
        "title": "The History of Jazz",
        "authors": [
          "Ted Gioia"
        ],
        "publisher": "Oxford University Press",
        "publishedDate": "2011-05-09",
        "description": "Ted Gioia's History of Jazz has been universally hailed as a classic--acclaimed by jazz critics and fans around the world. Now Gioia brings his magnificent work completely up-to-date, drawing on the latest research and revisiting virtually every aspect of the music, past and present. Gioia tells the story of jazz as it had never been told before, in a book that brilliantly portrays the legendary jazz players, the breakthrough styles, and the world in which it evolved. Here are the giants of jazz and the great moments of jazz history--Jelly Roll Morton, Louis Armstrong, Duke Ellington at the Cotton Club, cool jazz greats such as Gerry Mulligan, Stan Getz, and Lester Young, Charlie Parker and Dizzy Gillespie's advocacy of modern jazz in the 1940s, Miles Davis's 1955 performance at the Newport Jazz Festival, Ornette Coleman's experiments with atonality, Pat Metheny's visionary extension of jazz-rock fusion, the contemporary sounds of Wynton Marsalis, and the post-modernists of the current day. Gioia provides the reader with lively portraits of these and many other great musicians, intertwined with vibrant commentary on the music they created. He also evokes the many worlds of jazz, taking the reader to the swamp lands of the Mississippi Delta, the bawdy houses of New Orleans, the rent parties of Harlem, the speakeasies of Chicago during the Jazz Age, the after hours spots of corrupt Kansas city, the Cotton Club, the Savoy, and the other locales where the history of jazz was made. And as he traces the spread of this protean form, Gioia provides much insight into the social context in which the music was born.",
        "industryIdentifiers": [
          {
            "type": "ISBN_13",
            "identifier": "9780199831876"
          },
          {
            "type": "ISBN_10",
            "identifier": "0199831874"
          }
        ],
        "readingModes": {
          "text": true,
          "image": true
        },
        "pageCount": 454,
        "printType": "BOOK",
        "categories": [
          "Music"
        ],
        "maturityRating": "NOT_MATURE",
        "allowAnonLogging": true,
        "contentVersion": "0.12.7.0.preview.3",
        "panelizationSummary": {
          "containsEpubBubbles": false,
          "containsImageBubbles": false
        },
        "imageLinks": {
          "smallThumbnail": "http://books.google.com/books/content?id=J9G50L3c14QC&printsec=frontcover&img=1&zoom=5&edge=curl&source=gbs_api",
          "thumbnail": "http://books.google.com/books/content?id=J9G50L3c14QC&printsec=frontcover&img=1&zoom=1&edge=curl&source=gbs_api"
        },
        "language": "en",
        "previewLink": "http://books.google.ca/books?id=J9G50L3c14QC&printsec=frontcover&dq=jazz+history&hl=&cd=1&source=gbs_api",
        "infoLink": "https://play.google.com/store/books/details?id=J9G50L3c14QC&source=gbs_api",
        "canonicalVolumeLink": "https://play.google.com/store/books/details?id=J9G50L3c14QC"
      },
      "saleInfo": {
        "country": "CA",
        "saleability": "FOR_SALE",
        "isEbook": true,
        "listPrice": {
          "amount": 18.07,
          "currencyCode": "CAD"
        },
        "retailPrice": {
          "amount": 9.99,
          "currencyCode": "CAD"
        },
        "buyLink": "https://play.google.com/store/books/details?id=J9G50L3c14QC&rdid=book-J9G50L3c14QC&rdot=1&source=gbs_api",
        "offers": [
          {
            "finskyOfferType": 1,
            "listPrice": {
              "amountInMicros": 18070000,
              "currencyCode": "CAD"
            },
            "retailPrice": {
              "amountInMicros": 9990000,
              "currencyCode": "CAD"
            },
            "giftable": true
          }
        ]
      },
      "accessInfo": {
        "country": "CA",
        "viewability": "PARTIAL",
        "embeddable": true,
        "publicDomain": false,
        "textToSpeechPermission": "ALLOWED",
        "epub": {
          "isAvailable": true,
          "acsTokenLink": "http://books.google.ca/books/download/The_History_of_Jazz-sample-epub.acsm?id=J9G50L3c14QC&format=epub&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
        },
        "pdf": {
          "isAvailable": true,
          "acsTokenLink": "http://books.google.ca/books/download/The_History_of_Jazz-sample-pdf.acsm?id=J9G50L3c14QC&format=pdf&output=acs4_fulfillment_token&dl_type=sample&source=gbs_api"
        },
        "webReaderLink": "http://play.google.com/books/reader?id=J9G50L3c14QC&hl=&source=gbs_api",
        "accessViewStatus": "SAMPLE",
        "quoteSharingAllowed": false
      },
      "searchInfo": {
        "textSnippet": "Here are the giants of jazz and the great moments of jazz history--Jelly Roll Morton, Louis Armstrong, Duke Ellington at the Cotton Club, cool jazz greats such as Gerry Mulligan, Stan Getz, and Lester Young, Charlie Parker and Dizzy ..."
      }
    }
 */

@Serializable
data class TopLevel(
    val kind: String,
    val totalItems: Int,
    val items: List<Book>)
@Serializable
data class Book(val id: String,
    val volumeInfo: VolumeInfo
    )

@Serializable
data class VolumeInfo(val title: String,
    val authors: List<String>,
    val imageLinks: ImageLinks)

@Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String
)