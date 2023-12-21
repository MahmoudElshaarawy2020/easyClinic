package views
// import android.util.Size
// import androidx.compose.foundation.clickable
// import androidx.compose.foundation.layout.Box
// import androidx.compose.foundation.layout.Column
// import androidx.compose.foundation.layout.fillMaxSize
// import androidx.compose.foundation.layout.fillMaxWidth
// import androidx.compose.foundation.layout.padding
// import androidx.compose.foundation.layout.width
// import androidx.compose.material.icons.Icons
// import androidx.compose.material.icons.filled.KeyboardArrowDown
// import androidx.compose.material.icons.filled.KeyboardArrowUp
// import androidx.compose.material3.DropdownMenu
// import androidx.compose.material3.DropdownMenuItem
// import androidx.compose.material3.ExperimentalMaterial3Api
// import androidx.compose.material3.ExposedDropdownMenuBox
// import androidx.compose.material3.ExposedDropdownMenuDefaults
// import androidx.compose.material3.Icon
// import androidx.compose.material3.OutlinedTextField
// import androidx.compose.material3.Text
// import androidx.compose.runtime.Composable
// import androidx.compose.runtime.getValue
// import androidx.compose.runtime.getValue
// import androidx.compose.runtime.mutableStateOf
// import androidx.compose.runtime.remember
// import androidx.compose.runtime.setValue
// import androidx.compose.ui.Alignment
// import androidx.compose.ui.Modifier
// import androidx.compose.ui.layout.onGloballyPositioned
// import androidx.compose.ui.platform.LocalDensity
// import androidx.compose.ui.tooling.preview.Preview
// import androidx.compose.ui.unit.dp
// import androidx.compose.ui.unit.toSize
//
// @OptIn(ExperimentalMaterial3Api::class)
// @Composable
// fun MyDropList(){
// var isexpanded by remember {
// mutableStateOf(false)
// }
// var city by remember {
// mutableStateOf("")
// }
//
// Box(modifier = Modifier.fillMaxSize(),
// contentAlignment = Alignment.Center
// ){
// ExposedDropdownMenuBox(
// expanded = isexpanded,
// onExpandedChange = {isexpanded = it}) {
// OutlinedTextField(value = city,
// onValueChange = {},
// readOnly = true,
// trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = isexpanded)},
// colors = ExposedDropdownMenuDefaults.textFieldColors(),
// modifier = Modifier.menuAnchor()
// )
// ExposedDropdownMenu(
// expanded = isexpanded,
// onDismissRequest = { isexpanded = false }) {
// DropdownMenuItem(
// text = {Text(text = "Tanta") },
// onClick = {
// city = "Tanta"
// isexpanded = false
// }
// )
// DropdownMenuItem(
// text = {Text(text = "Mahala") },
// onClick = {
// city = "Mahala"
// isexpanded = false
// }
// )
// DropdownMenuItem(
// text = {Text(text = "Kafr elziat") },
// onClick = {
// city = "Kafr elziat"
// isexpanded = false
// }
// )
//
// }
//
// }
// }
//
// }
// @Composable
// @Preview(showBackground = true)
// fun myScreen(){
// MyDropList()
// }