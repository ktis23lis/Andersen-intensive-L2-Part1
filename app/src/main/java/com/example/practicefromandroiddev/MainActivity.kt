package com.example.practicefromandroiddev

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private val a = 3
    private val b = 0
    companion object {
        const val TAG = "MyActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Урок 1.1: Android Studio и Hello World
        // Задача: Добавьте операторы журнала в ваше приложение
        Log.d(TAG, "Hello World")
        Log.i(TAG, "Это проосто информация, и все что выше в списке Log сможет ее прочитать")
        //Урок 1.1: Android Studio и Hello World
        //Задача: Использовать размые методы вывода ошибок
        try {
            val c = a / b
        } catch (e: RuntimeException) {
            Log.e(TAG, "Низя делить на 0!", e)
            Log.getStackTraceString(e)
        }
        initButton()
        initLogicButton(button1, HelloToastActivity::class.java)
        initLogicButton(button2, HelloToastLinearActivity::class.java)
        initLogicButton(button3, HelloToastRelActivity::class.java)
        initLogicButton(button4, ScrollAcrivity::class.java)
        initLogicButton(button5, TwoActivity::class.java)
        initLogicButton(button6, ChuseTextActivity::class.java)
        initLogicButton(button7, CounterActivity::class.java)
        initLogicButton(button8, ImplicitIntentsActivity::class.java)
    }

    private fun initButton() {
        button1 = findViewById<Button>(R.id.button1)
        button2 = findViewById<Button>(R.id.button2)
        button3 = findViewById<Button>(R.id.button3)
        button4 = findViewById<Button>(R.id.button4)
        button5 = findViewById<Button>(R.id.button5)
        button6 = findViewById<Button>(R.id.button6)
        button7 = findViewById<Button>(R.id.button7)
        button8 = findViewById<Button>(R.id.button8)
    }

    private fun initLogicButton(btn: Button, cls: Class<*>?) {

        btn.setOnClickListener {
            val myIntent = Intent(this, cls)
            startActivity(myIntent)
        }
    }
}