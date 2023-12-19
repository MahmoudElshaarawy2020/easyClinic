package views

import android.graphics.MeshSpecification.Varying
import android.text.style.BackgroundColorSpan
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import java.lang.invoke.VarHandle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Government(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFE9FAFF)),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top =5.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Cairo",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Alexandria",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Giza",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Dakahlia",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Beheira",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Monufia",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Sharqia",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Gharbia",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Kafr El Sheikh",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Damiette",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Port Said",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Ismaillia",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Suez",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Red Sea",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "North Sinai",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "South Sinai",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Beni Suef",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Faiyuom",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Minya",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
        Button(
            onClick = {
                navController.navigate(route = "patient_home")
            },
            modifier = Modifier
                .padding(start = 25.dp, end = 25.dp, top = 2.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.white)),

            ) {
            Text(
                text = "Aswan",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }

}
}


@Preview(showBackground = true)
@Composable
fun  Governmen() {
    Government(navController = rememberNavController())
}