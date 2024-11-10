package com.example.t5a1_tortosa_pau

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.t5a1_tortosa_pau.databinding.ActivityMainBinding
import android.webkit.WebViewClient
import com.example.t5a1_tortosa_pau.databinding.WebViewBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var foodAdapter: FoodAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var itemDecoration: DividerItemDecoration
    private lateinit var binding: ActivityMainBinding
    private lateinit var bindindWebView: WebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bindindWebView = WebViewBinding.inflate(layoutInflater)

        foodAdapter = FoodAdapter(getFoods(), this)
        linearLayoutManager = LinearLayoutManager(this)
        itemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)

        binding.recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = foodAdapter
            addItemDecoration(itemDecoration)
        }
    }

    private fun getFoods(): MutableList<Food> {
        val foods = mutableListOf<Food>()

        val pizza = Food("Pizza", "Italia", R.drawable.pizza, "https://es.wikipedia.org/wiki/Pizza")
        val paella = Food("Paella", "España", R.drawable.paella, "https://es.wikipedia.org/wiki/Paella")
        val kebab = Food("Kebab", "Turquia", R.drawable.kebab, "https://es.wikipedia.org/wiki/Kebab")
        val hamburguesa = Food("Hamburguesa", "Estados Unidos", R.drawable.hamburguesa, "https://es.wikipedia.org/wiki/Hamburguesa")
        val pasta = Food("Pasta", "Italia", R.drawable.pasta, "https://es.wikipedia.org/wiki/Pasta")

        foods.add(pizza)
        foods.add(paella)
        foods.add(kebab)
        foods.add(hamburguesa)
        foods.add(pasta)

        return foods
    }

    override fun onClick(food: Food) {
        bindindWebView.webViewWiki.webViewClient = WebViewClient()
        bindindWebView.webViewWiki.loadUrl(food.wikipedia)
        setContentView(bindindWebView.root)
    }
}