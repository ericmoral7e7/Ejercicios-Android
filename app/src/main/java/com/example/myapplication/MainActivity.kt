package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.Exercici6
import com.example.myapplication.ui.theme.ambState.CalculadoraPropina


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Exercici1(modifier = Modifier.padding(innerPadding))
//                    Exercici2(modifier = Modifier.padding(innerPadding))
//                    Exercici6(modifier = Modifier.padding(innerPadding))
                    CalculadoraPropina(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}