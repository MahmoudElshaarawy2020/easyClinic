package views.Authentication

import android.util.Log
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.clinic.R
import com.example.clinic.api.ApiManager
import com.example.clinic.api.models.signin.SignInResponse
import com.example.clinic.models.data.PatientToken
import com.example.clinic.models.data.DoctorToken
import com.example.clinic.models.data.SignInUser
import com.example.clinic.models.data.UserPatient
import com.example.clinic.models.data.UserDoctor
import com.example.clinic.shared.SharedPerferenceHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import views.FunctionsComposable.LocalImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreenTextFields(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
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
            color = colorResource(R.color.light_blue)


        )


        OutlinedTextField(modifier = Modifier
            .padding(start = 13.dp, end = 13.dp, top = 25.dp)
            .fillMaxWidth(),
            value = email, onValueChange = { email = it },
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
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )
        var passwordVisability by remember { mutableStateOf(false) }
        val icon = if (passwordVisability)
            painterResource(id = R.drawable.visabilityon)
        else
            painterResource(id = R.drawable.visabilityoff)

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
                unfocusedBorderColor = colorResource(id = R.color.light_blue),
                focusedBorderColor = colorResource(id = R.color.light_blue)
            )
        )
        Text(
            text = stringResource(id = R.string.forgot), modifier = Modifier
                .padding(top = 17.dp, start = 198.dp)
                .clickable { },
            color = colorResource(id = R.color.light_blue),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )

        Button(
            onClick = {
                if (email.isEmpty() && password.isEmpty()) return@Button
                signIn(email, password, navController = navController)
            },
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, top = 40.dp)
                .size(height = 40.dp, width = 400.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.light_blue)),

            ) {
            Text(
                text = stringResource(id = R.string.sign_in),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
//            Button(
//                onClick = {},
//                modifier = Modifier
//                    .padding(start = 30.dp, end = 30.dp, top = 18.dp)
//                    .size(height = 40.dp, width = 400.dp),
//                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.light_blue)),
//
//                ) {
//                Text(
//                    text = "Sign in with Google",
//                    fontSize = 15.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color.White
//                )
//            }
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
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.light_blue))

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

fun signIn(email: String, password: String, navController: NavController) {
    ApiManager.getService().signIn(SignInUser(email, password)).enqueue(
        object : Callback<SignInResponse> {
            override fun onResponse(
                call: Call<SignInResponse>,
                response: Response<SignInResponse>
            ) {
                if (response.isSuccessful && response.body()?.userSignIn?.id == UserDoctor.id) {
                    UserDoctor.id = response.body()?.userSignIn?.id
                    DoctorToken.token = response.body()?.accessToken
                    Log.e("DoctorToken.token", "DoctorToken.token ${DoctorToken.token}", )
                    navController.navigate("doctor_data")
                } else if (response.isSuccessful && response.body()?.userSignIn?.id == UserPatient.id) {
                    UserPatient.id = response.body()?.userSignIn?.id
                    PatientToken.token = response.body()?.accessToken
                    navController.navigate("patient_data")
                }
                Log.e("TAG", "onResponse: $response")
            }

            override fun onFailure(call: Call<SignInResponse>, t: Throwable) {
                Log.e("TAG", "onFailure: $t")
            }

        }
    )
}


@Preview(showBackground = true)
@Composable
fun signinPreview() {
    LoginScreenTextFields(navController = rememberNavController())
}


