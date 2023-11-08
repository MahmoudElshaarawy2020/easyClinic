package com.example.clinic

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Icon
import android.os.Bundle
import android.text.Layout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clinic.ui.theme.ClinicTheme
import java.lang.reflect.Array.get
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ClinicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    loginScreen()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun loginScreen(){


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
            .background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally


    ){
        Image(

            painter = painterResource(id = R.drawable.bluelogo1),
            contentDescription = "Logo Image",
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
        )
        Text(text = "Welcome Back",
            fontSize = 30.sp,
            color = colorResource(R.color.lightblue)


        )
        var text by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 25.dp)
            .fillMaxWidth(),
            value = text, onValueChange = {text =it},
            shape = RoundedCornerShape(15.dp),
            label = { Text(text = "Email or User Name",color = Color.LightGray)}
           , leadingIcon = {
                Icon(
               imageVector = Icons.Filled.Person
                    , contentDescription = "Email icon"
           )

            },
            maxLines = 1,
            textStyle = androidx.compose.ui.text.TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.lightblue)
                , focusedBorderColor = colorResource(id = R.color.lightblue)
            )
        )
        var passworVisability by remember { mutableStateOf(false) }
        val icon = if (passworVisability)
            painterResource(id = R.drawable.visabilityon)
        else
            painterResource(id = R.drawable.visabilityoff)
        var password by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 15.dp)
            .fillMaxWidth(),
            value = password, onValueChange = {password =it},
            visualTransformation = if (passworVisability) VisualTransformation.None

            else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            ,shape = RoundedCornerShape(15.dp),

            label = { Text(text = "password",color = Color.LightGray)}
            , leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock
                    , contentDescription = "Email icon"
                )
            },
            trailingIcon = {
                           IconButton(onClick = { passworVisability = !passworVisability }) {
                               Icon(modifier = Modifier
                                   .padding(end = 10.dp)
                                   .size(20.dp), painter = icon , contentDescription = null)

                               
                           }
            },
            maxLines = 1,
            textStyle = androidx.compose.ui.text.TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.lightblue),
                        focusedBorderColor = colorResource(id = R.color.lightblue)
            )
        )


    }


}
@Preview (showBackground = true)
@Composable
fun loginPreview(){
    loginScreen()

}