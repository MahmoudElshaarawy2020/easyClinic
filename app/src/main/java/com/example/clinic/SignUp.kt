package com.example.clinic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RegisterScreenTextFields(){
    Column(
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxSize()
            .padding(10.dp)
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        LocalImage(
            painter = painterResource(id = R.drawable.bluelogo1),
            imageSize = 200.dp,
            padding = 30.dp,
        )


    }
}
@Preview(showBackground = true)
@Composable
fun signupPreview(){
    RegisterScreenTextFields()
}
