package views.patientViews

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import views.FunctionsComposable.LocalImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyProfile(navController: NavController) {
    val fontFamily = FontFamily(
        Font(R.font.wendyoneregular, FontWeight.Thin)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFE9FAFF)),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFF39A0FF), shape = RoundedCornerShape(0.dp)
                )
                .size(height = 80.dp, width = 450.dp),

            )
    }
    Box(modifier = Modifier

        .padding(10.dp)
        .clickable {
            navController.navigate(route = "patient_profile")
        }) {
        LocalImage(
            painter = painterResource(id = R.drawable.whitearrow), imageSize = 60.dp,
            padding = 10.dp
        )
    }
    Text(
        text = "My profile",
        fontSize = 26.sp,
        color = colorResource(R.color.white),
        textAlign = TextAlign.Center,
        fontFamily = fontFamily,
        modifier = Modifier
            .padding(start = 70.dp, end = 13.dp, top = 25.dp)
    )
    Text(
        text = "Name",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp, top = 100.dp, bottom = 5.dp)
    )
    var text by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 122.dp)
        .fillMaxWidth(),
        value = text, onValueChange = { text = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.lightblue),
            focusedBorderColor = colorResource(id = R.color.lightblue),
            containerColor = Color.White,
        )
    )
    Text(
        text = "Age",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp,bottom = 5.dp, top = 178.dp)
    )
    var age by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 202.dp)
        .fillMaxWidth(),
        value = age, onValueChange = { age = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.lightblue),
            focusedBorderColor = colorResource(id = R.color.lightblue),
            containerColor = Color.White,
        )
    )
    Text(
            text = "Phone Number",
    fontSize = 18.sp,
    color = colorResource(R.color.black),
    textAlign = TextAlign.Center,
    modifier = Modifier
        .padding(start = 14.dp, bottom = 5.dp, top = 260.dp)
    )
    var num by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 282.dp)
        .fillMaxWidth(),
        value = num, onValueChange = { num = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.lightblue),
            focusedBorderColor = colorResource(id = R.color.lightblue),
            containerColor = Color.White,
        )
    )
    Text(
            text = "Adress",
    fontSize = 18.sp,
    color = colorResource(R.color.black),
    textAlign = TextAlign.Center,
    modifier = Modifier
        .padding(start = 14.dp,bottom = 5.dp, top = 340.dp)
    )
    var address by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 362.dp)
        .fillMaxWidth(),
        value = address, onValueChange = { address = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.lightblue),
            focusedBorderColor = colorResource(id = R.color.lightblue),
            containerColor = Color.White,
        )
    )
    Text(
            text = "Gender",
    fontSize = 18.sp,
    color = colorResource(R.color.black),
    textAlign = TextAlign.Center,
    modifier = Modifier
        .padding(start = 14.dp, bottom = 5.dp, top = 420.dp)
    )
    var gender by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 444.dp)
        .fillMaxWidth(),
        value = gender, onValueChange = { gender = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.lightblue),
            focusedBorderColor = colorResource(id = R.color.lightblue),
            containerColor = Color.White,
        )
    )
    Text(
        text = "Height",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp, bottom = 5.dp, top = 500.dp)
    )
    var height by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 525.dp)
        .fillMaxWidth(),
        value = height, onValueChange = { height = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.lightblue),
            focusedBorderColor = colorResource(id = R.color.lightblue),
            containerColor = Color.White,
        )
    )
    Text(
        text = "Weight",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp, bottom = 5.dp, top = 580.dp)
    )
    var weight by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 605.dp)
        .fillMaxWidth(),
        value = weight, onValueChange = { weight = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.lightblue),
            focusedBorderColor = colorResource(id = R.color.lightblue),
            containerColor = Color.White,
        )
    )
    Text(
        text = "Blood type",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp, bottom = 5.dp, top = 660.dp)
    )
    var blood by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 688.dp)
        .fillMaxWidth(),
        value = blood, onValueChange = { blood = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.lightblue),
            focusedBorderColor = colorResource(id = R.color.lightblue),
            containerColor = Color.White,
        )
    )
    Button(
        onClick = {
            navController.navigate(route = "patient_profile")
        },
        modifier = Modifier
            .padding(start = 80.dp, end = 30.dp, top = 750.dp)
            .size(height = 60.dp, width = 250.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.lightblue)),
        shape = RoundedCornerShape(20.dp)
        ) {
        Text(
            text = "Save",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}
@Preview(showBackground = true)
@Composable
fun MyProfile(){
    MyProfile (navController=  rememberNavController())
}