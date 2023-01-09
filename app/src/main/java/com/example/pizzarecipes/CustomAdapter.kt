package com.example.pizzarecipes


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView


class CustomAdapter(val localDataSet: ArrayList<RecyclerViewPizzaItem>, val context1: Context) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener)
    {
        mListener = listener
    }

    class ViewHolder(view: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.pizzaImage)
        val textView1: TextView = view.findViewById(R.id.pizzaNameTextView)
        val textView2: TextView = view.findViewById(R.id.description)
        init {
            view.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.pizza_recipe_item, viewGroup, false)
        return ViewHolder(view, mListener)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.imageView.setImageResource(localDataSet[position].imageView)
        viewHolder.textView1.text = localDataSet[position].textView1
        viewHolder.textView2.text = localDataSet[position].textView2
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return localDataSet.size
    }


}