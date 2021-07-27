package com.example.practicefromandroiddev

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity(R.layout.activity_second) {

    private lateinit var mReply : EditText


    companion object{
        const val EXTRA_REPLY = "com.example.android.twoactivities.extra.REPLY"
        const val LOG_TAG = "LifecycleActivity"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val intent = intent
        val message = intent.getStringExtra(TwoActivity.EXTRA_MESSAGE)
        val textView = findViewById<TextView>(R.id.text_message)
        textView.setText(message)
        mReply = findViewById(R.id.editText_second)
        Log.d(SecondActivity.LOG_TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(SecondActivity.LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(SecondActivity.LOG_TAG, "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(SecondActivity.LOG_TAG, "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(SecondActivity.LOG_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(SecondActivity.LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(SecondActivity.LOG_TAG, "onDestroy")
    }

    fun returnReply(view: View) {
        val reply = mReply.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        Log.d(LOG_TAG, "End SecondActivity");
        finish()
    }

}