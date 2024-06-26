package views.patientViews

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import views.FunctionsComposable.LocalImage

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun Hospitals(navController: NavController) {
    val list = listOf("Tanta", "Kafr Elziat", "Mahla")

    var selectedText by remember { mutableStateOf(list[0]) }

    var isExpanded by remember { mutableStateOf(false) }


    val fontFamily = FontFamily(
        Font(R.font.wendyoneregular, FontWeight.Thin)
    )

    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(80.dp)
                .background(color = Color(0xFF2697FF))
        ) {
            Text(
                text = "Hospitals",
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
                    navController.navigate(route = "patient_home")

                }) {
                LocalImage(
                    painter = painterResource(id = R.drawable.whitearrow), imageSize = 60.dp,
                    padding = 10.dp
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            androidx.compose.material.ExposedDropdownMenuBox(
                expanded = isExpanded,
                onExpandedChange = { isExpanded = !isExpanded }
            ) {
                OutlinedTextField(
                    value = selectedText,
                    label = { Text(text = "choose a city") },
                    onValueChange = { selectedText },
                    trailingIcon = {
                        androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                    },
                )

                ExposedDropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = { isExpanded = false }) {
                    list.forEachIndexed { index, text ->
                        DropdownMenuItem(
                            text = { Text(text = text) },
                            onClick = {
                                selectedText = list[index]
                                isExpanded = false
                            },
                        )
                    }

                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
                    .background(color = Color(0xFFE9FAFF)),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Column(modifier = Modifier.padding(bottom = 8.dp)) {

                        Text(
                            text = "Dar El Shefaa Hospital",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color(0xFF4040FF)
                        )

                        Text(
                            "Private hospital",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 18.sp,
                            color = Color.Gray,
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.DateRange,
                                contentDescription = "Hospital icon",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "Open 24 hours",
                                modifier = Modifier.padding(8.dp),
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Call,
                                contentDescription = "Hospital icon",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "0403274001",
                                fontSize = 18.sp,
                            )

                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.LocationOn,
                                contentDescription = "Hospital icon",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))


                            Text(
                                "Dar El Shefaa Hospital, Moawya St, Tanta Qism 2",
                                fontSize = 16.sp,
                            )
                        }
                        Divider(modifier = Modifier.padding(8.dp))
                    }
                }

                item {
                    Column(modifier = Modifier.padding(bottom = 8.dp)) {

                        Text(
                            text = "Delta International Hospital",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color(0xFF4040FF)
                        )

                        Text(
                            "Private hospital",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 18.sp,
                            color = Color.Gray,
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.DateRange,
                                contentDescription = "Hospital icon",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "Open 24 hours",
                                modifier = Modifier.padding(8.dp),
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Call,
                                contentDescription = "Hospital icon",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "0403315001",
                                fontSize = 18.sp,
                            )

                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.LocationOn,
                                contentDescription = "Hospital icon",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))


                            Text(
                                "Dawaran Kotshnr, Tanta Qism 2, Second Tanta",
                                fontSize = 16.sp,
                            )
                        }
                        Divider(modifier = Modifier.padding(8.dp))
                    }
                }

                item {
                    Column(modifier = Modifier.padding(bottom = 8.dp)) {

                        Text(
                            text = "American Hospital",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color(0xFF4040FF)
                        )

                        Text(
                            "Private hospital",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 18.sp,
                            color = Color.Gray,
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.DateRange,
                                contentDescription = "Hospital icon",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "Open 24 hours",
                                modifier = Modifier.padding(8.dp),
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Call,
                                contentDescription = "Hospital icon",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "0403312692",
                                fontSize = 18.sp,
                            )

                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.LocationOn,
                                contentDescription = "Hospital icon",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))


                            Text(
                                "Saeed St, Tanta Qism 2",
                                fontSize = 16.sp,
                            )
                        }
                        Divider(modifier = Modifier.padding(8.dp))
                    }
                }

                item {
                    Column(modifier = Modifier.padding(bottom = 8.dp)) {

                        Text(
                            text = "Shorouk Hospital",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            color = Color(0xFF4040FF)
                        )

                        Text(
                            "Private hospital",
                            modifier = Modifier.padding(8.dp),
                            fontSize = 18.sp,
                            color = Color.Gray,
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.DateRange,
                                contentDescription = "Hospital icon",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "Open 24 hours",
                                modifier = Modifier.padding(8.dp),
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Call,
                                contentDescription = "Hospital icon",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                "0403271836",
                                fontSize = 18.sp,
                            )

                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Filled.LocationOn,
                                contentDescription = "Hospital icon",
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))


                            Text(
                                " Ali Bek Al Kabir, Tanta Qism 2, Second Tanta",
                                fontSize = 16.sp,
                            )
                        }
                        Divider(modifier = Modifier.padding(8.dp))
                    }
                }
            }

        }
    }
}


@Composable
@Preview(showBackground = true)
fun HosPreview(){
    Hospitals(navController = rememberNavController())
}