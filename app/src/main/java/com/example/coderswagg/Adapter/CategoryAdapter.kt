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
        val categoryView : View
        val holder : ViewHolder

        if (convertView == null) {
            categoryView = LayoutInflater
                .from(context)
                .inflate(R.layout.category_row_item, null)
            holder = ViewHolder()
            holder.categoryText = categoryView.findViewById(R.id.tvCategoryName)
            holder.categoryImage = categoryView.findViewById(R.id.ivCategoryImage)
            categoryView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            categoryView = convertView
        }

        val category = categories[position]
        holder.categoryText?.text = category.title
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        return categoryView
    }

    private class ViewHolder {
        var categoryImage : ImageView? = null
        var categoryText : TextView? = null
    }
}