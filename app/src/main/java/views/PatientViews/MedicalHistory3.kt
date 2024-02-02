package views.PatientViews

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import views.FunctionsComposable.LocalImage

@Composable
fun MedicalHistory3(
    name1 :String?,
    name2 : String?,
    name3 : String?,
    navController : NavController
){
    val fontFamily = FontFamily(
        Font(R.font.wendyoneregular, FontWeight.Thin)
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(100.dp)
                .background(color = Color(0xFF2697FF))
        ) {
            Text(
                text = "Medical history",
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
                })
                {
                LocalImage(
                    painter = painterResource(id = R.drawable.whitearrow), imageSize = 60.dp,
                    padding = 10.dp
                )
            }


        }
        Text(
            modifier = Modifier
            .padding(10.dp),
            text = "Check's name : $name1",
            fontSize = 24.sp
        )
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = "Check's date : $name2",
            fontSize = 24.sp
        )
        Text(
            modifier = Modifier
                .padding(10.dp),
            text = "Doctor's name : $name3",
            fontSize = 24.sp
        )


    }

}

@Composable
@Preview(showBackground = true)
fun MedicalPreview(){
    MedicalHistory3(name1 = "",
        name2 = "",
        name3 = "",
        navController = rememberNavController())
}