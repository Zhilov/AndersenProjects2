package com.example.andersenproject2

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
        val message = intent.getIntExtra(MainActivity().EXTRA_MESSAGE, 0)
        textView.text = resources.getText(R.string.hello).toString() + message
    }
}