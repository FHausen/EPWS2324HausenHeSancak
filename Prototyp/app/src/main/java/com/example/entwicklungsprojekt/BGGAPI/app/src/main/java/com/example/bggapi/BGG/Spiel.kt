package com.example.bggapi.BGG

class Spiel {
    var thumbnail: String? = ""
    var name: String? = ""
    var minplayers : Int? = 0
    var maxplayers : Int? = 0
    var rating : Double? = 0.0
    var genres = mutableListOf<String?>()
}