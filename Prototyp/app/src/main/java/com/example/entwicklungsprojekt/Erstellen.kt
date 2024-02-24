package com.example.entwicklungsprojekt

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.text.format.DateFormat
import android.widget.TimePicker
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.DialogFragment
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.entwicklungsprojekt.ui.theme.Blue40
import com.example.entwicklungsprojekt.ui.theme.BlueWhite40
import com.google.firebase.firestore.FirebaseFirestore
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import androidx.fragment.*
import com.google.firebase.Timestamp
import com.vanpra.composematerialdialogs.*
import com.vanpra.composematerialdialogs.datetime.date.DatePickerDefaults
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.TimePickerDefaults
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import java.time.LocalDateTime
import java.time.ZoneOffset

/*
@Composable
fun Erstellen( ) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Blue40)
        .padding(horizontal = 50.dp, vertical = 50.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Erstelle eine Spiel", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 36.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(50.dp))

        Box(modifier = Modifier
            .width(290.dp)
            .height(2.dp)
            .background(color = Color.White))
        Spacer(modifier = Modifier.height(50.dp))

        Box(modifier = Modifier
            .size(290.dp, 50.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(text = "(Bitte Kategorie wählen)", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier
                    .weight(1f)
                    .padding(15.dp))
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Pfeil", tint = Color.Black, modifier = Modifier
                    .padding(10.dp)
                    .size(40.dp)) }
        }
        Spacer(modifier = Modifier.height(50.dp))

        Box(modifier = Modifier
            .size(290.dp, 50.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(text = "(Bitte Spiel wählen)", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier
                    .weight(1f)
                    .padding(15.dp))
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Pfeil", tint = Color.Black, modifier = Modifier
                    .padding(10.dp)
                    .size(40.dp)) }
        }
        Spacer(modifier = Modifier.height(50.dp))

        Box(modifier = Modifier
            .size(290.dp, 50.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(text = "(Bitte Spielrunde wählen)", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier
                    .weight(1f)
                    .padding(15.dp))
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Pfeil", tint = Color.Black, modifier = Modifier
                    .padding(10.dp)
                    .size(40.dp)) }
        }
        Spacer(modifier = Modifier.height(50.dp))

        Box(modifier = Modifier
            .size(290.dp, 50.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(text = "(Bitte Spieleranzahl wählen)", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier
                    .weight(1f)
                    .padding(15.dp))
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Pfeil", tint = Color.Black, modifier = Modifier
                    .padding(10.dp)
                    .size(40.dp)) }
        }
        Spacer(modifier = Modifier.height(50.dp))

        Box(modifier = Modifier
            .size(290.dp, 50.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(text = "(Bitte Stadt wählen)", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier
                    .weight(1f)
                    .padding(15.dp))
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Pfeil", tint = Color.Black, modifier = Modifier
                    .padding(10.dp)
                    .size(40.dp)) }
        }
        Spacer(modifier = Modifier.height(100.dp))

        Box(modifier = Modifier
            .size(290.dp, 48.dp)
            .background(Color.White, shape = RoundedCornerShape(30.dp)), contentAlignment = Alignment.Center) {
            Text(text = "ERSTELLE EIN SPIEL", color = Blue40, fontWeight = FontWeight.Bold)}
    }
}

 */


