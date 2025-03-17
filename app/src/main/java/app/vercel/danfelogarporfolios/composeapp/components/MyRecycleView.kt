package app.vercel.danfelogarporfolios.composeapp.components

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.vercel.danfelogarporfolios.composeapp.R
import app.vercel.danfelogarporfolios.composeapp.model.SuperHero
import kotlinx.coroutines.launch

@Composable
fun MyRecycleView(modifier: Modifier = Modifier) {
    val myList = listOf("Dan", "Fe", "Lo", "Gar", "Dev", "Ing", "Frontend", "Mobile")
    Column(modifier = modifier) {
        LazyColumn {
            item { Text("Header") }
            items(7) {
                Text("First Item $it")
            }
            items(myList) {
                Text(it)
            }
            item { Text("Footer") }
        }


    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickyView(modifier: Modifier = Modifier) {
    val superHeroes: Map<String, List<SuperHero>> = getSuperHero().groupBy { it.publisher }
    val context = LocalContext.current
    Column(modifier = modifier) {
        LazyColumn(
            modifier = Modifier
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            superHeroes.forEach { (publisher, singleSuperHero) ->
                stickyHeader {
                    Text(
                        text = publisher,
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                    )
                }
                items(singleSuperHero) {
                    ItemHero(superHero = it) {
                        Toast.makeText(
                            context,
                            it.superHeroName,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }
    }
}

@Composable
fun SuperHeroWidthSpecialControlView(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutinesScope = rememberCoroutineScope()

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        LazyColumn(
            state = rvState,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .weight(1f)
        ) {
            items(getSuperHero()) {
                ItemHero(superHero = it) { superHero ->
                    Toast.makeText(
                        context,
                        superHero.superHeroName,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        val showButton by remember {
            // Optimizes recompositions by deriving `showButton` from `rvState.firstVisibleItemIndex`.
            // This prevents unnecessary recompositions when `rvState` changes but the result remains the same.
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }
        // Tracks the scroll offset of the first visible item in the list.
        // If the value increases (positive), the user is scrolling down.
        // If the value decreases (negative), the user is scrolling up.
//        rvState.firstVisibleItemScrollOffset

        if (showButton) {
            Button(
                onClick = {
                    coroutinesScope.launch {
                        rvState.animateScrollToItem(2)
                    }
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Text(
                    text = "I'm FAB"
                )
            }
        }
    }
}


@Composable
fun SuperHeroGridView(modifier: Modifier = Modifier) {
    val superHeroes = getSuperHero()
    val context = LocalContext.current

    Column(modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
//            columns =  GridCells.Adaptive(120.dp)
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
        ) {
            items(superHeroes) {
                ItemHero(superHero = it) {
                    Toast.makeText(
                        context,
                        it.superHeroName,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }
}

@Composable
fun SuperHeroView(modifier: Modifier = Modifier) {
    val superHeroes = getSuperHero()
    val context = LocalContext.current
    Column(modifier = modifier) {
        LazyRow(
            modifier = Modifier
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(superHeroes) {
                ItemHero(superHero = it) {
                    Toast.makeText(
                        context,
                        it.superHeroName,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        LazyColumn(
            modifier = Modifier
                .padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(superHeroes) {
                ItemHero(superHero = it) {
                    Toast.makeText(
                        context,
                        it.superHeroName,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}

@Composable
fun ItemHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Magenta),
        modifier = Modifier
            .width(200.dp)
            .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
            .clickable { onItemSelected(superHero) }

    ) {
        Column() {
            Image(
                painter = painterResource(id = superHero.photo),
                contentDescription = "hero photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = superHero.superHeroName,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                fontSize = 10.sp,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(8.dp),
            )
        }
    }
}

fun getSuperHero(): List<SuperHero> {
    return listOf(
        SuperHero("Spiderman", "Petter Parker", "Marvel", R.drawable.spiderman),
        SuperHero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        SuperHero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        SuperHero("Thor", "Thor Odin son", "Marvel", R.drawable.thor),
        SuperHero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        SuperHero("Green Lantern", "Alen Scott", "DC", R.drawable.green_lantern),
        SuperHero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman),
    )
}