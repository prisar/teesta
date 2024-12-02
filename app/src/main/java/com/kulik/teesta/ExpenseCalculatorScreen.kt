package com.kulik.teesta

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ExpenseCalculatorScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE9F0FF)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Top Bar
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp,
        ) {
            Text(
                text = "$32,500.00",
                style = MaterialTheme.typography.h6,
                modifier = Modifier.weight(1f),
                color = Color.Black
            )
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Edit",
                tint = Color.Black
            )
        }

        // Dropdowns and Amount
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                DropdownSelector("Cash", Color(0xFFCCE5FF))
                DropdownSelector("Shopping", Color(0xFFDFFFD6))
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "$25.00",
                style = MaterialTheme.typography.h3,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text("Add comment...") },
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
                    .padding(horizontal = 16.dp),
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }

        // Calculator Buttons
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val buttonColors = listOf(
                Color.White, Color.White, Color.White, Color(0xFFFFE6E6),
                Color.White, Color.White, Color.White, Color(0xFFE6F3FF),
                Color.White, Color.White, Color.White, Color(0xFF000000)
            )
            val numbers = listOf(
                "1", "2", "3", "4",
                "5", "6", "7", "8",
                "9", "0", "", "✔"
            )

            for (row in 0 until 3) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    for (col in 0..3) {
                        val index = row * 4 + col
                        if (index < numbers.size) {
                            CalculatorButton(
                                label = numbers[index],
                                backgroundColor = buttonColors[index]
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DropdownSelector(label: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(text = label, color = Color.Black)
    }
}

@Composable
fun CalculatorButton(label: String, backgroundColor: Color) {
    Box(
        modifier = Modifier
            .size(64.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .clickable { /* Handle click */ },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.h5,
            color = if (backgroundColor == Color.Black) Color.White else Color.Black
        )
    }
}
