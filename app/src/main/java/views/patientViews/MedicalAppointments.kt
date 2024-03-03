package views.patientViews

import android.content.ClipData.Item
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clinic.R
import views.FunctionsComposable.LocalImage


@Composable
fun  MedicalAppointments(){

    val fontFamily = FontFamily(
        Font(R.font.wendyoneregular, FontWeight.Thin)
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFE9FAFF))){

        Box(modifier = Modifier
            .fillMaxWidth()
            .size(80.dp)
            .background(color = Color(0xFF2697FF))){
            Text(text = " Medical appointments",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 70.dp, top = 25.dp),

                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Start,
                fontFamily = fontFamily,
                fontSize = 26.sp)


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
    LazyColumn(modifier = Modifier.fillMaxSize()
    ){
items(5){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp, start = 10.dp, end = 10.dp)
            .size(100.dp)



    ) {

        Row{
            Image(painter = painterResource(id = R.drawable.doctorhamza),
                contentDescription = "doctor photo",
                modifier = Modifier
                    .padding(start = 8.dp, top = 12.dp, bottom = 12.dp)
                    .size(100.dp)
                    .clip(RoundedCornerShape(10.dp)),
            )
            Column(modifier = Modifier
                .weight(2f)) {
                Text(
                    modifier = Modifier .padding(top = 7.dp,start = 10.dp),
                    text = dName,
                    fontSize = 17.sp,
                    fontWeight = Bold,
                    color = Color(0xFF2697FF))
                Text(
                    modifier = Modifier .padding(start = 10.dp),
                    text =  department,
                    fontSize = 13.sp,
                )
                Text(
                    modifier = Modifier .padding(start = 10.dp),
                    text =  "$timeFrom - $timeTo",
                    fontSize = 10.sp,
                    color = Color.Gray,
                )
                Text(
                    modifier = Modifier .padding(start = 10.dp),
                    text =  "fee : $fee L.E",
                    fontSize = 10.sp,
                    color = Color.Gray
                )
                Text(
                    modifier = Modifier .padding(start = 10.dp),
                    text =  "address : $address",
                    fontSize = 10.sp,
                    color = Color.Gray
                )

            }
        }


    }
}
        }
  }







@Composable
@Preview(showBackground = true)
fun MedicalAppointmentsPreview(){
   MedicalAppointments()
}