package com.example.entwicklungsprojekt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.navigation.compose.rememberNavController
import com.example.entwicklungsprojekt.ui.theme.Blue40
import com.example.entwicklungsprojekt.ui.theme.BlueWhite40

@Composable
fun Start(
    navController: NavHostController,
    navigateToFindeTreffen: () -> Unit,
    navigateToErstelleTreffen: () -> Unit)  {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Blue40)
        .padding(horizontal = 50.dp, vertical = 50.dp), horizontalAlignment = Alignment.Start) {
        Text(text = "Hallo Spieler", color = Color.Black, fontWeight = FontWeight.Light, fontSize = 20.sp, textAlign = TextAlign.Right)
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Ein neuer Tag eine neue Runde", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 30.sp, textAlign = TextAlign.Start)

        Spacer(modifier = Modifier.height(50.dp))
        Box(modifier = Modifier
            .width(290.dp)
            .height(2.dp)
            .background(color = Color.White))

        Spacer(modifier = Modifier.height(70.dp))
        Box(modifier = Modifier
            .size(width = 290.dp, height = 200.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Column(modifier = Modifier
                .align(Alignment.TopStart)
                .padding(20.dp)) {
                Button(
                    onClick = { navController.navigate("findeeinTreffen") },
                    shape = CutCornerShape(2),
                    modifier = Modifier.size(width = 260.dp, height = 120.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)
                ) {
                    Icon(Icons.Default.Search, contentDescription = "Suche Icon", modifier = Modifier.size(140.dp))
                }
            }
            Column(modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp)) {
                Text(text = "FINDE EINE TREFFEN", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
        }




        Spacer(modifier = Modifier.height(70.dp))
        Box(modifier = Modifier
            .size(width = 290.dp, height = 200.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Column(modifier = Modifier
                .align(Alignment.TopStart)
                .padding(20.dp)) {
                Button(
                    onClick = { navController.navigate("erstelleeinTreffen") },
                    shape = CutCornerShape(2),
                    modifier = Modifier.size(width = 260.dp, height = 120.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)
                ) {
                    Icon(Icons.Default.Person, contentDescription = "Person Icon", modifier = Modifier.size(140.dp))
                }
            }
            Column(modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(20.dp)) {
                Text(text = "ERSTELLE EINE TREFFEN", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            }
        }
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