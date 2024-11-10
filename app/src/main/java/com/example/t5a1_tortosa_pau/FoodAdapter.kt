package com.example.t5a1_tortosa_pau

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.t5a1_tortosa_pau.databinding.ItemFoodsBinding

class FoodAdapter(private val foods: List<Food>, private val listener: OnClickListener): RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val binding = ItemFoodsBinding.bind(view)

        fun setListener(food: Food) {
            binding.root.setOnClickListener {
                listener.onClick(food)
            }
        }
    }

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(R.layout.item_foods, parent, false)
        return ViewHolder(view);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val food = foods.get(position)
        with(holder) {
            setListener(food)
            binding.txtFoodName.text = food.name
            binding.txtFoodCountry.text = food.country
            binding.imgFood.setImageResource(food.img)
        }
    }

    override fun getItemCount(): Int = foods.size

}