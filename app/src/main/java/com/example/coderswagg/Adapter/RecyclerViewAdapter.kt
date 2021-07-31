package com.example.coderswagg.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswagg.Model.Category
import com.example.coderswagg.R

class RecyclerViewAdapter(val context : Context, val categories : List<Category>, val itemClick : (Category) -> Unit)
    : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(context)
            .inflate(R.layout.category_row_item, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.dataBinding(context, categories[position])
    }

    override fun getItemCount(): Int {
        return categories.count()
    }


    inner class ViewHolder(itemView: View, val itemClick : (Category) -> Unit ) : RecyclerView.ViewHolder(itemView) {
        var categoryImage: ImageView = itemView.findViewById(R.id.ivCategoryImage)
        var categoryName: TextView = itemView.findViewById(R.id.tvCategoryName)

        fun dataBinding(context : Context, category : Category) {
            val resourceId = context
                .resources
                .getIdentifier(category.image, "drawable", context.packageName)
            categoryImage.setImageResource(resourceId)
            categoryName.text = category.title
            itemView.setOnClickListener{
                itemClick(category)
            }
        }

    }

}