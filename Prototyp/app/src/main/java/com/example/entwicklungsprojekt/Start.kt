package com.example.entwicklungsprojekt

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.entwicklungsprojekt.ui.theme.Blue40
import com.example.entwicklungsprojekt.ui.theme.BlueWhite40
import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.time.ZoneOffset

@Composable
fun Start(navController: NavHostController) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Blue40)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 5.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start)
        {

            Button(
                onClick = { navController.navigate("pref") },
                shape = CutCornerShape(10),
                modifier = Modifier
                    .size(width = 170.dp, height = 40.dp)
                    .align(Alignment.End),
                colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = Color.Black
                )
                Text(
                    text = "Präferenzen",
                    style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Hallo Spieler",
                color = Color.Black,
                fontWeight = FontWeight.Light,
                fontSize = 20.sp,
                textAlign = TextAlign.Right
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Ein neuer Tag eine neue Runde",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Start
            )
////
            Spacer(modifier = Modifier.height(30.dp))

            Box(modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = Color.White)
            )
        }


        LazyColumn(
            modifier = Modifier
                .padding(top = 195.dp),
            contentPadding = PaddingValues(horizontal = 30.dp, vertical = 8.dp),
            content = {


                item {
                    Button(
                        onClick = { navController.navigate("treffenVorschlag") },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .padding(vertical = 15.dp)
                            .height(60.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)
                    ) {
                        Icon(imageVector = Icons.Default.ThumbUp, contentDescription = null,tint = Color.Black)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "EMPFOHLENE GRUPPEN",
                            style = TextStyle(color = Color.Black, fontSize = 20.sp)
                        )
                    }
                }


                item {
                    Button(
                        onClick = { navController.navigate("treffenPrototyp") },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .padding(vertical = 15.dp)
                            .height(60.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)
                    ) {
                        Icon(imageVector = Icons.Default.Build, contentDescription = null,tint = Color.Black)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "PROTOTYPEN TESTEN",
                            style = TextStyle(color = Color.Black, fontSize = 20.sp)
                        )
                    }
                }


                item {
                    Button(
                        onClick = { navController.navigate("alleTreffen") },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .padding(vertical = 15.dp)
                            .height(60.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)
                    ) {
                        Icon(imageVector = Icons.Default.List, contentDescription = null,tint = Color.Black)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "ALLE GRUPPEN",
                            style = TextStyle(color = Color.Black, fontSize = 20.sp))
                    }
                }

                item {
                    Button(
                        onClick = { navController.navigate("NewMeeting") },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .padding(vertical = 15.dp)
                            .height(60.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)
                    ) {
                        Icon(imageVector = Icons.Default.AddCircle, contentDescription = null,tint = Color.Black)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "TREFFEN ERSTELLEN",
                            style = TextStyle(color = Color.Black, fontSize = 20.sp)
                        )
                    }
                }


                item {
                    Button(
                        onClick = { navController.navigate("treffenBeigetreten") },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .padding(vertical = 15.dp)
                            .height(60.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)
                    ) {
                        Icon(imageVector = Icons.Default.DateRange, contentDescription = null,tint = Color.Black)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "BEIGETRETENE TREFFEN",
                            style = TextStyle(color = Color.Black, fontSize = 20.sp)
                        )
                    }
                }


            }
        )

    }
}

