package com.example.activitiesandintentscodingchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        textView = findViewById(R.id.textView)

        val intent = intent
        val message = intent.getIntExtra(MainActivity().EXTRA_MESSAGE, 1)
        textView.text = resources.getText(message)

    }
}