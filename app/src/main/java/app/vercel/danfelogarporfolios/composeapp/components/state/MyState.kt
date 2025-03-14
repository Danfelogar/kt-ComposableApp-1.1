package app.vercel.danfelogarporfolios.composeapp.components.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MyState(modifier: Modifier = Modifier) {
    //rememberSaveable() give for save value until the life cycle shot down
    //by help to down use "XXXX".value for access to values
    var number by rememberSaveable { mutableStateOf(3) }

    Column(modifier.fillMaxSize()) {
        StateExample1(number, onClick = { number += 1 })
        StateExample2(number) { number += 1 }
    }
}

@Composable
fun StateExample1(number: Int, onClick: () -> Unit) {
    Text(
        text = "Click me ${number}",
        modifier = Modifier
            .clickable { onClick() }
    )
}


@Composable
fun StateExample2(number: Int, onClick: () -> Unit) {
    Text(
        text = "Click me ${number}",
        modifier = Modifier
            .clickable { onClick() }
    )
}