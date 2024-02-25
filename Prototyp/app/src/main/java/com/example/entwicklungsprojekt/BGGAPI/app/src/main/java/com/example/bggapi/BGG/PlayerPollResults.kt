package com.example.example

import com.google.gson.annotations.SerializedName


data class PlayerPollResults (

  @SerializedName("numPlayers"            ) var numPlayers            : Int?     = null,
  @SerializedName("best"                  ) var best                  : Int?     = null,
  @SerializedName("recommended"           ) var recommended           : Int?     = null,
  @SerializedName("notRecommended"        ) var notRecommended        : Int?     = null,
  @SerializedName("numPlayersIsAndHigher" ) var numPlayersIsAndHigher : Boolean? = null

)