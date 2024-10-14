package com.example.lab3_8_2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    var taskInput by remember { mutableStateOf("") }
    val tasks = remember { mutableStateListOf<String>() }
    val context = LocalContext.current // Lấy ngữ cảnh từ Compose

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Todo List") })
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                TextField(
                    value = taskInput,
                    onValueChange = { taskInput = it },
                    label = { Text("Enter task") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp) // Khoảng cách dưới ô nhập
                )
                Button(
                    onClick = {
                        if (taskInput.isNotBlank()) {
                            tasks.add(taskInput)
                            Toast.makeText(context, "Task added: $taskInput", Toast.LENGTH_SHORT).show()
                            taskInput = ""
                        }
                    },
                    modifier = Modifier.align(Alignment.End) // Đẩy nút sang bên phải
                ) {
                    Text("Add Task")
                }
                Spacer(modifier = Modifier.height(16.dp)) // Khoảng cách giữa nút và danh sách

                Column {
                    for (task in tasks) {
                        TaskItem(task){
                            Toast.makeText(context,"Task removed: $task",Toast.LENGTH_SHORT).show()

                            tasks.remove(task) // Xóa task khi nhấn nút Delete
                            Toast.makeText(context,"Task removed: ${tasks.joinToString { "$it" }}",Toast.LENGTH_SHORT).show()

                        }
                    }
                }

            }
        }
    )
}

@Composable
fun TaskItem(task: String, onDelete: () -> Unit) {
    Card(
        elevation = 4.dp,
        shape = RoundedCornerShape(8.dp), // Bo góc cho card
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp) // Khoảng cách giữa các task
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = task)
            IconButton(onClick = onDelete) {
                Icon(Icons.Default.Delete, contentDescription = "Delete Task")
            }
        }
    }
}
