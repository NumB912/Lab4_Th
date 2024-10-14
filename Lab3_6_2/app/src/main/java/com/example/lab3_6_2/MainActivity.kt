package com.example.lab3_6_2

import TimerViewModel
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.lab3_6_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: TimerViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Quan sát LiveData
        viewModel.time.observe(this, Observer { time ->
            binding.tvTimer.text = time.toString()
        })

        // Thiết lập sự kiện cho nút Start/Pause
        binding.btnStartPause.setOnClickListener {
            if (binding.btnStartPause.text == "Start") {
                viewModel.startTimer()
                binding.btnStartPause.text = "Pause"
            } else {
                viewModel.pauseTimer()
                binding.btnStartPause.text = "Start"
            }
        }

        // Thiết lập sự kiện cho nút Reset
        binding.btnReset.setOnClickListener {
            viewModel.resetTimer()
            binding.btnStartPause.text = "Start"
        }
    }

    // Lưu trạng thái khi cấu hình thay đổi
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("timerValue", viewModel.time.value ?: 0)
    }

    // Khôi phục trạng thái khi cấu hình thay đổi
     override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val timerValue = savedInstanceState.getInt("timerValue", 0)
        viewModel.resetTimer()
        viewModel._time.value = timerValue
    }
}
