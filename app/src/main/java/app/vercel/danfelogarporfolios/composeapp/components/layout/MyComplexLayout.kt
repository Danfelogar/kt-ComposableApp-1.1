package app.vercel.danfelogarporfolios.composeapp.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showBackground = true
)
@Composable
fun MyComplexLayout(modifier: Modifier = Modifier){
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier.fillMaxWidth().weight(1f).background(Color.Magenta),
            contentAlignment = Alignment.Center
        ){
            Text("Hello 1")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.fillMaxWidth().weight(1f).background(Color.Blue)){
            Row{
                Box(
                    modifier = Modifier.weight(1f).fillMaxHeight().background(Color.DarkGray),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = "Hello 2"
                    )
                }
                Spacer(modifier = Modifier.width(80.dp))
                Box(
                    modifier = Modifier.weight(1f).fillMaxHeight().background(Color.Gray),
                    contentAlignment = Alignment.Center
                    ){
                    Text(
                        text = "Hello 3"
                    )
                }
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth().weight(1f).background(Color.Yellow),
            contentAlignment = Alignment.BottomCenter
        ){
            Text("Hello 4")
        }
    }
}