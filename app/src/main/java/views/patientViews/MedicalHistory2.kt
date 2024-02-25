package views.patientViews
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api

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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import views.FunctionsComposable.LocalImage


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MedicalHistory2(navController: NavController){
    val fontFamily = FontFamily(
        Font(R.font.wendyoneregular, FontWeight.Thin))

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        ){

        Box(modifier = Modifier
            .fillMaxWidth()
            .size(100.dp)
            .background(color = Color(0xFF2697FF))){
            Text(text = "Medical history",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 70.dp, top = 25.dp),

                color = Color(0xFFFFFFFF),
                textAlign = TextAlign.Start,
                fontFamily = fontFamily,
                fontSize = 26.sp)




            Box(modifier = Modifier

                .padding(10.dp)
                .clickable {
                    navController.navigate(route = "MedHis1")
                }) {
                LocalImage(
                    painter = painterResource(id = R.drawable.whitearrow), imageSize = 60.dp,
                    padding = 10.dp
                )
            }


        }

        var checkName by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 25.dp)
                .fillMaxWidth(),
            value = checkName, onValueChange = { checkName = it },
            shape = RoundedCornerShape(8.dp),
            label = {
                Text(
                    text = "check`s name",
                    color = Color.LightGray,
                    fontSize = 24.sp
                )
            },
            singleLine = true,
            textStyle = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.lightblue),
                focusedBorderColor = colorResource(id = R.color.lightblue)
            )
        )
        var checkDate by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 25.dp)
                .fillMaxWidth(),
            value = checkDate, onValueChange = { checkDate = it },
            shape = RoundedCornerShape(8.dp),
            label = {
                Text(
                    text = "check`s date",
                    color = Color.LightGray,
                    fontSize = 24.sp
                )
            },
            singleLine = true,
            textStyle = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.lightblue),
                focusedBorderColor = colorResource(id = R.color.lightblue)
            )
        )
        var DoctorName by remember { mutableStateOf(TextFieldValue("")) }
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 25.dp)
                .fillMaxWidth(),
            value = DoctorName, onValueChange = { DoctorName = it },
            shape = RoundedCornerShape(8.dp),
            label = {
                Text(
                    text = "doctor's name",
                    color = Color.LightGray,
                    fontSize = 24.sp
                )
            },
            singleLine = true,
            textStyle = TextStyle(
                color = Color.Black,
                fontWeight = FontWeight.Bold
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                unfocusedBorderColor = colorResource(id = R.color.lightblue),
                focusedBorderColor = colorResource(id = R.color.lightblue)
            )
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(10.dp)
        )

        Image(
            modifier = Modifier
                .clickable { }
                .fillMaxWidth()
                .size(120.dp),
            painter = painterResource(id = R.drawable.addfile),
            contentDescription ="adding file"
        )
        var selectedImageUri by remember {
            mutableStateOf<Uri?>(null)
        }

        val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.PickVisualMedia(),
            onResult = {uri -> selectedImageUri = uri}
        )
Box(modifier = Modifier.fillMaxWidth(),
    contentAlignment = Alignment.TopStart) {
    Image(
        modifier = Modifier
            .clickable {
                singlePhotoPickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            }
            .fillMaxWidth()
            .size(120.dp),
        painter = painterResource(id = R.drawable.addpicture),
        contentDescription = "adding picture"

    )

}


        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(10.dp)
        )

        Button(
            onClick = {
                      navController.navigate(route ="MH3Route/$checkName/$checkDate/$DoctorName")
            },
            modifier = Modifier
                .size(height = 60.dp, width = 280.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.lightblue)),
            shape = RoundedCornerShape(20.dp),

            ) {
            Text(
                text = "Next",
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }



    }


}



@Composable
@Preview(showBackground = true)
fun MedicalHistory2Preview(){
    MedicalHistory2(navController = rememberNavController())
}


