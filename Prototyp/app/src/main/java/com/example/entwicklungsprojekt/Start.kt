package com.example.entwicklungsprojekt

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.entwicklungsprojekt.ui.theme.Blue40
import com.example.entwicklungsprojekt.ui.theme.BlueWhite40

@Composable
fun Start(navController: NavHostController) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Blue40)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 30.dp, vertical = 5.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.Start)
        {

            Button(
                onClick = { navController.navigate(NavScreen.UserPref.route) },
                shape = CutCornerShape(10),
                modifier = Modifier
                    .size(width = 170.dp, height = 40.dp)
                    .align(Alignment.End),
                colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)
            ) {
                Icon(
                    imageVector = Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    tint = Color.Black
                )
                Text(
                    text = "Präferenzen",
                    style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Hallo Spieler",
                color = Color.Black,
                fontWeight = FontWeight.Light,
                fontSize = 20.sp,
                textAlign = TextAlign.Right
            )

            Spacer(modifier = Modifier.height(5.dp))

            Text(
                text = "Ein neuer Tag eine neue Runde",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Start
            )

            Spacer(modifier = Modifier.height(30.dp))

            Box(modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
                .background(color = Color.White)
            )
        }

        LazyColumn(
            modifier = Modifier
                .padding(top = 195.dp),
            contentPadding = PaddingValues(horizontal = 30.dp, vertical = 8.dp),
            content = {


                item {
                    Button(
                        onClick = {
                            updateData()
                            navController.navigate(NavScreen.RecommendedMeeting.route)
                                  },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .padding(vertical = 15.dp)
                            .height(60.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)
                    ) {
                        Icon(imageVector = Icons.Default.ThumbUp, contentDescription = null,tint = Color.Black)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "EMPFOHLENE TREFFEN",
                            style = TextStyle(color = Color.Black, fontSize = 20.sp)
                        )
                    }
                }


                item {
                    Button(
                        onClick = {
                            updateData()
                            navController.navigate(NavScreen.PrototypeMeeting.route)
                                  },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .padding(vertical = 15.dp)
                            .height(60.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)
                    ) {
                        Icon(imageVector = Icons.Default.Build, contentDescription = null,tint = Color.Black)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "PROTOTYPEN TESTEN",
                            style = TextStyle(color = Color.Black, fontSize = 20.sp)
                        )
                    }
                }


                item {
                    Button(
                        onClick = {
                            updateData()
                            navController.navigate(NavScreen.AllMeeting.route)
                                  },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .padding(vertical = 15.dp)
                            .height(60.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)
                    ) {
                        Icon(imageVector = Icons.Default.List, contentDescription = null,tint = Color.Black)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "ALLE TREFFEN",
                            style = TextStyle(color = Color.Black, fontSize = 20.sp))
                    }
                }


                item {
                    Button(
                        onClick = {
                            updateData()
                            navController.navigate(NavScreen.JoinedMeeting.route)
                                  },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .padding(vertical = 15.dp)
                            .height(60.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)
                    ) {
                        Icon(imageVector = Icons.Default.DateRange, contentDescription = null,tint = Color.Black)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "BEIGETRETENE TREFFEN",
                            style = TextStyle(color = Color.Black, fontSize = 20.sp)
                        )
                    }
                }


                item {
                    Button(
                        onClick = {
                            updateData()
                            navController.navigate(NavScreen.NewMeeting.route)
                                  },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .padding(vertical = 15.dp)
                            .height(60.dp)
                            .fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = BlueWhite40)
                    ) {
                        Icon(imageVector = Icons.Default.AddCircle, contentDescription = null,tint = Color.Black)
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "TREFFEN ERSTELLEN",
                            style = TextStyle(color = Color.Black, fontSize = 20.sp)
                        )
                    }
                }
            }
        )
    }
}