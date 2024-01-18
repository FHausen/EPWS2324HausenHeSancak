package com.example.algorithmuspoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.algorithmuspoc.ui.theme.AlgorithmusPoCTheme
import kotlin.math.abs
import kotlin.random.Random
import kotlin.random.nextInt


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlgorithmusPoCTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Recommendation()
                }
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Recommendation() {

    var searchUser by remember { mutableStateOf(User(0,"", listOf(),0,0, listOf(), listOf())) }
    var search by remember { mutableStateOf("") }
    val similarUsers = mutableListOf<UserSimilarity>()
    val similarGroups = mutableListOf<GroupFitting>()
    val similarGames = mutableListOf<GameSimilarity>()
    val recommendedGroups = remember { mutableStateListOf<Group>()}
    val recommendedGames = remember { mutableStateListOf<Game>()}
    val popularGames = gameList.sortedByDescending { it.views }

    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier
                    .padding(all = 10.dp),
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                text = "PoC Algorithmus",
            )

            //Eingabefeld für die userID
            TextField(
                modifier = Modifier
                    .padding(all = 5.dp),
                value = search,
                onValueChange = { search = it },
                placeholder = { Text(text = "ID eingeben(1-50)") },
            )

            //Button für die Empfehlungen
            Button(
                modifier = Modifier
                    .padding(all = 5.dp),
                onClick = {

                    //Löschung von vorherigen Empfehlungen
                    similarUsers.clear()
                    similarGames.clear()
                    similarGroups.clear()
                    recommendedGames.clear()
                    recommendedGroups.clear()
                    searchUser = User(0,"", listOf(),0,0, listOf(), listOf())


                    //Im userList wird nach den eingegebenen userID gesucht
                    if(search!=""){
                        for (u in userList){
                            if(u.userId.toString()==search){
                                searchUser = u


                                //In den Datensätzen werden nach ähnlichen Objekten gesucht
                                groupList.forEach {
                                    if (getFittingGroup(u,it)>0){
                                        similarGroups.add(GroupFitting(it, getFittingGroup(u,it)))
                                    }
                                }
                                userList.forEach {
                                    if (getUserSimilarity(u,it)>0){
                                        similarUsers.add(UserSimilarity(it, getUserSimilarity(u,it)))
                                    }
                                }
                                u.gameHistory.forEach { gameId ->
                                    gameList.forEach {
                                        if (getGameSimilarity(gameList[gameId-1],it) >0){
                                            similarGames.add(GameSimilarity(it, getGameSimilarity(gameList[gameId-1],it)))
                                        }
                                    }
                                }


                                //Die gefundenen Objekte werden nach der höchsten Ähnlichkeit sortiert
                                similarGroups.sortedByDescending { it.similarity }
                                if(similarGroups.size>=7){
                                    similarGroups.subList(7,similarGroups.size).clear()
                                }
                                similarUsers.sortedByDescending { it.similarity }
                                if(similarUsers.size>=4){
                                    similarUsers.subList(4,similarUsers.size).clear()
                                }
                                similarGames.sortedByDescending { it.similarity }
                                if(similarGames.size>=4){
                                    similarGames.subList(4,similarGames.size).clear()
                                }


                                //Die Objekte werden der Empfehlungsliste hinzugefügt
                                similarGroups.forEach{
                                    recommendedGroups.add(it.group)
                                }
                                similarUsers.forEach{
                                    it.user.gameHistory.forEach {
                                            gameId-> if(gameList[gameId-1] !in recommendedGames){
                                            recommendedGames.add(gameList[gameId-1])
                                            }
                                    }
                                }
                                similarGames.forEach{
                                    recommendedGames.add(it.game)
                                }


                                //Populäre Spiele werden pro 10 Spiele hinzugefügt, um für Varrianz zu sorgen
                                if (recommendedGames.size!=0){
                                    val randomGroup = generateSequence {
                                        Random.nextInt(0..15)
                                    }   .distinct()
                                        .take(recommendedGames.size/10)
                                        .toSet()
                                    for (i in randomGroup){
                                        recommendedGames.add(popularGames[i])
                                    }
                                }


                                //Empfehlungsliste wird für Varrianz durchmischt
                                recommendedGroups.shuffle()
                                recommendedGames.shuffle()


                                //Falls keine Spiele oder Gruppen gefunden wurden, werden populäre Spiele und zufällige Gruppen vorgeschlagen
                                if (recommendedGroups.size==0){
                                    val randomGroup = generateSequence {
                                        Random.nextInt(groupList.indices)
                                    }   .distinct()
                                        .take(7)
                                        .toSet()
                                    for (i in randomGroup){
                                        recommendedGroups.add(groupList[i])
                                    }
                                }
                                if (recommendedGames.size==0){
                                    val randomGroup = generateSequence {
                                        Random.nextInt(0..15)
                                    }   .distinct()
                                        .take(7)
                                        .toSet()
                                    for (i in randomGroup){
                                        recommendedGames.add(popularGames[i])
                                    }
                                }
                            }
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray, contentColor = Color.Black)
            ) {
                Text(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Empfehlungen vorschlagen"
                )
            }

            //Der aktuelle Nutzer
            UserCard(user = searchUser)


            //Empfohlende Gruppen
            Text(
                modifier = Modifier
                    .padding(all = 16.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                text = "Vorgeschlagene Gruppen",
            )
            LazyColumn(
                modifier = Modifier
                    .height(200.dp),
                content = {
                    items(recommendedGroups){
                            item -> GroupCard(item)
                    }
                }
            )


            //Empfohlende Spiele
            Text(
                modifier = Modifier
                    .padding(all = 16.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                text = "Vorgeschlagene Spiele",
            )
            LazyColumn(
                content = {
                    items(recommendedGames){
                            item -> GameCard(item)
                    }
                }
            )
        }
    }
}

//Einzelne Zeile zur Darstellung vom Nutzer
@Composable
fun UserCard(user: User) {
    Column(
        modifier = Modifier
            .padding(all = 5.dp),
    ) {
        Text(
            fontSize = 12.sp,
            text = "ID: "+user.userId+", Ort: "+user.location+", Alter: "+user.age+", Erfahrung: "+user.experience,
        )
        Text(
            fontSize = 12.sp,
            text = "Genre: "+user.genre.joinToString(),
        )

    }
}

//Einzelne Zeile zur Darstellung von Gruppen
@Composable
fun GroupCard(group: Group) {
    Column(
        modifier = Modifier
            .padding(all = 5.dp),
    ) {
        Text(
            fontSize = 12.sp,
            text = "ID: "+group.groupId+", Ort: "+group.location+", Alter: "+group.age+", Erfahrung: "+group.experience,
        )
        Text(
            fontSize = 12.sp,
            text = "Genre: "+group.genre.joinToString(),
        )

    }
}

//Einzelne Zeile zur Darstellung von Spielen
@Composable
fun GameCard(game: Game) {
    Column(
        modifier = Modifier
            .padding(all = 5.dp),
    ) {
        Text(
            fontSize = 12.sp,
            text = "ID: "+game.gameId+", Alter: "+game.age+"+, Komplexität: "+game.complexity+", Aufrufe: "+game.views,
        )
        Text(
            fontSize = 12.sp,
            text = "Genre: "+game.genre.joinToString(),
        )

    }
}


