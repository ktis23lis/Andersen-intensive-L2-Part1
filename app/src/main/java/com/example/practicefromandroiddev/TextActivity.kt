package com.example.practicefromandroiddev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import android.widget.TextView

class TextActivity : AppCompatActivity() {

    private lateinit var scrollView : ScrollView
    private lateinit var textScroll : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
        scrollView = findViewById(R.id.scroll_view)
        textScroll = findViewById(R.id.scroll_text)
        val intent = intent
        intent.getStringExtra(ChuseTextActivity.CHOICE)

        when(intent.getStringExtra(ChuseTextActivity.CHOICE)){
            "one" -> textScroll.text = getString(R.string.text_1)
            "two" ->  textScroll.text = getString(R.string.text_2)
            "three" -> textScroll.text = getString(R.string.text_3)
        }
    }
}