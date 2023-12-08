package views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DataScreenTextField(navController: NavController){
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {
        LocalImage(
            painter = painterResource(id = R.drawable.finalbluelogo),
            imageSize = 200.dp,
            padding = 15.dp,
        )


        Text(
            text = "Enter your data",
            fontSize = 30.sp,
            color = colorResource(R.color.lightblue)


        )
        var text by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 25.dp)
            .fillMaxWidth(),
            value = text, onValueChange = { text = it },
            shape = RoundedCornerShape(15.dp),
            label = {
                Text(
                    text = "name",
                    style = TextStyle(
                    color = Color.LightGray,textAlign=TextAlign.Center)
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.lightblue),
                focusedBorderColor = colorResource(id = R.color.lightblue)
            )
        )
        var age by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 25.dp)
            .fillMaxWidth(),
            value = age, onValueChange = { age = it },
            shape = RoundedCornerShape(15.dp),
            label = {
                Text(
                    text = "age",
                    style = TextStyle(
                        color = Color.LightGray,textAlign=TextAlign.Center)
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.lightblue),
                focusedBorderColor = colorResource(id = R.color.lightblue)
            )
        )
        var num by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 25.dp)
            .fillMaxWidth(),
            value = num, onValueChange = { num = it },
            shape = RoundedCornerShape(15.dp),
            label = {
                Text(
                    text = "phone number",
                    style = TextStyle(
                        color = Color.LightGray,textAlign=TextAlign.Center)
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.lightblue),
                focusedBorderColor = colorResource(id = R.color.lightblue)
            )
        )
        var address by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 25.dp)
            .fillMaxWidth(),
            value = address, onValueChange = { address = it },
            shape = RoundedCornerShape(15.dp),
            label = {
                Text(
                    text = "address",
                    style = TextStyle(
                        color = Color.LightGray,textAlign=TextAlign.Center)
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.lightblue),
                focusedBorderColor = colorResource(id = R.color.lightblue)
            )
        )
        var gender by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 25.dp)
            .fillMaxWidth(),
            value = gender, onValueChange = { gender = it },
            shape = RoundedCornerShape(15.dp),
            label = {
                Text(
                    text = "gender",
                    style = TextStyle(
                        color = Color.LightGray,textAlign=TextAlign.Center)
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.lightblue),
                focusedBorderColor = colorResource(id = R.color.lightblue)
            )
        )
        Button(
            onClick = {},
            modifier = Modifier
                .padding(start = 250.dp, end = 5.dp, top = 40.dp)
                .size(height = 40.dp, width = 100.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.lightblue)),

            ) {
            Text(
                text = "Next",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Data() {
    DataScreenTextField(navController = rememberNavController())
}
