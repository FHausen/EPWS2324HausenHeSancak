package com.example.entwicklungsprojekt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.epspieltreffen.ui.theme.Blue40
import com.example.epspieltreffen.ui.theme.BlueWhite40
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.epspieltreffen.ui.theme.EPSpieltreffenTheme

@Composable
fun Start(
    navController: NavHostController,
    navigateToFindeTreffen: () -> Unit,
    navigateToErstelleTreffen: () -> Unit
)  {
    Column(modifier = Modifier.fillMaxSize().background(color = Blue40).padding(horizontal = 50.dp, vertical = 50.dp), horizontalAlignment = Alignment.Start) {
        Text(text = "Hallo Spieler", color = Color.Black, fontWeight = FontWeight.Light, fontSize = 20.sp, textAlign = TextAlign.Right)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Ein neuer Tag eine neue Runde", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Start)

        Spacer(modifier = Modifier.height(50.dp))
        Box(modifier = Modifier.width(290.dp).height(2.dp).background(color = Color.White))

        Spacer(modifier = Modifier.height(90.dp))
        Box(modifier = Modifier.size(width = 290.dp, height = 200.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Column(modifier = Modifier.align(Alignment.TopStart).padding(20.dp)) {
                Button(onClick = { navController.navigate("findeeinTreffen") }, shape = CutCornerShape(2), modifier = Modifier.size(width = 260.dp, height = 110.dp), colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)) {
                    Text(text = "FINDE", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp)) } }
            Column(modifier = Modifier.align(Alignment.BottomCenter).padding(20.dp)) {
                Text(text = "FINDE EINE TREFFEN", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            } }

        Spacer(modifier = Modifier.height(90.dp))
        Box(modifier = Modifier.size(width = 290.dp, height = 200.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Column(modifier = Modifier.align(Alignment.TopStart).padding(20.dp)) {
                Button(onClick = { navController.navigate("erstelleeinTreffen") }, shape = CutCornerShape(2), modifier = Modifier.size(width = 260.dp, height = 110.dp), colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)) {
                    Text(text = "ERSTELLEN", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp)) } }
            Column(modifier = Modifier.align(Alignment.BottomCenter).padding(20.dp)) {
                Text(text = "ERSTELLE EIN TREFFEN", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            } }
    }
}

