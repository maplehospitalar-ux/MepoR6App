package com.maple.mepo.r6.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun RadarScreen(nav: NavController) {
  var target by remember { mutableStateOf("") }
  var intensity by remember { mutableStateOf(0) }
  Surface(Modifier.fillMaxSize().padding(16.dp)) {
    Column {
      Text("Radar de Aproximação", style = MaterialTheme.typography.titleLarge)
      Spacer(Modifier.height(8.dp))
      OutlinedTextField(value = target, onValueChange = { target = it }, label = { Text("EPC ou SKU") }, modifier = Modifier.fillMaxWidth())
      Spacer(Modifier.height(8.dp))
      Button(onClick = { intensity = (intensity + 10).coerceAtMost(100) }) { Text("Iniciar Radar") }
      Spacer(Modifier.height(16.dp))
      LinearProgressIndicator(progress = { (intensity/100f).coerceIn(0f,1f) })
      Text("Intensidade: ${intensity}/100")
    }
  }
}