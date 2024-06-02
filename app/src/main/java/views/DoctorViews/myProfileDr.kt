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
import com.example.clinic.api.ApiManager
import com.example.clinic.api.models.update_doctor_profile.UpdateDoctorProfileResponse
import com.example.clinic.models.data.UpdateDoctorProfile
import com.example.clinic.shared.SharedPerferenceHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
    var drName by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
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
        text = "Specialties",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp, bottom = 5.dp, top = 178.dp)
    )
    var specialties by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 202.dp)
            .fillMaxWidth(),
        value = specialties, onValueChange = { specialties = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
            containerColor = Color.White,
        )
    )
    Text(
        text = "Qualifications",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp, bottom = 5.dp, top = 260.dp)
    )
    var qualifications by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 282.dp)
            .fillMaxWidth(),
        value = qualifications, onValueChange = { qualifications = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
            containerColor = Color.White,
        )
    )
    Text(
        text = "Experience",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp, bottom = 5.dp, top = 340.dp)
    )
    var experience by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 362.dp)
            .fillMaxWidth(),
        value = experience, onValueChange = { experience = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
            containerColor = Color.White,
        )
    )
    Text(
        text = "Price",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp, bottom = 5.dp, top = 420.dp)
    )
    var price by remember { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 444.dp)
            .fillMaxWidth(),
        value = price, onValueChange = { price = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
            containerColor = Color.White,
        )
    )
//    Text(
//        text = "Specialization",
//        fontSize = 18.sp,
//        color = colorResource(R.color.black),
//        textAlign = TextAlign.Center,
//        modifier = Modifier
//            .padding(start = 14.dp, bottom = 5.dp, top = 500.dp)
//    )
//    var drSpec by remember { mutableStateOf(TextFieldValue("")) }
//    OutlinedTextField(modifier = Modifier
//        .padding(start = 13.dp, end = 13.dp, top = 525.dp)
//        .fillMaxWidth(),
//        value = drSpec, onValueChange = { drSpec = it },
//        shape = RoundedCornerShape(5.dp),
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            unfocusedBorderColor = colorResource(id = R.color.light_blue),
//            focusedBorderColor = colorResource(id = R.color.light_blue),
//            containerColor = Color.White,
//        )
//    )
//    Text(
//        text = "Medical Fees",
//        fontSize = 18.sp,
//        color = colorResource(R.color.black),
//        textAlign = TextAlign.Center,
//        modifier = Modifier
//            .padding(start = 14.dp, bottom = 5.dp, top = 580.dp)
//    )
//    var drFees by remember { mutableStateOf(TextFieldValue("")) }
//    OutlinedTextField(modifier = Modifier
//        .padding(start = 13.dp, end = 13.dp, top = 605.dp)
//        .fillMaxWidth(),
//        value = drFees, onValueChange = { drFees = it },
//        shape = RoundedCornerShape(5.dp),
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            unfocusedBorderColor = colorResource(id = R.color.light_blue),
//            focusedBorderColor = colorResource(id = R.color.light_blue),
//            containerColor = Color.White,
//        )
//    )
//    Text(
//        text = "Appointments",
//        fontSize = 18.sp,
//        color = colorResource(R.color.black),
//        textAlign = TextAlign.Center,
//        modifier = Modifier
//            .padding(start = 14.dp, bottom = 5.dp, top = 660.dp)
//    )
//    var drAppoint by remember { mutableStateOf(TextFieldValue("")) }
//    OutlinedTextField(modifier = Modifier
//        .padding(start = 13.dp, end = 13.dp, top = 688.dp)
//        .fillMaxWidth(),
//        value = drAppoint, onValueChange = { drAppoint = it },
//        shape = RoundedCornerShape(5.dp),
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            unfocusedBorderColor = colorResource(id = R.color.light_blue),
//            focusedBorderColor = colorResource(id = R.color.light_blue),
//            containerColor = Color.White,
//        )
//    )
    Button(
        onClick = {
            updateDoctorProfile(
                name = drName,
                specialties = specialties,
                qualifications = qualifications,
                experience = experience,
                price = price,
                navController = navController
            )
        },
        modifier = Modifier
            .padding(start = 80.dp, end = 30.dp, top = 530.dp)
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

fun updateDoctorProfile(
    name: String,
    specialties: String,
    qualifications: String,
    experience: String,
    price: String,
    navController: NavController
) {
    ApiManager.getService().updateDoctorProfile(
        userId = SharedPerferenceHelper.getIdDoctor(),
        token = "Bearer ${SharedPerferenceHelper.getToken()}",
        UpdateDoctorProfile(
            userName = name,
            specialties = specialties,
            qualifications = qualifications,
            experience = experience,
            price = price
        )
    ).enqueue(object : Callback<UpdateDoctorProfileResponse> {
        override fun onResponse(
            call: Call<UpdateDoctorProfileResponse>,
            response: Response<UpdateDoctorProfileResponse>
        ) {
            if (response.isSuccessful)
                navController.navigate("doctor_profile")
        }

        override fun onFailure(call: Call<UpdateDoctorProfileResponse>, t: Throwable) {
            TODO("Not yet implemented")
        }

    })
}

@Preview(showBackground = true)
@Composable
fun MyProfileDrPreview() {
    MyProfileDr(navController = rememberNavController())
}