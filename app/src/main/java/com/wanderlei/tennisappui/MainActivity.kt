package com.wanderlei.tennisappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wanderlei.tennisappui.ui.theme.TennisAppUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    val clubs = listOf(
        Club(
            "Women's Club",
            colorResource(id = R.color.women),
            painterResource(id = R.drawable.tennis_player)
        ),
        Club(
            "Men's \nClub",
            colorResource(id = R.color.men),
            painterResource(id = R.drawable.men_tennis_player)
        )
    )

    TennisAppUITheme {
        Scaffold(
            modifier = Modifier.background(Color.White),
            topBar = {
                TopAppBar(
                    modifier = Modifier
                        .background(Color.Transparent)
                        .padding(24.dp, 16.dp),
                    title = {},
                    actions = {
                        IconButton(
                            onClick = { /*TODO*/ }, modifier =
                            Modifier
                                .clip(shape = RoundedCornerShape(25))
                                .background(Color.Black)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Menu Icon",
                                tint = Color.White
                            )
                        }

                        Spacer(Modifier.weight(1f))

                        IconButton(
                            onClick = { /*TODO*/ }, modifier =
                            Modifier
                                .clip(shape = RoundedCornerShape(25))
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Search,
                                contentDescription = "Search Icon",
                                tint = Color.Black,
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState(), true)
                    .padding(innerPadding)
                    .padding(start = 24.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.clubs), //"Clubs",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.displaySmall.fontSize,
                    modifier = Modifier.padding(bottom = 20.dp)
                )

                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(clubs) {
                        ClubItem(it)
                    }
                }

                Spacer(modifier = Modifier.size(30.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 16.dp, bottom = 18.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Train",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )

                    Text(
                        text = "alles",
                        color = colorResource(id = R.color.green),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 20.dp)
                    )
                }

                Column {
                    for (i in 1..3) {
                        TrainItem()
                    }
                }
            }
        }
    }
}

@Composable
fun TrainItem() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .background(colorResource(id = R.color.green_ball))
                .padding(5.dp),
            contentAlignment = Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.tennis_balls),
                contentDescription = "Tennis Ball"
            )
        }

        Spacer(modifier = Modifier.size(8.dp))

        Column {
            Text(
                text = "Yoga and Tennis",
                color = Color.Black,
                fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = "Sep 27 | 18:00am",
                color = Color.LightGray,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 5.dp)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(color = Color.Black),
            contentAlignment = Center
        ) {
            Text(
                text = "$25", color = Color.White, fontSize = 21.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(7.dp)
            )
        }
    }
}

@Composable
fun ClubItem(
    club: Club
) {
    Box(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(30.dp))
            .background(club.color),
        contentAlignment = Center
    ) {
        Row(
            modifier = Modifier.padding(start = 20.dp, top = 25.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            Column(modifier = Modifier.width(150.dp)) {
                Text(
                    modifier = Modifier.padding(bottom = 10.dp),
                    text = club.title,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                )

                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color.White
                    ),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(text = stringResource(id = R.string.all_levels), color = Color.Black)
                }

                Spacer(modifier = Modifier.height(180.dp))

                Text(
                    text = stringResource(id = R.string.events),
                    color = Color.Black, fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                    modifier = Modifier.padding(bottom = 50.dp)
                )
            }

            Image(
                painter = club.image,
                contentDescription = "image of the tennis player",
                contentScale = ContentScale.FillBounds,
            )
        }
    }
}

data class Club(
    var title: String,
    var color: Color,
    var image: Painter
)