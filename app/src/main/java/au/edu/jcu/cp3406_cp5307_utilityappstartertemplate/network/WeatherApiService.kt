package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.network

import retrofit2.Call
import retrofit2.http.GET

interface WeatherApiService {

    @GET("v1/forecast?latitude=1.3521&longitude=103.8198&current=temperature_2m")

    fun getWeather(): Call<Map<String, Any>>
}