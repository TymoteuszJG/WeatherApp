package com.example.weatherapp.View

import java.text.SimpleDateFormat
import java.util.Date
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.R
import com.example.weatherapp.ViewModel.WeatherDetailsVM
import androidx.navigation.findNavController
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
class WeatherDetails : Fragment() {

    lateinit var vm : WeatherDetailsVM


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm = ViewModelProvider(this).get(WeatherDetailsVM::class.java)
        val name = arguments?.getString("name")?:"Gliwice"
       // val name="Gliwice"
        vm.changeFruit(name)

       // vm.changeFruit("Gliwice")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_details_elderly, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.GobackButton).setOnClickListener{

            it.findNavController().navigate(R.id.action_weatherDetails_to_chooseCity)
        }
        vm.weatherdata.observe(viewLifecycleOwner,{
            view.findViewById<TextView>(R.id.City_Name).text =
                vm.weatherdata.value?.name.toString()
            if(vm.weatherdata.value?.cod==200) {
                val timeD = Date((vm.weatherdata.value?.sys?.sunrise!!) * 1000)
                val sdf = SimpleDateFormat("HH:mm:ss")
                val Time: String = sdf.format(timeD)
                val timeD2 = Date((vm.weatherdata.value?.sys?.sunset!!) * 1000)
                val sdf2 = SimpleDateFormat("HH:mm:ss")
                val Time2: String = sdf2.format(timeD2)
                view.findViewById<TextView>(R.id.City_Name).text =
                    vm.weatherdata.value?.name.toString()
                view.findViewById<TextView>(R.id.Temperature_Value).text =
                    vm.weatherdata.value?.main?.temp.toString()
                view.findViewById<TextView>(R.id.Pressure_Value).text =
                    vm.weatherdata.value?.main?.pressure.toString()
                view.findViewById<TextView>(R.id.Sunrise_Value).text = Time
                view.findViewById<TextView>(R.id.Sunset_Value).text = Time2
                view.findViewById<TextView>(R.id.Weather_Description).text =
                    vm.weatherdata.value?.weather?.get(0)?.description.toString()
            }
            else{
                view.findViewById<TextView>(R.id.City_Name).text =
                    "Wrong City Name"
                view.findViewById<TextView>(R.id.Temperature_Value).text =
                    "Wrong City Name"
                view.findViewById<TextView>(R.id.Pressure_Value).text =
                    "Wrong City Name"
                view.findViewById<TextView>(R.id.Sunrise_Value).text = "Wrong City Name"
                view.findViewById<TextView>(R.id.Sunset_Value).text ="Wrong City Name"
                view.findViewById<TextView>(R.id.Weather_Description).text =
                    "Wrong City Name"


            }

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