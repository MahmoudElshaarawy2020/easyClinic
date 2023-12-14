package views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clinic.R

@Composable
fun SplashForPatient(name : String?){
    val fontFamily = FontFamily(
        Font(R.font.merienda_one, FontWeight.Thin)
    )
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Welcome",
            fontSize = 60.sp,
            fontFamily = fontFamily,
            color = Color(0xFF499DEB),
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.size(20.dp))
        Text(
            text = "Mr.$name",
            textAlign = TextAlign.Center,
            fontSize = 60.sp,
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0075FF),
        )

    }
}

@Preview(showBackground =  true)
@Composable
fun previewPatient(){
    SplashForPatient(name = "")
}
