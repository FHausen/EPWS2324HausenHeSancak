package com.example.entwicklungsprojekt

import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.entwicklungsprojekt.ui.theme.Blue40

@Composable
fun Runde() {

    Column(modifier = Modifier.fillMaxSize().background(color = Blue40).padding(horizontal = 50.dp, vertical = 50.dp), horizontalAlignment = Alignment.CenterHorizontally) {

        Text(text = "Finde eine Runde", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 36.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(50.dp))

        Box(modifier = Modifier.width(290.dp).height(2.dp).background(color = Color.White))
        Spacer(modifier = Modifier.height(50.dp))

        Box(modifier = Modifier.size(290.dp, 50.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(text = "(Bitte Kategorie wählen)", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.weight(1f).padding(15.dp))
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Pfeil", tint = Color.Black, modifier = Modifier.padding(10.dp).size(40.dp)) }
        }
        Spacer(modifier = Modifier.height(46.dp))

        Box(modifier = Modifier.size(290.dp, 50.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(text = "(Bitte Spiel wählen)", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.weight(1f).padding(15.dp))
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Pfeil", tint = Color.Black, modifier = Modifier.padding(10.dp).size(40.dp)) }
        }
        Spacer(modifier = Modifier.height(46.dp))

        Box(modifier = Modifier.size(290.dp, 25.dp).background(Color.White, shape = RoundedCornerShape(25.dp))) {
            Box(modifier = Modifier.size(290.dp, 25.dp).background(Color.White, shape = RoundedCornerShape(25.dp))) {
                Icon(imageVector = Icons.Default.Info, contentDescription = "Standort", tint = Color.Black, modifier = Modifier.padding(0.dp).size(40.dp))
                Text(text = "Suche im Umkreis eines Ortes", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Center, modifier = Modifier.padding(40.dp, vertical = 4.dp))}
        }
        Spacer(modifier = Modifier.height(46.dp))

        Box(modifier = Modifier.size(290.dp, 50.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(text = "(Bitte Stadt wählen)", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.weight(1f).padding(15.dp))
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Pfeil", tint = Color.Black, modifier = Modifier.padding(10.dp).size(40.dp)) }
        }
        Spacer(modifier = Modifier.height(46.dp))

        Box(modifier = Modifier.size(290.dp, 50.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(text = "(Bitte PLZ wählen)", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.weight(1f).padding(15.dp))
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Pfeil", tint = Color.Black, modifier = Modifier.padding(10.dp).size(40.dp)) }
        }
        Spacer(modifier = Modifier.height(46.dp))

        Box(modifier = Modifier.size(290.dp, 50.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                Text(text = "Umkreis 5 km", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.weight(1f).padding(15.dp))
                Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Pfeil", tint = Color.Black, modifier = Modifier.padding(10.dp).size(40.dp)) }
        }
        Spacer(modifier = Modifier.height(46.dp))

        Box(modifier = Modifier.size(290.dp, 50.dp).background(Color.White, shape = RoundedCornerShape(30.dp)), contentAlignment = Alignment.Center) {
            Text(text = "WEITER", color = Blue40, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
@Preview
fun RundePreview(){
    Runde()
}
