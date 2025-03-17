package app.vercel.danfelogarporfolios.composeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import app.vercel.danfelogarporfolios.composeapp.model.Routes
import app.vercel.danfelogarporfolios.composeapp.model.Routes.*


@Composable
fun Screen1(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Cyan)
    ){
        Text(
            text = "Screen 1",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navController.navigate(Screen2.route)
                }
        )
    }
}

@Composable
fun Screen2(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ){
        Text(
            text = "Screen 2",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navController.navigate(Screen3.route)
                }
        )
    }
}

@Composable
fun Screen3(navController: NavController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ){
        Text(
            text = "Screen 3",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navController.navigate(
//                        "${Routes.Screen4.route}/DanfelogarDev"
//                        "${Routes.Screen4.route}/2"
                        Routes.Screen4.createRoute(26)
                    )
                }
        )
    }
}

@Composable
fun Screen4(navController: NavController, name: Int){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Magenta)
    ){
        Text(
            text = "Screen 4 with: $name",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navController.navigate(Screen5.route)
                }
        )
    }
}

@Composable
fun Screen5(navController: NavController, name: String?){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ){
        Text(
            text = "Screen 5 my name is: $name",
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .clickable {
                    navController.navigate(Screen1.route)
                }
        )
    }
}

