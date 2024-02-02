package views.FunctionsComposable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.*
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.*
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldWithFeatures(
    text: String,
    onTextChanged: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    textStyle: TextStyle = TextStyle.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,

) {
    OutlinedTextField(value = text,
        onValueChange = onTextChanged,
        label = { Text(text = label) },
        modifier = modifier,
        keyboardOptions = keyboardOptions,
        textStyle = textStyle,
        visualTransformation = visualTransformation,
        singleLine = true,
        shape = RoundedCornerShape(4.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Blue,
            unfocusedBorderColor = Color.Gray,
            textColor = Color.Black))
}

@Composable
@Preview(showBackground = true)
fun test(){
    var text by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxSize()) {


        OutlinedTextFieldWithFeatures(text = "username", onTextChanged = {newText -> text = newText},
            label = "enter the username",
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp))
    }
}
    
