package com.example.lab3_6
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.lab3_6.MainViewModel
import com.example.lab3_6.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Quan sát dữ liệu từ LiveData trong ViewModel
        viewModel.counter.observe(this, Observer { count ->
            binding.tvCounter.text = count.toString()
        })
        // Tăng giá trị khi người dùng nhấn nút
        binding.btnIncrement.setOnClickListener {
            viewModel.incrementCounter()
        }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Lưu giá trị biến đếm vào Bundle trước khi cấu hình thay đổi
        outState.putInt("counter", viewModel.counter.value ?: 0)
    }
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Khôi phục giá trị biến đếm sau khi cấu hình thay đổi
        val savedCounter = savedInstanceState.getInt("counter", 0)
        viewModel.incrementCounter(savedCounter)
    }

}
