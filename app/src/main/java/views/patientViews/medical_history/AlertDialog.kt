package views.patientViews.medical_history

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.clinic.R


data class Check(
    val id: Int,
    var checkName: String,
    var checkDoctor: String,
    var checkDate: String,
    var isEditing: Boolean = false
)
@Composable
fun AlertDialog() {

    var checkList by remember { mutableStateOf(listOf<Check>()) }
    var showDialog by remember { mutableStateOf(false) }
    var name by remember { mutableStateOf("") }
    var doctor by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton ={
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                    Button(
                        onClick = {
                            if (name.isNotBlank()) {
                                val newItem = Check(
                                    id = checkList.size + 1,
                                    checkName = name,
                                    checkDoctor = doctor,
                                    checkDate = date
                                )
                                checkList = checkList + newItem
                                showDialog = false
                                name = ""
                                doctor = ""
                                date = ""
                            }
                                  },
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Text("Save")
                    }
                    Button(onClick = { /* Handle Button 2 click */ }) {
                        Text("Cancel")
                    }
                }
            },
            title = { Text(text = "Add information",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 20.sp)},
            text = {
                Column (modifier = Modifier.padding(16.dp)){
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Check's name") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Check's doctor") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = { Text("Check's date") },
                        modifier = Modifier.fillMaxWidth()
                    )

                    Box(modifier = Modifier.fillMaxWidth()
                        .clickable {


                    }){
                        Image(painter = painterResource(id = R.drawable.addpicture ),
                            contentDescription ="" )
                    }


                }
            }
        )
    }
}

@Composable
@Preview(showBackground = true)
fun AlertDialogPreview(){
    AlertDialog()
}