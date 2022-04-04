package com.example.weatherapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.Model.ForecastData
import com.example.weatherapp.Model.Repo
import com.example.weatherapp.Model.WeatherData
import kotlinx.coroutines.launch

class WeatherDetailsNormalVM(application: Application): AndroidViewModel(application) {
    private val _forecastData : MutableLiveData<ForecastData> = MutableLiveData()
    val forecastData : LiveData<ForecastData>
        get() {
            return _forecastData
        }

    fun changeForecast(name:String){
        viewModelScope.launch {
            val newForecast = Repo.getForecast(name)
            //val newFruit = Repo.getall()
            val z=0
            if(newForecast != null)
                _forecastData.value = newForecast!!
        }
    }
}