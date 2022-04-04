package com.example.weatherapp.Model

import com.example.weatherapp.Model.WeatherData
import retrofit2.awaitResponse

class Repo {

    companion object {



        suspend fun getFruitByFamily(City:String): WeatherData? {
            return Retro.api.getCurrentWeather(City,"metric","e519f199a407af9c9ff53b11d608b9b2").awaitResponse().body()
        }
        suspend fun getall(): WeatherData? {
            return Retro.api.getAll().awaitResponse().body()
        }
        suspend fun getForecast(City:String): ForecastData? {

            return Retro.api.getForecast( City,"metric","e519f199a407af9c9ff53b11d608b9b2").awaitResponse().body()
        }



    }
}