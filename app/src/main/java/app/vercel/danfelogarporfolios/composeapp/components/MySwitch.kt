package app.vercel.danfelogarporfolios.composeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonColors
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.state.ToggleableState.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.vercel.danfelogarporfolios.composeapp.components.state.CheckInfo


@Composable
fun MyCheckBoxWithText(checkInfo: CheckInfo){

    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Checkbox(checked = checkInfo.selected, onCheckedChange = { checkInfo.onCheckedChange(it) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(checkInfo.title)
    }
}

@Composable
fun getOptions(titles:List<String>):List<CheckInfo>{
    return titles.map{
        var status by rememberSaveable {  mutableStateOf(false) }
         CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { status = it }
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    val myOptions = getOptions(listOf("example 2.1", "example 2.2",))
    var selected by remember{
        mutableStateOf("1")
    }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        Column {
            MyRadioButton()
            MyTrisStatusCheckBox()
            myOptions.forEach {
                MyCheckBoxWithText(it)
            }
            MyRadioButtonList(selected) { selected = it }
        }
    }
}

@Composable
fun MyRadioButton(){
    var status by rememberSaveable { mutableStateOf(false) }

    Row(Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
        ){
        RadioButton(
            selected = status,
            onClick = {status = !status},
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green
            )
        )
        Text("Example radio button 1")
    }

}

@Composable
fun MyRadioButtonList(numberStr: String, onItemSelected: (String) -> Unit){


    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = numberStr == "1",
                onClick = {onItemSelected("1")},
            )
            Text("Example radio button 1")
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = numberStr == "2",
                onClick = {onItemSelected("2")},
            )
            Text("Example radio button 2")
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = numberStr == "3",
                onClick = {onItemSelected("3")},
            )
            Text("Example radio button 3")
        }
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = numberStr == "4",
                onClick = {onItemSelected("4")},
            )
            Text("Example radio button 4")
        }
    }

}

@Composable
fun MyTrisStatusCheckBox(){
    var status by rememberSaveable { mutableStateOf(Off) }

    TriStateCheckbox(
        state = status,
        onClick = {
            status = when(status){
                On -> Off
                Off -> Indeterminate
                Indeterminate -> On
            }
        }
    )
}

@Composable
fun MySimpleCheckBox(modifier: Modifier = Modifier) {
    var state by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = modifier
    ) {
        Checkbox(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = true,
            colors = CheckboxDefaults.colors(
                checkedColor =  Color.Red,
                uncheckedColor = Color.Yellow,
                checkmarkColor = Color.Blue
            )
        )
    }
}

@Composable
fun MySimpleSwitch(modifier: Modifier = Modifier) {
    var state by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = modifier
    ) {
        Switch(
            checked = state,
            onCheckedChange = { state = !state },
            enabled = true,
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.Red,
                uncheckedTrackColor = Color.Magenta,
                checkedThumbColor = Color.Green,
                checkedTrackColor = Color.Cyan,
                disabledCheckedTrackColor = Color.Yellow,
                disabledCheckedThumbColor = Color.Yellow
            )
        )
    }
}