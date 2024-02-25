package com.example.entwicklungsprojekt

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import java.time.LocalDateTime


@Composable
fun MeetingCard(
    meeting: Meeting,
    navController: NavController
) {
    var genreAll = ""
    meeting.genre.forEachIndexed{ index, b ->
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
            .clickable { navController.navigate(NavScreen.SingleMeeting.withArg(meeting.groupId)) }
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
                text = "Titel: "+meeting.titel,
            )
            Text(
                fontSize = 12.sp,
                text = "Beschreibung: "+meeting.beschreibung,
            )
            Text(
                fontSize = 12.sp,
                text = "Ort: "+meeting.stadt+", Datum: "+meeting.date.dayOfMonth+"."+meeting.date.monthValue+"."+meeting.date.year+"  "+meeting.date.hour+":"+meeting.date.minute,
            )
            Text(
                fontSize = 12.sp,
                text = "Alter: "+meeting.alter1+" bis "+meeting.alter2+", Erfahrung: "+meeting.erfahrung,
            )
            Text(
                fontSize = 12.sp,
                text = "Genre: "+genreAll,
            )
            Text(
                fontSize = 12.sp,
                text = "Spiele: "+meeting.spiele,
            )
            if (meeting.prototyp){
                Text(
                    fontSize = 12.sp,
                    text = "Prototyp",
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            joinedMeetingList.forEach { id ->
                if (id==meeting.groupId) {
                    Text(
                        textAlign = TextAlign.End,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        text = "Treffen beigetreten",
                    )
                }
            }
        }
    }
}

@Composable
fun AllMeeting(
    navController: NavController
){
    var filteredList = mutableListOf<Meeting>()
    meetingListAll.forEach { id ->
        if (id.date.isAfter(LocalDateTime.now())) {
            filteredList.add(id)
        }
    }
    filteredList.sortBy { it.date }


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
                text = "Alle Treffen",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
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
                items(filteredList){
                        item -> MeetingCard(item,navController = navController)
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
                updateData()
                navController.navigate("startScreen")
            }
        )
    }
}

@Composable
fun JoinedMeeting(
    navController: NavController
){
    var filteredList = mutableListOf<Meeting>()
    joinedMeetingList.forEach { id ->
        val n = meetingListAll.find { group -> group.groupId == id }
        if (n != null) {
            if (n.date.isAfter(LocalDateTime.now())) {
                filteredList.add(n)
            }
        }
    }
    filteredList.sortBy { it.date }

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
                text = "Beigetreten",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
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
                items(filteredList){
                        item -> MeetingCard(item,navController = navController)
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
                updateData()
                navController.navigate("startScreen")
            }
        )
    }
}


