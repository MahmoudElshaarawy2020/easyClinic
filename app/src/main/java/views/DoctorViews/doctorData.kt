package views.doctorViews

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import com.example.clinic.api.ApiManager
import com.example.clinic.api.models.doctor_data.DoctorDataResponse
import views.FunctionsComposable.LocalImage
import androidx.compose.material3.Text as Text
import com.example.clinic.models.data.DataDoctor
import com.example.clinic.models.data.DoctorToken
import com.example.clinic.models.data.UserDoctor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DoctorData(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var specialization by remember { mutableStateOf("") }
    var qualifications by remember { mutableStateOf("") }
    var clincaddress by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var section by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center


    ) {
        LocalImage(
            painter = painterResource(id = R.drawable.finalbluelogo),
            imageSize = 150.dp,
            padding = 15.dp,
        )


        Text(
            text = "Enter your data",
            fontSize = 20.sp,
            color = colorResource(R.color.light_blue)


        )

        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 10.dp)
                .fillMaxWidth(),
            value = name, onValueChange = { name = it },
            shape = RoundedCornerShape(15.dp),
            singleLine = true,
            label = {
                Text(
                    text = "Name",
                    style = TextStyle(
                        color = Color.LightGray, textAlign = TextAlign.Center
                    )
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 10.dp)
                .fillMaxWidth(),
            value = age, onValueChange = { age = it },
            shape = RoundedCornerShape(15.dp),
            singleLine = true,
            label = {
                Text(
                    text = "Age",
                    style = TextStyle(
                        color = Color.LightGray, textAlign = TextAlign.Center
                    )
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 10.dp)
                .fillMaxWidth(),
            value = specialization, onValueChange = { specialization = it },
            shape = RoundedCornerShape(15.dp),
            singleLine = true,
            label = {
                Text(
                    text = " specialization",
                    style = TextStyle(
                        color = Color.LightGray, textAlign = TextAlign.Center
                    )
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 10.dp)
                .fillMaxWidth(),
            value = qualifications, onValueChange = { qualifications = it },
            shape = RoundedCornerShape(15.dp),
            singleLine = true,
            label = {
                Text(
                    text = "Qualifications",
                    style = TextStyle(
                        color = Color.LightGray, textAlign = TextAlign.Center
                    )
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 10.dp)
                .fillMaxWidth(),
            value = clincaddress, onValueChange = { clincaddress = it },
            shape = RoundedCornerShape(15.dp),
            singleLine = true,
            label = {
                Text(
                    text = " clincaddress",
                    style = TextStyle(
                        color = Color.LightGray, textAlign = TextAlign.Center
                    )
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 10.dp)
                .fillMaxWidth(),
            value = price, onValueChange = { price = it },
            shape = RoundedCornerShape(15.dp),
            singleLine = true,
            label = {
                Text(
                    text = "Price",
                    style = TextStyle(
                        color = Color.LightGray, textAlign = TextAlign.Center
                    )
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 10.dp)
                .fillMaxWidth(),
            value = section, onValueChange = { section = it },
            shape = RoundedCornerShape(15.dp),
            singleLine = true,
            label = {
                Text(
                    text = "Section",
                    style = TextStyle(
                        color = Color.LightGray, textAlign = TextAlign.Center
                    )
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 10.dp)
                .fillMaxWidth(),
            value = gender, onValueChange = { gender = it },
            shape = RoundedCornerShape(topStart = 13.dp, bottomEnd = 13.dp),
            label = {
                Text(
                    text = "Gender",
                    style = TextStyle(
                        color = Color.LightGray, textAlign = TextAlign.Center
                    )
                )
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )
        Button(
            onClick = {
                enterDataDoctor(
                    name = name,
                    age = age.toInt(),
                    specialties = specialization,
                    qualifications = qualifications,
                    adress = clincaddress,
                    price = price,
                    section = section,
                    gender = gender,
                    navController = navController
                )

            },
            modifier = Modifier
                .padding(start = 250.dp, end = 5.dp, top = 8.dp)
                .size(height = 40.dp, width = 100.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.light_blue)),

            ) {
            Text(
                text = "Next",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(30.dp)
        )
    }

}

fun enterDataDoctor(
    name: String,
    age: Int,
    specialties: String,
    qualifications: String,
    adress: String,
    price: String,
    section: String,
    gender: String,
    navController: NavController
) {
    ApiManager.getService().DoctorData(
        token = "Bearer ${DoctorToken.token}", DataDoctor(
            id = UserDoctor.id,
            name = name,
            age = age,
            specialties = specialties,
            qualifications = qualifications,
            adress = adress,
            price = price,
            section = section,
            gender = gender
        )
    ).enqueue(object : Callback<DoctorDataResponse> {
        override fun onResponse(
            call: Call<DoctorDataResponse>,
            response: Response<DoctorDataResponse>
        ) {
            if (response.isSuccessful)
                Log.e("Data Doctor", "Data Doctor ${response.body()}")
            navController.navigate(route = "splash_doctor/$name")
        }

        override fun onFailure(call: Call<DoctorDataResponse>, t: Throwable) {
            Log.e("Data Doctor", "Data Doctor Faluires ${t.localizedMessage}")

        }

    })
}

@Preview(showBackground = true)
@Composable
fun Data() {
    DoctorData(navController = rememberNavController())
}
