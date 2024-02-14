package views.PatientViews

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import views.FunctionsComposable.LocalImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Booking(navController: NavController) {
    val fontFamily = FontFamily(
        Font(R.font.wendyoneregular, FontWeight.Thin)


    )
    var date = "Friday - 23DEC"

    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(100.dp)
                .background(color = Color(0xFF2697FF))
        ) {
            Text(
                text = "Booking",
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
                    navController.navigate(route = "patient_home")

                }) {
                LocalImage(
                    painter = painterResource(id = R.drawable.whitearrow), imageSize = 60.dp,
                    padding = 10.dp
                )
            }
        }
}

    Box (modifier = Modifier
        .fillMaxWidth()
        .padding(top = 80.dp)
        .height(290.dp)

    ){
        Image(painter = painterResource(id = R.drawable.doctorhamza), contentDescription ="",
            modifier = Modifier
                .fillMaxSize()
        )

    }

    Box (modifier = Modifier
        .padding(top = 370.dp)
        .height(500.dp)
        .fillMaxWidth()
        .background(
            color = Color(0XFFE9FAFF),
            shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
        )
    ,
    ){
        Column (modifier = Modifier .padding(start = 50.dp, top = 70.dp, end = 50.dp)){
            Row() {
                Icon(imageVector = Icons.Filled.Notifications, contentDescription = "",
                    tint = colorResource(id = R.color.lightblue))
                Text(text = "$timeFrom - $timeTo", fontSize = 17.sp,fontWeight = FontWeight.Bold)
            }
            Row() {
                Icon(imageVector = Icons.Filled.Edit, contentDescription = "",
                    tint = colorResource(id = R.color.lightblue))
                Text(text = "Fee:$fee LE", fontSize = 17.sp,fontWeight = FontWeight.Bold)
            }
            Row() {
                Icon(imageVector = Icons.Filled.LocationOn, contentDescription = "",
                    tint = colorResource(id = R.color.lightblue))
                Text(text = "$address", fontSize = 17.sp,fontWeight = FontWeight.Bold)
            }

            Divider(modifier = Modifier.padding(top = 20.dp, bottom = 10.dp),
                color =colorResource(id = R.color.lightblue) )

            Row() {
                Icon(imageVector = Icons.Filled.Call, contentDescription = "",
                    tint = colorResource(id = R.color.lightblue), modifier = Modifier.size(32.dp))
                Text(text = "  $doctorPhone", fontSize = 22.sp, fontWeight = FontWeight.Bold)
            }

            Divider(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                color =colorResource(id = R.color.lightblue) )

            Row() {
                Icon(imageVector = Icons.Filled.Email, contentDescription = "",
                    tint = colorResource(id = R.color.lightblue), modifier = Modifier.size(32.dp))
                Text(text = "  $doctorEmail", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            }

            Divider(modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                color =colorResource(id = R.color.lightblue) )

            Row(modifier = Modifier .clickable {  }) {
                Icon(imageVector = Icons.Filled.DateRange, contentDescription = "",
                    tint = colorResource(id = R.color.lightblue), modifier = Modifier.size(32.dp))
                Text(text = "  $date", fontSize = 20.sp, fontWeight = FontWeight.Bold
                , color = Color.Gray)
            }

            Button(onClick = {},
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp, top = 30.dp)
                    .size(height = 50.dp, width = 300.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.lightblue))

            ) {
                Text(
                    text = "Book now",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
                
            }

        }

    Box( contentAlignment = Alignment.Center
        ,modifier = Modifier
            .fillMaxWidth()
            .padding(top = 360.dp, start = 50.dp, end = 50.dp)
            .background(
                color = Color(0xFF2697FF),
                shape = RoundedCornerShape(25.dp)

            )){
        Column(verticalArrangement = Arrangement.Center
        , horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(bottom = 10.dp)) {

            Text(text = " $dName", fontSize = 32.sp,
                fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = " $department", fontSize = 18.sp,
                fontWeight = FontWeight.Bold, color = Color.Black)
        }

    }

    }

    @Composable
    @Preview(showBackground = true)
    fun BookingPreview(){
        Booking(navController = rememberNavController())
    }