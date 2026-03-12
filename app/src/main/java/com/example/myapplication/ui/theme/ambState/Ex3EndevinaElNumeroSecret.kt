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
import kotlin.random.Random
import kotlin.random.nextInt

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NumeroSecret(modifier: Modifier = Modifier) {

    //Inputs
    var numeroIntroduit by remember { mutableStateOf("") }
    var missatge by remember { mutableStateOf("") }
    var numeroSecret by remember { mutableStateOf(Random.nextInt(0..100)) }
    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //Nom usuari
        TextField(
            value = numeroIntroduit,
            onValueChange = { numeroIntroduit = it },
            label = { Text(text = "Insereix un número ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(Modifier.height(25.dp))

        Button(onClick = {
            if (validarNumero(numeroIntroduit)) {
                missatge = when {
                    numeroIntroduit.toInt() > numeroSecret -> "El número que busques és més petit"

                    numeroIntroduit.toInt() < numeroSecret -> "El número que busques és més gran"

                    else -> "Has encertat!"
                }
            } else missatge = "No has introduit un número enter"
        }) {
            Text("Jugar")
        }

        Spacer(Modifier.height(25.dp))
        Text(missatge)
    }
}

fun validarNumero(text: String): Boolean {
    return text.isDigitsOnly()
}