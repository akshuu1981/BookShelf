package com.akshat.bookshelfapp.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import coil3.request.CachePolicy
import coil3.request.ImageRequest
import coil3.request.crossfade
import coil3.size.Scale
import com.akshat.bookshelfapp.data.model.Book
import com.akshat.bookshelfapp.data.model.ImageLinks
import com.akshat.bookshelfapp.data.model.VolumeInfo
import com.akshat.bookshelfapp.ui.theme.Purple80


@Composable
fun BooksList(books: List<Book>,
              modifier: Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),//(100.dp),
        modifier = modifier,
    ) {
        items(books) { book ->
            Log.d("Booklists: ", "Book = ${book.volumeInfo.title}, img = ${book.volumeInfo.imageLinks.thumbnail}")
            BookCard(book = book)
        }
    }
}

@Composable
fun BookCard(book: Book){
    Card(modifier = Modifier.padding(4.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.elevatedCardColors(
            containerColor = Purple80
        )) {
        Column(){
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                .data(book.volumeInfo.imageLinks.thumbnail.replace("http://","https://"))
                .crossfade(true)
                    .scale(Scale.FIT)
                .diskCachePolicy(CachePolicy.ENABLED)
                .build(),
                contentDescription = "Image describing ${book.volumeInfo.title}",
                modifier = Modifier.fillMaxWidth().padding(4.dp))
            Text(text = book.volumeInfo.title)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewBookCard(){
    val vol = VolumeInfo(title = "Dummy Title",
    authors = listOf("Dummy Author"),
    imageLinks = ImageLinks("", ""))
    BookCard(book = Book(id="id1", volumeInfo = vol))
}


@Preview(showBackground = true)
@Composable
fun PreviewBooksList(){
    val vol = VolumeInfo(title = "Dummy Title",
        authors = listOf("Dummy Author"),
        imageLinks = ImageLinks("", ""))
    BooksList(books = listOf(Book(id="id1", volumeInfo = vol),Book(id="id2", volumeInfo = vol)),
        modifier = Modifier.fillMaxWidth())
}