/*
class MainViewModel : ViewModel() {

var sstadt = ""
var salter = ""
var serfahrung = ""
var sfavAbstract = false
var sfavChildren = false
var sfavCustomizable = false
var sfavFamily = false
var sfavParty = false
var sfavStrategy = false
var sfavThematic = false
var sfavWargame = false

var sjoinedGroups = mutableListOf<String>()

    var gruppenListe = mutableListOf<Group>()

    fun updateData(){
        CoroutineScope(Dispatchers.Main).launch {

            val db: FirebaseFirestore = FirebaseFirestore.getInstance()
            val savedprefQuery = db.collection("user").document("prototype").collection("pref").document("savedpref")
            val meetingQuery = db.collection("meeting")
            val joinedQuery = db.collection("user").document("prototype").collection("groups").document("joined")

            joinedQuery.get()
                .addOnSuccessListener { snapshot ->
                    sjoinedGroups = snapshot.data?.get("groups") as MutableList<String>
                }
                .addOnFailureListener { exeption ->
                    println("failed to get joined groups")
                }

            savedprefQuery.get()
                .addOnSuccessListener { snapshot ->
                    sstadt = snapshot.data?.get("stadt") as String
                    salter = snapshot.data?.get("alter") as String
                    serfahrung = snapshot.data?.get("erfahrung") as String
                    val favGenre = snapshot.data?.get("favGenre") as List<Boolean>
                    sfavAbstract = favGenre[0]
                    sfavChildren = favGenre[1]
                    sfavCustomizable = favGenre[2]
                    sfavFamily = favGenre[3]
                    sfavParty = favGenre[4]
                    sfavStrategy = favGenre[5]
                    sfavThematic = favGenre[6]
                    sfavWargame = favGenre[7]
                }
                .addOnFailureListener { exeption ->
                    println("failed to get preference")
                }

            meetingQuery.get()
                .addOnSuccessListener { snapshot ->
                    val documentList = snapshot.documents
                    gruppenListe.clear()
                    for (m in documentList){
                        val meetingData = m.data

                        val groupid = m.id
                        val titel = meetingData?.get("titel") as String
                        val stadt = meetingData["stadt"] as String
                        val alter1 = meetingData["alter1"] as String
                        val alter2 = meetingData["alter2"] as String
                        val erfahrung = meetingData["erfahrung"] as String
                        val spiele = meetingData["spiele"] as String
                        val prototyp = meetingData["prototyp"] as Boolean
                        val genre = meetingData["genre"] as List<Boolean>
                        val beschreibung = meetingData["beschreibung"] as String
                        val timestamp = meetingData["date"] as Timestamp
                        val date = timestamp.toDate().toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime()

                        gruppenListe.add(
                            Group(
                                groupid,
                                titel,
                                stadt,
                                genre,
                                alter1,
                                alter2,
                                erfahrung,
                                spiele,
                                prototyp,
                                beschreibung,
                                date
                            )
                        )
                    }
                }

        }
    }
}

 */


@Composable
fun Navigation() {
    val navController = rememberNavController()
    val actions = remember(navController) { NavActions(navController) }
    NavHost(navController, startDestination = "startScreen") {
        composable("startScreen") { Start(navController = navController) }
        composable("findeSpielerunde") { FindeSpielerunde() }
        composable("erstelleSpielerunde") { ErstelleSpielerunde() }
        composable(NavScreen.UserPref.route) { UserPref(navController = navController) }
        composable(NavScreen.NewMeeting.route) { NewMeeting(navController = navController) }
        composable(NavScreen.TreffenSammlung.route) { TreffenSammlung(navController = navController) }
        composable(NavScreen.TreffenEinzel.route + "/{index}", listOf(navArgument("index") { type = NavType.StringType })
        ) { entry ->
            entry.arguments?.getString("index")
                ?.let { TreffenEinzel(navController = navController,treffenIndex = it) }
        }
        composable(NavScreen.Treffenbeigetreten.route) { TreffenBeigetreten(navController = navController) }
        composable(NavScreen.TreffenVorschlag.route) { TreffenVorschlag(navController = navController) }
        composable(NavScreen.TreffenPrototyp.route) { TreffenPrototyp(navController = navController) }
    }
}

sealed class NavScreen(val route:String){

    object TreffenSammlung:NavScreen("alleTreffen")
    object NewMeeting:NavScreen("newMeeting")
    object UserPref:NavScreen("pref")
    object TreffenEinzel:NavScreen("treffenEinzel")
    object Treffenbeigetreten:NavScreen("treffenBeigetreten")
    object TreffenVorschlag:NavScreen("treffenVorschlag")
    object TreffenPrototyp:NavScreen("treffenPrototyp")

