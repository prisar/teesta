package com.kulik.teesta

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ShirtDetailsScreen() {
    var selectedSize by remember { mutableStateOf("M") }
    var selectedColor by remember { mutableStateOf("Brown") }

    val sizes = listOf("S", "M", "L", "XL", "XXL")
    val colors = listOf("Black", "Grey", "Brown")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Image
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(bottom = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.shirt),
                contentDescription = "Leather Jacket",
                modifier = Modifier.fillMaxSize()
            )
        }

        // Title and Price
        Text(
            text = "Sleeved Leather Jacket",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "$154.99",
            fontSize = 18.sp,
            color = Color(0xFF444444)
        )

        // Ratings
        Row(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(
                text = "⭐ 4.8 ",
                fontSize = 14.sp,
                color = Color(0xFF888888),
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "(1.2k+ Reviews)",
                fontSize = 14.sp,
                color = Color(0xFFBBBBBB)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Size Selector
        Text("Size", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            sizes.forEach { size ->
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            if (selectedSize == size) Color.Black else Color(0xFFE0E0E0),
                            RoundedCornerShape(8.dp)
                        )
                        .clickable { selectedSize = size },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = size,
                        color = if (selectedSize == size) Color.White else Color.Black
                    )
                }
            }
        }

        // Color Selector
        Text("Color", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            colors.forEach { color ->
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(
                            when (color) {
                                "Black" -> Color.Black
                                "Grey" -> Color.Gray
                                "Brown" -> Color(0xFFA52A2A)
                                else -> Color.Transparent
                            },
                            CircleShape
                        )
                        .border(
                            width = 2.dp,
                            color = if (selectedColor == color) Color.Black else Color.Transparent,
                            shape = CircleShape
                        )
                        .clickable { selectedColor = color }
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Description
        Text("Description", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        Text(
            text = "A stylish long-sleeved brown leather jacket crafted from premium material, featuring a sleek design with a smooth finish. Perfect for adding a touch of sophistication to any outfit.",
            fontSize = 14.sp,
            color = Color(0xFF666666),
            lineHeight = 20.sp,
            textAlign = TextAlign.Justify
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Buttons
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = { /* TODO: Add to Cart */ },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(contentColor = Color.White)
            ) {
                Text("Add To Cart", color = Color.Black)
            }
            Button(
                onClick = { /* TODO: Buy Now */ },
                modifier = Modifier
                    .weight(1f)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(contentColor = Color.Black)
            ) {
                Text("Buy Now", color = Color.White)
            }
        }
    }
}
