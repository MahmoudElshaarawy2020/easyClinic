package views.patientViews

import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import com.example.clinic.api.ApiManager
import com.example.clinic.api.models.createappoint.CreateAppointmentResponse
import com.example.clinic.api.models.patient_doctor_data.DoctorsItem
import com.example.clinic.models.data.CreateAppointment
import com.example.clinic.navigation.navigationModel.Screens
import com.example.clinic.shared.SharedPerferenceHelper
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import views.FunctionsComposable.LocalImage
import kotlin.math.log

val dateOfDay = "Friday - 23DEC"

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Booking(doctorsItem: DoctorsItem, navController: NavController) {
    val fontFamily = FontFamily(
        Font(R.font.wendyoneregular, FontWeight.Thin)
    )

//    SharedPerferenceHelper.saveDoctorName(doctorsItem.name!!)
//    SharedPerferenceHelper.saveDoctorPrice(doctorsItem.price!!)
//    SharedPerferenceHelper.saveDoctorAddress(doctorsItem.address!!)
//    SharedPerferenceHelper.saveDoctorExperience(doctorsItem.experience!!)
//    SharedPerferenceHelper.saveDoctorPhone(doctorsItem.phone!!)

    val calendarState = rememberSheetState()

    CalendarDialog(
        state = calendarState,
        config = CalendarConfig(
            monthSelection = true
        ),
        selection = CalendarSelection.Date { date ->
            Log.d("SelectedDate", "$date")

        }
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0XFFE9FAFF))
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(100.dp)
                .background(color = Color(0xFF2697FF))
        ) {
            Text(
                text = "Booking",
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
                    navController.navigate(route = "patient_home")

                }) {
                LocalImage(
                    painter = painterResource(id = R.drawable.whitearrow), imageSize = 60.dp,
                    padding = 10.dp
                )
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 80.dp)
            .height(250.dp)

    ) {
        Image(
            painter = painterResource(id = R.drawable.doctorhamza), contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
        )

    }

    Box(
        modifier = Modifier
            .padding(top = 310.dp)
            .height(500.dp)
            .fillMaxWidth()
            .background(
                color = Color(0XFFE9FAFF),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
            ),
    ) {
        Column(modifier = Modifier.padding(start = 50.dp, top = 85.dp, end = 50.dp)) {
//            Row{
//                Icon(imageVector = Icons.Filled.Notifications, contentDescription = "",
//                    tint = colorResource(id = R.color.light_blue))
//                Text(text = "$timeFrom - $timeTo", fontSize = 17.sp,fontWeight = FontWeight.Bold)
//            }
            Row(
                modifier = Modifier
                    .padding(top = 5.dp, bottom = 5.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Edit, contentDescription = "",
                    tint = colorResource(id = R.color.light_blue)
                )
                Text(
                    text = "  ${SharedPerferenceHelper.getDoctorPrice()}",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Row{
                Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "",
                    tint = colorResource(id = R.color.light_blue))
                Text(text = "  ${SharedPerferenceHelper.getDoctorAddress()}", fontSize = 17.sp,fontWeight = FontWeight.Bold)
            }

            Divider(
                modifier = Modifier.padding(top = 17.dp, bottom = 10.dp),
                color = colorResource(id = R.color.light_blue)
            )

            Row {
                Icon(
                    imageVector = Icons.Filled.Call, contentDescription = "",
                    tint = colorResource(id = R.color.light_blue), modifier = Modifier.size(32.dp)
                )
                Text(text =  SharedPerferenceHelper.getDoctorPhone()!!, fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }

            Divider(
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                color = colorResource(id = R.color.light_blue)
            )

            Row {
                Icon(
                    imageVector = Icons.Filled.Email, contentDescription = "",
                    tint = colorResource(id = R.color.light_blue), modifier = Modifier.size(32.dp)
                )
                Text(text = "  ${ SharedPerferenceHelper.getDoctorExperience()}", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            Divider(
                modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                color = colorResource(id = R.color.light_blue)
            )

            Row(modifier = Modifier.clickable { calendarState.show() }) {
                Icon(
                    imageVector = Icons.Filled.DateRange, contentDescription = "",
                    tint = colorResource(id = R.color.light_blue), modifier = Modifier.size(32.dp)
                )
                Text(
                    text = "Choose Time", fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    textDecoration = TextDecoration.Underline, color = Color.Gray,
                    modifier = Modifier.clickable {
                        navController.navigate(Screens.ChooseTime.route)
                    }
                )
            }

            Button(
                onClick = {
                    createAppointment(navController = navController)
                },
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp, top = 20.dp)
                    .size(height = 50.dp, width = 300.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.light_blue))

            ) {
                Text(
                    text = "Book now",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }

        }

    }

    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxWidth()
            .padding(top = 310.dp, start = 50.dp, end = 50.dp)
            .background(
                color = Color(0xFF2697FF),
                shape = RoundedCornerShape(25.dp)

            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 10.dp)
        ) {

            Text(
                text = SharedPerferenceHelper.getDoctorName()!!, fontSize = 32.sp,
                fontWeight = FontWeight.Bold, color = Color.White
            )
//            Text(
//                text = doctorsItem.qualifications ?: "", fontSize = 18.sp,
//                fontWeight = FontWeight.Bold, color = Color.Black
//            )
        }

    }

}

fun createAppointment(navController: NavController){
    ApiManager.getService().createAppointment(
        token = "Bearer ${SharedPerferenceHelper.getToken()}",
        CreateAppointment(patientId = SharedPerferenceHelper.getIdPatient(), appointmentId = SharedPerferenceHelper.getNewIdAppointment())
    ).enqueue(object :Callback<CreateAppointmentResponse>{
        override fun onResponse(
            call: Call<CreateAppointmentResponse>,
            response: Response<CreateAppointmentResponse>
        ) {
            if(response.isSuccessful)
                navController.navigate("patient_home")
            Log.e("TAG", "onResponse: ${response}", )
        }

        override fun onFailure(call: Call<CreateAppointmentResponse>, t: Throwable) {
            Log.e("TAG", "onFailure: $t", )
        }

    })
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
@Preview(showBackground = true)
fun BookingPreview() {
    Booking(DoctorsItem(), navController = rememberNavController())
}