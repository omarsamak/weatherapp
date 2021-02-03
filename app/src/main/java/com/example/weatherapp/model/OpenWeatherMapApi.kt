package com.example.weatherapp.model

import com.example.weatherapp.model.response.CurrentWeatherResponse
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "8277b3d12b6e121e02edbd9a62640323"

//https://api.openweathermap.org/data/2.5/weather?q=cairo&appid=8277b3d12b6e121e02edbd9a62640323

interface OpenWeatherMapApi {
    @GET("weather")
    fun getCurrentWeather(
            @Query("q") location: String
    ): Deferred<CurrentWeatherResponse>

    companion object{
        operator fun invoke(): OpenWeatherMapApi {
            val requestInterceptor = Interceptor {chain ->
                val url = chain.request()
                        .url()
                        .newBuilder()
                        .addQueryParameter("appid", API_KEY)
                        .build()
                val request = chain.request()
                        .newBuilder()
                        .url(url)
                        .build()
                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(requestInterceptor)
                    .build()
            return Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("https://api.openweathermap.org/data/2.5/")
                    .addCallAdapterFactory(CoroutineCallAdapterFactory())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(OpenWeatherMapApi::class.java)
        }
    }
}