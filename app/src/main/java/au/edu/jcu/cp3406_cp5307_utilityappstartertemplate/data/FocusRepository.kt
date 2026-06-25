package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data

import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.network.RetrofitInstance
import retrofit2.Call

class FocusRepository {

    fun getQuoteData(): Call<List<Map<String, String>>> {
        return RetrofitInstance.api.getQuote()
    }
}