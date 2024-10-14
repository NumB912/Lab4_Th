import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {
     var timerJob: Job? = null
     val _time = MutableLiveData<Int>()
     val time: LiveData<Int> get() = _time

    fun startTimer() {
        timerJob = viewModelScope.launch {
            while (true) {
                delay(1000) // Delay 1 giây
                _time.value = (_time.value?:0)+1
            }
        }
    }

    fun pauseTimer() {
        timerJob?.cancel()
    }

    fun resetTimer() {
        timerJob?.cancel()
        _time.value = 0
    }
}
