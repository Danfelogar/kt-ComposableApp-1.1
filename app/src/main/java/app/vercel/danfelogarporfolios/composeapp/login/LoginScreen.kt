package app.vercel.danfelogarporfolios.composeapp.login

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@Preview(
//    widthDp = 50,
//    heightDp = 50,
//    showBackground =  true,
//    apiLevel = 30,
//    showSystemUi = true,
//    device = Devices.PIXEL_4,
)
@Composable
fun PreviewGreet(){
    PreviewGreeting("HELLO Daniel!!!!!!!!!")
}

@Composable
fun PreviewGreeting(a: String){
    Text(
        text = "$a welcome to kotlin",
        modifier = Modifier
            .background(Color.Cyan)
            .padding(horizontal = 30.dp)
            .clickable {

            }
    )
}