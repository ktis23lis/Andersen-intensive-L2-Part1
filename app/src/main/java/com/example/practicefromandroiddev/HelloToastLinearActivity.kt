package com.example.practicefromandroiddev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class HelloToastLinearActivity : AppCompatActivity(R.layout.activity_hello_toast_linear) {
    private var mCount = 0
    private lateinit var mShowCount : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mShowCount = findViewById(R.id.show_count)
    }

    fun showToast(view: View) {
        val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT).show()
    }

    fun countUp(view: View) {
        mCount ++
        if (mShowCount != null)
            mShowCount.text = mCount.toString()
    }
}