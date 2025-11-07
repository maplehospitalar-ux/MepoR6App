package com.maple.mepo.r6.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun GeneralCountScreen(nav: NavController) {
  var scanning by remember { mutableStateOf(false) }
  val expected = listOf("SKU001" to 35, "SKU002" to 12) // TODO: Supabase
  val missing = mapOf("SKU001" to 5) // TODO: compute after scan
  Surface(Modifier.fillMaxSize().padding(16.dp)) {
    Column {
      Text("Contagem Geral", style = MaterialTheme.typography.titleLarge)
      Spacer(Modifier.height(8.dp))
      Row {
        Button(onClick = { scanning = true }, enabled = !scanning) { Text(if (scanning) "Lendo..." else "Iniciar Leitura Geral") }
        Spacer(Modifier.width(8.dp))
        Button(onClick = { /* Buscar Tags Perdidas */ }, enabled = missing.isNotEmpty()) { Text("Buscar Tags Perdidas") }
      }
      Spacer(Modifier.height(16.dp))
      LazyColumn {
        items(expected) { s ->
          val diff = missing[s.first] ?: 0
          ListItem(headlineContent = { Text("${s.first} – esperado: ${s.second}") }, supportingContent = { Text("faltando: $diff") })
          Divider()
        }
      }
    }
  }
}