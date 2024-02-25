package com.example.entwicklungsprojekt.BGG

import com.example.example.*
import okhttp3.OkHttpClient
import retrofit2.*
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import retrofit2.http.Url


interface BGGApi {
    @GET
    fun searchGame (@Url url : String) : Call <Game>
}

class RestAPI {

private val bggApi: BGGApi

init {
    val mHttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    val mOkHttpClient = OkHttpClient.Builder().addInterceptor(mHttpLoggingInterceptor).build()
    val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://www.boardgamegeek.com/xmlapi2/").addConverterFactory(GsonConverterFactory.create()).client(mOkHttpClient).build()
    bggApi = retrofit.create(BGGApi::class.java)
}
suspend fun getGame (query: String) :Call<Game> {
    return bggApi.searchGame(query)
}
}
