package com.example.kotlinplotgenerator

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.unirfp.jetpackcomposeinstagram.Body
import com.unirfp.jetpackcomposeinstagram.Footer
import com.unirfp.jetpackcomposeinstagram.Header
import com.unirfp.jetpackcomposeinstagram.SignUp

@Composable
fun CharCreatorScreen(modifier: Modifier = Modifier){
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)){
        Header(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center))
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}


@Composable
fun Body(modifier: Modifier){
    Column(modifier = modifier.fillMaxWidth()){
        MyForm()
    }
}

@Composable
fun MyForm() {
    var descriptionInput by rememberSaveable { mutableStateOf("") }

    var destrezaStat by rememberSaveable { mutableStateOf("0") }
    var fuerzaStat by rememberSaveable { mutableStateOf("0") }
    var constitucionStat by rememberSaveable { mutableStateOf("0") }
    var inteligenciaStat by rememberSaveable { mutableStateOf("0") }
    var sabiduriaStat by rememberSaveable { mutableStateOf("0") }
    var carismaStat by rememberSaveable { mutableStateOf("0") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextDescription(statDescription = "Descripción Principal", modifier = Modifier.padding(bottom = 8.dp))
        TextInput(textInput = descriptionInput, onTextChanged = { newText -> descriptionInput = newText })

        TextDescription(statDescription = "Destreza", modifier = Modifier.padding(bottom = 8.dp))
        StatInput(stat = destrezaStat) { destrezaStat = it }

        TextDescription(statDescription = "Fuerza", modifier = Modifier.padding(bottom = 8.dp))
        StatInput(stat = fuerzaStat) { fuerzaStat = it }

        TextDescription(statDescription = "Constitución", modifier = Modifier.padding(bottom = 8.dp))
        StatInput(stat = constitucionStat) { constitucionStat = it }

        TextDescription(statDescription = "Inteligencia", modifier = Modifier.padding(bottom = 8.dp))
        StatInput(stat = inteligenciaStat) { inteligenciaStat = it }

        TextDescription(statDescription = "Sabiduría", modifier = Modifier.padding(bottom = 8.dp))
        StatInput(stat = sabiduriaStat) { sabiduriaStat = it }

        TextDescription(statDescription = "Carisma", modifier = Modifier.padding(bottom = 8.dp))
        StatInput(stat = carismaStat) { carismaStat = it }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StatInput(stat: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = stat,
        onValueChange = { onTextChanged(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "0") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors = TextFieldDefaults.textFieldColors(
            focusedTextColor = Color(0xFFB2B2B2),
            containerColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedLabelColor = Color.Transparent
        )
    )
}



@Composable
fun TextDescription(statDescription : String, modifier: Modifier) {
    Text(text = statDescription, fontSize = 12.sp, fontWeight = FontWeight.Bold,
        color = Color(0xFF4EA8E9), modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput(textInput: String, onTextChanged: (String) -> Unit) {
    TextField(value = textInput, onValueChange = { onTextChanged(it)},
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text(text = "0") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions =  KeyboardOptions(keyboardType = KeyboardType.Email),
        colors = TextFieldDefaults.textFieldColors(
            focusedTextColor = Color(0xFFB2B2B2),
            containerColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedLabelColor = Color.Transparent
        )
    )
}



@Composable
fun Header(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(imageVector = Icons.Default.Close, contentDescription = "close app",
        modifier = modifier.clickable { activity.finish() })
}


@Composable
fun Footer(modifier: Modifier) {
    Column (modifier = modifier.fillMaxWidth()){
        HorizontalDivider(
            Modifier
                .background(Color(0XFF9F9F9))
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(16.dp))
        SignUp()
        Spacer(modifier = Modifier.size(16.dp))
    }


}