fun checkMeetingInput(alter1:String,alter2:String,erfahrung:String):Boolean{
    return if (alter1.all { char -> char.isDigit()}&&alter2.all { char -> char.isDigit()}&&erfahrung.all { char -> char.isDigit()}&&alter1!=""&&alter2!=""&&erfahrung!=""){
        erfahrung.toIntOrNull() in 1..5&&alter1.toIntOrNull()!! > 0&&alter2.toIntOrNull()!! > 0
    }else false
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewMeeting(
    navController: NavController
){

    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val meeting = db.collection("meeting")

    var titel by remember { mutableStateOf("") }
    var stadt by remember { mutableStateOf("") }
    var alter1 by remember { mutableStateOf("") }
    var alter2 by remember { mutableStateOf("") }
    var erfahrung by remember { mutableStateOf("") }
    var spiele by remember { mutableStateOf("") }
    var prototyp by remember { mutableStateOf(false) }
    var abstract by remember { mutableStateOf(false) }
    var children by remember { mutableStateOf(false) }
    var customizable by remember { mutableStateOf(false) }
    var family by remember { mutableStateOf(false) }
    var party by remember { mutableStateOf(false) }
    var strategy by remember { mutableStateOf(false) }
    var thematic by remember { mutableStateOf(false) }
    var wargame by remember { mutableStateOf(false) }
    var beschreibung by remember { mutableStateOf("") }
    var pickedDate by remember { mutableStateOf(LocalDate.now()) }
    var pickedTime by remember { mutableStateOf(LocalTime.now()) }

    val formattedDate by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("dd MMM yyyy")
                .format(pickedDate)
        }
    }
    val formattedTime by remember {
        derivedStateOf {
            DateTimeFormatter
                .ofPattern("hh:mm")
                .format(pickedTime)
        }
    }

    val dateDialogState = rememberMaterialDialogState()
    val timeDialogState = rememberMaterialDialogState()


    var okInput by remember { mutableStateOf(false) }



    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Blue40),
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(20.dp),
        ) {

            Text(
                text = "Erstelle ein Treffen",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .width(290.dp)
                    .height(2.dp)
                    .background(color = Color.White)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 15.dp)
                    .padding(bottom = 5.dp),
                text = "Titel",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                value = titel,
                onValueChange = { titel = it },
                placeholder = { Text(text = "Titel eingeben") },
            )

            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 15.dp)
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
                text = "Altersgruppe",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextField(
                    modifier = Modifier
                        .width(130.dp)
                        .height(60.dp),
                    value = alter1,
                    onValueChange = {
                        alter1 = it
                        okInput = checkMeetingInput(alter1, alter2, erfahrung)
                    },
                    placeholder = { Text(text = "Alter 1") },
                )

                Text(
                    modifier = Modifier
                        .padding(10.dp)
                        .align(Alignment.CenterVertically),
                    text = "bis",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )

                TextField(
                    modifier = Modifier
                        .width(130.dp)
                        .height(60.dp),
                    value = alter2,
                    onValueChange = {
                        alter2 = it
                        okInput = checkMeetingInput(alter1, alter2, erfahrung)
                    },
                    placeholder = { Text(text = "Alter 2") },
                )
            }


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
                    okInput = checkMeetingInput(alter1, alter2, erfahrung)
                },
                placeholder = { Text(text = "Erfahrung eingeben (1 - 5)") },
            )

            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 15.dp)
                    .padding(bottom = 5.dp),
                text = "Spiele",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                value = spiele,
                onValueChange = { spiele = it },
                placeholder = { Text(text = "Spiele eingeben") },
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .align(Alignment.CenterStart),
                    text = "Prototyp",
                    fontSize = 14.sp,
                )
                Checkbox(
                    modifier = Modifier
                        .padding(start = 120.dp)
                        .align(Alignment.CenterStart),
                    checked = prototyp,
                    onCheckedChange = {prototyp = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = BlueWhite40
                    )
                )
            }




            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 15.dp)
                    .padding(bottom = 5.dp),
                text = "Genres",
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
                    checked = abstract,
                    onCheckedChange = {abstract = it},
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
                    checked = children,
                    onCheckedChange = {children = it},
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
                    checked = customizable,
                    onCheckedChange = {customizable = it},
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
                    checked = family,
                    onCheckedChange = {family = it},
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
                    checked = party,
                    onCheckedChange = {party = it},
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
                    checked = strategy,
                    onCheckedChange = {strategy = it},
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
                    checked = thematic,
                    onCheckedChange = {thematic = it},
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
                    checked = wargame,
                    onCheckedChange = {wargame = it},
                    colors = CheckboxDefaults.colors(
                        checkedColor = BlueWhite40
                    )
                )
            }


            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 15.dp)
                    .padding(bottom = 5.dp),
                text = "Datum und Uhrzeit",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {

                TextField(
                    modifier = Modifier
                        .width(160.dp)
                        .height(60.dp)
                        .clickable { dateDialogState.show() },
                    value = formattedDate,
                    onValueChange = {
                        okInput = checkMeetingInput(alter1, alter2, erfahrung)
                    },
                    placeholder = { Text(text = "Datum") },
                    enabled = false
                )
                MaterialDialog(
                    dialogState = dateDialogState,
                    buttons = {
                        positiveButton(text = "ok", textStyle = TextStyle(color = Color.Black))
                        negativeButton(text = "cancel", textStyle = TextStyle(color = Color.Black))
                    },
                    backgroundColor = BlueWhite40
                ) {
                    datepicker(
                        initialDate = pickedDate,
                        title = "wähle das Datum",
                        colors = DatePickerDefaults.colors(
                            headerBackgroundColor = Blue40,
                            dateActiveBackgroundColor = Blue40,
                            dateActiveTextColor = Color.Black
                        )
                    ) {
                        pickedDate = it
                    }
                }



                TextField(
                    modifier = Modifier
                        .width(160.dp)
                        .height(60.dp)
                        .clickable { timeDialogState.show() },
                    value = formattedTime,
                    onValueChange = {
                        okInput = checkMeetingInput(alter1, alter2, erfahrung)
                    },
                    placeholder = { Text(text = "Uhrzeit") },
                    enabled = false
                )
                MaterialDialog(
                    dialogState = timeDialogState,
                    buttons = {
                        positiveButton(text = "ok", textStyle = TextStyle(color = Color.Black))
                        negativeButton(text = "cancel", textStyle = TextStyle(color = Color.Black))
                    },
                    backgroundColor = BlueWhite40
                ) {
                    timepicker(
                        initialTime = pickedTime,
                        title = "wähle die Uhrzeit",
                        is24HourClock = true,
                        colors = TimePickerDefaults.colors(
                            selectorColor = Blue40,
                            activeBackgroundColor = Blue40,
                            inactiveBackgroundColor = BlueWhite40
                        )
                    ) {
                        pickedTime = it
                    }
                }
            }
            

            Text(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .padding(top = 15.dp)
                    .padding(bottom = 5.dp),
                text = "Beschreibung",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                singleLine = false,
                minLines = 3,
                value = beschreibung,
                onValueChange = { beschreibung = it },
                placeholder = { Text(text = "Beschreibung hinzufügen") },
            )
            Spacer(modifier = Modifier.height(76.dp))
        }



        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(56.dp)
                .align(Alignment.BottomCenter),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40),
            content = { Text(text = "TREFFEN ERSTELLEN", color = Color.DarkGray) },
            enabled = okInput,
            onClick = {

                    val genre = listOf(abstract,children,customizable,family,party,strategy,thematic,wargame)
                    val datetime = pickedDate.atTime(pickedTime)
                println(datetime)

                    val convertDateTime = Timestamp(datetime.toEpochSecond(java.time.ZoneOffset.UTC),0)
                println(convertDateTime)

                    val newDocument = hashMapOf(
                        "titel" to titel,
                        "stadt" to stadt,
                        "alter1" to alter1,
                        "alter2" to alter2,
                        "erfahrung" to erfahrung,
                        "spiele" to spiele,
                        "prototyp" to prototyp,
                        "genre" to genre,
                        "beschreibung" to beschreibung,
                        "date" to convertDateTime
                    )

                    meeting
                        .add(newDocument)
                        .addOnSuccessListener { documentReference ->
                            println("meeting created")
                        }
                        .addOnFailureListener { exception ->
                            println("failed to create meeting")
                        }

                //updateCardList()
                navController.popBackStack()
                navController.navigate("startScreen")
            }
        )
    }
}

/*
@Composable
@Preview
fun ErstellenPreview(){
    Erstellen()
}

 */

@Composable
@Preview
fun NewMeetingPreview(){
    NewMeeting(navController = rememberNavController())
}
