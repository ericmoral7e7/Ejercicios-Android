package com.example.myapplication.ui.theme.ambState

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Calculadora(modifier: Modifier = Modifier) {

    //Inputs
    var numeroA by remember { mutableStateOf("") }
    var numeroB by remember { mutableStateOf("") }
    var operacion by remember { mutableStateOf("+") } // operación seleccionada

    var menuExpanded by remember { mutableStateOf(false) } // controla si el menú está abierto
    val operaciones = listOf("+", "-", "x", "/")
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = numeroA,
            onValueChange = { numeroA = it },
            label = { Text(text = "Insereix un número ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        DropdownMenu(
            expanded = menuExpanded,
            onDismissRequest = { menuExpanded = false }
        ) {
            operaciones.forEach { op ->
                androidx.compose.material3.DropdownMenuItem(
                    text = { Text(op) },
                    onClick = {
                        operacion = op
                        menuExpanded = false
                    }
                )
            }
        }

        TextField(
            value = numeroA,
            onValueChange = { numeroA = it },
            label = { Text(text = "Insereix un número ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(onClick = {

        }) {
            Text("Calcula")
        }

        Spacer(Modifier.height(25.dp))
        Text("")
    }
}