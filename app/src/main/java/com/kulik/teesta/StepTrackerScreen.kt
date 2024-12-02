package com.kulik.teesta

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun StepTrackerScreen() {
    Scaffold(
        bottomBar = { BottomNavigationBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                text = "Step Tracker",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "You have walked 7,235 steps today",
                fontSize = 16.sp,
                color = Color(0xFF6750A4)
            )
            Spacer(modifier = Modifier.height(32.dp))

            // Circular Progress Indicator (Simplified)
            Box(contentAlignment = Alignment.Center) {
                CircularProgressIndicator(
                    progress = 0.72f, // 7235/10000
                    modifier = Modifier.size(200.dp),
                    strokeWidth = 16.dp,
                    color = Color(0xFF6FCF97)
                )
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(id = R.drawable.shoe), // Replace with your shoe icon
                        contentDescription = null,
                        tint = Color(0xFF4CAF50),
                        modifier = Modifier.size(32.dp)
                    )
                    Text(text = "7,235", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Steps")
                }
            }


            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Cal Burned")
                    Text("870Cal", fontWeight = FontWeight.Bold)
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Daily Goal")
                    Text("1000Step", fontWeight = FontWeight.Bold)
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text("Statistics", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))

            // Placeholder Bar Chart
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                verticalAlignment = Alignment.Bottom
            ) {
                for (i in 0..23) {
                    val barHeight = if (i in 8..17) (20 + i * 2).dp else 20.dp
                    Spacer(
                        modifier = Modifier
                            .width(4.dp)
                            .height(barHeight)
                            .background(Color(0xFFFFA500))
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)
                )
                Text("6AM")
                Text("12PM")
                Text("6PM")
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp)

                )
            }
        }
    }
}




@Composable
fun BottomNavigationBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BottomNavItem(icon = Icons.Filled.Home, text = "Home", selected = true)
        BottomNavItem(icon = Icons.Filled.ShoppingCart, text = "Diet", selected = false)
        BottomNavItem(icon = Icons.Filled.Warning, text = "Report", selected = false)
        BottomNavItem(icon = Icons.Filled.Person, text = "Profile", selected = false)
    }
}


@Composable
fun BottomNavItem(icon: ImageVector, text: String, selected: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Icon(
            imageVector = icon,
            contentDescription = text,
            tint = if (selected) Color(0xFF6750A4) else Color.Gray

        )

        Text(
            text = text,
            fontSize = 12.sp,
            color = if (selected) Color(0xFF6750A4) else Color.Gray

        )
    }
}