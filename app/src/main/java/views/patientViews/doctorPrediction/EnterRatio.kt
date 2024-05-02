package views.patientViews.doctorPrediction


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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

import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.graphics.Color.Companion

import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clinic.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxOfData(
    state : Inputs,
    text : String,
              ){
    val state by remember { mutableStateOf(TextFieldValue("")) }

    Box(contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
        ) {
        Column {
            Text(
                text = text,
                fontSize = 18.sp
            )
            OutlinedTextField(
                value = state,
                onValueChange = {},
                modifier = Modifier
                    .padding(6.dp)
                    .fillMaxWidth()
                    .size(45.dp),
                singleLine = true,
                textStyle = TextStyle(
                    color = Companion.Black,
                    fontWeight = FontWeight.Bold
            )
            )
        }
    }
}

@Composable
fun EnterAiData(){

    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        TopAppBar(
            title = { Text("AI Prediction") },
            backgroundColor = Color(0xFF0480C4),
            contentColor = Companion.White,
            elevation = 8.dp
        )
        BoxOfData(text = "Height(cm):", state = Inputs(height = ""))
        BoxOfData(text = "Weight(kg):", state = Inputs(weight = ""))
        Divider(thickness = 1.dp, color = Companion.Black)
        Text(
            "Enter a ratio (0 -> 120)",
            modifier = Modifier
                .padding(top = 10.dp)
                .fillMaxWidth()
            , textAlign = TextAlign.Center,
            fontSize = 15.sp,
            color = Companion.Magenta
        )
        BoxOfData(text = "BMI:", state = Inputs(bmi = ""))
        BoxOfData(text = "Alcohol consumption:",state = Inputs(alcoholConsumption = ""))
        BoxOfData(text = "Fruit consumption:", state = Inputs(fruitConsumption = ""))
        BoxOfData(text = "Green vegetables consumption:", state = Inputs(greenVegetablesConsumption = ""))
        BoxOfData(text = "Fried potato consumption:", state = Inputs(friedPotatoConsumption = ""))

        Button(modifier = Modifier
            .padding(start = 30.dp, end = 30.dp, top = 20.dp)
            .size(height = 40.dp, width = 300.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.light_blue)),
            onClick = {}){
                androidx.compose.material3.Text(
                    text = "Predict",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Companion.White
                )
            }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AiPreview(){
    EnterAiData()
}