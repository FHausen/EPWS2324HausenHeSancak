package com.example.entwicklungsprojekt

import android.view.RoundedCorner
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.entwicklungsprojekt.ui.theme.Blue40
import com.example.entwicklungsprojekt.ui.theme.BlueWhite40
import com.google.firebase.firestore.FirebaseFirestore


@Composable
fun TreffenCard(
    group: Group,
    navController: NavController
) {

    var genreAll = ""
    group.genre.forEachIndexed{index,b ->
        if (index==0&&b)genreAll += "Abstract, "
        if (index==1&&b)genreAll += "Children, "
        if (index==2&&b)genreAll += "Customizable, "
        if (index==3&&b)genreAll += "Family, "
        if (index==4&&b)genreAll += "Party, "
        if (index==5&&b)genreAll += "Strategy, "
        if (index==6&&b)genreAll += "Thematic, "
        if (index==7&&b)genreAll += "Wargame, "
    }
    if (genreAll!="")genreAll.dropLast(2)

    Box(
        modifier = Modifier
        .fillMaxSize()
        .padding(10.dp)
        //.clickable { navController.navigate("TreffenEinzel".withArg(group.groupId)) }
        .shadow(
            elevation = 10.dp,
            shape = RoundedCornerShape(14.dp)
        )
        .background(Color.White)

    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
        ) {
            Text(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                text = "Titel: "+group.titel,
            )
            Text(
                fontSize = 12.sp,
                text = "Ort: "+group.stadt+", Datum: "+group.date.dayOfMonth+"."+group.date.monthValue+"."+group.date.year+"  "+group.date.hour+":"+group.date.minute,
            )
            Text(
                fontSize = 12.sp,
                text = "Alter: "+group.alter1+" bis "+group.alter2+", Erfahrung: "+group.erfahrung,
            )
            Text(
                    fontSize = 12.sp,
            text = "Beschreibung: "+group.beschreibung,
            )
            Text(
                fontSize = 12.sp,
                text = "Genre: "+genreAll,
            )
            Text(
                fontSize = 12.sp,
                text = "Spiele: "+group.spiele,
            )
            if (group.prototyp){
                Text(
                    fontSize = 12.sp,
                    text = "Prototyp",
                )
            }

        }
    }

}

@Composable
fun TreffenSammlung(
    navController: NavController
){

    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val meeting = db.collection("meeting")



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
                text = "Finde ein Treffen",
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

        }
        LazyColumn(
            modifier = Modifier
                .padding(top = 100.dp)
                .padding(bottom = 70.dp),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            content = {
                items(gruppenListe){
                        item -> TreffenCard(item,navController = navController)
                }
            }
        )


        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(56.dp)
                .align(Alignment.BottomCenter),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40),
            content = { Text(text = "HAUPTMENÜ", color = Color.DarkGray) },
            enabled = true,
            onClick = {
                navController.navigate("startScreen")
            }
        )
    }
}


@Composable
fun TreffenEinzel(
    navController: NavController
){

    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val meeting = db.collection("meeting")


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
                text = "Finde ein Treffen",
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

        }


        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(56.dp)
                .align(Alignment.BottomCenter),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40),
            content = { Text(text = "BEITRETEN", color = Color.DarkGray) },
            enabled = true,
            onClick = {
                navController.navigate("alleTreffen")
            }
        )
    }
}