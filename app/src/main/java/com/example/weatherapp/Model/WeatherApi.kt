package com.example.weatherapp.Model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherApi {
  //  @GET("weather?q={City}")
    //fun getCityData(@Path("City") City:String):Call<WeatherData>
    @GET("weather?q={City}&appid=e519f199a407af9c9ff53b11d608b9b2")
    fun getCityData(@Path("City") City:String):Call<WeatherData>

    @GET("weather?q=Gliwice&appid=e519f199a407af9c9ff53b11d608b9b2")
    fun getAll(): Call<WeatherData>

    @GET("weather?")
    fun getCurrentWeather(@Query("q") q:String,@Query("units") units:String,  @Query("appid") appid:String): Call<WeatherData>

    @GET("forecast?")
    fun getForecast(@Query("q") q:String, @Query("units") units:String, @Query("appid") appid:String): Call<ForecastData>

}

