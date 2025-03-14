package app.vercel.danfelogarporfolios.composeapp.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp


@Composable()
fun MyText(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(text = "Hello Danfelogar Dev")
        Text(text = "Hello Danfelogar Dev", color = Color.Cyan)
        Text(text = "Hello Danfelogar Dev", fontSize = 25.sp)
        Text(text = "Hello Danfelogar Dev", fontStyle = FontStyle.Italic)
        Text(text = "Hello Danfelogar Dev", fontWeight = FontWeight.ExtraBold)
        Text(text = "Hello Danfelogar Dev", letterSpacing = 10.sp)
        Text(
            text = "Hello Danfelogar Dev",
            textDecoration = TextDecoration.Underline,
            color = Color.Blue,
            modifier = Modifier.clickable{
                println("Hello")
            }
        )
        Text(
            text = "Hello Danfelogar Dev",
            textDecoration = TextDecoration.Underline + TextDecoration.LineThrough
        )
        Text(
            text = "Hello Danfelogar Dev Hello Danfelogar Dev Hello Danfelogar Dev Hello Danfelogar Dev Hello Danfelogar Dev Hello Danfelogar Dev Hello Danfelogar Dev Hello Danfelogar Dev Hello Danfelogar Dev",
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )


    }

}