package views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clinic.R

@Composable
fun PatientHome (){
    val fontFamily = FontFamily(
        Font(R.font.audiowideregular, FontWeight.Thin)
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFE9FAFF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Box (contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth()
            ){
            LocalImage(painter = painterResource(id = R.drawable.img_5), imageSize =310.dp, padding = 0.dp)
            Text(
                "Doctor\n" +
                        "suggestion",
                fontSize = 20.sp,
                color = Color(0xFF2697FF),
                fontFamily = fontFamily,
                modifier = Modifier.width(270.dp)
                    .padding(start = 140.dp, bottom = 30.dp),
                textAlign = TextAlign.Center
            )
        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
            ){
            Box(contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.padding( 6.dp)
                .clickable {  }) {
                LocalImage(painter = painterResource(id = R.drawable.img_6), imageSize =190.dp , padding = 0.dp )
                Text(
                    "Hospitals",
                    fontSize = 20.sp,
                    color = Color(0xFF2697FF),
                    fontFamily = fontFamily,
                    textAlign = TextAlign.Center
                )
            }
            Box(contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.padding( 6.dp)
                .clickable {  }) {
                LocalImage(painter = painterResource(id = R.drawable.img_7), imageSize =190.dp , padding = 0.dp )
                Text(
                    "Labs",
                    fontSize = 20.sp,
                    color = Color(0xFF2697FF),
                    fontFamily = fontFamily,
                    textAlign = TextAlign.Center
                )
            }

        }
        Row (modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Box(contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.padding( 6.dp)
                .clickable {  }) {
                LocalImage(painter = painterResource(id = R.drawable.img_8), imageSize =190.dp , padding = 0.dp )
                Text(
                    "Medicines",
                    fontSize = 20.sp,
                    color = Color(0xFF2697FF),
                    fontFamily = fontFamily,
                    textAlign = TextAlign.Center
                )
            }
            Box(contentAlignment = Alignment.BottomCenter,
                modifier = Modifier.padding( 6.dp)
                .clickable {  }) {
                LocalImage(painter = painterResource(id = R.drawable.img_9), imageSize =190.dp , padding = 0.dp )
                Text(
                    "Diet",
                    fontSize = 20.sp,
                    color = Color(0xFF2697FF),
                    fontFamily = fontFamily,
                    textAlign = TextAlign.Center
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewPatientHome(){
    PatientHome()
}