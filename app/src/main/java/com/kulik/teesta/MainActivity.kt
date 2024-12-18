package com.kulik.teesta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kulik.teesta.ui.theme.TeestaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TeestaTheme {
                // Setup navigation
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable("home") { Home(navController) }
                    composable("boarding_pass") { BoardingPassScreen() }
                    composable("expense_calculator") { ExpenseCalculatorScreen() }
                    composable("travel") { TravelScreen() }
                    composable("step_tracker") { StepTrackerScreen() }
                    composable("sushi_details") { RestaurantScreen() }
                    composable("shirt_details") { ShirtDetailsScreen() }
                }
            }
        }
    }
}

@Composable
fun Home(navController: NavHostController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Teesta app for north Bengal",
            style = MaterialTheme.typography.h5,
            modifier = Modifier.padding(top = 16.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.dalimgaon),
            contentDescription = "Train",
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        )

        Text(
            text = "Wiki for outsiders",
            style = MaterialTheme.typography.body1
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("boarding_pass") },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text("Open Boarding Pass")
        }

        Button(
            onClick = { navController.navigate("expense_calculator") },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text("Expense calculator")
        }

        Button(
            onClick = { navController.navigate("travel") },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text("Travel")
        }

        Button(
            onClick = { navController.navigate("step_tracker") },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text("Step Tracker")
        }

        Button(
            onClick = { navController.navigate("sushi_details") },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text("Sushi Details")
        }

        Button(
            onClick = { navController.navigate("shirt_details") },
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text("Shirt Details")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TeestaTheme {
        val navController = rememberNavController()
        Home(navController)
    }
}
