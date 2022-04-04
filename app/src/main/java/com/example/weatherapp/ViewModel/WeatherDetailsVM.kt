package com.example.weatherapp.ViewModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.Model.WeatherData
import com.example.weatherapp.Model.Repo

import kotlinx.coroutines.launch
class WeatherDetailsVM(application: Application): AndroidViewModel(application) {
    private val _weatherData : MutableLiveData<WeatherData> = MutableLiveData()
    val weatherdata : LiveData<WeatherData>
        get() {
            return _weatherData
        }

    fun changeFruit(name:String){
        viewModelScope.launch {
            val newFruit = Repo.getFruitByFamily(name)
            //val newFruit = Repo.getall()

            if(newFruit != null)
                _weatherData.value = newFruit!!
        }
    }

}