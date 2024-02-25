package com.example.entwicklungsprojekt

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.entwicklungsprojekt.ui.theme.Blue40
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExposedDropDownMenu(options: List<String>, defaultText: String) {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf(defaultText) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = it }
    ) {

        TextField(
            modifier = Modifier.size(290.dp, 50.dp)
                .menuAnchor()
                .clip(RoundedCornerShape(8.dp)),
            readOnly = true,
            value = selectedOption,
            onValueChange = {},
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            textStyle = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            ),
            colors = ExposedDropdownMenuDefaults.textFieldColors()
        )


        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        selectedOption = option
                        expanded = false
                    },
                    contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding,
                )
            }
        }
    }
}

@Composable
fun ErstelleTreffen(navController: NavController, navigateToSpielTreffen: () -> Unit) {
    val kategorieList = listOf(
        "Kartenspiel",
        "Strategiespiel",
        "Familienspiel",
        "Würfelspiel",
        "Geschicklichkeitsspiel",
        "Brettspiel",
        "Kinderspiel",
        "Wargames",
        "Partyspiele"
    )

    val spieleList = listOf(
        "Phase 10",
        "Uno",
        "Skipbo",
        "Halli Galli",
        "Kribbeln",
        "Code",
        "Ligretto"
    )

    val spieleranzahlList = listOf(
        "1 Spieler",
        "2 Spieler",
        "3 Spieler",
        "4 Spieler",
        "5 Spieler",
        "6 Spieler",
    )

    var stadt by remember { mutableStateOf(TextFieldValue()) }
    val suggestions = listOf(
        "Koeln",
        "Bonn",
        "Gummerbach",
        "Duesseldorf",
        "Essen",
        "Wuppertal")

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Blue40),
    ) {

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 50.dp, vertical = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Erstelle ein Treffen",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Start
            )
            Spacer(modifier = Modifier.height(50.dp))
            Box(modifier = Modifier.width(290.dp).height(2.dp).background(color = Color.White))

            Spacer(modifier = Modifier.height(50.dp))
            ExposedDropDownMenu(options = kategorieList, defaultText = "Bitte Kategorie wählen")
            Spacer(modifier = Modifier.height(50.dp))
            ExposedDropDownMenu(options = spieleList, defaultText = "Bitte Spiel wählen")
            Spacer(modifier = Modifier.height(50.dp))
            ExposedDropDownMenu(options = spieleranzahlList, defaultText = "Bitte Spieleranzahl wählen")
            Spacer(modifier = Modifier.height(50.dp))

            Box(
                modifier = Modifier
                    .width(290.dp)
                    .height(50.dp)
                    .background(color = Gray40, shape = RoundedCornerShape(8.dp))
            ) {
                BasicTextField(
                    value = stadt,
                    onValueChange = { newValue ->
                        stadt = newValue
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(15.dp),
                    textStyle = TextStyle(color = Color.Black),
                    decorationBox = { innerTextField ->
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            innerTextField()
                            if (stadt.text.isEmpty()) {
                                Text(
                                    text = "Bitte Stadt eingeben",
                                    color = Color.Black.copy(alpha = 1f),
                                    fontWeight = FontWeight.Bold,
                                    textAlign = TextAlign.Start,
                                    style = TextStyle(fontSize = 14.sp)
                                )
                            } else {
                                suggestions.forEach { suggestion ->
                                    if (suggestion.startsWith(stadt.text, ignoreCase = true)) {
                                        Text(
                                            text = suggestion,
                                            color = Color.Gray,
                                            textAlign = TextAlign.Start,
                                            style = TextStyle(fontSize = 14.sp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                )
            }

            Spacer(modifier = Modifier.height(150.dp))

            Button(
                onClick = { navController.navigate("spieleTreffen") },
                modifier = Modifier.size(290.dp, 50.dp),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Text(
                    text = "ERSTELLE EIN TREFFEN",
                    color = Blue40,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
@Preview
fun ErstelleTreffenPreview() {
    val navController = rememberNavController()
    ErstelleTreffen(navController = navController) {
        navController.navigate("spieleTreffen")
    }
}