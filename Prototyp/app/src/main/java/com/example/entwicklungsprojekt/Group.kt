package com.example.entwicklungsprojekt

import com.google.firebase.Timestamp
import com.google.firebase.firestore.FirebaseFirestore
import java.time.ZoneOffset

var sstadt = ""
var salter = ""
var serfahrung = ""
var sfavAbstract = false
var sfavChildren = false
var sfavCustomizable = false
var sfavFamily = false
var sfavParty = false
var sfavStrategy = false
var sfavThematic = false
var sfavWargame = false

var joinedMeetingList = mutableListOf<String>()

var meetingListAll = mutableListOf<Meeting>()

fun updateData(){

    val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    val savedprefQuery = db.collection("user").document("prototype").collection("pref").document("savedpref")
    val meetingQuery = db.collection("meeting")
    val joinedQuery = db.collection("user").document("prototype").collection("groups").document("joined")

    joinedQuery.get()
        .addOnSuccessListener { snapshot ->
            joinedMeetingList = snapshot.data?.get("groups") as MutableList<String>
        }
        .addOnFailureListener { exeption ->
            println("failed to get joined groups")
        }

    savedprefQuery.get()
        .addOnSuccessListener { snapshot ->
            sstadt = snapshot.data?.get("stadt") as String
            salter = snapshot.data?.get("alter") as String
            serfahrung = snapshot.data?.get("erfahrung") as String
            val favGenre = snapshot.data?.get("favGenre") as List<Boolean>
            sfavAbstract = favGenre[0]
            sfavChildren = favGenre[1]
            sfavCustomizable = favGenre[2]
            sfavFamily = favGenre[3]
            sfavParty = favGenre[4]
            sfavStrategy = favGenre[5]
            sfavThematic = favGenre[6]
            sfavWargame = favGenre[7]
        }
        .addOnFailureListener { exeption ->
            println("failed to get preference")
        }

    meetingQuery.get()
        .addOnSuccessListener { snapshot ->
            val documentList = snapshot.documents
            meetingListAll.clear()
            for (m in documentList){
                val meetingData = m.data

                val groupid = m.id
                val titel = meetingData?.get("titel") as String
                val stadt = meetingData["stadt"] as String
                val alter1 = meetingData["alter1"] as String
                val alter2 = meetingData["alter2"] as String
                val erfahrung = meetingData["erfahrung"] as String
                val spiele = meetingData["spiele"] as String
                val prototyp = meetingData["prototyp"] as Boolean
                val genre = meetingData["genre"] as List<Boolean>
                val beschreibung = meetingData["beschreibung"] as String
                val timestamp = meetingData["date"] as Timestamp
                val date = timestamp.toDate().toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime()

                meetingListAll.add(
                    Meeting(
                        groupid,
                        titel,
                        stadt,
                        genre,
                        alter1,
                        alter2,
                        erfahrung,
                        spiele,
                        prototyp,
                        beschreibung,
                        date
                    )
                )
            }
        }

}