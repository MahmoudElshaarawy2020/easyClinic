package views.Authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import views.FunctionsComposable.LocalImage
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenTextFields(navController: NavController) {
        Column(
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center


        ) {
            LocalImage(
                painter = painterResource(id = R.drawable.finalbluelogo),
                imageSize = 200.dp,
                padding = 5.dp,
            )


            Text(
                text = stringResource(R.string.welcome),
                fontSize = 30.sp,
                color = colorResource(R.color.lightblue)


            )
            var text by remember { mutableStateOf(TextFieldValue("")) }

            OutlinedTextField(modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 25.dp)
                .fillMaxWidth(),
                value = text, onValueChange = { text = it },
                shape = RoundedCornerShape(15.dp),
                label = {
                    Text(
                        text = "Email or User Name",
                        color = Color.LightGray
                    )
                }, leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Person, contentDescription = "Email icon"
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
            var passwordVisability by remember { mutableStateOf(false) }
            val icon = if (passwordVisability)
                painterResource(id = R.drawable.visabilityon)
            else
                painterResource(id = R.drawable.visabilityoff)
            var password by remember { mutableStateOf(TextFieldValue("")) }
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 13.dp, end = 13.dp, top = 15.dp)
                    .fillMaxWidth(),
                value = password,
                onValueChange = { password = it },
                visualTransformation = if (passwordVisability) VisualTransformation.None
                else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                shape = RoundedCornerShape(15.dp),

                label = { Text(text = stringResource(R.string.password), color = Color.LightGray) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Filled.Lock, contentDescription = "Email icon"
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { passwordVisability = !passwordVisability }) {
                        Icon(
                            modifier = Modifier
                                .padding(end = 10.dp)
                                .size(20.dp), painter = icon, contentDescription = null
                        )


                    }
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
            Text(
                text = stringResource(id = R.string.forgot) , modifier = Modifier
                    .padding(top = 17.dp, start = 198.dp)
                    .clickable { },
                color = colorResource(id = R.color.lightblue),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )

            Button(
                onClick = {
                    login()
                },
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp, top = 40.dp)
                    .size(height = 40.dp, width = 400.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.lightblue)),

                ) {
                Text(
                    text = stringResource(id = R.string.sign_in),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(start = 30.dp, end = 30.dp, top = 18.dp)
                    .size(height = 40.dp, width = 400.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.lightblue)),

                ) {
                Text(
                    text = "Sign in with Google",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Row(
                modifier = Modifier
                    .padding(top = 50.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.question),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 6.dp, end = 3.dp)
                )
                Button(
                    onClick = {
                        navController.navigate(route = "signUp_screen")

                    },
                    modifier = Modifier
                        .size(width = 100.dp, height = 37.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(id = R.color.lightblue))

                ) {
                    Text(
                        text = stringResource(id = R.string.sign_up),
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )


                }
            }

        }
    }




@Preview(showBackground = true)
@Composable
fun signinPreview() {
    LoginScreenTextFields(navController = rememberNavController())
}
fun login (){
    val baseUrl  = URL("https://zezo-yousef-taha.onrender.com/")
    val connection = baseUrl.openConnection() as HttpURLConnection

    connection.requestMethod = "POST"
    connection.doOutput = true


    val requestBody = "email=zezoelmalky894@gmail.com&password=@d3@AaA13"

    connection.outputStream.use { outputStream ->
        val writer = BufferedWriter(OutputStreamWriter(outputStream,"UTF-8"))
        writer.write(requestBody)
        writer.flush()
    }

    val responseCode = connection.responseCode
    val responseBody = if(responseCode == HttpURLConnection.HTTP_OK ){
        val inputStream = connection.inputStream
        inputStream. bufferedReader().use(BufferedReader::readText)

    }else{
        val errStream = connection.errorStream
        errStream.bufferedReader().use(BufferedReader::readText)
    }
    connection.disconnect()
    println("Response Code $responseCode")
    println("Response Code $responseBody")

}

