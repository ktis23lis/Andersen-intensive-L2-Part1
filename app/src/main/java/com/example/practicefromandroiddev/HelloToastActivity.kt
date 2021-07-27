package com.example.practicefromandroiddev

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HelloToastActivity : AppCompatActivity(R.layout.activity_hello_toast) {
    private var mCount = 0
    private var zero = 0
    private var count = 0
    private lateinit var mShowCount: TextView
    private lateinit var zeroBtn: Button
    private lateinit var cntBtn: Button

    companion object{
        const val COUNTER_MESSAGE = "com.example.practicefromandroiddev.COUNTER"
        lateinit var intent: Intent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    fun initView() {
        mShowCount = findViewById(R.id.show_count)
        zeroBtn = findViewById(R.id.button_zero)
        cntBtn = findViewById(R.id.button_count)
    }

    fun showToast(view: View) {
        intent = Intent(this, CounterHelloActivity::class.java)
        count = mCount
        intent.putExtra(COUNTER_MESSAGE, count.toString() )
        startActivity(intent)
    }

    fun countUp(view: View) {
        mCount++
        if (mShowCount != null)
            mShowCount.text = mCount.toString()
        zeroBtn.setBackgroundColor(resources.getColor(R.color.pink))
        changeColorBtn()
    }

    fun zero(view: View) {
        if (mCount != null)
            mShowCount.text = zero.toString()
           mCount = zero
        zeroBtn.setBackgroundColor(resources.getColor(R.color.gray))
    }

    fun changeColorBtn(){
        if (mCount%2 == 0){
            cntBtn.setBackgroundColor(resources.getColor(R.color.green))
        }else
            cntBtn.setBackgroundColor(resources.getColor(R.color.purple_200))
    }

}