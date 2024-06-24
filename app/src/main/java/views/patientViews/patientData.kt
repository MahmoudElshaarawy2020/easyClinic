package views.patientViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import com.example.clinic.api.ApiManager
import com.example.clinic.api.models.patient_data.DataPatientResponse
import com.example.clinic.models.data.PatientToken
import com.example.clinic.models.data.DataPatient
import com.example.clinic.models.data.UserPatient
import com.example.clinic.shared.SharedPerferenceHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import views.FunctionsComposable.LocalImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PatientData(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var insuranceDetails by remember { mutableStateOf("") }
    var diseases by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }
    var iExpanded by remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(color = Color.White)
            .verticalScroll(scrollState)
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
            color = colorResource(R.color.light_blue)


        )

        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 25.dp)
                .fillMaxWidth(),
            value = name, onValueChange = { name = it },
            shape = RoundedCornerShape(15.dp),
            singleLine = true,
            label = {
                Text(
                    text = "Name",
                    color = Color.LightGray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(300.dp)
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 25.dp)
                .fillMaxWidth(),
            value = age, onValueChange = { age = it },
            shape = RoundedCornerShape(15.dp),
            singleLine = true,
            label = {
                Text(
                    text = "Age",
                    style = TextStyle(
                        color = Color.LightGray, textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.width(300.dp)
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 25.dp)
                .fillMaxWidth(),
            value = insuranceDetails, onValueChange = { insuranceDetails = it },
            singleLine = true,
            shape = RoundedCornerShape(15.dp),
            label = {
                Text(
                    text = "InsuranceDetails",
                    style = TextStyle(
                        color = Color.LightGray, textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.width(300.dp)
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 25.dp)
                .fillMaxWidth(),
            value = diseases, onValueChange = { diseases = it },
            singleLine = true,
            shape = RoundedCornerShape(15.dp),
            label = {
                Text(
                    text = "Diseases",
                    style = TextStyle(
                        color = Color.LightGray, textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.width(300.dp)
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )

        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 25.dp)
                .fillMaxWidth(),
            value = address, onValueChange = { address = it },
            shape = RoundedCornerShape(15.dp),
            singleLine = true,
            label = {
                Text(
                    text = "address",
                    style = TextStyle(
                        color = Color.LightGray, textAlign = TextAlign.Center
                    ),
                    modifier = Modifier.width(300.dp)
                )
            },

            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )

        OutlinedButton(
            onClick = { iExpanded = true },
        ) {
            when (gender) {
                "Male" -> {
                    Text(
                        text = "Male",
                        color = Color.Blue
                    )
                }

                "Female" -> {
                    Text(
                        text = "Female",
                        color = Color.Blue
                    )
                }

                else -> {
                    Text(
                        text = "Choose Role",
                        color = Color.Blue
                    )
                }
            }
            Icon(
                Icons.Default.ArrowDropDown,
                contentDescription = "Arrow Down"
            )
        }
        DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
            DropdownMenuItem(text = { Text("Male") },
                onClick = {
                    iExpanded = false
                    gender = "Male"

                })
            DropdownMenuItem(text = { Text("Female") },
                onClick = {
                    iExpanded = false
                    gender = "Female"

                })
        }
        Button(
            onClick = {
                if (name.isEmpty()) return@Button
                patientData(
                    name = name,
                    age = age,
                    insuranceDetails = insuranceDetails,
                    diseases = diseases,
                    adress = address,
                    gender = gender,
                    navController = navController
                )

            },
            modifier = Modifier
                .padding(start = 250.dp, end = 5.dp, top = 40.dp)
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
    }
}

fun patientData(
    name: String,
    age: String,
    insuranceDetails: String,
    diseases: String,
    adress: String,
    gender: String,
    navController: NavController
) {
    ApiManager.getService().PatientData(
        token = "Bearer ${SharedPerferenceHelper.getToken()}",
        DataPatient(
            id = SharedPerferenceHelper.getIdPatient()!!,
            name = name,
            age = age.toInt(),
            insuranceDetails = insuranceDetails,
            diseases = diseases,
            adress = adress,
            gender = gender
        )
    ).enqueue(object : Callback<DataPatientResponse> {
        override fun onResponse(
            call: Call<DataPatientResponse>,
            response: Response<DataPatientResponse>
        ) {
            if (response.isSuccessful){
                navController.navigate(route = "splash_patient/$name")
                SharedPerferenceHelper.saveName(name)
            }

        }

        override fun onFailure(call: Call<DataPatientResponse>, t: Throwable) {
            TODO("Not yet implemented")
        }

    })
}

@Preview(showBackground = true)
@Composable
fun Data() {
    PatientData(navController = rememberNavController())
}
