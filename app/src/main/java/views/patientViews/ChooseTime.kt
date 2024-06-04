package views.patientViews

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChooseTime(items: List<String>){
    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("Pick a time") },
            backgroundColor = Color(0xFF0480C4),
            contentColor = Color.White,
            elevation = 8.dp
        )

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items) { item ->
                Text(modifier = Modifier
                    .padding(16.dp)
                    .clickable { },
                    text = item,
                    fontSize = 32.sp)
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewTime(){
    ChooseTime(items = listOf("Item 1", "Item 2", "Item 3"))
}