package com.example.weatherapp.Model
import java.util.ArrayList
import com.example.weatherapp.Model.WeatherData

data class ForecastData(
    val cod:Int=0,
    val message:Int=0,
    val cnt:Int=0,
    val list:ArrayList<ListData>,
    val city:City

)
data class ListData(
    val dt:Long=0L,
    val main:Main,
    val weather:ArrayList<Weather>,
    val clouds: Clouds,
    val wind: Wind,
    val visibility:Int=0,
    val pop:Float=0.0F,
    val rain:Rain,
    val snow:Snow,
    val sys: Sys,
    val dt_text:String="",

)
data class Snow(
    val h :Float=0.0F,

)
data class City(
    val id:String="",
    val name:String="",
    val coord:Coordinates,
    val country:String="",
    val population:Int=0,
    val timezone:Int=0,
    val sunrise:Long=0L,
    val sunset:Long=0L
)



