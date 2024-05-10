package views.patientViews.doctorPrediction

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.ui.Modifier
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clinic.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterAiData(){
    var Height by remember { mutableStateOf("") }
    var Weight by remember { mutableStateOf("") }
    var BMI by remember { mutableStateOf("") }
    var Alcohol by remember { mutableStateOf("") }
    var Fruit by remember { mutableStateOf("") }
    var Vegetables by remember { mutableStateOf("") }
    var Fried by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = { Text("AI Prediction") },
            backgroundColor = Color(0xFF0480C4),
            contentColor = Color.White,
            elevation = 8.dp
        )
        Box(contentAlignment = Alignment.CenterStart,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Column {
                Text(
                    modifier = Modifier.padding(start = 7.dp),
                    text = "Height : ",
                    fontSize = 18.sp
                )
                OutlinedTextField(
                    value = Height,
                    onValueChange = {Height = it},
                    modifier = Modifier
                        .padding(6.dp)
                        .fillMaxWidth()
                        .size(45.dp),
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    modifier = Modifier.padding(start = 7.dp),
                    text = "Weight : ",
                    fontSize = 18.sp
                )
                OutlinedTextField(
                    value = Weight,
                    onValueChange = {Weight = it},
                    modifier = Modifier
                        .padding(6.dp)
                        .fillMaxWidth()
                        .size(45.dp),
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.size(height = 15.dp, width = 200.dp))

                Divider(
                    thickness = 1.dp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.size(height = 15.dp, width = 200.dp))

                Text(text = "Enter a ratio 0 -> 120",
                    color = Color(0xFF0480C4),
                    fontSize = 16.sp,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center)

                Text(
                    modifier = Modifier.padding(start = 7.dp),
                    text = "BMI : ",
                    fontSize = 18.sp
                )
                OutlinedTextField(
                    value = BMI,
                    onValueChange = {BMI = it},
                    modifier = Modifier
                        .padding(6.dp)
                        .fillMaxWidth()
                        .size(45.dp),
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    modifier = Modifier.padding(start = 7.dp),
                    text = "Alcohol consumption : ",
                    fontSize = 18.sp
                )
                OutlinedTextField(
                    value = Alcohol,
                    onValueChange = {Alcohol = it},
                    modifier = Modifier
                        .padding(6.dp)
                        .fillMaxWidth()
                        .size(45.dp),
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )


                Text(
                    modifier = Modifier.padding(start = 7.dp),
                    text = "Fruit consumption : ",
                    fontSize = 18.sp
                )
                OutlinedTextField(
                    value = Fruit,
                    onValueChange = {Fruit = it},
                    modifier = Modifier
                        .padding(6.dp)
                        .fillMaxWidth()
                        .size(45.dp),
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    modifier = Modifier.padding(start = 7.dp),
                    text = "Green Vegetables consumption : ",
                    fontSize = 18.sp
                )
                OutlinedTextField(
                    value = Vegetables,
                    onValueChange = {Vegetables = it},
                    modifier = Modifier
                        .padding(6.dp)
                        .fillMaxWidth()
                        .size(45.dp),
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )

                Text(
                    modifier = Modifier.padding(start = 7.dp),
                    text = "Fried potato consumption : ",
                    fontSize = 18.sp
                )
                OutlinedTextField(
                    value = Fried,
                    onValueChange = {Fried = it},
                    modifier = Modifier
                        .padding(6.dp)
                        .fillMaxWidth()
                        .size(45.dp),
                    singleLine = true,
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )

            }
        }
        Button(modifier = Modifier
            .padding(start = 30.dp, end = 30.dp, top = 20.dp)
            .size(height = 40.dp, width = 300.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.light_blue)),
            onClick = {}){
            Text(
                text = "Predict",
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
//finished
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AiPreview(){
    EnterAiData()
}