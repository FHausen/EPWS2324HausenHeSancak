package com.example.algorithmuspoc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Start(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize().background(color = Blue40).padding(horizontal = 50.dp, vertical = 50.dp), horizontalAlignment = Alignment.Start) {
        Text(text = "Hallo Spieler", color = Color.Black, fontWeight = FontWeight.Light, fontSize = 20.sp, textAlign = TextAlign.Right)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Ein neuer Tag eine neue Runde", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Start)
////
        Spacer(modifier = Modifier.height(50.dp))
        Box(modifier = Modifier.width(290.dp).height(2.dp).background(color = Color.White))
        Spacer(modifier = Modifier.height(40.dp))
////
        Text(text = "FINDE EINE SPIELERUNDE ", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp, textAlign = TextAlign.Start)
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.size(width = 290.dp, height = 200.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Column(modifier = Modifier.align(Alignment.TopStart).padding(20.dp)) {
                Button(onClick = { navController.navigate("findeSpielerunde") }, shape = CutCornerShape(2), modifier = Modifier.size(width = 260.dp, height = 100.dp), colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)) {
                    Text(text = "FINDE", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp)) } }
            Column(modifier = Modifier.align(Alignment.BottomCenter).padding(20.dp)) {
                Text(text = "Hier finden Sie eine Beschreibung für Ihr Spiel. Weitere Details sind hier verfügbar", style = TextStyle(color = Color.Black)) } }
        Spacer(modifier = Modifier.height(40.dp))
////
        Text(text = "ERSTELLE EINE SPIELERUNDE ", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp, textAlign = TextAlign.Start)
        Spacer(modifier = Modifier.height(20.dp))
        Box(modifier = Modifier.size(width = 290.dp, height = 200.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Column(modifier = Modifier.align(Alignment.TopStart).padding(20.dp)) {
                Button(onClick = { navController.navigate("erstelleSpielerunde") }, shape = CutCornerShape(2), modifier = Modifier.size(width = 260.dp, height = 100.dp), colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)) {
                    Text(text = "ERSTELLEN", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp)) } }
            Column(modifier = Modifier.align(Alignment.BottomCenter).padding(20.dp)) {
                Text(text = "Hier finden Sie eine Beschreibung für Ihr Spiel. Weitere Details sind hier verfügbar", style = TextStyle(color = Color.Black)) } }
    }
}
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val actions = remember(navController) { NavActions(navController) }
    NavHost(navController, startDestination = "startScreen") {
        composable("startScreen") { Start(navController = navController) }
        composable("findeSpielerunde") { FindeSpielerunde() }
        composable("erstelleSpielerunde") { ErstelleSpielerunde() } } }

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

        Box(modifier = Modifier
            .size(290.dp, 50.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(text = "(Bitte PLZ wählen)", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier
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
