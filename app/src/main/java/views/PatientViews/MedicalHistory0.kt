package views.PatientViews

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
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
fun MedicalHistory0(navController: NavController) {
    val fontFamily = FontFamily(
        Font(R.font.wendyoneregular, FontWeight.Thin)
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFE9FAFF))) {

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

                }) {
                LocalImage(
                    painter = painterResource(id = R.drawable.whitearrow), imageSize = 60.dp,
                    padding = 10.dp
                )
            }
        }
        Column {


            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                thickness = 0.8.dp,
                color = Color(0xFF486A89)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically

            ) {

                LocalImage(
                    painter = painterResource(id = R.drawable.medicalcheckups),
                    imageSize = 70.dp, padding = 0.dp

                )
                Text(
                    text = "medical check-ups",
                    fontSize = 25.sp,
                    color = Color(0xFF1683E7),
                    modifier = Modifier.padding(start = 18.dp)


                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {

                    LocalImage(
                        painter = painterResource(id = R.drawable.img_4),
                        imageSize = 40.dp, padding = 0.dp

                    )
                }


            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                thickness = 0.8.dp,
                color = Color(0xFF486A89)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .clickable { },
                verticalAlignment = Alignment.CenterVertically

            ) {
                Box(contentAlignment = Alignment.Center) {

                    LocalImage(
                        painter = painterResource(id = R.drawable.dricon1),
                        imageSize = 70.dp, padding = 0.dp

                    )
                    LocalImage(
                        painter = painterResource(id = R.drawable.diseases),
                        imageSize = 45.dp, padding = 0.dp
                    )
                }
                Text(
                    text = "diseases",
                    fontSize = 25.sp,
                    color = Color(0xFF1683E7),
                    modifier = Modifier.padding(start = 18.dp)


                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {

                    LocalImage(
                        painter = painterResource(id = R.drawable.img_4),
                        imageSize = 40.dp, padding = 0.dp

                    )
                }

            }


        }

    }
}


@Composable
@Preview(showBackground = true)
fun MedicalHistory0Prview(){
    MedicalHistory0(navController = rememberNavController())
}
