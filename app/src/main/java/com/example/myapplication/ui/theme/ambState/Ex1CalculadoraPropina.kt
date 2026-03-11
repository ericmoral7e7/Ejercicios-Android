package com.example.myapplication.ui.theme.ambState

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculadoraPropina(modifier: Modifier = Modifier) {
    var preuMenu by remember { mutableStateOf("") }
    var propina by remember { mutableStateOf("") }
    var preuTotal by remember { mutableStateOf(0.0) }
    var showResult by remember { mutableStateOf(false) }
    var enableButton by remember { mutableStateOf(false) }

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = preuMenu,
            onValueChange = {
                preuMenu = it
                enableButton = habilitarBoton(preuMenu, propina)
            },
            label = { Text(text = "Preu menú") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        TextField(
            value = propina,
            onValueChange = {
                propina = it
                enableButton = habilitarBoton(preuMenu, propina)
            },
            label = { Text(text = "Percentatge de propina") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

        Spacer(Modifier.height(50.dp))

        Button(
            onClick = {
                preuTotal = preuMenu.toDouble() * (propina.toDouble() / 100)
                showResult = true
            }, enabled = enableButton
        ) {
            Text(text = "Calcular preu total")
        }

        Spacer(Modifier.height(50.dp))

        if (showResult) {
            Text("Preu total: $preuTotal", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)
        }
    }
}

fun habilitarBoton(preuMenu: String, propina: String): Boolean {
    var resultat: Boolean = false
    if (preuMenu.isNotEmpty() && propina.isNotEmpty()) {
        resultat = true
    } else {
        resultat = false
    }

    return resultat
}