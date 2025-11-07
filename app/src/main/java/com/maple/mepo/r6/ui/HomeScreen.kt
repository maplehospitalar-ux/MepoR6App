package com.maple.mepo.r6.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(nav: NavController) {
  Surface(Modifier.fillMaxSize()) {
    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
      Text("MEPO Expedição – R6", style = MaterialTheme.typography.headlineSmall)
      Spacer(Modifier.height(12.dp))
      Button(onClick = { nav.navigate("general") }, modifier = Modifier.fillMaxWidth()) { Text("Contar Estoque (Geral)") }
      Spacer(Modifier.height(8.dp))
      Button(onClick = { nav.navigate("individual") }, modifier = Modifier.fillMaxWidth()) { Text("Contagem Individual por SKU") }
      Spacer(Modifier.height(8.dp))
      Button(onClick = { nav.navigate("radar") }, modifier = Modifier.fillMaxWidth()) { Text("Radar de Aproximação") }
      Spacer(Modifier.height(8.dp))
      Button(onClick = { nav.navigate("inventory") }, modifier = Modifier.fillMaxWidth()) { Text("Inventário Completo (TXT)") }
    }
  }
}