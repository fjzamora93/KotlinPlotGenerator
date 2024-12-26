package com.example.kotlinplotgenerator

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
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
    // Instanciar el ViewModel
    val viewModel: CharCreatorViewModel = viewModel()

    // Acceder a las propiedades del character y sus stats
    val character = viewModel.character.value

    // Crear la columna que contendrá todas las filas de los stats
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        // Llamamos a StatRow para cada stat
        StatRow(statName = "Destreza", viewModel = viewModel)
        StatRow(statName = "Fuerza", viewModel = viewModel)
        StatRow(statName = "Constitución", viewModel = viewModel)
        StatRow(statName = "Inteligencia", viewModel = viewModel)
        StatRow(statName = "Sabiduría", viewModel = viewModel)
        StatRow(statName = "Carisma", viewModel = viewModel)

        // Aquí podrías agregar otros elementos de UI como el nombre del personaje, etc.
        Text(text = "Nombre del personaje: ${character.name}")
        Text(text = "ID del personaje: ${character.id}")
    }
}


@Composable
fun StatRow(
    statName: String,
    viewModel: CharCreatorViewModel
) {
    // Observar el estado de `character` desde el ViewModel
    val stats = viewModel.character.value
    val statValue = stats.stats[statName] ?: 0

    Row(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextDescription(statDescription = statName, modifier = Modifier)

        // Botón de decremento
        IconButton(icon = Icons.Default.Remove, onClick = {
            viewModel.decrementStat(statName)
        })

        // Input para mostrar y actualizar el valor del stat
        StatInput(stat = statValue.toString()) { newValue ->
            viewModel.updateStat(statName, newValue.toIntOrNull()?:0)
        }

        // Botón de incremento
        IconButton(icon = Icons.Default.Add, onClick = {
            viewModel.incrementStat(statName)
        })
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

/**
 * A composable function for a Button with an inner Icon.
 *
 * @param icon The ImageVector to be used as the icon. For example: Icons.Default.Add
 * @param contentDescription A description of the icon for accessibility purposes.
 * @param onClick The functions that activate the button.
 */
@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    contentDescription: String? = null,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .size(20.dp)
            .clip(RoundedCornerShape(4.dp))
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(40.dp)
                .padding(8.dp),
            tint = Color.Red
        )
    }
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