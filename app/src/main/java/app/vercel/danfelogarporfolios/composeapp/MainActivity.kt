package app.vercel.danfelogarporfolios.composeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import app.vercel.danfelogarporfolios.composeapp.components.ColorAnimationHard
import app.vercel.danfelogarporfolios.composeapp.components.ColorAnimationSimple
import app.vercel.danfelogarporfolios.composeapp.components.CrossfadeAnimations
import app.vercel.danfelogarporfolios.composeapp.components.MyButton
import app.vercel.danfelogarporfolios.composeapp.components.MyCard
import app.vercel.danfelogarporfolios.composeapp.components.MyDialogs
import app.vercel.danfelogarporfolios.composeapp.components.MyProgressAdvance
import app.vercel.danfelogarporfolios.composeapp.components.MyProgressBar
import app.vercel.danfelogarporfolios.composeapp.components.MyRecycleView
import app.vercel.danfelogarporfolios.composeapp.components.MyScaffold
import app.vercel.danfelogarporfolios.composeapp.components.MySliders
import app.vercel.danfelogarporfolios.composeapp.components.MySwitch
import app.vercel.danfelogarporfolios.composeapp.components.MyText
import app.vercel.danfelogarporfolios.composeapp.components.MyTextField
import app.vercel.danfelogarporfolios.composeapp.components.MyTextFieldPatent
import app.vercel.danfelogarporfolios.composeapp.components.Screen1
import app.vercel.danfelogarporfolios.composeapp.components.Screen2
import app.vercel.danfelogarporfolios.composeapp.components.Screen3
import app.vercel.danfelogarporfolios.composeapp.components.Screen4
import app.vercel.danfelogarporfolios.composeapp.components.Screen5
import app.vercel.danfelogarporfolios.composeapp.components.SizeAnimation
import app.vercel.danfelogarporfolios.composeapp.components.SuperHeroGridView
import app.vercel.danfelogarporfolios.composeapp.components.SuperHeroStickyView
import app.vercel.danfelogarporfolios.composeapp.components.SuperHeroView
import app.vercel.danfelogarporfolios.composeapp.components.SuperHeroWidthSpecialControlView
import app.vercel.danfelogarporfolios.composeapp.components.VisibilityAnimation
import app.vercel.danfelogarporfolios.composeapp.components.layout.ConstrainExampleGuide
import app.vercel.danfelogarporfolios.composeapp.components.layout.ConstraintBarrier
import app.vercel.danfelogarporfolios.composeapp.components.layout.ConstraintChain
import app.vercel.danfelogarporfolios.composeapp.components.layout.MyColumn
import app.vercel.danfelogarporfolios.composeapp.components.layout.MyComplexLayout
import app.vercel.danfelogarporfolios.composeapp.components.layout.MyCustomConstraintLayout
import app.vercel.danfelogarporfolios.composeapp.components.layout.MyRow
import app.vercel.danfelogarporfolios.composeapp.components.state.MyState
import app.vercel.danfelogarporfolios.composeapp.login.Greeting
import app.vercel.danfelogarporfolios.composeapp.model.Routes
import app.vercel.danfelogarporfolios.composeapp.ui.theme.ComposeAppTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeAppTheme {

                CrossfadeAnimations()

//                val navigationController = rememberNavController()
//                NavHost(
//                    navController = navigationController,
//                    startDestination = Routes.Screen1.route
//                ) {
//                    composable(Routes.Screen1.route) { Screen1(navigationController) }
//                    composable(Routes.Screen2.route) { Screen2(navigationController) }
//                    composable(Routes.Screen3.route) { Screen3(navigationController) }
//                    composable(
//                        Routes.Screen4.route,
//                        arguments = listOf(navArgument("age") { type = NavType.IntType })
////                      arguments = navArgument("name")
//
//                    ) { backStackEntry ->
//                        Screen4(
//                            navigationController,
//                            backStackEntry.arguments?.getInt("age") ?: 0
////                            backStackEntry.arguments?.getString("name").orEmpty()
//                        )
//                    }
//                    composable(
//                        Routes.Screen5.route,
//                        arguments = listOf(navArgument("name") { defaultValue = "Danfe" })
//                    ) { backStackEntry ->
//                        Screen5(
//                            navigationController,
//                            backStackEntry.arguments?.getString("name")
//                        )
//                    }
//
//                }
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    SuperHeroStickyView(
//                        Modifier.padding(innerPadding)
//                    )
//                }
//                MyScaffold()
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