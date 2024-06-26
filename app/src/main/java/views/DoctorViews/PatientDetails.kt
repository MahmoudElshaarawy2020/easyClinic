package views.DoctorViews

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.models.data.CheckItem
import com.example.clinic.shared.SharedPerferenceHelper

@Composable
fun PatientDetails(checks: List<CheckItem>, navController: NavController) {
    val name: String = ""
    val age: String = ""
    val phoneNumber: String = ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE9FAFF)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = { Text("Patient details") },
            backgroundColor = Color(0xFF0480C4),
            contentColor = Color.White,
            elevation = 8.dp
        )

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .border(
                border = BorderStroke(width = 2.dp, color = Color(0xFF018786)),
                shape = RoundedCornerShape(20)
            )) {
            Text(text = "Name : ${SharedPerferenceHelper.getClickedPatientName()}",
                fontSize = 20.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(8.dp))

        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .border(
                border = BorderStroke(width = 2.dp, color = Color(0xFF018786)),
                shape = RoundedCornerShape(20)
            )) {
            Text(text = "Age: ${SharedPerferenceHelper.getClickedPatientAge()}",
                fontSize = 20.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(8.dp))

        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .border(
                border = BorderStroke(width = 2.dp, color = Color(0xFF018786)),
                shape = RoundedCornerShape(20)
            )) {
            Text(text = "Phone Number: ${SharedPerferenceHelper.getClickedPatientPhone()}",
                fontSize = 16.sp,
                color = Color.DarkGray,
                modifier = Modifier.padding(8.dp))

        }

        LazyVerticalGrid(
            GridCells.Fixed(2), modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .border(
                    border = BorderStroke(width = 2.dp, color = Color(0xFF018786)),
                    shape = RoundedCornerShape(10)
                )){
            items(checks.size) {
                checkItem(checks)
            }
        }

    }
}

@Composable
fun checkItem(checks: List<CheckItem>){
    val checkName: String = ""
    Column(modifier = Modifier
        .background(color = Color.LightGray)
        .border(
            border = BorderStroke(
                width = 2.dp,
                color = Color(0xFF018786)
            ),
            shape = RoundedCornerShape(20)
        )){

        Text("Check Name: $checkName",
            fontSize = 20.sp,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(8.dp)

        )

    }
}

@Preview(showBackground = true)
@Composable
private fun prevcheck() {
    checkItem(checks = listOf())
    
}
@Preview(showBackground = true)
@Composable
private fun pre() {
    PatientDetails(checks = listOf(), navController = rememberNavController())
}