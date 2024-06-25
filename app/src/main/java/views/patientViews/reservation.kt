package views.patientViews

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import com.example.clinic.api.ApiManager
import com.example.clinic.api.models.patient_doctor_data.DoctorsItem
import com.example.clinic.api.models.patient_doctor_data.PatientDoctorDataResponse
import com.example.clinic.navigation.navigationModel.Screens
import com.example.clinic.shared.SharedPerferenceHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import views.FunctionsComposable.LocalImage

val doctorEmail = "hamza@gmail.com"
val doctorPhone = "01018490780"
val dName = "Dr.Hamza Tariq"
val department = "Senior Surgeon"
val timeFrom = "10:30"
val timeTo = "3:30"
val fee = "300 L.E"
val address = "Tanta,stad st."


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun reservation(navController: NavController, function: (DoctorsItem) -> Unit) {
    var listOfDoctors = remember {
        mutableStateListOf<DoctorsItem>()
    }

    val fontFamily = FontFamily(
        Font(R.font.wendyoneregular, FontWeight.Thin)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFE9FAFF))
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(100.dp)
                .background(color = Color(0xFF2697FF))
        ) {
            Text(
                text = "Reservation",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 70.dp, top = 25.dp),

                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Start,
                fontFamily = fontFamily,
                fontSize = 26.sp
            )


            Box(modifier = Modifier

                .padding(10.dp)
                .clickable {

                }) {
                LocalImage(
                    painter = painterResource(id = R.drawable.whitearrow), imageSize = 60.dp,
                    padding = 10.dp
                )
            }
        }
    }
    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 70.dp)
    ) {
        var doctorName by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 50.dp, end = 50.dp, top = 0.dp)
                .fillMaxWidth(),
            value = doctorName, onValueChange = { doctorName = it },
            shape = RoundedCornerShape(50.dp),
            label = {
                Text(
                    text = "Search doctor's name",
                    color = Color.LightGray
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search, contentDescription = "Email icon",
                )

            },
            singleLine = true,
            textStyle = TextStyle(
                color = Color.Black,
                fontWeight = Bold
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color.White,
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )
        LazyColumn {
            items(listOfDoctors.size) { position ->
                listOfDoctors.forEachIndexed { index, doctorItem ->
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 20.dp
                        ),
                        colors = CardDefaults.cardColors(containerColor = Color.White),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 60.dp, start = 10.dp)
                            .size(100.dp)
                            .clickable {
                                function(listOfDoctors[index])
                                SharedPerferenceHelper.saveTokenAppointment(
                                    listOfDoctors[index].token ?: ""
                                )
                                SharedPerferenceHelper.saveIdAppointment(
                                    listOfDoctors[index].id ?: ""
                                )
                                SharedPerferenceHelper.saveDoctorName(listOfDoctors[index].name!!)
                                SharedPerferenceHelper.saveDoctorPhone(listOfDoctors[index].phone!!)
                                SharedPerferenceHelper.saveDoctorPrice(listOfDoctors[index].price!!)
                                SharedPerferenceHelper.saveDoctorAddress(listOfDoctors[index].address!!)
                                SharedPerferenceHelper.saveDoctorExperience(listOfDoctors[index].experience!!)
                            }
                    ) {

                        Row() {
                            Image(
                                painter = painterResource(id = R.drawable.doctorhamza),
                                contentDescription = "doctor photo",
                                modifier = Modifier
                                    .padding(start = 8.dp, top = 12.dp, bottom = 12.dp)
                                    .size(100.dp)
                                    .clip(RoundedCornerShape(10.dp)),
                            )
                            Column(
                                modifier = Modifier
                                    .weight(2f)
                                    .verticalScroll(rememberScrollState())
                            )
                            {
                                Text(
                                    modifier = Modifier.padding(top = 7.dp, start = 10.dp),
                                    text = doctorItem.userName!!,
                                    fontSize = 17.sp,
                                    fontWeight = Bold,
                                    color = Color(0xFF2697FF)
                                )
                                Text(
                                    modifier = Modifier.padding(start = 10.dp),
                                    text = doctorItem.status!!,
                                    fontSize = 13.sp,
                                )
                                Text(
                                    modifier = Modifier.padding(start = 10.dp),
                                    text = doctorItem.phone!!,
                                    fontSize = 10.sp,
                                    color = Color.Gray,
                                )
                                Text(
                                    modifier = Modifier.padding(start = 10.dp),
                                    text = doctorItem.gender!!,
                                    fontSize = 10.sp,
                                    color = Color.Gray
                                )
                                Text(
                                    modifier = Modifier.padding(start = 10.dp),
                                    text = doctorItem.role ?: "Doctor",
                                    fontSize = 10.sp,
                                    color = Color.Gray
                                )

                            }
                        }

                    }
                }
            }
        }
    }
    LaunchedEffect(Unit) {
        ApiManager.getService()
            .getAllDoctorAvaliable("Bearer ${SharedPerferenceHelper.getToken()}")
            .enqueue(object : Callback<PatientDoctorDataResponse> {
                override fun onResponse(
                    call: Call<PatientDoctorDataResponse>,
                    response: Response<PatientDoctorDataResponse>
                ) {
                    if (response.body()!!.doctors!!.isNotEmpty()) {
                        listOfDoctors.addAll(
                            response.body()!!.doctors!!.filterNotNull().toMutableList()
                        )
                    }
                    Log.e("TAG", "reservation: ${listOfDoctors.size}")
                    Log.e("TAG", "reservation: ${listOfDoctors}")
                }

                override fun onFailure(call: Call<PatientDoctorDataResponse>, t: Throwable) {
                    Log.e("TAG", "onFailure: $t")
                    Log.e("TAG", "reservation: ${listOfDoctors.size}")
                    Log.e("TAG", "reservation: ${listOfDoctors}")
                }

            })
    }
}


@Composable
@Preview(showBackground = true)
fun reservationPreview() {
    reservation(navController = rememberNavController(), function = {

    })
}

