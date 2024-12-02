package com.kulik.teesta

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.draw.clip


@Composable
fun TravelScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Header with profile and location
        HeaderSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Search and filter buttons
        SearchAndFilterSection()

        Spacer(modifier = Modifier.height(16.dp))

        // Popular locations
        PopularLocationsSection()
    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Profile Picture
        Image(
            painter = painterResource(id = R.drawable.dalimgaon),
            contentDescription = "Profile",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .border(1.dp, Color.Gray, CircleShape)
        )

        Spacer(modifier = Modifier.width(12.dp))

        // User Name and Account Type
        Column {
            Text(text = "Annie January", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(text = "Basic account", color = Color.Gray, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.weight(1f))

        // Location
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(Icons.Default.LocationOn, contentDescription = null, tint = Color.Gray)
            Text(text = "Jombang, IDN", fontSize = 16.sp)
        }
    }
}

@Composable
fun SearchAndFilterSection() {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        // Search Bar
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search destination...") },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Filter Options
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            FilterButton(label = "Mountain")
            FilterButton(label = "Beach")
            FilterButton(label = "Urban")
        }
    }
}

@Composable
fun FilterButton(label: String) {
    Button(
        onClick = { /* Filter action */ },
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFf5f5f5)),
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .padding(horizontal = 8.dp)
    ) {
        Text(text = label, color = Color.Black)
    }
}

@Composable
fun PopularLocationsSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Popular near you 🔥", fontWeight = FontWeight.Bold, fontSize = 18.sp)
            Text(
                text = "See more",
                color = Color.Blue,
                modifier = Modifier.clickable { /* See more action */ }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Locations List
        LazyColumn {
            items(sampleLocations) { location ->
                LocationCard(location)
            }
        }
    }
}

@Composable
fun LocationCard(location: Location) {
    Card(
        shape = RoundedCornerShape(12.dp),
        elevation = 4.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Column {
            // Image
            Image(
                painter = painterResource(id = location.imageRes), // Replace with actual resource
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Info
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = location.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(text = "${location.city}, ${location.region}", color = Color.Gray, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "${location.price}/Trip", color = Color.Black, fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

data class Location(
    val name: String,
    val city: String,
    val region: String,
    val price: String,
    val imageRes: Int
)

val sampleLocations = listOf(
    Location("Bromo Tengger Semeru", "Probolinggo", "East Java", "$12k", R.drawable.bromo),
    Location("Gunung Andong Magelang", "Magelang", "East Java", "$9k", R.drawable.andong) // avif
)
