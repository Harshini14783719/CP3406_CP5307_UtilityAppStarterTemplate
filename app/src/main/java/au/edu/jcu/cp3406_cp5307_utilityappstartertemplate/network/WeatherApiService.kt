package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.network

import retrofit2.Call
import retrofit2.http.GET

interface WeatherApiService {

    @GET("api/random")

    fun getQuote(): Call<List<Map<String, String>>>
}