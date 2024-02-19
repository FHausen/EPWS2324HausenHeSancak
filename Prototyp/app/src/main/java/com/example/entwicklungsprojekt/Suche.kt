package com.example.entwicklungsprojekt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.entwicklungsprojekt.ui.theme.Blue40
import com.example.entwicklungsprojekt.ui.theme.BlueWhite40

@Composable
fun Suche() {

    Column(modifier = Modifier.fillMaxSize().background(color = Blue40).padding(horizontal = 50.dp, vertical = 50.dp), horizontalAlignment = Alignment.Start) {


        Text(text = buildAnnotatedString { append("Suchergebnisse für ")
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) { append("\"Kartenspiele\"") }
            append(" ") }, color = Color.Black, fontSize = 19.sp)

        Spacer(modifier = Modifier.height(14.dp))

        Text(
            text = buildAnnotatedString {
                append("\"")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("5")
                }
                append("\" Ergebnisse für ")
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("Uno, Phase 10, Skipbo")
                }
                append(" ")
            },
            color = Color.Black,
            fontSize = 14.sp
        )


        Spacer(modifier = Modifier.height(40.dp))

        Box(modifier = Modifier.width(290.dp).height(2.dp).background(color = Color.White))

        Spacer(modifier = Modifier.height(50.dp))

        Row {
            Box(modifier = Modifier.size(290.dp, 88.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
                Box(modifier = Modifier.size(100.dp, 88.dp).background(color = BlueWhite40, shape = RoundedCornerShape(8.dp)).align(Alignment.CenterStart)) {}
                Icon(imageVector = Icons.Default.Person, contentDescription = "Profil", tint = Color.White, modifier = Modifier.padding(5.dp).size(90.dp))
                Text(text = "Uno \n" + "Hier finden Sie eine Beschreibung für Ihre Spielerunde", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.align(Alignment.CenterStart).padding(start = 110.dp, end = 10.dp)) }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Row {
            Box(modifier = Modifier.size(290.dp, 88.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
                Box(modifier = Modifier.size(100.dp, 88.dp).background(color = BlueWhite40, shape = RoundedCornerShape(8.dp)).align(Alignment.CenterStart)) {}
                Icon(imageVector = Icons.Default.Person, contentDescription = "Profil", tint = Color.White, modifier = Modifier.padding(5.dp).size(90.dp))
                Text(text = "Uno \n" + "Hier finden Sie eine Beschreibung für Ihre Spielerunde", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.align(Alignment.CenterStart).padding(start = 110.dp, end = 10.dp)) }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Row {
            Box(modifier = Modifier.size(290.dp, 88.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
                Box(modifier = Modifier.size(100.dp, 88.dp).background(color = BlueWhite40, shape = RoundedCornerShape(8.dp)).align(Alignment.CenterStart)) {}
                Icon(imageVector = Icons.Default.Person, contentDescription = "Profil", tint = Color.White, modifier = Modifier.padding(5.dp).size(90.dp))
                Text(text = "Phase 10 \n" + "Hier finden Sie eine Beschreibung für Ihre Spielerunde", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.align(Alignment.CenterStart).padding(start = 110.dp, end = 10.dp)) }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Row {
            Box(modifier = Modifier.size(290.dp, 88.dp).background(Color.White, shape = RoundedCornerShape(8.dp))) {
                Box(modifier = Modifier.size(100.dp, 88.dp).background(color = BlueWhite40, shape = RoundedCornerShape(8.dp)).align(Alignment.CenterStart)) {}
                Icon(imageVector = Icons.Default.Person, contentDescription = "Profil", tint = Color.White, modifier = Modifier.padding(5.dp).size(90.dp))
                Text(text = "Skipbo \n" + "Hier finden Sie eine Beschreibung für Ihre Spielerunde", color = Color.Black, fontWeight = FontWeight.Bold, textAlign = TextAlign.Start, modifier = Modifier.align(Alignment.CenterStart).padding(start = 110.dp, end = 10.dp)) }
        }

        Spacer(modifier = Modifier.height(50.dp))

        Box(modifier = Modifier.size(290.dp, 50.dp).background(Color.White, shape = RoundedCornerShape(30.dp)), contentAlignment = Alignment.Center) {
            Text(text = "TRETE SPIEL BEI", color = Blue40, fontWeight = FontWeight.Bold)}
    }
}

@Composable
@Preview
fun SuchePreview(){
    Suche()
}
