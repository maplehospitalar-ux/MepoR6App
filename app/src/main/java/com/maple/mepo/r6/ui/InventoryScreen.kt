package com.maple.mepo.r6.ui

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun InventoryScreen(nav: NavController) {
  val ctx = LocalContext.current
  var running by remember { mutableStateOf(false) }
  var saved by remember { mutableStateOf<String?>(null) }
  Surface(Modifier.fillMaxSize().padding(16.dp)) {
    Column {
      Text("Inventário Completo", style = MaterialTheme.typography.titleLarge)
      Spacer(Modifier.height(8.dp))
      Button(enabled = !running, onClick = {
        running = true
        val list = listOf("E20034120123456789012345","E20034120987564213123123")
        val name = "inventario_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss")) + ".txt"
        val file = writeTxt(ctx, name, list)
        saved = file.absolutePath
        running = false
      }) { Text(if (running) "Lendo..." else "Realizar Inventário") }
      Spacer(Modifier.height(8.dp))
      if (saved != null) Text("TXT salvo em: ${saved}")
    }
  }
}
private fun writeTxt(ctx: Context, name: String, lines: List<String>): File {
  val dir = ctx.getExternalFilesDir(null) ?: ctx.filesDir
  val f = File(dir, name); f.writeText(lines.joinToString("\n")); return f
}