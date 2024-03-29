package views.patientViews
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrugsAlarm0(navController: NavController){
    val fontFamily = FontFamily(
        Font(R.font.wendyoneregular, FontWeight.Thin))

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFE9FAFF)),
    ){


        Box(modifier = Modifier
            .fillMaxWidth()
            .size(100.dp)
            .background(color = Color(0xFF2697FF))){
            Text(text = "Drugs alarm",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 70.dp, top = 25.dp),

                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Start,
                fontFamily = fontFamily,
                fontSize = 26.sp)


            Box(modifier = Modifier

                .padding(10.dp)
                .clickable {}
            ) {
                LocalImage(
                    painter = painterResource(id = R.drawable.whitearrow), imageSize = 60.dp,
                    padding = 10.dp
                )
            }
        }
        Column(modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .size(50.dp))
            LocalImage(painter = painterResource(id = R.drawable.drugscup),
                imageSize = 150.dp,
                padding =0.dp )
            Text(modifier = Modifier.fillMaxWidth(),
                text = "please add the drugs \n you are taking......\n " +
                        "and we will remind you \n of their time ",
                fontSize = 24.sp,
                color = Color(0xFF646E82),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .size(20.dp))
            Box(modifier = Modifier
                .clickable { navController.navigate(route = "MedHis2") }){

                Image(
                    modifier = Modifier
                        .clickable { }
                        .fillMaxWidth()
                        .size(120.dp),
                    painter = painterResource(id = R.drawable.addalarm),
                    contentDescription ="adding alarm"
                )
            }
        }


    }

}



@Composable
@Preview(showBackground = true)
fun DrugsAlarm0Prview(){
    DrugsAlarm0(navController = rememberNavController())
}
