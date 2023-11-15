package com.example.clinic.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.clinic.R

@Composable
fun AnimatedSplashScreen(){
    Splash()
}

@Composable
fun Splash(){
    Box(modifier = Modifier
        .background(if (isSystemInDarkTheme()) Color.Black else Color.White)
        .fillMaxSize()
    ){
            Icon(
                modifier = Modifier.size(150.dp),
                painter = painterResource(id = R.drawable.bluelogo1), contentDescription = "logo",

            )
    }
}
