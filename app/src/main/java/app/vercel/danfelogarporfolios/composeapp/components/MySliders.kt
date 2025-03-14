package app.vercel.danfelogarporfolios.composeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MySliders(modifier: Modifier = Modifier) {
    var sliderPositions by remember { mutableStateOf(0.2f) }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 42.dp)
    ) {
        Slider(
            value = sliderPositions,
            onValueChange = { sliderPositions = it },
            enabled = false
        )
        Text("Slider Position ${sliderPositions.toString()}")

        AdvanceSlider()
        RangeSliders()
    }
}

@Composable
fun RangeSliders(modifier: Modifier = Modifier) {
    var currentRange by remember { mutableStateOf(0f..10f) }
    RangeSlider(
        value = currentRange,
        valueRange = 0f..40f,
        onValueChange = { currentRange = it },
    )
    Text("Button value: ${currentRange.start}")
    Text("Top value: ${currentRange.endInclusive}")
    Text(currentRange.toString())
}

@Composable
fun AdvanceSlider(modifier: Modifier = Modifier) {
    var sliderPosition by remember { mutableStateOf(0f) }
    var completeValue by remember { mutableStateOf("") }
    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        onValueChangeFinished = { completeValue = sliderPosition.toString() },
        valueRange = 0f..10f,
        steps = 9
    )
    Text(completeValue)
}
