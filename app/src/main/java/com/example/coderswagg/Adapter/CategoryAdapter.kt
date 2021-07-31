package com.example.coderswagg.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswagg.Model.Category
import com.example.coderswagg.R

class CategoryAdapter(context : Context, categories: List<Category>) : BaseAdapter() {

    val context = context
    val categories = categories

    override fun getCount(): Int {
        return categories.count()
    }

    override fun getItem(position: Int): Any {
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val categoryView : View= LayoutInflater
            .from(context)
            .inflate(R.layout.category_row_item, null)

        val name : TextView = categoryView.findViewById(R.id.tvCategoryName)
        val image : ImageView = categoryView.findViewById(R.id.ivCategoryImage)

        val category = categories[position]
        name.text = category.title
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        image.setImageResource(resourceId)

        return categoryView
    }
}