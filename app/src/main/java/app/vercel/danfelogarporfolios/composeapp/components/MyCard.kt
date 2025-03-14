package app.vercel.danfelogarporfolios.composeapp.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.dp

@Composable
fun MyCard(modifier: Modifier = Modifier) {
    Column(modifier) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(12.dp),
            colors = CardDefaults.cardColors(Color.White),
            border = BorderStroke(4.dp, SolidColor(Color.Red))
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Text 1")
                Text("Text 2")
                Text("Text 3")
            }
        }
        Surface {
            Column(Modifier.padding(16.dp)) {
                Text("Text 1")
                Text("Text 2")
                Text("Text 3")
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
//                .background(Color.Magenta)
            ,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            VerticalDivider(
                color = Color.Magenta,
                thickness = 10.dp,
                modifier = Modifier.height(1000.dp)
            )
            HorizontalDivider()
        }

        BadgedBox(
            badge = {
                Badge(
                    modifier = Modifier.padding(bottom = 12.dp),
                    containerColor = Color.Red,
                    contentColor = Color.White
                ) {
                    Text("3")
                }
            },
            modifier = Modifier
                .padding(20.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "star",
                Modifier.padding(bottom = 120.dp)
            )
        }
        var selectedText by remember { mutableStateOf("") }
        var expanded by remember { mutableStateOf(false) }
        val desserts = listOf("ice cream", "coffe", "fruits", "chilaquiles", "chocolate")
        Column(
            modifier = Modifier
                .padding(20.dp)
        ) {
            OutlinedTextField(
                value = selectedText,
                onValueChange = { selectedText = it },
                enabled = false,
                readOnly = true,
                modifier = Modifier
                    .clickable {
                        expanded = true
                    }
                    .fillMaxWidth()
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                desserts.forEach {
                    DropdownMenuItem(
                        onClick = {
                            expanded = false
                            selectedText = it
                        },
                        text = {
                            Text(text = it)
                        }
                    )
                }
            }
        }


    }
}