package com.example.practicefromandroiddev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class CounterHelloActivity : AppCompatActivity() {
    lateinit var counterTextView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter_hello)
        counterTextView = findViewById(R.id.counter_textView)
        val intent = intent
        val coumt = intent.getStringExtra(HelloToastActivity.COUNTER_MESSAGE)
        counterTextView.setText(coumt.toString())

    }
}