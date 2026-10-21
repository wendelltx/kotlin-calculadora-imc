package com.example.calculadora_imc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadora_imc.ui.theme.CalculadoraIMCTheme
import java.util.Locale
import kotlin.math.ceil

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculadoraIMCTheme {
                TipTimeLayout()
            }
        }
    }
}

@Composable
fun TipTimeLayout() {
    var pesoInput by remember { mutableStateOf("") }
    var alturaInput by remember { mutableStateOf("") }
    var arredondarResultado by remember { mutableStateOf(false) }
    var imcResultado by remember { mutableStateOf("") }

    val pesoKg = pesoInput.replace(",", ".").toDoubleOrNull() ?: 0.0
    val alturaM = alturaInput.replace(",", ".").toDoubleOrNull() ?: 0.0

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding()
            .padding(40.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Calcular IMC",
            fontSize = 29.sp,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(Alignment.Start)
        )
        EditNumberField(
            label = "Peso (kg)",
            value = pesoInput,
            onValueChanged = { pesoInput = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )
        EditNumberField(
            label = "Altura (m)",
            value = alturaInput,
            onValueChanged = { alturaInput = it },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )
        RoundTheTipRow(
            arredondar = arredondarResultado,
            onArredondarChanged = { arredondarResultado = it },
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Button(
            onClick = {
                imcResultado = calcularImc(pesoKg, alturaM, arredondarResultado)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            Text("Calcular")
        }
        if (imcResultado.isNotEmpty()) {
            val imcVal = imcResultado.replace(",", ".").toDoubleOrNull() ?: 0.0
            ExibirImc(imc = imcVal)
        }
    }
}

@Composable
fun EditNumberField(
    label: String,
    value: String,
    onValueChanged: (String) -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChanged,
        singleLine = true,
        label = { Text(label) },
        keyboardOptions = keyboardOptions,
        modifier = modifier
    )
}

@Composable
fun RoundTheTipRow(
    arredondar: Boolean,
    onArredondarChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Arredondar resultado")
        Switch(checked = arredondar, onCheckedChange = onArredondarChanged)
    }
}

@Composable
fun ExibirImc(imc: Double, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = "IMC: ${String.format(Locale.forLanguageTag("pt-BR"), "%.2f", imc)}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(3.dp))
        Text(
            text = "Classificação: ${faixaIMC(imc)}",
            fontSize = 20.sp
        )
    }
}

fun faixaIMC(n: Double): String = when {
    n <= 0.0 -> "-"
    n < 18.5 -> "Abaixo do peso"
    n < 25.0 -> "Peso normal"
    n < 30.0 -> "Sobrepeso"
    else -> "Obesidade"
}

fun calcularImc(
    pesoKg: Double,
    alturaM: Double,
    arredondar: Boolean
): String {
    if (alturaM <= 0.0 || pesoKg <= 0.0) return "0,00"
    var imc = pesoKg / (alturaM * alturaM)
    if (arredondar) imc = ceil(imc)
    return String.format(Locale.forLanguageTag("pt-BR"), "%.2f", imc)
}

