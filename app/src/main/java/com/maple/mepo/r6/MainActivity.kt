package com.maple.mepo.r6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.maple.mepo.r6.ui.*

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MaterialTheme {
        val nav = rememberNavController()
        NavHost(navController = nav, startDestination = "home") {
          composable("home") { HomeScreen(nav) }
          composable("general") { GeneralCountScreen(nav) }
          composable("individual") { IndividualCountScreen(nav) }
          composable("radar") { RadarScreen(nav) }
          composable("inventory") { InventoryScreen(nav) }
        }
      }
    }
  }
}