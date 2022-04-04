package com.example.weatherapp.Model

import java.sql.Timestamp
import java.util.ArrayList
import java.util.Date

data class WeatherData(
    val coordinates:Coordinates,
    //var weather=ArrayList<Weather>(),
    val weather:ArrayList<Weather>,
    val base:String="",
    val main:Main,
    val visibility:Int=0,
    val wind:Wind,
    val clouds:Clouds,
    val rain:Rain,
  //  val snow:Snow,
    //val dt:Timestamp ,
    val dt:String="000" ,
    val sys:Sys,
    val timezone:Int=0,
    val id:String="000",
    val name:String="00",
    val cod:Int=0

)
data class Weather(
    val id:Int=0,
    val main:String="",
    val description:String="",
    val icon:String="")
data class Coordinates(
    val lon:Float=0F,
    val lat:Float=0F)
data class Main(
    val temp:Float=0F,
    val humidity:Float=0F,
    val pressure:Float=0F,
    val temp_min:Float=0F,
    val temp_max:Float=0F
)
data class Wind(
    val speed:Float=0F,
    val deg:Float=0F,
    val gust:Float=0F
)
data class Clouds(
    val all:Float=0F
)
data class Rain(
    val h3:Float=0F
)
//data class Snow()
data class Sys(
    val country:String="",
    val sunrise:Long=0L,
    val sunset:Long=0L
    //val sunrise:String="",
    //val sunset:String=""
)
