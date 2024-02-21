package com.example.entwicklungsprojekt

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import com.example.entwicklungsprojekt.ui.theme.Blue40
import com.example.entwicklungsprojekt.ui.theme.BlueWhite40

@Composable
fun Start(navController: NavHostController) {
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
                Text(text = "FINDE EINE TREFFEN", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp)} }

        Spacer(modifier = Modifier.height(90.dp))
        Box(modifier = Modifier.size(width = 290.dp, height = 200.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Column(modifier = Modifier.align(Alignment.TopStart).padding(20.dp)) {
                Button(onClick = { navController.navigate("erstelleeinTreffen") }, shape = CutCornerShape(2), modifier = Modifier.size(width = 260.dp, height = 110.dp), colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)) {
                    Text(text = "ERSTELLEN", style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp)) } }
            Column(modifier = Modifier.align(Alignment.BottomCenter).padding(20.dp)) {
                Text(text = "ERSTELLE EIN TREFFEN", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 20.sp)} }
    }
}
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val actions = remember(navController) { NavActions(navController) }
    NavHost(navController, startDestination = "startScreen") {
        composable("startScreen") { Start(navController = navController) }
        composable("findeeinTreffen") { FindeTreffen() }
        composable("erstelleeinTreffen") { ErstelleTreffen() } } }

class NavActions(navController: NavHostController) {
    val navigateToFindeTreffen: () -> Unit = { navController.navigate("findeeinTreffen") }
    val navigateToErstelleTreffen: () -> Unit = { navController.navigate("erstelleeinTreffen") } }


@Composable
fun FindeTreffen() {
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

        Box(modifier = Modifier
            .size(290.dp, 50.dp)
            .background(Color.White, shape = RoundedCornerShape(30.dp)), contentAlignment = Alignment.Center) {
            Text(text = "WEITER", color = Blue40, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun ErstelleTreffen() {
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

        Box(modifier = Modifier
            .size(290.dp, 48.dp)
            .background(Color.White, shape = RoundedCornerShape(30.dp)), contentAlignment = Alignment.Center) {
            Text(text = "ERSTELLE EIN TREFFEN", color = Blue40, fontWeight = FontWeight.Bold)}
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
fun FindeTreffenreview() {
    FindeTreffen()
}

@Composable
@Preview
fun ErstelleTreffenPreview() {
    ErstelleTreffen()
}
