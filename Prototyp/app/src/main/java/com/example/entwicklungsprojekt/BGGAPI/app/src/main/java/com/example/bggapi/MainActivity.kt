package com.example.bggapi

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bggapi.BGG.Spiel
import com.example.bggapi.ui.theme.BGGAPITheme
import com.example.entwicklungsprojekt.BGG.RestAPI
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BGGAPITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        runBlocking {
            val spieleliste = mutableListOf<Spiel>()
            val api = RestAPI()
           // val queryList = ArrayList<Int>(174430)
            launch(Dispatchers.IO) {
               // queryList.forEach {
                    //val query = it
                    val callResponse =
                        api.getGame("https://bgg-json.azurewebsites.net/thing/174430")
                    val response = callResponse.execute()


                    if (response.isSuccessful) {
                        val spiel: Spiel = Spiel()
                        spiel.thumbnail = response.body()?.thumbnail
                        spiel.name = response.body()?.name
                        spiel.minplayers = response.body()?.minPlayers
                        spiel.maxplayers = response.body()?.maxPlayers
                        spiel.rating = response.body()?.averageRating
                        spieleliste.add(spiel)
                    } else Throwable(response.message())
                }


            Log.d("TAG_",spieleliste.toString())
            }
        }
  //      }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BGGAPITheme {
        Greeting("Android")
    }
}