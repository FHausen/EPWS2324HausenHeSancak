package com.example.example

import com.google.gson.annotations.SerializedName


data class Expansions (

  @SerializedName("name"   ) var name   : String? = null,
  @SerializedName("gameId" ) var gameId : Int?    = null

)