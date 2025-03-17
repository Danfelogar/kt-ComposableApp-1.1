package app.vercel.danfelogarporfolios.composeapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Stars
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.danfelogarporfolios.composeapp.R

@Preview(
    showBackground = true
)
@Composable
fun MyIcon(){
    Icon(
        imageVector = Icons.Rounded.Stars,
        contentDescription =  "Example_icon",
        tint = Color.Blue
    )
}


@Composable
fun MyImageAdvance(){
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Example",
        modifier = Modifier
            .clip(
//                RoundedCornerShape(25f)
            CircleShape
            )
            .border(5.dp, Color.Magenta, CircleShape)
    )
}


@Composable
fun MyImage(){
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Example",
        alpha = 0.5f
    )
}