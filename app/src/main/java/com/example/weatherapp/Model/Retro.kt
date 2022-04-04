package com.example.weatherapp.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BaseUrl = "https://api.openweathermap.org/data/2.5/"
object Retro {
    private val retro by lazy{
        Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }

    val api : WeatherApi by lazy {
        Retrofit.Builder()
            .baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create())
            .build().create(WeatherApi::class.java)
    }
}