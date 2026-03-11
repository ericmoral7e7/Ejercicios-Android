package com.example.myapplication.ui.theme.ambState

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
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

@Composable
fun CalculIMC(modifier: Modifier = Modifier) {

    var nomUsuari by remember { mutableStateOf("") }
    var anyNaixament by remember { mutableStateOf("") }
    var alcada by remember { mutableStateOf("") }
    var pes by remember { mutableStateOf("") }

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //Nom usuari
        TextField(
            value = "",
            onValueChange = { nomUsuari = it },
            label = { Text(text = "Nom usuari: ") }
        )

        //Any naixament
        TextField(
            value = "",
            onValueChange = { anyNaixament = it },
            label = { Text(text = "Percentatge de propina") },

            )

        //Alçada
        TextField(
            value = "",
            onValueChange = { alcada = it },
            label = { Text(text = "Percentatge de propina") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )

        //Pes
        TextField(
            value = "",
            onValueChange = { pes = it },
            label = { Text(text = "Percentatge de propina") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
    }
}