package com.example.example

import com.google.gson.annotations.SerializedName


data class Game (

  @SerializedName("gameId"            ) var gameId            : Int?                         = null,
  @SerializedName("name"              ) var name              : String?                      = null,
  @SerializedName("description"       ) var description       : String?                      = null,
  @SerializedName("image"             ) var image             : String?                      = null,
  @SerializedName("thumbnail"         ) var thumbnail         : String?                      = null,
  @SerializedName("minPlayers"        ) var minPlayers        : Int?                         = null,
  @SerializedName("maxPlayers"        ) var maxPlayers        : Int?                         = null,
  @SerializedName("playingTime"       ) var playingTime       : Int?                         = null,
  @SerializedName("mechanics"         ) var mechanics         : List<String>            = arrayListOf(),
  @SerializedName("isExpansion"       ) var isExpansion       : Boolean?                     = null,
  @SerializedName("yearPublished"     ) var yearPublished     : Int?                         = null,
  @SerializedName("bggRating"         ) var bggRating         : Double?                      = null,
  @SerializedName("averageRating"     ) var averageRating     : Double?                      = null,
  @SerializedName("rank"              ) var rank              : Int?                         = null,
  @SerializedName("designers"         ) var designers         : List<String>            = arrayListOf(),
  @SerializedName("publishers"        ) var publishers        : List<String>            = arrayListOf(),
  @SerializedName("artists"           ) var artists           : List<String>            = arrayListOf(),
  @SerializedName("playerPollResults" ) var playerPollResults : List<PlayerPollResults> = arrayListOf(),
  @SerializedName("expansions"        ) var expansions        : List<Expansions>        = arrayListOf()

)