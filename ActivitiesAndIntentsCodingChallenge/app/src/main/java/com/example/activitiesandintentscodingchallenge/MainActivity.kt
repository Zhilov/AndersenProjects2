package com.example.activitiesandintentscodingchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var buttonOne: Button
    private lateinit var buttonTwo: Button
    private lateinit var buttonThree: Button
    val EXTRA_MESSAGE = "com.example.android.activitiesandintentscodingchallenge.extra.MESSAGE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonOne = findViewById(R.id.button_one)
        buttonTwo = findViewById(R.id.button_two)
        buttonThree = findViewById(R.id.button_three)

        buttonOne.setOnClickListener(this)
        buttonTwo.setOnClickListener(this)
        buttonThree.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val intent = Intent(this, SecondActivity::class.java)

        when(p0!!.id) {
            R.id.button_one -> intent.putExtra(EXTRA_MESSAGE, R.string.text_one)
            R.id.button_two -> intent.putExtra(EXTRA_MESSAGE, R.string.text_two)
            R.id.button_three -> intent.putExtra(EXTRA_MESSAGE, R.string.text_three)
        }

        startActivity(intent)
    }
}