    fun withArg(vararg arg:String):String{
        return buildString {
            append(route)
            arg.forEach { arg -> append("/$arg") }
        }
    }
}



class NavActions(navController: NavHostController) {
val navigateToFindeSpielerunde: () -> Unit = { navController.navigate("findeSpielerunde") }
val navigateToErstelleSpielerunde: () -> Unit = { navController.navigate("erstelleSpielerunde") } }


@Composable
fun FindeSpielerunde() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Blue40)
        .padding(horizontal = 50.dp, vertical = 50.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Finde eine Runde", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 36.sp, textAlign = TextAlign.Center)
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
        Spacer(modifier = Modifier.height(46.dp))

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
        Spacer(modifier = Modifier.height(46.dp))

        Box(modifier = Modifier
            .size(290.dp, 25.dp)
            .background(Color.White, shape = RoundedCornerShape(25.dp))) {
            Box(modifier = Modifier
                .size(290.dp, 25.dp)
                .background(Color.White, shape = RoundedCornerShape(25.dp))) {
                Icon(imageVector = Icons.Default.Info, contentDescription = "Standort", tint = Color.Black, modifier = Modifier
                    .padding(0.dp)
                    .size(40.dp))
                Text(text = "Suche im Umkreis eines Ortes", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.padding(40.dp, vertical = 4.dp))}
        }
        Spacer(modifier = Modifier.height(46.dp))

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
        Spacer(modifier = Modifier.height(46.dp))

        /*Box(modifier = Modifier
        .size(290.dp, 50.dp)
        .background(Color.White, shape = RoundedCornerShape(8.dp))) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
            Text(text = "(Bitte PLZ wählen)", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier
                .weight(1f)
                .padding(15.dp))
            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Pfeil", tint = Color.Black, modifier = Modifier
                .padding(10.dp)
                .size(40.dp)) }
        }*/

        var plz by remember { mutableStateOf("") }

        Box(
            modifier = Modifier
                .size(290.dp, 50.dp)
                .background(Color.White, shape = RoundedCornerShape(8.dp))
                .clickable(onClick = { })
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                BasicTextField(
                    value = plz,
                    onValueChange = { plz = it },
                    modifier = Modifier
                        .weight(1f)
                        .padding(15.dp)
                        .background(Color.Transparent),
                    textStyle = TextStyle(color = Color.Black),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            innerTextField()
                            if (plz.isEmpty()) {
                                Text(
                                    text = "(Bitte PLZ eingeben)",
                                    color = Color.Black.copy(alpha = 1f),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                )
                            }
                        }
                    }
                )
            }
        }
        Spacer(modifier = Modifier.height(46.dp))

        Box(modifier = Modifier
            .size(290.dp, 50.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Umkreis 5 km", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier
                    .weight(1f)
                    .padding(15.dp))
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Pfeil", tint = Color.Black, modifier = Modifier
                    .padding(10.dp)
                    .size(40.dp)) }
        }
        Spacer(modifier = Modifier.height(46.dp))

        Box(modifier = Modifier
            .size(290.dp, 50.dp)
            .background(Color.White, shape = RoundedCornerShape(30.dp)), contentAlignment = Alignment.Center) {
            Text(text = "WEITER", color = Blue40, fontWeight = FontWeight.Bold)
        }
    }
}




@Composable
fun ErstelleSpielerunde() {
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

@Composable
@Preview
fun StartPreview() {
val navController = rememberNavController()
val actions = remember(navController) { NavActions(navController) }
Start(navController)
}


@Composable
@Preview
fun FindeSpielerundePreview() {
FindeSpielerunde()
}

@Composable
@Preview
fun ErstelleSpielerundePreview() {
ErstelleSpielerunde()
}
