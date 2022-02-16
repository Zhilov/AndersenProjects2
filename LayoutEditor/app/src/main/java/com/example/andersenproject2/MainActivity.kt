package com.example.andersenproject2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var mCount = 0
    private var mShowCount: TextView? = null
    val EXTRA_MESSAGE = "com.example.android.andersenproject2.extra.MESSAGE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mShowCount = findViewById(R.id.show_count)
    }

    fun showToast(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, mCount)
        startActivity(intent)
    }

    fun countUp(view: View) {
        mCount++
        if (mShowCount != null) mShowCount!!.text = mCount.toString()
    }

    fun zero(view: View) {
        mCount = 0
        mShowCount!!.text = mCount.toString()
    }
}