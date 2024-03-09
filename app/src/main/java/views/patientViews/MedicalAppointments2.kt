package views.patientViews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clinic.R
import views.FunctionsComposable.LocalImage

@Composable
fun MedicalAppointments2(){
    val fontFamily = FontFamily(
        Font(R.font.wendyoneregular, FontWeight.Thin)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFE9FAFF))
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(80.dp)
                .background(color = Color(0xFF2697FF))
        ) {
            Text(
                text = " Medical appointments",
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
        Text(
            text = "About visit",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 15.dp),
            textAlign = TextAlign.Center,
            color = Color.DarkGray,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,

        )
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, top = 10.dp)){
            Column {
            Text(
                "Specialist",
                modifier = Modifier
                    .padding(6.dp),
                color = Color.Gray,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                )
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)) {

                Image(
                    painter = painterResource(id = R.drawable.doctorhamza),
                    contentDescription = "doctor photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(70.dp)
                        .clip(CircleShape)
                )
                Column{
                    Text(
                        modifier = Modifier.padding(top = 7.dp, start = 10.dp),
                        text = dName,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2697FF)
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 10.dp, top = 5.dp),
                        text = department,
                        fontSize = 13.sp,
                    )
                }
            }
                Divider(modifier = Modifier
                    .padding(top = 15.dp,end = 15.dp),
                    color = Color(0xFF2697FF))

                Text(
                    "Date",
                    modifier = Modifier
                        .padding(10.dp),
                    color = Color.Gray,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp, top = 5.dp),
                    text = dateOfDay,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )

                Divider(modifier = Modifier
                    .padding(top = 10.dp,end = 15.dp),
                    color = Color(0xFF2697FF))

                Text(
                    "Address",
                    modifier = Modifier
                        .padding(10.dp),
                    color = Color.Gray,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                )



    Text(
        modifier = Modifier
            .padding(start = 10.dp, top = 5.dp),
        text = address,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
    )


                Divider(modifier = Modifier
                    .padding(top = 10.dp,end = 15.dp),
                    color = Color(0xFF2697FF))

                Text(
                    "Fee",
                    modifier = Modifier
                        .padding(10.dp),
                    color = Color.Gray,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    modifier = Modifier
                        .padding(start = 10.dp, top = 5.dp),
                    text = fee,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                )

                Divider(modifier = Modifier
                    .padding(top = 10.dp,end = 15.dp),
                    color = Color(0xFF2697FF))




            }


        }
        Spacer(modifier = Modifier.size(250.dp))
        Button(onClick = {},modifier = Modifier

            .size(height = 50.dp, width = 230.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.lightblue)),


            ) {
            Text(
                text = "Cancel visit",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }

}

@Composable
@Preview(showBackground = true)
fun MedicalAppointmentsPreview2(){
    MedicalAppointments2()
}