package com.example.lab3_7_1
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab3_7_1.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Sử dụng ViewBinding để thiết lập giao diện
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Dữ liệu mẫu
        val itemList = listOf(
            Item("Item 1", "Description 1"),
            Item("Item 2", "Description 2"),
            Item("Item 3", "Description 3"),
            Item("Item 4", "Description 4"),
            Item("Item 5", "Description 5")
        )
        // Thiết lập RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = ItemAdapter(itemList)
    }
}