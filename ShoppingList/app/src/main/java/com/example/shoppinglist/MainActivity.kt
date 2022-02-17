package com.example.shoppinglist

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.UnsupportedEncodingException
import java.net.URLEncoder
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val ITEM_REQUEST = 1
    private val item = arrayOfNulls<TextView>(10)
    private var itemsList: ArrayList<String?> = ArrayList(10)
    private lateinit var mStoreEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        item[0] = findViewById(R.id.item1)
        item[1] = findViewById(R.id.item2)
        item[2] = findViewById(R.id.item3)
        item[3] = findViewById(R.id.item4)
        item[4] = findViewById(R.id.item5)
        item[5] = findViewById(R.id.item6)
        item[6] = findViewById(R.id.item7)
        item[7] = findViewById(R.id.item8)
        item[8] = findViewById(R.id.item9)
        item[9] = findViewById(R.id.item10)

        mStoreEditText = findViewById(R.id.map_editText)

        if (savedInstanceState != null) {
            var i: Int
            itemsList = savedInstanceState.getStringArrayList("ItemsListStringArray")!!

            if (itemsList.size > 0) {
                i = 0
                while (i < itemsList.size) {
                    if (itemsList.size > 10) {
                        Toast.makeText(this, "Cannot add more items to the list", Toast.LENGTH_LONG)
                            .show()
                        break
                    }
                    item[i]!!.visibility = View.VISIBLE
                    item[i]!!.text = itemsList[i]
                    i++
                }
            }
        }
    }

    fun addItem(view: View?) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivityForResult(intent, ITEM_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ITEM_REQUEST) {
            if (resultCode == RESULT_OK) {
                val itemString = data!!.getStringExtra(SecondActivity().EXTRA_ITEMS)
                itemsList.add(itemString)
                var i = 0
                while (i < itemsList.size) {
                    if (itemsList.size > 10) {
                        Toast.makeText(this, "Cannot add more items to the list", Toast.LENGTH_LONG)
                            .show()
                        break
                    }
                    item[i]!!.visibility = View.VISIBLE
                    item[i]!!.text = itemsList[i]
                    i++
                }
            }
        }
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (itemsList.size != 0) {
            outState.putStringArrayList("ItemsListStringArray", itemsList)
        }
    }

    fun searchStores(view: View) {
        val location: String = mStoreEditText.text.toString()
        var url: String? = null
        try {
            url = URLEncoder.encode(location, "UTF-8")
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        }
        val address: Uri = Uri.parse("https://www.google.com/maps/search/?api=1&query=$url")
        startActivity(Intent(Intent.ACTION_VIEW, address))
    }
}