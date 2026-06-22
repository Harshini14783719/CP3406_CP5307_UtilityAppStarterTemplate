package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class FocusViewModel : ViewModel() {

    var timer = mutableStateOf(25)

    var focusScore = mutableStateOf(84)

    fun startTimer() {
        timer.value--
    }

    fun resetTimer() {
        timer.value = 25
    }
}