package com.example.practicefromandroiddev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CounterActivity : AppCompatActivity() {
    lateinit var countTV : TextView
    lateinit var btn : Button
    var count = 0

    companion object{
        const val COUNT_MESSAGE = "com.example.counter.COUNTER"
        const val PUT_KEY = "COUNT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        initView()
        if (savedInstanceState != null){
            countTV.text = savedInstanceState.getString(PUT_KEY)
            count = savedInstanceState.getInt(PUT_KEY)
            countTV.text = count.toString()
        }
        btnClick(btn)
    }

    private fun initView(){
        countTV = findViewById(R.id.count_textView)
        btn = findViewById(R.id.button)
    }

    private fun btnClick(btn: Button){
        btn.setOnClickListener {
            count++
            if (countTV!=null)
                countTV.text = count.toString()
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState, )
        outState.putString(PUT_KEY, countTV.text.toString())
        outState.putInt(PUT_KEY, count)
    }
}