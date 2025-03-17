package app.vercel.danfelogarporfolios.composeapp.components

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(
    showBackground = true
)
@Composable
fun MyButton(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Button(
            onClick = {
                Log.i("DanfelogarInf", "Holo Holo")
            },
            enabled = true,
            shape = RoundedCornerShape(20),
            border = BorderStroke(
                width = 6.dp,
                Color.Magenta
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Yellow,
                contentColor = Color.Black,
                disabledContainerColor = Color.Blue,
                disabledContentColor = Color.White
            )
        ) {
            Text("Danfelogar Button")
        }

        OutlinedButton(
            onClick = {
                Log.e("DanfelogarInf", "Holo Holo")
            },
            enabled = true,
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Yellow,
                contentColor = Color.Black,
                disabledContainerColor = Color.Blue,
                disabledContentColor = Color.White
            )
        ) {
            Text("Danfelogar Button Outlined")
        }

        TextButton(onClick = {}) {
            Text("\"daNF\"")
        }


        FilledTonalButton(onClick = {}) {
            Text("Danfelogar FilledTonalButton")
        }

        ElevatedButton(
            onClick = {},
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 26.dp
            )
        ) {
            Text("Danfelogar ElevatedButton")
        }
    }
}