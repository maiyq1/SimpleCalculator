package com.example.challenger1_calculator

import android.graphics.fonts.FontStyle
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challenger1_calculator.ui.theme.Challenger1_calculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            principal()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun principal() {

    var num1 by remember { mutableStateOf("")}
    var num2 by remember { mutableStateOf("")}
    var result by remember { mutableStateOf("")}

    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TopAppBar(
            title = { Text(text = "Calculadora UPC", textAlign = TextAlign.Center)},
            navigationIcon = {
                Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Menu")
            })

        Image(
            painter = painterResource(id = R.drawable.logo_calculadora),
            contentDescription = null,
            modifier = Modifier
                .height(150.dp))

        OutlinedTextField(
            value = num1,
            label = {
                Text(text = "Ingrese el valor 1")
            },
            modifier = Modifier
                .padding(7.dp)
                .background(color = Color.Transparent),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                num1 = it
            }
        )

        OutlinedTextField(
            value = num2,
            label = {
                Text(text = "Ingrese el valor 2")
            },
            modifier = Modifier
                .padding(7.dp)
                .background(color = Color.Transparent),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = {
                num2 = it
            }
        )

        Row {

        }

        Button(
            colors = ButtonDefaults.buttonColors(Color(175,38,29)),
            modifier = Modifier
                .padding(20.dp),
            onClick = {
                val valNum1 = num1.toFloat()
                val valNum2 = num2.toFloat()
                result = (valNum1 + valNum2).toString()
            }) {
            Text(text = "+")
        }

        Button(
            colors = ButtonDefaults.buttonColors(Color(175,38,29)),
            modifier = Modifier
                .padding(20.dp),
            onClick = {
                val valNum1 = num1.toFloat()
                val valNum2 = num2.toFloat()
                result = (valNum1 - valNum2).toString()
            }) {
            Text(text = "-")
        }

        Button(
            colors = ButtonDefaults.buttonColors(Color(175,38,29)),
            modifier = Modifier
                .padding(20.dp),
            onClick = {
                val valNum1 = num1.toFloat()
                val valNum2 = num2.toFloat()
                result = (valNum1 * valNum2).toString()
            }) {
            Text(text = "*")
        }

        Button(
            colors = ButtonDefaults.buttonColors(Color(175,38,29)),
            modifier = Modifier
                .padding(20.dp),
            onClick = {
                val valNum1 = num1.toFloat()
                val valNum2 = num2.toFloat()
                result = (valNum1 / valNum2).toString()
            }) {
            Text(text = "/")
        }
        
        Text(text = "Resultado: ${result}")
    }


}