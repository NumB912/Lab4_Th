package com.example.lab3_9

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:ProductAdapter
    private val productList = listOf(
        Product("Sản phẩm 1", 100.0),
        Product("Sản phẩm 2", 150.0),
        Product("Sản phẩm 3", 200.0),
        Product("Sản phẩm 4", 250.0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val layoutManager = if (resources.configuration.smallestScreenWidthDp >= 600) {
            GridLayoutManager(this, 2) // Hoặc 3 cho chế độ ngang
        } else {
            LinearLayoutManager(this)
        }
        recyclerView.layoutManager = layoutManager
        adapter = ProductAdapter(productList)
        recyclerView.adapter = adapter
    }
}
