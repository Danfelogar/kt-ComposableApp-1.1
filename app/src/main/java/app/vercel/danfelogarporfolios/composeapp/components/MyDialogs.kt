package app.vercel.danfelogarporfolios.composeapp.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.core.graphics.drawable.WrappedDrawable
import app.vercel.danfelogarporfolios.composeapp.R

@ExperimentalMaterial3Api
@Composable
fun MyDialogs(modifier: Modifier = Modifier) {
    var showDialog by remember { mutableStateOf(false) }
    var showCustomDialog by remember { mutableStateOf(false) }
    var showCustomDialogM3 by remember { mutableStateOf(false) }
    var showConfirmationDialog by remember { mutableStateOf(false) }


    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(onClick = { showDialog = true }) {
            Text("Show Dialog")
        }
        Button(onClick = { showCustomDialog = true }) {
            Text("Show Custom Dialog")
        }
        Button(onClick = { showCustomDialogM3 = true }) {
            Text("Show Custom Dialog by material ui 3")
        }

        Button(onClick = { showConfirmationDialog = true }) {
            Text("Show My Confirmation Dialog")
        }

        MyCustomDialog(
            show = showCustomDialogM3,
            onDisMiss = { showCustomDialogM3 = false },
            onConfirm = { showCustomDialogM3 = true },
        )

        MyConfirmationDialog(
            show = showConfirmationDialog,
            onDisMiss = { showConfirmationDialog = false },
            onConfirm = { showConfirmationDialog = true },
        )

        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false }, // close Dialog When touch outside
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Accept")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDialog = false }) {
                        Text("Cancel")
                    }
                },
                title = { Text("Dialog Title") },
                text = { Text("This is an example of a dialog in Jetpack Compose.") },
                properties = DialogProperties(dismissOnClickOutside = true) // Enables the fact that it can be clicked outside
            )
        }

        if (showCustomDialog) {
            Dialog(
                onDismissRequest = { showCustomDialog = false },
                properties = DialogProperties(
                    dismissOnBackPress = false,
                    dismissOnClickOutside = false
                )
            ) {
                Column(
                    modifier = Modifier
                        .background(Color.White)
                        .padding(24.dp)
                        .fillMaxWidth()
                ) {
                    Text("Show Custom Dialog")
                    Text("Show Custom Dialog")
                    Text("Show Custom Dialog")
                }
            }
        }
    }
}

@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDisMiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = onDisMiss
        ) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(18.dp))
                    .background(Color.White)
                    .fillMaxWidth()

            ) {
                MyTitleDialog("Phone ringtone", Modifier.padding(
                    top = 18.dp,
                    start = 18.dp,
                    end = 18.dp,
                    bottom = 4.dp
                ))
                HorizontalDivider(Modifier.fillMaxWidth(), color = Color.Gray)
                var status by remember {  mutableStateOf("") }
                MyRadioButtonList(status){ status = it }
                HorizontalDivider(Modifier.fillMaxWidth(), color = Color.Gray)
                Row(
                    modifier = Modifier.align(Alignment.End).padding(10.dp)
                ){
                    TextButton(onDisMiss) { Text("Cancel") }
                    TextButton(onConfirm) { Text("Ok") }
                }
            }
        }
    }
}

@Composable
fun MyCustomDialog(
    show: Boolean,
    onDisMiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = onDisMiss
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog("Set Backup")

                AccountItem("example@example.com", R.drawable.avatar)
                AccountItem("example2@example2.com", R.drawable.avatar)
                AccountItem("Add new Account", R.drawable.add)
            }
        }
    }
}

@Composable
fun AccountItem(
    email: String,
    @DrawableRes drawable: Int
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )

        Text(text = email, fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun MyTitleDialog(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
            .padding(
                bottom = 12.dp
            )
    )
}
