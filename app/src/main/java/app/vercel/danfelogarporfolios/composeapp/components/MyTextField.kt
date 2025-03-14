package app.vercel.danfelogarporfolios.composeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showBackground = true
)
@Composable
fun MyTextFieldPatent(modifier: Modifier = Modifier) {
    var textInput: String by rememberSaveable { mutableStateOf("D") }
    var textInput2: String by rememberSaveable { mutableStateOf("") }
    var textInput3: String by rememberSaveable { mutableStateOf("") }
    var textInput4: String by rememberSaveable { mutableStateOf("") }
    var textInput5: String by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        MyTextField(textInput) { textInput = it }
        MySecondTextField(textInput2) { textInput2 = it }
        MyAdvanceTextField(textInput3) { textInput3 = it }
        MyPasswordTextField(textInput4) { textInput4 = it }
        Spacer(Modifier.height(20.dp))
        MyOutlinedTextField(textInput5) { textInput5 = it }
    }
}


@Composable()
fun MyTextField(user: String, onUserChange: (String) -> Unit) {
    TextField(
        value = user,
        onValueChange = { onUserChange(it) },
        readOnly = user.isEmpty()
    )
}

@Composable
fun MySecondTextField(value: String, onChangeValue: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = { onChangeValue(it) },
//        placeholder = {
//            Box(Modifier.size(40.dp).background(Color.Magenta))
//        }
        label = { Text("Write your email") }
    )
}

@Composable
fun MyAdvanceTextField(value: String, onChangeValue: (String) -> Unit) {
    TextField(
        value = value,
        onValueChange = {
//            if(it.contains("a")){
            onChangeValue(it.replace("a", ""))
//            }else{
//                onChangeValue(it)
//            }
        },
//        placeholder = {
//            Box(Modifier.size(40.dp).background(Color.Magenta))
//        }
        label = { Text("Advance TextField") }
    )
}

@Composable
fun MyPasswordTextField(value: String, onChangeValue: (String) -> Unit) {
    var passwordHidden: Boolean by remember { mutableStateOf(true) }

    TextField(
        value = value,
        onValueChange = { onChangeValue(it) },
        singleLine = true,
        label = { Text("Write your Password") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Text(
                text = if(passwordHidden) "Show" else "Hidden",
                modifier = Modifier.clickable { passwordHidden = !passwordHidden }
            )
        }
    )
}

@Composable
fun MyOutlinedTextField(value: String, onValueChange: (String) -> Unit){
    OutlinedTextField(
        value = value,
        onValueChange = { onValueChange(it) }
    )

    BasicTextField(
        value = value,
        onValueChange = { onValueChange(it) }
    )
}