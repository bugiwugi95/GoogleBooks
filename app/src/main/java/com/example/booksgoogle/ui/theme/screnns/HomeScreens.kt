package com.example.booksgoogle.ui.theme.screnns

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.booksgoogle.R
import com.example.booksgoogle.model.BooksData





@Composable
fun CardImage(
    booksData: BooksData,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = 6.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            /*
             AsyncImage(
                modifier = modifier.fillMaxWidth(),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(booksData.image)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                placeholder = painterResource(R.drawable.ic_launcher_foreground)

            )
             */
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
            //временнно
            Text("name", modifier = modifier.padding(16.dp))
            Text("type", modifier = modifier.padding(16.dp))
        }


    }

}

@Preview(showBackground = true)
@Composable
fun CardImagePreview() {
    val dataPreview = BooksData(
        image = ""
    )
    CardImage(dataPreview)
}