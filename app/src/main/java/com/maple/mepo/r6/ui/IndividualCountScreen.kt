package com.maple.mepo.r6.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun IndividualCountScreen(nav: NavController) {
  var query by remember { mutableStateOf("") }
  var selected by remember { mutableStateOf<String?>(null) }
  var expected by remember { mutableStateOf(0) }
  var found by remember { mutableStateOf(0) }
  Surface(Modifier.fillMaxSize().padding(16.dp)) {
    Column {
      Text("Contagem Individual por SKU", style = MaterialTheme.typography.titleLarge)
      Spacer(Modifier.height(8.dp))
      OutlinedTextField(value = query, onValueChange = { query = it }, label = { Text("SKU ou descrição") }, modifier = Modifier.fillMaxWidth())
      Spacer(Modifier.height(8.dp))
      Button(onClick = { selected = "SKU001"; expected = 35; found = 0 }) { Text("Buscar") }
      Spacer(Modifier.height(12.dp))
      if (selected != null) {
        Text("Selecionado: ${selected} — No banco: ${expected}")
        Spacer(Modifier.height(8.dp))
        Button(onClick = { /* iniciar scan filtrado */ }) { Text("Buscar Individual") }
        Spacer(Modifier.height(8.dp))
        LinearProgressIndicator(progress = { if (expected == 0) 0f else (found.toFloat()/expected.toFloat()).coerceIn(0f,1f) })
        Text("Encontrados: ${found} / ${expected}")
      }
    }
  }
}