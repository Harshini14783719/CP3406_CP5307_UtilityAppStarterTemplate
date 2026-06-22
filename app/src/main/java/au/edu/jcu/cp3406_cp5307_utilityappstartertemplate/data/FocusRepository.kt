package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data

import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.network.RetrofitInstance

class FocusRepository {

    fun getWeatherData() {
        RetrofitInstance.api.getWeather()
    }
}