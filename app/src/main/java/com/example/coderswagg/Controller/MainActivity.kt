package com.example.coderswagg.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswagg.Adapter.CategoryAdapter
import com.example.coderswagg.Adapter.RecyclerViewAdapter
import com.example.coderswagg.Model.Category
import com.example.coderswagg.R
import com.example.coderswagg.Services.DataService
import com.example.coderswagg.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : RecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = RecyclerViewAdapter(this, DataService.categories) { category ->
            val productIntent = Intent(this, ProductActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title)
            startActivity(productIntent)
        }
        lvMainListView.adapter = adapter
        val layoutManager = LinearLayoutManager(this)
        lvMainListView.layoutManager = layoutManager
        lvMainListView.setHasFixedSize(true)
    }
}