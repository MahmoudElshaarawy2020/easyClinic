package views.doctorViews

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import com.example.clinic.api.ApiManager
import com.example.clinic.api.models.confirmedpatient.Appointment
import com.example.clinic.api.models.confirmedpatient.ConfirmedPatientResponse
import com.example.clinic.models.PatientsConfirmed
import com.example.clinic.shared.SharedPerferenceHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import views.FunctionsComposable.LocalImage

val patientName: String = "Patient name"
val ID: String = "213406"
val date: String = "friday - 23Dec"


val fontFamily = FontFamily(
    Font(R.font.merienda_one, FontWeight.Thin)
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Homedoctor(navController : NavController) {
    var listofConfirmedPatients = remember {
        mutableStateListOf<Appointment>()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFE9FAFF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_11),
            contentDescription = "doctor",
            modifier = Modifier
                .fillMaxWidth()
                .size(170.dp)
        )
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFF486A89), shape = RoundedCornerShape(30.dp)
                )
                .size(height = 40.dp, width = 200.dp), contentAlignment = Alignment.Center
        ) {
            Text(
                text = "My Patients",
                color = Color.White,
                fontFamily = fontFamily,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal
            )

        }


        var text by remember { mutableStateOf(TextFieldValue("")) }
//        OutlinedTextField(
//            modifier = Modifier
//                .padding(start = 50.dp, end = 50.dp, top = 0.dp)
//                .fillMaxWidth()
//                .background(color = Color.White),
//            value = text,
//            onValueChange = { text = it },
//            shape = RoundedCornerShape(50.dp),
//            label = {
//                Text(
//                    text = "Search Name or ID", color = Color.LightGray
//                )
//            },
//            leadingIcon = {
//                Icon(
//                    imageVector = Icons.Filled.Search, contentDescription = "Email icon",
//                )
//
//            },
//            singleLine = true,
//            textStyle = TextStyle(
//                color = Color.Black, fontWeight = FontWeight.Bold
//            ),
//            colors = TextFieldDefaults.outlinedTextFieldColors(
//                unfocusedBorderColor = colorResource(id = R.color.light_blue),
//                focusedBorderColor = colorResource(id = R.color.light_blue)
//            )
//        )
        Spacer(modifier = Modifier.padding(15.dp))
        LazyColumn{
            items(listofConfirmedPatients.size) { index->
                ElevatedCard(
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 20.dp
                    ),
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 13.dp, start = 10.dp, end = 10.dp)


                ) {

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.img_2),
                            contentDescription = "patient photo",
                            modifier = Modifier
                                .padding(start = 8.dp, top = 12.dp, bottom = 12.dp)
                                .size(100.dp)
                                .clip(RoundedCornerShape(10.dp)),
                        )
                        Column(
                            modifier = Modifier.weight(2f)
                        ) {
                            Text(
                                modifier = Modifier.padding(start = 30.dp, bottom = 15.dp),
                                text = listofConfirmedPatients[index].patientId?.name ?: "Test",
                                fontSize = 20.sp,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF01BCE9)
                            )
                            Text(
                                modifier = Modifier.padding(start = 30.dp, bottom = 5.dp),
                                text = "Age : ${listofConfirmedPatients[index].patientId?.age}",
                                fontSize = 16.sp,
                            )
                            Text(
                                modifier = Modifier.padding(start = 30.dp),
                                text = "Address :${listofConfirmedPatients[index].patientId?.adress}",
                                fontSize = 14.sp,
                                color = Color.Gray,
                            )
                            Text(
                                modifier = Modifier.padding(start = 30.dp),
                                text = "Gender : ${listofConfirmedPatients[index].patientId?.gender}",
                                fontSize = 14.sp,
                                color = Color.Gray,
                            )

                        }
                    }


                }
            }
        }


//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = 5.dp, end = 5.dp, bottom = 10.dp, top = 50.dp)
//                .background(
//                    color = Color(0xFF39A0FF),
//                    shape = RoundedCornerShape(25.dp),
//
//                    )
//        ) {
//            Box(
//                modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
//            ) {
//                LocalImage(
//                    painter = painterResource(id = R.drawable.img_12),
//                    imageSize = 70.dp,
//                    padding = 0.dp,
//                )
//            }
//            Box(
//                modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
//            ) {
//                LocalImage(
//                    painter = painterResource(id = R.drawable.homeicon),
//                    imageSize = 90.dp,
//                    padding = 0.dp
//                )
//            }
//            Box(
//                modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
//            ) {
//                LocalImage(
//                    painter = painterResource(id = R.drawable.proficon),
//                    imageSize = 55.dp,
//                    padding = 0.dp
//                )
//            }
//
//        }

    }
    LaunchedEffect(key1 = Unit) {
        ApiManager.getService().patientsConfirmed(
            token = "Bearer ${SharedPerferenceHelper.getToken()}",
            PatientsConfirmed(doctorId = SharedPerferenceHelper.getIdDoctor())
        ).enqueue(object : Callback<ConfirmedPatientResponse>{
            override fun onResponse(
                call: Call<ConfirmedPatientResponse>,
                response: Response<ConfirmedPatientResponse>
            ) {
                if(response.isSuccessful){
                    listofConfirmedPatients.addAll(
                        response.body()!!.appointments!!.filterNotNull().toMutableList()
                    )
                    Log.e("TAG", "onResponse: $response", )
                }
            }

            override fun onFailure(call: Call<ConfirmedPatientResponse>, t: Throwable) {
                Log.e("TAG", "onFailure: $t", )
            }

        })
        
    }
}
@Composable
@Preview(showBackground = true)
fun Doctor(){
    Homedoctor(navController = rememberNavController())
}