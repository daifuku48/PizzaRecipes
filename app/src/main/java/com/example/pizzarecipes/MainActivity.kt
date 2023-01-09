package com.example.pizzarecipes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){

    private lateinit var adapter: Adapter<CustomAdapter.ViewHolder>
    private lateinit var layoutManager: LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arrayRecipeItem = ArrayList<RecyclerViewPizzaItem>()
        arrayRecipeItem.add(
            RecyclerViewPizzaItem(
                R.drawable.pizza_1,
                Utils.PIZZA_1_TITLE, Utils.PIZZA_1_DESCRIPTION,
                Utils.PIZZA_1_RECIPE
            )
        )
        arrayRecipeItem.add(
            RecyclerViewPizzaItem(
                R.drawable.pizza_2,
                Utils.PIZZA_2_TITLE, Utils.PIZZA_2_DESCRIPTION,
                Utils.PIZZA_2_RECIPE
            )
        )
        arrayRecipeItem.add(
            RecyclerViewPizzaItem(
                R.drawable.pizza_3,
                Utils.PIZZA_3_TITLE, Utils.PIZZA_3_DESCRIPTION,
                Utils.PIZZA_3_RECIPE
            )
        )
        arrayRecipeItem.add(
            RecyclerViewPizzaItem(
                R.drawable.pizza_4,
                Utils.PIZZA_4_TITLE, Utils.PIZZA_4_DESCRIPTION,
                Utils.PIZZA_4_RECIPE
            )
        )
        arrayRecipeItem.add(
            RecyclerViewPizzaItem(
                R.drawable.pizza_5,
                Utils.PIZZA_5_TITLE, Utils.PIZZA_5_DESCRIPTION,
                Utils.PIZZA_5_RECIPE
            )
        )
        arrayRecipeItem.add(
            RecyclerViewPizzaItem(
                R.drawable.pizza_6,
                Utils.PIZZA_6_TITLE, Utils.PIZZA_6_DESCRIPTION,
                Utils.PIZZA_6_RECIPE
            )
        )
        arrayRecipeItem.add(
            RecyclerViewPizzaItem(
                R.drawable.pizza_7,
                Utils.PIZZA_7_TITLE, Utils.PIZZA_7_DESCRIPTION,
                Utils.PIZZA_7_RECIPE
            )
        )
        arrayRecipeItem.add(
            RecyclerViewPizzaItem(
                R.drawable.pizza_8,
                Utils.PIZZA_8_TITLE, Utils.PIZZA_8_DESCRIPTION,
                Utils.PIZZA_8_RECIPE
            )
        )
        arrayRecipeItem.add(
            RecyclerViewPizzaItem(
                R.drawable.pizza_9,
                Utils.PIZZA_9_TITLE,
                Utils.PIZZA_9_DESCRIPTION,
                Utils.PIZZA_9_RECIPE
            )
        )
        arrayRecipeItem.add(
            RecyclerViewPizzaItem(
                R.drawable.pizza_10,
                Utils.PIZZA_10_TITLE, Utils.PIZZA_10_DESCRIPTION,
                Utils.PIZZA_10_RECIPE
            )
        )
        adapter = CustomAdapter(arrayRecipeItem, this)
        (adapter as CustomAdapter).setOnItemClickListener(object: CustomAdapter.OnItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(applicationContext, RecipeActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                intent.putExtra("imagePizza", arrayRecipeItem[position].imageView)
                intent.putExtra("namePizza", arrayRecipeItem[position].textView1)
                intent.putExtra("recipePizza", arrayRecipeItem[position].textView3)
                applicationContext.startActivity(intent)
            }
        })
        layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }
}