package com.sample.demo.compose.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.design2.ui.theme.Design
import com.example.design2.ui.theme.DesignTheme
import com.example.design2.ui.theme.customColorsPalette
import com.google.android.material.color.MaterialColors
import com.sample.demo.R
import com.sample.demo.data.local.ColorData
import com.sample.demo.utility.getColorList
import com.sample.demo.utility.toggleThemeMode
import com.sample.demo.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ComposeActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val theme = viewModel.getCurrentTheme().collectAsState().value
            if (theme) {
//                setTheme(com.example.design2.R.style.DesignTheme_Project)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                delegate.applyDayNight()
            } else {
//                setTheme(com.example.design2.R.style.DesignTheme_Project)
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                delegate.applyDayNight()
            }
            DesignTheme(darkTheme = theme) {
                val modifier = Modifier.fillMaxSize()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = modifier
                ) {
                    Canvas(viewModel)
                }
            }
        }
    }
}

@Composable
fun Canvas(viewModel: MainViewModel) {
    Box(
        modifier = Modifier
            .background(getCustomColor(LocalContext.current, Design.current.Kesar))
            .fillMaxSize()
    ) {
        Column {
            composeNotes()
            TextSection("Saran", "Welcome !")
            BackgroundImageSection(viewModel)
            ScaffoldSection()
            CardSection()
            AnimationInCompose()
            ComposeMaterials()
            val productList = viewModel.listData.collectAsState().value
            GridLayoutSection(
                modifier = Modifier
                    .fillMaxWidth(),
                items = getColorList()
            )
            viewModel.getDataList()
        }
        ChipsSection(
            listOf("Item 1", "Item 2", "Item 3", "Item 4", "A very long item"),
            modifier = Modifier      // can set modifier to the root element of the user defined layout
                .align(Alignment.BottomStart)
                .padding(8.dp)
        )
    }
}

fun getCustomColor(current: Context, colorInt: Int) =
    Color(MaterialColors.getColor(current, colorInt, com.example.design2.R.color.white))

@Composable
fun ComposeMaterials() {

}

@Composable
fun AnimationInCompose() {
    // https://developer.android.com/codelabs/jetpack-compose-basics?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fjetpack-compose-for-android-developers-1%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fjetpack-compose-basics#10
    val extraPadding by animateDpAsState(
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ), label = "", targetValue = if (true) 4.dp else 6.dp
    )
}

fun composeNotes() {
    /*
    * state manages the ui
    * when the event is triggered and the state changes update in the ui causing recomposition
    * all the data needed by the composable functions are provided as arguments for recomposition
    * composable are like adapters all the parameter required should be provided as arguments for state changes
    * by value() declaration prevents from adding .value =  everytime for re assigning
    * remember can be used for values not needed to handle on configuration changes
    * rememberSavable can be used for values that needs to be handled on configuration changes as well
    *
    */
}

@Composable
fun CardSection() {

}

@Composable
fun ScaffoldSection() {
    // a composable which has top bar, bottom bar, floating action button
}

@Composable
fun BackgroundImageSection(viewModel: MainViewModel) {
    Box (contentAlignment = Alignment.Center, modifier = Modifier
        .fillMaxWidth()
        .clickable {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            viewModel.updateTheme()
        }){
        Box(modifier = Modifier.paint(painterResource(id = R.drawable.ic_launcher_background))) {   // background image
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),      // foreground image
                contentDescription = "foreground image"
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridLayoutSection(items: List<ColorData>, modifier: Modifier) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(100.dp),      // fixed and adaptive
        modifier = modifier,
        contentPadding = PaddingValues(bottom = 100.dp)     // similar to clip to padding only applies to the content within
    ) {
        items(items) { item ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(getCustomColor(LocalContext.current, item.color))
                    .padding(8.dp)
                    .clickable {
                        toggleThemeMode()
                    }
            ) {
                Text(
                    text = item.name,
                    color = Color.White,
                    modifier = Modifier.align(Alignment.TopStart)       // alignment with relation to the parent layout topStart topEnd BottomStart BottomEnd
                )
            }
        }
    }
}

@Composable
fun ChipsSection(chips: List<String>, modifier: Modifier) {
    var selectedChip by rememberSaveable {
        mutableStateOf(0)
    }
    LazyRow(modifier.background(getCustomColor(LocalContext.current, Design.current.Theme_Grey)), contentPadding = PaddingValues(end = 5.dp)) {
        items(chips.size) {
            Box(contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 5.dp, top = 5.dp, bottom = 5.dp)
                    .clickable {                // set click action with modifier
                        selectedChip = it
                    }
                    .clip(RoundedCornerShape(10.dp))        // To give shape to the layout and best to be applied to box
                    .background(
                        if (it == selectedChip) getCustomColor(
                            LocalContext.current,
                            Design.current.Kesar
                        ) else getCustomColor(LocalContext.current, Design.current.Ocean)
                    )
                    .padding(20.dp)
                    //.width(500.dp)            sets the width if available else fills the available space
                    //.requiredWidth(500.dp)    absolute width required
            ) {
                Text(text = chips[it], color = Color.White)
            }
        }
    }
}


@Composable
fun TextSection(name: String, title: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,       // alignment of row and column
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier         // modifier to modify the layout further
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = "Hi $name",
            style = MaterialTheme.typography.bodyMedium
        )  //Apply default material style provided
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = title, style = TextStyle(       // Apply text style manually
                    color = getCustomColor(LocalContext.current,MaterialTheme.customColorsPalette.Ocean),
                    textAlign = TextAlign.Center
                )
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_heart_red),
                contentDescription = "Red heart",
                tint = Color.Red
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun CanvasPreview() {
//    DesignTheme {
//        Canvas(MainViewModel())
//    }
//}