package com.example.clinic.network

import QuranRequestBody
import QuranResponse
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST


class ApisClient {
    companion object {
        const val BASE_URL = "https://gad25.xyz/Quran/"

        var gson = GsonBuilder()
            .setLenient()
            .create()


        fun getMyClient() = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        fun getMyClientServices() = getMyClient().create(QuranApiServices::class.java)
    }
}

interface QuranApiServices {

    @POST("QuranShared.php")
    fun getMySuras(@Body quranBody: QuranRequestBody): Call<QuranResponse>


    // TODO Sample on get request with path
//    @GET("QuranShared.php/{reader_id}")
//    fun getMySuras(@Path("reader_id") readerId:Int ):Response<QuranResponse>

    // TODO Sample on get request with query
//    @GET("QuranShared.php")
//    fun getMySuras(@Query("reader_id") readerId: Int ):Response<QuranResponse>

}