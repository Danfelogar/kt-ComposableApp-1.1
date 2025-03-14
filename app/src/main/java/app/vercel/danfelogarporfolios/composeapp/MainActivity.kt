package app.vercel.danfelogarporfolios.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import app.vercel.danfelogarporfolios.composeapp.components.MyButton
import app.vercel.danfelogarporfolios.composeapp.components.MyCard
import app.vercel.danfelogarporfolios.composeapp.components.MyProgressAdvance
import app.vercel.danfelogarporfolios.composeapp.components.MyProgressBar
import app.vercel.danfelogarporfolios.composeapp.components.MySliders
import app.vercel.danfelogarporfolios.composeapp.components.MySwitch
import app.vercel.danfelogarporfolios.composeapp.components.MyText
import app.vercel.danfelogarporfolios.composeapp.components.MyTextField
import app.vercel.danfelogarporfolios.composeapp.components.MyTextFieldPatent
import app.vercel.danfelogarporfolios.composeapp.components.layout.ConstrainExampleGuide
import app.vercel.danfelogarporfolios.composeapp.components.layout.ConstraintBarrier
import app.vercel.danfelogarporfolios.composeapp.components.layout.ConstraintChain
import app.vercel.danfelogarporfolios.composeapp.components.layout.MyColumn
import app.vercel.danfelogarporfolios.composeapp.components.layout.MyComplexLayout
import app.vercel.danfelogarporfolios.composeapp.components.layout.MyCustomConstraintLayout
import app.vercel.danfelogarporfolios.composeapp.components.layout.MyRow
import app.vercel.danfelogarporfolios.composeapp.components.state.MyState
import app.vercel.danfelogarporfolios.composeapp.login.Greeting
import app.vercel.danfelogarporfolios.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android :3",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    MySliders(
                        Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeAppTheme {
        Greeting("Android :3")
    }
}