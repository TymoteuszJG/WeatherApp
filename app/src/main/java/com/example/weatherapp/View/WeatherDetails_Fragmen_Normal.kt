package com.example.weatherapp.View

import java.text.SimpleDateFormat
import java.util.Date
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.R
import com.example.weatherapp.ViewModel.WeatherDetailsNormalVM
import com.example.weatherapp.ViewModel.WeatherDetailsVM
import kotlinx.coroutines.GlobalScope

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WeatherDetails.newInstance] factory method to
 * create an instance of this fragment.
 */
class WeatherDetails_Normal : Fragment() {

    lateinit var vm : WeatherDetailsNormalVM


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm = ViewModelProvider(this).get(WeatherDetailsNormalVM::class.java)
        val name = arguments?.getString("name")?:"Gliwice"
       // val name="Gliwice"
        vm.changeForecast(name)

       // vm.changeFruit("Gliwice")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_details, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.forecastData.observe(viewLifecycleOwner,{
            val timeD = Date((vm.forecastData.value?.city?.sunrise!!) * 1000)
            val sdf = SimpleDateFormat("HH:mm:ss")
            val Time: String = sdf.format(timeD)
            val timeD2 = Date((vm.forecastData.value?.city?.sunset!!) * 1000)
            val sdf2 = SimpleDateFormat("HH:mm:ss")
            val Time2: String = sdf2.format(timeD2)
            //view.findViewById<TextView>(R.id.City_Name).text=vm.forecastData.value?.cod.toString()
            view.findViewById<TextView>(R.id.City_Name).text=vm.forecastData.value?.city?.name.toString()
            view.findViewById<TextView>(R.id.Temperature_Value).text =
                vm.forecastData.value?.list?.get(0)?.main?.temp.toString()
            view.findViewById<TextView>(R.id.Pressure_Value).text =
                vm.forecastData.value?.list?.get(0)?.main?.pressure.toString()
            view.findViewById<TextView>(R.id.Sunrise_Value).text = Time
            view.findViewById<TextView>(R.id.Sunset_Value).text = Time2
            view.findViewById<TextView>(R.id.Weather_Description).text =
                vm.forecastData.value?.list?.get(0)?.weather?.get(0)?.description.toString()
            view.findViewById<TextView>(R.id.Temp_Day1).text=(vm.forecastData.value?.list?.get(8)?.main?.temp.toString()+"C")
            view.findViewById<TextView>(R.id.Temp_Day2).text=(vm.forecastData.value?.list?.get(16)?.main?.temp.toString()+"C")
            view.findViewById<TextView>(R.id.Temp_Day3).text=(vm.forecastData.value?.list?.get(24)?.main?.temp.toString()+"C")



        })

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment WeatherDetails.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WeatherDetails().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}