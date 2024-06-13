package views.patientViews

import android.icu.text.SimpleDateFormat
import android.icu.util.TimeZone
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.api.ApiManager
import com.example.clinic.api.models.getappintment.AppointmentsItem
import com.example.clinic.api.models.getappintment.getAppointmentResponse
import com.example.clinic.shared.SharedPerferenceHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ChooseTime(navController: NavController) {
    var listOfAppointment = remember {
        mutableStateListOf<AppointmentsItem>()
    }
    val outputFormat = SimpleDateFormat("dd MMM yyyy hh:mm a")
    val isoFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    isoFormat.timeZone = TimeZone.getTimeZone("UTC")
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Pick a time") },
            backgroundColor = Color(0xFF0480C4),
            contentColor = Color.White,
            elevation = 8.dp
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(listOfAppointment.size) {
                listOfAppointment.forEachIndexed { index, appointmentsItem ->
                    var date = isoFormat.parse(appointmentsItem.appointmentDateTime)
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

                            }
                    ) {
                        Text(
                            modifier = Modifier.padding(top = 7.dp, start = 10.dp),
                            text = outputFormat.format(date),
                            fontSize = 17.sp,
                            fontWeight = Bold,
                            color = Color(0xFF2697FF)
                        )
                    }
                }
            }

        }
    }
    LaunchedEffect(key1 = Unit) {
        ApiManager.getService().getAppointment(
            doctorId = SharedPerferenceHelper.getIdAppointment(),
            token = "Bearer ${SharedPerferenceHelper.getTokenAppointment()}"
        ).enqueue(object : Callback<getAppointmentResponse> {
            override fun onResponse(
                call: Call<getAppointmentResponse>,
                response: Response<getAppointmentResponse>
            ) {
                if (response.isSuccessful && response.body()!!.appointments!!.isNotEmpty()) {
                    listOfAppointment.addAll(
                        response.body()?.appointments?.filterNotNull()!!.toMutableList()
                    )
                }
            }

            override fun onFailure(call: Call<getAppointmentResponse>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }

        })

    }
}

@Composable
@Preview(showBackground = true)
fun PreviewTime() {
    ChooseTime(navController = rememberNavController())
}