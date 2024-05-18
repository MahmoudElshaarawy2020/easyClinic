package views.patientViews.doctorPrediction

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AiResults() {
    val skinCancer : String = ""
    var otherCancers : String = ""
    var depression : String = ""
    var arthritis : String = ""
    var diabetes : String = ""
    var heartDisease : String = ""

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = { Text("AI Prediction") },
            backgroundColor = Color(0xFF0480C4),
            contentColor = Color.White,
            elevation = 8.dp
        )

    Text(text = "Prediction Results",
        modifier = Modifier.padding(16.dp),
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF0480C4))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .border(
                        border = BorderStroke(width = 2.dp, color = Color(0xFF018786)),
                        shape = RoundedCornerShape(20)
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Skin Cancer : $skinCancer",
                    fontSize = 24.sp,
                    color = Color.DarkGray,
                    modifier = Modifier.padding(8.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(
                    border = BorderStroke(width = 2.dp, color = Color(0xFF018786)),
                    shape = RoundedCornerShape(20)
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Other Cancers : $otherCancers",
                fontSize = 24.sp,
                modifier = Modifier.padding(8.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(
                    border = BorderStroke(width = 2.dp, color = Color(0xFF018786)),
                    shape = RoundedCornerShape(20)
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Depression : $depression",
                fontSize = 24.sp,
                modifier = Modifier.padding(8.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(
                    border = BorderStroke(width = 2.dp, color = Color(0xFF018786)),
                    shape = RoundedCornerShape(20)
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Arthritis : $arthritis",
                fontSize = 24.sp,
                modifier = Modifier.padding(8.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(
                    border = BorderStroke(width = 2.dp, color = Color(0xFF018786)),
                    shape = RoundedCornerShape(20)
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Diabetes : $diabetes",
                fontSize = 24.sp,
                modifier = Modifier.padding(8.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .border(
                    border = BorderStroke(width = 2.dp, color = Color(0xFF018786)),
                    shape = RoundedCornerShape(20)
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Heart Disease : $heartDisease",
                fontSize = 24.sp,
                modifier = Modifier.padding(8.dp))
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AiResultPreview(){
    AiResults()
}