@Composable
fun FindeTreffen(navController: NavController, navigateToSpielTreffen: () -> Unit)  {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Blue40)
        .padding(horizontal = 50.dp, vertical = 50.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Finde eine Treffen", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 34.sp, textAlign = TextAlign.Center)
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
                Text(text = "Bitte Kategorie wählen", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier
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
                Text(text = "Bitte Spiel wählen", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier
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
                Text(text = "Bitte Stadt wählen", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier
                    .weight(1f)
                    .padding(15.dp))
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Pfeil", tint = Color.Black, modifier = Modifier
                    .padding(10.dp)
                    .size(40.dp)) }
        }
        Spacer(modifier = Modifier.height(50.dp))


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
                                    text = "Bitte PLZ eingeben",
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

        Spacer(modifier = Modifier.height(50.dp))

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
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = { navController.navigate("spieleTreffen") }, modifier = Modifier.size(290.dp, 50.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
            Text(text = "WEITER", color = Blue40, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ErstelleTreffen(navController: NavController, navigateToSpielTreffen: () -> Unit) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Blue40)
        .padding(horizontal = 50.dp, vertical = 50.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Erstelle ein Treffen", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 34.sp, textAlign = TextAlign.Center)
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
                Text(text = "Bitte Kategorie wählen", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier
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
                Text(text = "Bitte Spiel wählen", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier
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
                Text(text = "Bitte Spieleranzahl wählen", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier
                    .weight(1f)
                    .padding(15.dp))
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Pfeil", tint = Color.Black, modifier = Modifier
                    .padding(10.dp)
                    .size(40.dp)) }
        }
        Spacer(modifier = Modifier.height(50.dp))

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
                                    text = "Bitte Stadt eingeben",
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
        Spacer(modifier = Modifier.height(205.dp))

        Button(onClick = { navController.navigate("spieleTreffen") }, modifier = Modifier.size(290.dp, 50.dp), colors = ButtonDefaults.buttonColors(containerColor = Color.White)) {
            Text(text = "ERSTELLE EIN TREFFEN", color = Blue40, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "startScreen") {
        composable("startScreen") {
            Start(
                navController = navController,
                navigateToFindeTreffen = { navController.navigate("findeeinTreffen") }
            ) { navController.navigate("erstelleeinTreffen") }
        }
        composable("findeeinTreffen") {
            FindeTreffen(
                navController = navController
            ) { navController.navigate("spieleTreffen") }
        }
        composable("erstelleeinTreffen") {
            ErstelleTreffen(
                navController = navController
            ) { navController.navigate("spieleTreffen") }
        }
        composable("spieleTreffen") {
            SpielTreffen()
        }
    }
}

@Composable
fun SpielTreffen() {

    Column(modifier = Modifier.fillMaxSize().background(color = Blue40).padding(horizontal = 50.dp), horizontalAlignment = Alignment.Start) {
        Spacer(modifier = Modifier.height(50.dp))

        Text(text = "Passende Spieltreffen in Ihrer Nähe", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp, textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(50.dp))
        Box(modifier = Modifier.width(290.dp).height(2.dp).background(color = Color.White))

        Spacer(modifier = Modifier.height(40.dp))
        Row { Box(modifier = Modifier.size(290.dp, 88.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Box(modifier = Modifier.size(100.dp, 88.dp).background(color = BlueWhite40, shape = RoundedCornerShape(8.dp)).align(Alignment.CenterStart)) {}
            Icon(imageVector = Icons.Default.Person, contentDescription = "Profil", tint = Color.White, modifier = Modifier.padding(5.dp).size(90.dp))
            Text(text = "Uno \n" + "Hier finden Sie eine Beschreibung für Ihre Spielerunde", color = Color.Black, fontSize = 13.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.align(Alignment.CenterStart).padding(start = 110.dp, end = 10.dp)) } }

        Spacer(modifier = Modifier.height(25.dp))

        Row { Box(modifier = Modifier.size(290.dp, 88.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Box(modifier = Modifier.size(100.dp, 88.dp).background(color = BlueWhite40, shape = RoundedCornerShape(8.dp)).align(Alignment.CenterStart)) {}
            Icon(imageVector = Icons.Default.Person, contentDescription = "Profil", tint = Color.White, modifier = Modifier.padding(5.dp).size(90.dp))
            Text(text = "Uno \n" + "Hier finden Sie eine Beschreibung für Ihre Spielerunde", color = Color.Black, fontSize = 13.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.align(Alignment.CenterStart).padding(start = 110.dp, end = 10.dp)) } }

        Spacer(modifier = Modifier.height(25.dp))

        Row { Box(modifier = Modifier.size(290.dp, 88.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Box(modifier = Modifier.size(100.dp, 88.dp).background(color = BlueWhite40, shape = RoundedCornerShape(8.dp)).align(Alignment.CenterStart)) {}
            Icon(imageVector = Icons.Default.Person, contentDescription = "Profil", tint = Color.White, modifier = Modifier.padding(5.dp).size(90.dp))
            Text(text = "Phase 10 \n" + "Hier finden Sie eine Beschreibung für Ihre Spielerunde", color = Color.Black, fontSize = 13.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.align(Alignment.CenterStart).padding(start = 110.dp, end = 10.dp)) } }

        Spacer(modifier = Modifier.height(25.dp))

        Row { Box(modifier = Modifier.size(290.dp, 88.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Box(modifier = Modifier.size(100.dp, 88.dp).background(color = BlueWhite40, shape = RoundedCornerShape(8.dp)).align(Alignment.CenterStart)) {}
            Icon(imageVector = Icons.Default.Person, contentDescription = "Profil", tint = Color.White, modifier = Modifier.padding(5.dp).size(90.dp))
            Text(text = "Skipbo \n" + "Hier finden Sie eine Beschreibung für Ihre Spielerunde", color = Color.Black, fontSize = 13.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.align(Alignment.CenterStart).padding(start = 110.dp, end = 10.dp)) } }

        Spacer(modifier = Modifier.height(25.dp))

        Row { Box(modifier = Modifier.size(290.dp, 88.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Box(modifier = Modifier.size(100.dp, 88.dp).background(color = BlueWhite40, shape = RoundedCornerShape(8.dp)).align(Alignment.CenterStart)) {}
            Icon(imageVector = Icons.Default.Person, contentDescription = "Profil", tint = Color.White, modifier = Modifier.padding(5.dp).size(90.dp))
            Text(text = "Skipbo \n" + "Hier finden Sie eine Beschreibung für Ihre Spielerunde", color = Color.Black, fontSize = 13.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.align(Alignment.CenterStart).padding(start = 110.dp, end = 10.dp)) } }

        Spacer(modifier = Modifier.height(25.dp))

        Row { Box(modifier = Modifier.size(290.dp, 88.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Box(modifier = Modifier.size(100.dp, 88.dp).background(color = BlueWhite40, shape = RoundedCornerShape(8.dp)).align(Alignment.CenterStart)) {}
            Icon(imageVector = Icons.Default.Person, contentDescription = "Profil", tint = Color.White, modifier = Modifier.padding(5.dp).size(90.dp))
            Text(text = "Skipbo \n" + "Hier finden Sie eine Beschreibung für Ihre Spielerunde", color = Color.Black, fontSize = 13.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.align(Alignment.CenterStart).padding(start = 110.dp, end = 10.dp)) } }

        Spacer(modifier = Modifier.height(25.dp))

        Row { Box(modifier = Modifier.size(290.dp, 88.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Box(modifier = Modifier.size(100.dp, 88.dp).background(color = BlueWhite40, shape = RoundedCornerShape(8.dp)).align(Alignment.CenterStart)) {}
            Icon(imageVector = Icons.Default.Person, contentDescription = "Profil", tint = Color.White, modifier = Modifier.padding(5.dp).size(90.dp))
            Text(text = "Skipbo \n" + "Hier finden Sie eine Beschreibung für Ihre Spielerunde", color = Color.Black, fontSize = 13.sp, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.align(Alignment.CenterStart).padding(start = 110.dp, end = 10.dp)) } }
    }

}

@Composable
@Preview
fun StartPreview() {
    val navController = rememberNavController()
    Start(
        navController = navController,
        navigateToFindeTreffen = { navController.navigate("findeeinTreffen") },
        navigateToErstelleTreffen = { navController.navigate("erstelleeinTreffen") }
    )
}

@Composable
@Preview
fun FindeTreffenReview() {
    val navController = rememberNavController()
    FindeTreffen(navController = navController) {
        navController.navigate("spieleTreffen")
    }
}

@Composable
@Preview
fun ErstelleTreffenPreview() {
    val navController = rememberNavController()
    ErstelleTreffen(navController = navController) {
        navController.navigate("spieleTreffen")
    }
}

@Composable
@Preview
fun SpielTreffenPreview(){
    SpielTreffen()
}
