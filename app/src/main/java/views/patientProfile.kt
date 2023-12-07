package views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.clinic.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun patientProfile() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFE9FAFF))
            ,
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
                    color = Color(0xFFFFFFFF), shape = RoundedCornerShape(25.dp)
                )
        ) {
            OutlinedTextField(
                value = name,
                shape = RoundedCornerShape(25.dp),
                onValueChange = { name = it },
                singleLine = true,
                textStyle = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold

                )
            )
        }
        Box(modifier = Modifier
            .fillMaxWidth(0.8f)
            .weight(2f)
            .padding(vertical = 50.dp)
            .background(color = Color.White)
        )

    }

}
@Preview (showBackground = true)
@Composable
fun showPreview(){
    patientProfile()
}