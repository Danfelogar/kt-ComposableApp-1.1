package app.vercel.danfelogarporfolios.composeapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showBackground = true
)
@Composable
fun MyProgressAdvance(modifier: Modifier = Modifier){
    var progressWidth by rememberSaveable {  mutableStateOf( 0.5f) }

    Column(modifier
        .padding(24.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        CircularProgressIndicator(
            progress = {
                progressWidth
            },
        )
        Row(Modifier.fillMaxWidth()) {
            Button(onClick = { progressWidth -= 0.1f }) { Text("Decrease") }
            Button(onClick = { progressWidth += 0.1f })  { Text("Increase") }
        }
    }
}

@Composable
fun MyProgressBar(modifier: Modifier = Modifier){
    var showLoading by rememberSaveable {  mutableStateOf(false) }

    Column(modifier
        .padding(24.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        if(showLoading) {
            CircularProgressIndicator(
                color = Color.Cyan,
                strokeWidth = 10.dp
            )
            LinearProgressIndicator(
                color = Color.Yellow,
                modifier = Modifier.padding(top = 32.dp),
                trackColor = Color.Gray,
            )
        }
        Button(onClick = { showLoading = !showLoading }) {
            Text("Click me")
        }
    }
}