package views.doctorViews

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
fun MyProfileDr(navController: NavController) {
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
                    color = Color(0xFF39A0FF)
                )
                .size(height = 80.dp, width = 450.dp),

            )
    }
    Box(modifier = Modifier

        .padding(10.dp)
        .clickable {
            navController.navigate(route = "doctor_profile")
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
    var drName by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 122.dp)
        .fillMaxWidth(),
        value = drName, onValueChange = { drName = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
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
    var drAge by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 202.dp)
        .fillMaxWidth(),
        value = drAge, onValueChange = { drAge = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
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
    var drNum by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 282.dp)
        .fillMaxWidth(),
        value = drNum, onValueChange = { drNum = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
            containerColor = Color.White,
        )
    )
    Text(
        text = "Clinic Address",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp,bottom = 5.dp, top = 340.dp)
    )
    var drAddress by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 362.dp)
        .fillMaxWidth(),
        value = drAddress, onValueChange = { drAddress = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
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
    var drGender by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 444.dp)
        .fillMaxWidth(),
        value = drGender, onValueChange = { drGender = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
            containerColor = Color.White,
        )
    )
    Text(
        text = "Specialization",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp, bottom = 5.dp, top = 500.dp)
    )
    var drSpec by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 525.dp)
        .fillMaxWidth(),
        value = drSpec, onValueChange = { drSpec = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
            containerColor = Color.White,
        )
    )
    Text(
        text = "Medical Fees",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp, bottom = 5.dp, top = 580.dp)
    )
    var drFees by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 605.dp)
        .fillMaxWidth(),
        value = drFees, onValueChange = { drFees = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
            containerColor = Color.White,
        )
    )
    Text(
        text = "Appointments",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp, bottom = 5.dp, top = 660.dp)
    )
    var drAppoint by remember { mutableStateOf(TextFieldValue("")) }
    OutlinedTextField(modifier = Modifier
        .padding(start = 13.dp, end = 13.dp, top = 688.dp)
        .fillMaxWidth(),
        value = drAppoint, onValueChange = { drAppoint = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
            containerColor = Color.White,
        )
    )
    Button(
        onClick = {
            navController.navigate(route = "doctor_profile")
        },
        modifier = Modifier
            .padding(start = 80.dp, end = 30.dp, top = 750.dp)
            .size(height = 60.dp, width = 250.dp),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.light_blue)),
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
fun MyProfileDrPreview(){
    MyProfileDr(navController=  rememberNavController())
}