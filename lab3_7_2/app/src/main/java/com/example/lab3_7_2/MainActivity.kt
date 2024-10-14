package com.example.lab3_7_2

import BookAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab3_7_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Sử dụng ViewBinding để thiết lập giao diện
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Dữ liệu mẫu
        val itemList = listOf(
            Book("Book 1", "author 1"),
            Book("Book 2", "author 2"),
            Book("Book 3", "author 3"),
            Book("Book 4", "author 4"),
            Book("Book 5", "author 5")
        )
        // Thiết lập RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = BookAdapter(itemList)
    }
}
