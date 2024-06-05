package views.Authentication

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.platform.LocalContext
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
import com.example.clinic.api.models.signup_doctor.SignUpDoctorResponse
import com.example.clinic.api.models.signup_patient.SignUpPatientResponse
import com.example.clinic.models.data.SignUpUser
import com.example.clinic.models.data.UserDoctor
import com.example.clinic.models.data.UserPatient
import com.example.clinic.shared.SharedPerferenceHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import views.FunctionsComposable.LocalImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun RegisterScreenTextFields(navController: NavController) {

    var iExpanded by remember { mutableStateOf(false) }
    var role by remember { mutableStateOf("") }
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password1 by remember { mutableStateOf("") }
    var passwordVisability by remember { mutableStateOf(false) }
    var password2 by remember { mutableStateOf("") }
    var passwordVisability2 by remember { mutableStateOf(false) }
    var phone by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Box(modifier = Modifier
            .align(Alignment.Start)
            .padding(10.dp)
            .clickable {
                navController.navigate(route = "signIn_screen")
            }) {
            LocalImage(
                painter = painterResource(id = R.drawable.backarrow), imageSize = 60.dp,
                padding = 10.dp
            )
        }

        LocalImage(
            painter = painterResource(id = R.drawable.finalbluelogo),
            imageSize = 200.dp,
            padding = 10.dp,
        )

        Text(
            text = stringResource(id = R.string.sign_up),
            fontSize = 30.sp,
            color = colorResource(R.color.light_blue)

        )

        OutlinedTextField(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 5.dp)
                .fillMaxWidth(),
            value = userName, onValueChange = { userName = it },
            shape = RoundedCornerShape(15.dp),
            label = {
                Text(
                    text = stringResource(id = R.string.user_name),
                    color = Color.LightGray
                )
            },
            leadingIcon = {
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

        OutlinedTextField(modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
            .fillMaxWidth(),
            value = phone, onValueChange = { phone = it },
            shape = RoundedCornerShape(15.dp),
            label = {
                Text(
                    text = stringResource(id = R.string.phone_number),
                    color = Color.LightGray
                )
            }, leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Call, contentDescription = "Email icon"
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

        OutlinedTextField(modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
            .fillMaxWidth(),
            value = email, onValueChange = { email = it },
            shape = RoundedCornerShape(15.dp),
            label = {
                Text(
                    text = stringResource(id = R.string.email),
                    color = Color.LightGray
                )
            }, leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email, contentDescription = "Email icon"
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

        val icon = if (passwordVisability)
            painterResource(id = R.drawable.visabilityon)
        else
            painterResource(id = R.drawable.visabilityoff)

        OutlinedTextField(
            modifier = Modifier
                .padding(start = 13.dp, end = 13.dp, top = 15.dp)
                .fillMaxWidth(),
            value = password1,
            onValueChange = { password1 = it },
            visualTransformation = if (passwordVisability) VisualTransformation.None
            else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            shape = RoundedCornerShape(15.dp),

            label = {
                Text(
                    text = stringResource(id = R.string.password),
                    color = Color.LightGray
                )
            },
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

        val icon2 = if (passwordVisability2)
            painterResource(id = R.drawable.visabilityon)
        else
            painterResource(id = R.drawable.visabilityoff)
        OutlinedTextField(
            modifier = Modifier
                .padding(start = 15.dp, end = 15.dp, top = 15.dp)
                .fillMaxWidth(),
            value = password2,
            onValueChange = { password2 = it },
            visualTransformation = if (passwordVisability2) VisualTransformation.None
            else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            shape = RoundedCornerShape(15.dp),

            label = {
                Text(
                    text = stringResource(id = R.string.confirm_password),
                    color = Color.LightGray
                )
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock, contentDescription = "Email icon"
                )
            },
            trailingIcon = {
                IconButton(onClick = { passwordVisability2 = !passwordVisability2 }) {
                    Icon(
                        modifier = Modifier
                            .padding(end = 10.dp)
                            .size(20.dp), painter = icon2, contentDescription = null
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
        val context = LocalContext.current

        Box(
            modifier = Modifier
                .padding(5.dp)
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            //input button
            OutlinedButton(
                onClick = { iExpanded = true },
            ) {
                when (role) {
                    "Patient" -> {
                        Text(
                            text = "Patient",
                            color = Color.Blue
                        )
                    }

                    "Doctor" -> {
                        Text(
                            text = "Doctor",
                            color = Color.Blue
                        )
                    }

                    else -> {
                        Text(
                            text = "Choose Role",
                            color = Color.Blue
                        )
                    }
                }
                Icon(
                    Icons.Default.ArrowDropDown,
                    contentDescription = "Arrow Down"
                )
            }
            DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                DropdownMenuItem(text = { Text("Patient") },
                    onClick = {
                        iExpanded = false
                        role = "Patient"

                    })
                DropdownMenuItem(text = { Text("Doctor") },
                    onClick = {
                        iExpanded = false
                        role = "Doctor"

                    })
            }
        }
        Button(
            onClick = {
                if (email.isEmpty()) return@Button
                if (role == "Doctor") {
                    signUpDoctor(
                        userName = userName,
                        phone = phone,
                        email = email,
                        password = password1,
                        confirmPassword = password2,
                        role = role,
                        navController = navController
                    )
                } else {
                    signUpPatient(
                        userName = userName,
                        phone = phone,
                        email = email,
                        password = password1,
                        confirmPassword = password2,
                        role = role,
                        navController = navController
                    )
                }
            },
            modifier = Modifier
                .padding(start = 30.dp, end = 30.dp, top = 5.dp, bottom = 20.dp)
                .size(height = 40.dp, width = 300.dp),
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.light_blue)),


            ) {
            Text(
                text = stringResource(id = R.string.sign_up),
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

fun signUpDoctor(
    userName: String,
    phone: String,
    email: String,
    password: String,
    confirmPassword: String,
    role: String,
    navController: NavController
) {
    ApiManager.getService()
        .signUpDoctor(SignUpUser(userName, email, password, confirmPassword, phone, role)).enqueue(
            object : Callback<SignUpDoctorResponse> {
                override fun onResponse(
                    call: Call<SignUpDoctorResponse>,
                    response: Response<SignUpDoctorResponse>
                ) {
                    if (response.isSuccessful && role == "Doctor") {
                        navController.navigate("signIn_screen")
                        UserDoctor.id = response.body()?.userSignUpDoctor?.id
                        SharedPerferenceHelper.saveIdDoctor(response.body()?.userSignUpDoctor?.id!!)
                        SharedPerferenceHelper.saveRole(response.body()?.userSignUpDoctor?.role!!)
                        SharedPerferenceHelper.saveName(response.body()!!.userSignUpDoctor!!.userName!!)
                        Log.e("UserDoctor.id", "Userdoctor ${UserDoctor.id}")
                    }
                }

                override fun onFailure(call: Call<SignUpDoctorResponse>, t: Throwable) {
                    Log.e("TAG", "onFailure: $t")
                }

            }
        )
}

fun signUpPatient(
    userName: String,
    phone: String,
    email: String,
    password: String,
    confirmPassword: String,
    role: String,
    navController: NavController
) {
    ApiManager.getService().signUpPatient(
        SignUpUser(
            userName = userName,
            email = email,
            password = password,
            cPassword = confirmPassword,
            phone = phone,
            role = role
        )
    ).enqueue(object : Callback<SignUpPatientResponse> {
        override fun onResponse(
            call: Call<SignUpPatientResponse>,
            response: Response<SignUpPatientResponse>
        ) {
            if (response.isSuccessful && role == "Patient")
                navController.navigate("signIn_screen")
            UserPatient.id = response.body()?.userSignUpPatient?.id
            SharedPerferenceHelper.saveIdPatient(response.body()?.userSignUpPatient?.id!!)
            SharedPerferenceHelper.saveRole(response.body()?.userSignUpPatient?.role!!)
            SharedPerferenceHelper.saveName(response.body()?.userSignUpPatient?.userName!!)
            Log.e("UserDoctor.id", "UserPatient ${UserPatient.id}")
        }

        override fun onFailure(call: Call<SignUpPatientResponse>, t: Throwable) {
            Log.e("TAG", "onFailure: $t")
        }

    })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    RegisterScreenTextFields(navController = rememberNavController())
}