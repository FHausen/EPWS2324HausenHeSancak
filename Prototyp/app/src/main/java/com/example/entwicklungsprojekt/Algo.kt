package com.example.entwicklungsprojekt


import java.time.LocalDateTime


class Meeting(
    var groupId: String,
    var titel: String,
    var stadt: String,
    var genre: List<Boolean>,
    var alter1: String,
    var alter2: String,
    var erfahrung: String,
    var spiele: String,
    var prototyp: Boolean,
    var beschreibung: String,
    var date: LocalDateTime
)

class MeetingFit(
    var meeting: Meeting,
    var similarity: Int
)

fun getFittingGroup(meeting: Meeting, stadt: String, alter: String, erfahrung: String, genre: List<Boolean>):Int{

    var similarity = 0
    var genreSimilarity = 0

    if (meeting.alter1!=""&&meeting.alter2!=""&&meeting.stadt!=""&&meeting.erfahrung!=""&&stadt!=""&&alter!=""&&erfahrung!=""&&genre!=null){
        if (stadt==meeting.stadt) similarity += 2
        if (meeting.alter1.all { char -> char.isDigit()}&&meeting.alter2.all { char -> char.isDigit()}){
            if (alter.toInt() in meeting.alter1.toInt()..meeting.alter2.toInt()) similarity += 1
        }
        if (erfahrung==meeting.erfahrung) similarity += 1
        genre.forEachIndexed() {index,fav ->
            if (meeting.genre[index]==fav){
                similarity += 1
                genreSimilarity += 1
            }
        }

        return if (similarity>=3&&genreSimilarity>=1||stadt==meeting.stadt){
            similarity
        }
        else 0
    }else return 0
}