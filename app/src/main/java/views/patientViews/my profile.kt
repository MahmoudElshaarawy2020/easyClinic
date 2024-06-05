package views.patientViews

import android.util.Log
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
import com.example.clinic.api.models.updatepatientdata.UpdatePatientDataResponse
import com.example.clinic.models.data.UpdatePatientData
import com.example.clinic.shared.SharedPerferenceHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import views.FunctionsComposable.LocalImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyProfilePatient(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var insuranceDetails by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var diseases by remember { mutableStateOf("") }
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

    OutlinedTextField(
        modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 122.dp)
            .fillMaxWidth(),
        value = name, onValueChange = { name = it },
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
            .padding(start = 14.dp, bottom = 5.dp, top = 178.dp)
    )

    OutlinedTextField(
        modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 202.dp)
            .fillMaxWidth(),
        value = age, onValueChange = { age = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
            containerColor = Color.White,
        )
    )
    Text(
        text = "InsuranceDetails",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp, bottom = 5.dp, top = 260.dp)
    )

    OutlinedTextField(
        modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 282.dp)
            .fillMaxWidth(),
        value = insuranceDetails, onValueChange = { insuranceDetails = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
            containerColor = Color.White,
        )
    )
    Text(
        text = "Adress",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp, bottom = 5.dp, top = 340.dp)
    )

    OutlinedTextField(
        modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 362.dp)
            .fillMaxWidth(),
        value = address, onValueChange = { address = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
            containerColor = Color.White,
        )
    )
    Text(
        text = "Diseases",
        fontSize = 18.sp,
        color = colorResource(R.color.black),
        textAlign = TextAlign.Center,
        modifier = Modifier
            .padding(start = 14.dp, bottom = 5.dp, top = 420.dp)
    )

    OutlinedTextField(
        modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 444.dp)
            .fillMaxWidth(),
        value = diseases, onValueChange = { diseases = it },
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = colorResource(id = R.color.light_blue),
            focusedBorderColor = colorResource(id = R.color.light_blue),
            containerColor = Color.White,
        )
    )
//    Text(
//        text = "Height",
//        fontSize = 18.sp,
//        color = colorResource(R.color.black),
//        textAlign = TextAlign.Center,
//        modifier = Modifier
//            .padding(start = 14.dp, bottom = 5.dp, top = 500.dp)
//    )
//    var height by remember { mutableStateOf(TextFieldValue("")) }
//    OutlinedTextField(modifier = Modifier
//        .padding(start = 13.dp, end = 13.dp, top = 525.dp)
//        .fillMaxWidth(),
//        value = height, onValueChange = { height = it },
//        shape = RoundedCornerShape(5.dp),
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            unfocusedBorderColor = colorResource(id = R.color.light_blue),
//            focusedBorderColor = colorResource(id = R.color.light_blue),
//            containerColor = Color.White,
//        )
//    )
//    Text(
//        text = "Weight",
//        fontSize = 18.sp,
//        color = colorResource(R.color.black),
//        textAlign = TextAlign.Center,
//        modifier = Modifier
//            .padding(start = 14.dp, bottom = 5.dp, top = 580.dp)
//    )
//    var weight by remember { mutableStateOf(TextFieldValue("")) }
//    OutlinedTextField(modifier = Modifier
//        .padding(start = 13.dp, end = 13.dp, top = 605.dp)
//        .fillMaxWidth(),
//        value = weight, onValueChange = { weight = it },
//        shape = RoundedCornerShape(5.dp),
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            unfocusedBorderColor = colorResource(id = R.color.light_blue),
//            focusedBorderColor = colorResource(id = R.color.light_blue),
//            containerColor = Color.White,
//        )
//    )
//    Text(
//        text = "Blood type",
//        fontSize = 18.sp,
//        color = colorResource(R.color.black),
//        textAlign = TextAlign.Center,
//        modifier = Modifier
//            .padding(start = 14.dp, bottom = 5.dp, top = 660.dp)
//    )
//    var blood by remember { mutableStateOf(TextFieldValue("")) }
//    OutlinedTextField(modifier = Modifier
//        .padding(start = 13.dp, end = 13.dp, top = 688.dp)
//        .fillMaxWidth(),
//        value = blood, onValueChange = { blood = it },
//        shape = RoundedCornerShape(5.dp),
//        colors = TextFieldDefaults.outlinedTextFieldColors(
//            unfocusedBorderColor = colorResource(id = R.color.light_blue),
//            focusedBorderColor = colorResource(id = R.color.light_blue),
//            containerColor = Color.White,
//        )
//    )
    Button(
        onClick = {
            updatePatientData(
                name = name,
                adress = address,
                age = age,
                insuranceDetails = insuranceDetails,
                diseases = diseases,
                navController = navController
            )
        },
        modifier = Modifier
            .padding(start = 80.dp, end = 30.dp, top = 520.dp)
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

fun updatePatientData(
    name: String,
    adress: String,
    age: String,
    insuranceDetails: String,
    diseases: String,
    navController: NavController
) {
    ApiManager.getService().updatePatientData(
        userId = SharedPerferenceHelper.getIdPatient(),
        token = "Bearer ${SharedPerferenceHelper.getToken()}",
        UpdatePatientData(
            name = name,
            adress = adress,
            age = age,
            insuranceDetails = insuranceDetails,
            diseases = diseases
        )
    ).enqueue(object : Callback<UpdatePatientDataResponse> {
        override fun onResponse(
            call: Call<UpdatePatientDataResponse>,
            response: Response<UpdatePatientDataResponse>
        ) {
            if (response.isSuccessful)
                navController.navigate(route = "patient_profile")
        }

        override fun onFailure(call: Call<UpdatePatientDataResponse>, t: Throwable) {
            Log.e("TAG", "onFailure: $t")
        }

    })
}

@Preview(showBackground = true)
@Composable
fun MyProfilePatientPreview() {
    MyProfilePatient(navController = rememberNavController())
}