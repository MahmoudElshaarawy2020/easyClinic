package views.patientViews

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import views.FunctionsComposable.LocalImage


@Composable
fun patientProfile(navController : NavController) {
    val fontFamily = FontFamily(
        Font(R.font.audiowideregular, FontWeight.Thin)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFE9FAFF)),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        LocalImage(
            painter = painterResource(id = R.drawable.userpic),
            imageSize = 150.dp,
            padding = 10.dp
        )
        var name by remember { mutableStateOf(TextFieldValue("")) }
        Box(
            modifier = Modifier
                .background(
                    color = Color(0xFF39A0FF), shape = RoundedCornerShape(25.dp)
                )
                .size(height = 50.dp, width = 260.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Name",
                color = Color.White,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
                .padding(vertical = 50.dp)

        ) {
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
                        painter = painterResource(id = R.drawable.img_3),
                        imageSize = 70.dp, padding = 0.dp

                    )
                    Text(
                        text = "My profile",
                        fontFamily = fontFamily,
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
                        .clickable {navController.navigate(route = "MedHis1"){
                            popUpTo("patient_profile"){
                                inclusive = true
                            }
                        } },
                    verticalAlignment = Alignment.CenterVertically

                ) {

                    LocalImage(
                        painter = painterResource(id = R.drawable.mhicon1),
                        imageSize = 70.dp, padding = 0.dp
                    )

                    Text(
                        text = "Medical history",
                        fontFamily = fontFamily,
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
                    LocalImage(
                        painter = painterResource(id = R.drawable.maicon1),
                        imageSize = 70.dp, padding = 0.dp

                    )
                    Text(
                        text = "Medical appointments",
                        fontFamily = fontFamily,
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
                            painter = painterResource(id = R.drawable.malicon1),
                            imageSize = 70.dp, padding = 0.dp

                        )
                        LocalImage(
                            painter = painterResource(id = R.drawable.alarmicon),
                            imageSize = 45.dp, padding = 0.dp
                        )
                    }
                    Text(
                        text = "Drugs alarm",
                        fontFamily = fontFamily,
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

            }
        }


    }

    Box(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            navController.navigate(route = "signIn_screen")
        }
        .padding(start = 330.dp, end = 10.dp, top = 15.dp),
        contentAlignment = Alignment.TopEnd
    ) {
        LocalImage(
            painter = painterResource(id = R.drawable.img_10),
            imageSize = 45.dp,
            padding = 0.dp
        )

    }
}

@Preview (showBackground = true)
@Composable
fun ShowPreview(){
    patientProfile(navController = rememberNavController())
}