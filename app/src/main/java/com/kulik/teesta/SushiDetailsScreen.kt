package com.kulik.teesta

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun RestaurantScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        TopAppBarSection()
        RestaurantInfoSection()
        SearchSection()
        TabsSection()
        MenuItemList()
    }
}

@Composable
fun TopAppBarSection() {
    Box(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = R.drawable.sushi_image),
            contentDescription = "Restaurant Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.TopStart),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {}) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
            }
            Row {
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.FavoriteBorder,
                        contentDescription = "Favorite",
                        tint = Color.White
                    )
                }
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Filled.Refresh,
                        contentDescription = "refresh",
                        tint = Color.White
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomEnd),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(painterResource(id = R.drawable.ic_thumb_up), contentDescription = "Like", tint = Color.White)
            Text(text = "97%", color = Color.White, modifier = Modifier.padding(start = 4.dp))
        }

    }
}
@Composable
fun RestaurantInfoSection() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Kotosushi", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = "Opened", color = Color.Gray)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Delivery Costs:", color = Color.Gray)
            Text(text = "402", color = Color.Black, modifier = Modifier.padding(start = 4.dp))
            Text(
                text = "Reviews",
                color = Color.Blue,
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f),
                textAlign = TextAlign.End
            )
        }
        Row(
            modifier = Modifier.padding(top = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Icon(painterResource(id = R.drawable.thumb_down), contentDescription = "Dislike", tint = Color.Gray)
            Icon(
                painterResource(id = R.drawable.ic_thumb_up),
                contentDescription = "Like",
                tint = Color(0xFF9337F6),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Composable
fun SearchSection() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
        placeholder = { Text("Looking for something?") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(24.dp)
    )
}
@Composable
fun TabsSection() {
    val tabs = listOf("Recomended", "Highest rating", "Prom")
    LazyRow(
        modifier = Modifier.padding(top = 16.dp, start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(tabs) { tab ->
            TabItem(title = tab)
        }
    }
}


@Composable
fun TabItem(title: String) {
    Button(onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF8F6F9)),
        shape = RoundedCornerShape(24.dp),
    ) {
        Text(text = title, color = Color.Black)
    }

}
@Composable
fun MenuItemList() {
    Column {
        MenuItem(
            name = "Black Dragon",
            composition = "Shrimp, and roasted salmon, with Philadelphia cream cheese and daikon, in spicy and unagi sauce, with sesame and chili threads",
            price = "4212",
            weight = "300g",
            image = R.drawable.sushi_image
        )
        MenuItem(
            name = "Philadelphia",
            composition = "Classic",
            price = "4000",
            weight = "250g",
            image = R.drawable.sushi_image
        )

    }

}
@Composable
fun MenuItem(name: String, composition: String, price: String, weight: String, image: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF8F6F9))
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = name,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Icon(painterResource(id = R.drawable.check), contentDescription = "Check", tint = Color(0xFF9337F6), modifier = Modifier.align(Alignment.BottomStart).padding(8.dp))

        }


        Column(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f)
        ) {
            Text(text = name, fontSize = 16.sp, fontWeight = FontWeight.Medium)
            Text(text = "Composition", color = Color.Gray, fontSize = 12.sp)
            Text(text = composition, color = Color.Gray, fontSize = 12.sp)
            Row(modifier = Modifier.padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = price, fontWeight = FontWeight.Bold)
                Text(text = weight, color = Color.Gray, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SushiDetailScreenPreview() {
    RestaurantScreen()
}