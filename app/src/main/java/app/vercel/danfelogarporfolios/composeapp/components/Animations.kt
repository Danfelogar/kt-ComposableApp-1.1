package app.vercel.danfelogarporfolios.composeapp.components

import android.graphics.drawable.Icon
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SensorDoor
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random.Default.nextInt

enum class ComponentType() {
    Image, Text, Box, Error
}

@Composable
fun CrossfadeAnimations() {
    var myComponentType: ComponentType by rememberSaveable {
        mutableStateOf(ComponentType.Text)
    }

    Column(Modifier.fillMaxSize()) {
        Button(onClick = { myComponentType = getComponentRandom() }) {
            Text(text = "Change component")
        }

        Crossfade(
            targetState = myComponentType,
            animationSpec = tween(durationMillis = 500)
        ) {
            when (it) {
                ComponentType.Image -> Icon(Icons.Default.SensorDoor, contentDescription = "")
                ComponentType.Text -> Text("I'm a text")
                ComponentType.Box -> Box(
                    Modifier
                        .size(150.dp)
                        .background(Color.Cyan)
                )

                ComponentType.Error -> Text("I'm a error", color = Color.Red)
            }
        }
    }
}

fun getComponentRandom(): ComponentType {
    val myNumberRandom = nextInt(from = 0, until = 3)

    return when (myNumberRandom) {
        0 -> ComponentType.Text
        1 -> ComponentType.Image
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }
}

@Composable
fun VisibilityAnimation() {

    var isVisible by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Button(
            onClick = { isVisible = !isVisible }
        ) {
            Text(text = "SHow/ Hidden Box")
        }
        AnimatedVisibility(
            isVisible,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(Color.Red)
            )
        }
    }
}

@Composable
fun SizeAnimation() {
    var smallSize by rememberSaveable { mutableStateOf(true) }
    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(durationMillis = 500),
        finishedListener = {
            //show any text if in the case that this component are a dropdown card or anything
        }
    )

    Box(
        modifier = Modifier
            .size(size)
            .background(Color.Cyan)
            .clickable { smallSize = !smallSize }
    )
}

@Composable
fun ColorAnimationHard() {
    var firstColor by rememberSaveable {
        mutableStateOf(false)
    }
    var showBox: Boolean by rememberSaveable {
        mutableStateOf(true)
    }
    val realColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Yellow,
        animationSpec = tween(durationMillis = 1000),
        finishedListener = { showBox = false }
    )


    if (showBox) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor)
                .clickable { firstColor = !firstColor }
        )
    }

}


@Composable
fun ColorAnimationSimple() {
    var firstColor by rememberSaveable {
        mutableStateOf(false)
    }

    var secondColor by rememberSaveable {
        mutableStateOf(false)
    }

    var realColor = if (firstColor) Color.Red else Color.Yellow
    val realColor2 by animateColorAsState(
        targetValue = if (secondColor) Color.Red else Color.Yellow
    )

    Column() {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor)
                .clickable { firstColor = !firstColor }
        )
        Spacer(modifier = Modifier.size(200.dp))

        Box(
            modifier = Modifier
                .size(100.dp)
                .background(realColor2)
                .clickable { secondColor = !secondColor }
        )
    }
}