package com.example.pizzarecipes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.recipe.*

class RecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)
        val intent = intent
        if (intent != null)
        {
            imageViewPizza.setImageResource(intent.getIntExtra("imagePizza", 0))
            textViewRecipe.text = intent.getStringExtra("namePizza")
            textViewRecipeText.text = intent.getStringExtra("recipePizza")
        }
    }
}