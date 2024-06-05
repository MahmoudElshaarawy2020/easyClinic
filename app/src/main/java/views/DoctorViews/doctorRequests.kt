package views.doctorViews

import android.icu.text.SimpleDateFormat
import android.icu.util.TimeZone
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import com.example.clinic.api.ApiManager
import com.example.clinic.api.models.patinets_requests.RequestItem
import com.example.clinic.api.models.patinets_requests.PatientsRequestsResponse
import com.example.clinic.shared.SharedPerferenceHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun Requests(navController: NavController) {
    var listOfRequests = remember {
        mutableStateListOf<RequestItem>()
    }
    val outputFormat = SimpleDateFormat("dd MMM yyyy hh:mm a")
    val isoFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    isoFormat.timeZone = TimeZone.getTimeZone("UTC")

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
                .size(90.dp)
                .background(color = Color(0xFF2697FF))
        ) {
            Text(
                text = "Requests",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp),

                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Center,
                fontFamily = fontFamily,
                fontSize = 35.sp
            )
        }

        LazyColumn {
            items(listOfRequests.size) {
                listOfRequests.forEachIndexed { index, requestItem ->
                    var date = isoFormat.parse(requestItem.appointmentDateTime)
                    var dateCreate = isoFormat.parse(requestItem.createdAt)
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
                                contentDescription = " photo",
                                modifier = Modifier
                                    .padding(start = 8.dp, top = 12.dp, bottom = 12.dp)
                                    .size(100.dp)
                                    .clip(RoundedCornerShape(10.dp)),
                            )
                            Column(
                                modifier = Modifier.weight(2f)
                            ) {
                                Text(
                                    modifier = Modifier.padding(
                                        start = 30.dp,
                                        bottom = 10.dp,
                                        top = 8.dp
                                    ),
                                    text = outputFormat.format(date),
                                    fontSize = 20.sp,
                                    fontFamily = fontFamily,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF01BCE9)
                                )
                                Text(
                                    modifier = Modifier.padding(start = 30.dp, bottom = 5.dp),
                                    text = "ID : ${requestItem.id}",
                                    fontSize = 16.sp,
                                )
                                Text(
                                    modifier = Modifier.padding(start = 30.dp, bottom = 8.dp),
                                    text = outputFormat.format(dateCreate),
                                    fontSize = 14.sp,
                                    color = Color.Gray,
                                )
                                Row {

                                    Button(
                                        onClick = { /*TODO*/ },
                                        modifier = Modifier.padding(
                                            start = 20.dp,
                                            end = 5.dp,
                                            bottom = 7.dp
                                        ),
                                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.light_red)),
                                    ) {
                                        Text(
                                            text = "Cancel",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 15.sp
                                        )

                                    }
                                    Button(
                                        onClick = { /*TODO*/ },
                                        modifier = Modifier.padding(
                                            start = 5.dp,
                                            end = 10.dp,
                                            bottom = 7.dp
                                        ),
                                        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.light_blue)),
                                    ) {
                                        Text(
                                            text = "Accept",
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 15.sp
                                        )


                                    }

                                }
                            }
                        }

                    }
                }
            }
        }
    }
    LaunchedEffect(key1 = Unit) {
        ApiManager.getService().getAllRequestsPatients(
            userId = SharedPerferenceHelper.getIdDoctor(),
            token = "Bearer ${SharedPerferenceHelper.getToken()}"
        ).enqueue(object : Callback<PatientsRequestsResponse> {
            override fun onResponse(
                call: Call<PatientsRequestsResponse>,
                response: Response<PatientsRequestsResponse>
            ) {
                if (response.isSuccessful)
                    listOfRequests.addAll(
                        response.body()?.appointments!!.filterNotNull().toMutableList()
                    )
            }

            override fun onFailure(call: Call<PatientsRequestsResponse>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }

        })
    }


}


@Preview(showBackground = true)
@Composable
fun drReequestsPrev() {
    Requests(navController = rememberNavController())
}
