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
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CalculIMC(modifier: Modifier = Modifier) {

    //Inputs
    var nomTextField by remember { mutableStateOf("") }
    var anyNaixament by remember { mutableStateOf("") }
    var alcada by remember { mutableStateOf("") }
    var pes by remember { mutableStateOf("") }

    // Resultats
    var nomUsuari by remember { mutableStateOf("") }
    var edatCalculada by remember { mutableStateOf(0) }
    var estatSalud by remember { mutableStateOf("") }

    Column(
        modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //Nom usuari
        TextField(
            value = nomTextField,
            onValueChange = { nomTextField = it },
            label = { Text(text = "Nom usuari: ") })

        //Any naixament
        TextField(
            value = anyNaixament,
            onValueChange = { anyNaixament = it },
            label = { Text(text = "Any de naixament:") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        //Alçada
        TextField(
            value = alcada,
            onValueChange = { alcada = it },
            label = { Text(text = "Alçada:") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        //Pes
        TextField(
            value = pes,
            onValueChange = { pes = it },
            label = { Text(text = "Pes:") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(Modifier.height(50.dp))

        Button(
            onClick = {
                if (inputsValids(nomTextField, anyNaixament, pes, alcada)) {
                    nomUsuari = nomTextField
                    edatCalculada = LocalDate.now().year - anyNaixament.toInt()
                    estatSalud = calcuarEstatSalud(pes.toDouble(), alcada.toDouble())
                }
            }) {

            Text("Mostrar")
        }


        Spacer(Modifier.height(25.dp))

        Text("Usuari: $nomUsuari")
        Text("Edat: $edatCalculada")
        Text("Estat de salud: $estatSalud")
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun inputsValids(nomUsuari: String, anyNaixament: String, pes: String, alcada: String): Boolean {
    val regexDouble = """^\d+(\.\d+)?$""".toRegex()

    if (nomUsuari.isBlank()) return false

    if (anyNaixament.isBlank() || !anyNaixament.isDigitsOnly()) return false
    val any = anyNaixament.toInt()
    val anyActual = LocalDate.now().year
    if (any !in 1901..anyActual) return false

    if (!regexDouble.matches(pes) || pes.toDouble() <= 0) return false
    if (!regexDouble.matches(alcada) || alcada.toDouble() <= 0) return false

    return true
}

fun calcuarEstatSalud(pes: Double, alcada: Double): String {
    val IMC = pes / (alcada * alcada)
    var resultat = ""

    when {
        IMC < 18.5 -> resultat = "Pes insuficient"
        IMC in 18.5..24.9 -> resultat = "Normal"
        IMC in 25.0..50.0 -> resultat = "Sobrepès"
        IMC > 50 -> resultat = "Obesitat"
    }

    return resultat
}