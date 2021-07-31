package com.example.coderswagg.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.coderswagg.Model.Category
import com.example.coderswagg.R
import com.example.coderswagg.Services.DataService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : ArrayAdapter<Category>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            DataService.categories)

        lvMainCategory.adapter = adapter
    }
}