package views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R

@Composable
fun ChooseRole(navController: NavController) {
    val colors = listOf(Color(0xFF1FA1F7), Color(0xFFA4CDE8), Color(0xFFECEBF0))

    Box(

        modifier = Modifier
            .background(brush = Brush.verticalGradient(colors))
            .fillMaxSize()

    ) {
        ImageBackground(painter = painterResource(id = R.drawable.background1st))

    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(modifier = Modifier
            .background(color = Color(0xFF0480C4)
            , shape = RoundedCornerShape(topEnd = 25.dp)
            )){
            Text(text = " LET'S START...  ", fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                contentAlignment = Alignment.Center

            ) {
                LocalImage(
                    painter = painterResource(id = R.drawable.img_1),
                    imageSize = 180.dp,
                    padding = 0.dp
                )
                Button(
                    onClick = {
                        navController.navigate(route = "doctor_data")
                    },
                    modifier = Modifier
                        .padding(top = 280.dp)
                        .size(height = 45.dp, width = 124.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.lightblue))
                ) {
                    Text(text = "Doctor", fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, fontSize = 20.sp)

                }
            }
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 30.dp)
            ) {
                LocalImage(
                    painter = painterResource(id = R.drawable.img_2),
                    imageSize = 180.dp,
                    padding = 0.dp
                )
                Button(
                    onClick = {
                        navController.navigate(route = "patient_data")
                    },
                    modifier = Modifier
                        .padding(top = 280.dp, end = 30.dp)
                        .size(height = 45.dp, width = 124.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.lightblue))
                ) {
                    Text(text = "Patient", fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, fontSize = 20.sp)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LinearBackgroundPreview() {
    ChooseRole(navController = rememberNavController())
}



