package com.example.weatherapp.ui.weather.future.detailed

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.R

class FutureDetailedWeatherFragment : Fragment() {

    companion object {
        fun newInstance() = FutureDetailedWeatherFragment()
    }

    private lateinit var viewModel: FutureDetailedWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.future_detailed_weather_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FutureDetailedWeatherViewModel::class.java)
        // TODO: Use the ViewModel
    }

}