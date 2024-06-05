package views.patientViews

import android.annotation.SuppressLint
import android.content.Context
import android.icu.text.SimpleDateFormat
import android.icu.util.TimeZone
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
import com.example.clinic.api.ApiManager
import com.example.clinic.api.models.medical_history.MedicalHistoryResponse
import com.example.clinic.models.data.MedicalHistoryData
import com.example.clinic.shared.SharedPerferenceHelper
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import views.FunctionsComposable.LocalImage
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import kotlin.math.sin


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun MedicalHistory2(navController: NavController) {
    var patientName by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var doctorName by remember { mutableStateOf("") }
    val context = LocalContext.current
    var fileUri by remember { mutableStateOf<Uri?>(null) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val filePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        fileUri = uri
    }

    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
    }

    val fontFamily = FontFamily(
        Font(R.font.wendyoneregular, FontWeight.Thin)
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(100.dp)
                .background(color = Color(0xFF2697FF))
        ) {
            Text(
                text = "Medical history",
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
                    navController.navigate(route = "MedHis1")
                }) {
                LocalImage(
                    painter = painterResource(id = R.drawable.whitearrow), imageSize = 60.dp,
                    padding = 10.dp
                )
            }


        }

        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 25.dp)
                .fillMaxWidth(),
            value = patientName, onValueChange = { patientName = it },
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
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 25.dp)
                .fillMaxWidth(),
            value = date, onValueChange = { date = it },
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
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 25.dp)
                .fillMaxWidth(),
            value = doctorName, onValueChange = { doctorName = it },
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
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .size(10.dp)
        )

        Image(
            modifier = Modifier
                .clickable {
                    filePicker.launch("*/*")
                }
                .fillMaxWidth()
                .size(120.dp),
            painter = painterResource(id = R.drawable.addfile),
            contentDescription = "adding file"
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopStart
        ) {
            Image(
                modifier = Modifier
                    .clickable {
                        imagePicker.launch("image/*")
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

                if (fileUri != null && imageUri != null) {
                    val fileExtension = getFileExtension(context, fileUri!!)
                    val imageExtension = getFileExtension(context, imageUri!!)
                    if (fileExtension.isValidExtension() && imageExtension.isValidExtension()) {
                        uploadMedicalHistory(
                            context = context,
                            fileUri = fileUri!!,
                            imageUri = imageUri!!,
                            name = patientName,
                            doctorName = doctorName,
                            date = date,
                            patientId = SharedPerferenceHelper.getIdPatient()!!,
                            navController = navController
                        )
                    } else {
                        Toast.makeText(context, "Invalid file extension", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Please select both file and image", Toast.LENGTH_SHORT)
                        .show()
                }
            },
            modifier = Modifier
                .size(height = 60.dp, width = 280.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.light_blue)),
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


fun uploadMedicalHistory(
    context: Context,
    fileUri: Uri,
    imageUri: Uri,
    name: String,
    doctorName: String,
    date: String,
    patientId: String,
    navController: NavController
) {

    val file = getFileFromUri(context, fileUri)
    val image = getFileFromUri(context, imageUri)

    val requestFile = file!!.asRequestBody("multipart/form-data".toMediaTypeOrNull())
    val requestImage = image!!.asRequestBody("multipart/form-data".toMediaTypeOrNull())

    val filePart = MultipartBody.Part.createFormData("AddFile", file.name, requestFile)
    val imagePart = MultipartBody.Part.createFormData("AddImage", image.name, requestImage)
    ApiManager.getService().uploadMedicalHistory(
        token = "Bearer ${SharedPerferenceHelper.getToken()}",
        MedicalHistoryData(
            file = filePart,
            image = imagePart,
            name = name,
            doctorName = doctorName,
            date = date,
            patientId = patientId
        )
    ).enqueue(object : Callback<MedicalHistoryResponse> {
        override fun onResponse(
            call: Call<MedicalHistoryResponse>,
            response: Response<MedicalHistoryResponse>
        ) {
            if (response.isSuccessful) {
                navController.navigate("MedHis3/${name}/${date}/${doctorName}")
                Log.e("TAG", "onResponse: $response")
            }
        }

        override fun onFailure(call: Call<MedicalHistoryResponse>, t: Throwable) {
            Log.e("TAG", "onFailure: $t")
        }

    })
    // You can use this result to show a message in your UI

}

fun getFileFromUri(context: Context, uri: Uri): File? {
    val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
    val file = File(context.cacheDir, getFileName(context, uri))

    inputStream?.use { input ->
        FileOutputStream(file).use { output ->
            val buffer = ByteArray(4 * 1024) // Buffer size
            var read: Int
            while (input.read(buffer).also { read = it } != -1) {
                output.write(buffer, 0, read)
            }
            output.flush()
        }
    }

    return file
}

fun getFileName(context: Context, uri: Uri): String {
    var result: String? = null
    if (uri.scheme == "content") {
        context.contentResolver.query(uri, null, null, null, null)?.use {
            if (it.moveToFirst()) {
                result = it.getString(it.getColumnIndexOrThrow(OpenableColumns.DISPLAY_NAME))
            }
        }
    }
    if (result == null) {
        result = uri.path
        val cut = result!!.lastIndexOf('/')
        if (cut != -1) {
            result = result!!.substring(cut + 1)
        }
    }
    return result ?: "file"
}

fun String.isValidExtension(): Boolean {
    val validExtensions = listOf("jpg", "jpeg", "png", "pdf") // Add valid extensions
    return validExtensions.contains(this.lowercase())
}

fun getFileExtension(context: Context, uri: Uri): String {
    val contentResolver = context.contentResolver
    val mimeType = contentResolver.getType(uri)
    return mimeType?.substringAfterLast('/') ?: ""
}

@Composable
@Preview(showBackground = true)
fun MedicalHistory2Preview() {
    MedicalHistory2(navController = rememberNavController())
}


