package com.example.shoppinglist

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {

    val EXTRA_ITEMS = "me.mahakagg.shoppinglist.extra.ITEMS"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }

    fun selectItem(view: View) {
        val return_items_intent = Intent()
        when (view.id) {
            R.id.button_Chocolate -> {
                return_items_intent.putExtra(EXTRA_ITEMS, "Chocolate")
                setResult(RESULT_OK, return_items_intent)
                finish()
            }
            R.id.button_oil -> {
                return_items_intent.putExtra(EXTRA_ITEMS, "Oil")
                setResult(RESULT_OK, return_items_intent)
                finish()
            }
            R.id.button_milk -> {
                return_items_intent.putExtra(EXTRA_ITEMS, "Milk")
                setResult(RESULT_OK, return_items_intent)
                finish()
            }
            R.id.button_eggs -> {
                return_items_intent.putExtra(EXTRA_ITEMS, "Eggs")
                setResult(RESULT_OK, return_items_intent)
                finish()
            }
            R.id.button_cheese -> {
                return_items_intent.putExtra(EXTRA_ITEMS, "Cheese")
                setResult(RESULT_OK, return_items_intent)
                finish()
            }
            R.id.button_rice -> {
                return_items_intent.putExtra(EXTRA_ITEMS, "Rice")
                setResult(RESULT_OK, return_items_intent)
                finish()
            }
            R.id.button_wheat -> {
                return_items_intent.putExtra(EXTRA_ITEMS, "Wheat Flour")
                setResult(RESULT_OK, return_items_intent)
                finish()
            }
            R.id.button_bread -> {
                return_items_intent.putExtra(EXTRA_ITEMS, "Bread")
                setResult(RESULT_OK, return_items_intent)
                finish()
            }
            R.id.button_sugar -> {
                return_items_intent.putExtra(EXTRA_ITEMS, "Sugar")
                setResult(RESULT_OK, return_items_intent)
                finish()
            }
            R.id.button_salt -> {
                return_items_intent.putExtra(EXTRA_ITEMS, "Salt")
                setResult(RESULT_OK, return_items_intent)
                finish()
            }
            else -> Toast.makeText(this, "There was an error", Toast.LENGTH_LONG).show()
        }
    }
}