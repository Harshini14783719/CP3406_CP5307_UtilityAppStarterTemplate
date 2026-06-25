package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FocusViewModel : ViewModel() {

    var timer = mutableStateOf(25)
    var focusScore = mutableStateOf(84)

    var weather = mutableStateOf("30°C Cloudy")
    var quote = mutableStateOf("Loading quote...")

    var darkMode = mutableStateOf(false)


    init {
        fetchQuote()
    }

    fun toggleDarkMode() {
        darkMode.value = !darkMode.value
    }

    fun startTimer() {
        timer.value--
    }

    fun resetTimer() {
        timer.value = 25
    }

    fun setTimer(minutes: Int) {
        timer.value = minutes
    }

    fun fetchQuote() {

        RetrofitInstance.api.getQuote().enqueue(object :
            Callback<List<Map<String, String>>> {

            override fun onResponse(
                call: Call<List<Map<String, String>>>,
                response: Response<List<Map<String, String>>>
            ) {
                if (response.isSuccessful) {
                    val quoteText = response.body()?.get(0)?.get("q")
                    quote.value = quoteText ?: "No quote found"
                }
            }

            override fun onFailure(
                call: Call<List<Map<String, String>>>,
                t: Throwable
            ) {
                quote.value = "API Error"
            }
        })
    }
}