@Composable
fun SingleMeeting(
    navController: NavController,
    meetingIndex: String
){
    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val joined = db.collection("user").document("prototype").collection("groups").document("joined")


    var current = meetingListAll.find { g -> g.groupId == meetingIndex }

    if (current!=null) {

        var genreAll = ""
        current.genre.forEachIndexed { index, b ->
            if (index == 0 && b) genreAll += "Abstract, "
            if (index == 1 && b) genreAll += "Children, "
            if (index == 2 && b) genreAll += "Customizable, "
            if (index == 3 && b) genreAll += "Family, "
            if (index == 4 && b) genreAll += "Party, "
            if (index == 5 && b) genreAll += "Strategy, "
            if (index == 6 && b) genreAll += "Thematic, "
            if (index == 7 && b) genreAll += "Wargame, "
        }
        if (genreAll != "") genreAll.dropLast(2)

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



                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp)
                ) {
                    Text(
                        text = "Titel",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    joinedMeetingList.forEach { id ->
                        if (id==current.groupId) {
                            Text(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                text = "Beigetreten",
                            )
                        }
                    }
                }

                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp),
                    text = current.titel,
                    fontSize = 16.sp,
                )


                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp),
                    text = "Beschreibung",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp),
                    text = current.beschreibung,
                    fontSize = 16.sp,
                )


                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp),
                    text = "Stadt",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp),
                    text = current.stadt,
                    fontSize = 16.sp,
                )

                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp),
                    text = "Datum und Uhrzeit",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp),
                    text = current.date.dayOfMonth.toString() + "." + current.date.monthValue + "." + current.date.year + "  " + current.date.hour + ":" + current.date.minute,
                    fontSize = 16.sp,
                )

                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp),
                    text = "Altersgruppe",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp),
                    text = current.alter1 + " bis " + current.alter2+" Jahren",
                    fontSize = 16.sp,
                )


                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp),
                    text = "Erfahrung",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp),
                    text = current.erfahrung,
                    fontSize = 16.sp,
                )


                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp),
                    text = "Spiele",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp),
                    text = current.spiele,
                    fontSize = 16.sp,
                )


                if (current.prototyp) {
                    Text(
                        modifier = Modifier
                            .padding(start = 10.dp)
                            .padding(top = 15.dp)
                            .padding(bottom = 5.dp),
                        text = "Prototypen enthalten",
                        fontSize = 16.sp,
                    )
                }


                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp),
                    text = "Genres",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .padding(top = 15.dp)
                        .padding(bottom = 5.dp),
                    text = genreAll,
                    fontSize = 16.sp,
                )

                Spacer(modifier = Modifier.height(76.dp))
            }


            if (joinedMeetingList.contains(current.groupId)) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                        .height(56.dp)
                        .align(Alignment.BottomCenter),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40),
                    content = { Text(text = "ZURÜCK", color = Color.DarkGray) },
                    enabled = true,
                    onClick = {
                        navController.navigateUp()
                    }
                )
            }else{
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

                        val newJoinedGroups = joinedMeetingList
                        newJoinedGroups.add(current.groupId)
                        val newDocument = hashMapOf(
                            "groups" to newJoinedGroups
                        )
                        joined
                            .set(newDocument)
                            .addOnSuccessListener { documentReference ->
                                println("meeting created")
                            }
                            .addOnFailureListener { exception ->
                                println("failed to create meeting")
                            }
                        updateData()
                        navController.navigateUp()
                    }
                )
            }
        }
    }else{
        Text(
            modifier = Modifier
                .padding(start = 10.dp)
                .padding(top = 15.dp)
                .padding(bottom = 5.dp),
            text = "Meeting nicht gefunden",
            fontSize = 12.sp,
        )
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .height(56.dp),
            shape = CircleShape,
            colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40),
            content = { Text(text = "ZURÜCK ZUM HAUPTMENÜ", color = Color.DarkGray) },
            enabled = true,
            onClick = {
                updateData()
                navController.navigate("startScreen")
            }
        )
    }
}

@Composable
fun RecommendedMeeting(
    navController: NavController
){
    var matchedList = mutableListOf<MeetingFit>()
    val favGenre = listOf(sfavAbstract,sfavChildren,sfavCustomizable,sfavFamily,sfavParty,sfavStrategy,sfavThematic,sfavWargame)


    meetingListAll.forEach { id ->
        if (id.date.isAfter(LocalDateTime.now())) {
            if (getFittingGroup(id, sstadt, salter, serfahrung,favGenre)>0){
                matchedList.add(MeetingFit(id,getFittingGroup(id, sstadt, salter, serfahrung,favGenre)))
            }
        }
    }
    matchedList.sortByDescending { it.similarity }
    matchedList.forEach { i -> println(i.similarity) }


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
                text = "Empfehlungen",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
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
                items(matchedList){
                        item -> MeetingCard(item.meeting,navController = navController)
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
                updateData()
                navController.navigate("startScreen")
            }
        )
    }
}


@Composable
fun PrototypeMeeting(
    navController: NavController
) {
    var filteredList = mutableListOf<Meeting>()
    meetingListAll.forEach { id ->
        if (id.prototyp) {
            if (id.date.isAfter(LocalDateTime.now())) {
                filteredList.add(id)
            }
        }
    }
    filteredList.sortBy { it.date }

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
                text = "Prototypen",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
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
                items(filteredList) { item ->
                    MeetingCard(item, navController = navController)
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
                updateData()
                navController.navigate("startScreen")
            }
        )
    }
}