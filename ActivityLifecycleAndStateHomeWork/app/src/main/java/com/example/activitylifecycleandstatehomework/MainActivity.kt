package com.example.activitylifecycleandstatehomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        if (savedInstanceState != null) {
            val i = savedInstanceState.getString("count_value")
            textView.text = i
            count = i!!.toInt()
        }
    }

    fun increment(view: View) {
        count++
        textView.text = count.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("count_value", textView.text.toString())
    }
}