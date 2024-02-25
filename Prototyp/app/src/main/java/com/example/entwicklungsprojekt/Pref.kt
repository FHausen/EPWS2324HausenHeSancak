package com.example.entwicklungsprojekt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.entwicklungsprojekt.ui.theme.Blue40
import com.example.entwicklungsprojekt.ui.theme.BlueWhite40
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.ZoneOffset

fun checkPrefInput(alter:String,erfahrung:String):Boolean{
    return if (alter.all { char -> char.isDigit()}&&erfahrung.all { char -> char.isDigit()}&&alter!=""&&erfahrung!=""){
        erfahrung.toIntOrNull() in 1..5&&alter.toIntOrNull()!! > 0
    }else false
}



@Composable
fun UserPref(
    navController: NavController
){
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val savedprefQuery = db.collection("user").document("prototype").collection("pref").document("savedpref")

    var stadt by remember { mutableStateOf(sstadt) }
    var alter by remember { mutableStateOf(salter) }
    var erfahrung by remember { mutableStateOf(serfahrung) }
    var favAbstract by remember { mutableStateOf(sfavAbstract) }
    var favChildren by remember { mutableStateOf(sfavChildren) }
    var favCustomizable by remember { mutableStateOf(sfavCustomizable) }
    var favFamily by remember { mutableStateOf(sfavFamily) }
    var favParty by remember { mutableStateOf(sfavParty) }
    var favStrategy by remember { mutableStateOf(sfavStrategy) }
    var favThematic by remember { mutableStateOf(sfavThematic) }
    var favWargame by remember { mutableStateOf(sfavWargame) }
    var okInput by remember { mutableStateOf(false) }


    okInput = checkPrefInput(alter, erfahrung)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Blue40)
            .verticalScroll(rememberScrollState()),
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp),
        ) {


            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 0.dp)
                    .padding(bottom = 5.dp),
                text = "Stadt",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                value = stadt,
                onValueChange = { stadt = it },
                placeholder = { Text(text = "Stadt eingeben") },
            )



            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 15.dp)
                    .padding(bottom = 5.dp),
                text = "Alter",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                value = alter,
                onValueChange = {
                    alter = it
                    okInput = checkPrefInput(alter, erfahrung) },
                placeholder = { Text(text = "Alter eingeben") },
            )


            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 15.dp)
                    .padding(bottom = 5.dp),
                text = "Erfahrung",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                value = erfahrung,
                onValueChange = {
                    erfahrung = it
                    okInput = checkPrefInput(alter, erfahrung) },
                placeholder = { Text(text = "Erfahrung eingeben (1 - 5)") },
            )


            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 15.dp)
                    .padding(bottom = 5.dp),
                text = "Lieblingsgenres",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
            ) {

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 20.dp),
                    text = "Abstract",
                    fontSize = 14.sp,
                )
                Checkbox(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 120.dp),
                    checked = favAbstract,
                    onCheckedChange = {favAbstract = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = BlueWhite40
                    )
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(start = 130.dp),
                    text = "Children",
                    fontSize = 14.sp,
                )
                Checkbox(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    checked = favChildren,
                    onCheckedChange = {favChildren = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = BlueWhite40
                    )
                )

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
            ) {

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 20.dp),
                    text = "Customizable",
                    fontSize = 14.sp,
                )
                Checkbox(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 120.dp),
                    checked = favCustomizable,
                    onCheckedChange = {favCustomizable = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = BlueWhite40
                    )
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(start = 120.dp),
                    text = "Family",
                    fontSize = 14.sp,
                )
                Checkbox(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    checked = favFamily,
                    onCheckedChange = {favFamily = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = BlueWhite40
                    )
                )

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
            ) {

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 20.dp),
                    text = "Party",
                    fontSize = 14.sp,
                )
                Checkbox(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 120.dp),
                    checked = favParty,
                    onCheckedChange = {favParty = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = BlueWhite40
                    )
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(start = 130.dp),
                    text = "Strategy",
                    fontSize = 14.sp,
                )
                Checkbox(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    checked = favStrategy,
                    onCheckedChange = {favStrategy = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = BlueWhite40
                    )
                )

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
            ) {

                Text(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 20.dp),
                    text = "Thematic",
                    fontSize = 14.sp,
                )
                Checkbox(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 120.dp),
                    checked = favThematic,
                    onCheckedChange = {favThematic = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = BlueWhite40
                    )
                )

                Text(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(start = 138.dp),
                    text = "Wargame",
                    fontSize = 14.sp,
                )
                Checkbox(
                    modifier = Modifier
                        .align(Alignment.CenterEnd),
                    checked = favWargame,
                    onCheckedChange = {favWargame = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = BlueWhite40
                    )
                )

            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(56.dp)
                .align(Alignment.BottomCenter),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40),
            content = { Text(text = "PRÄFERENZEN SPEICHERN", color = Color.DarkGray) },
            enabled = okInput,
            onClick = {
                    val favGenre = listOf(favAbstract,favChildren,favCustomizable,favFamily,favParty,favStrategy,favThematic,favWargame)

                    val updatedDocument = hashMapOf(
                        "stadt" to stadt,
                        "alter" to alter,
                        "erfahrung" to erfahrung,
                        "favGenre" to favGenre
                    )

                    savedprefQuery
                        .set(updatedDocument)
                        .addOnSuccessListener { documentReference ->
                            println("preference saved")
                        }
                        .addOnFailureListener { exception ->
                            println("failed to save preference")
                        }

                updateData()
                navController.popBackStack()
                navController.navigate("startScreen")
            }
        )
    }
}

@Composable
@Preview
fun PrefPreview(){
    UserPref(navController = rememberNavController())
}