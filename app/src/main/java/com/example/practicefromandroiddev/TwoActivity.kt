package com.example.practicefromandroiddev

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class TwoActivity : AppCompatActivity(R.layout.activity_two) {
    private val LOG_TAG = "TwoActivity"
    private lateinit var mMessageEditText : EditText
    private lateinit var mReplyHeadTextView: TextView
    private lateinit var mReplyTextView: TextView

    companion object{
        const val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
        const val TEXT_REQUEST = 1
        const val LOG_TAG = "LifecycleActivity"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);
        if (savedInstanceState !=null){
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            if (isVisible){
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = savedInstanceState.getString("reply_text")
                mReplyTextView.visibility = View.VISIBLE


            }
        }
        Log.d(TwoActivity.LOG_TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TwoActivity.LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TwoActivity.LOG_TAG, "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TwoActivity.LOG_TAG, "onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
         if (mReplyHeadTextView.visibility == View.VISIBLE){
             outState.putBoolean("reply_visible", true)
             outState.putString("reply_text", mReplyTextView.getText().toString())
         }
    }

    override fun onPause() {
        super.onPause()
        Log.d(TwoActivity.LOG_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TwoActivity.LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TwoActivity.LOG_TAG, "onDestroy")
    }


    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!");
        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === TEXT_REQUEST) {
            if (resultCode === RESULT_OK) {
                val reply = data?.getStringExtra(SecondActivity.EXTRA_REPLY)
                mReplyHeadTextView.visibility = View.VISIBLE
                mReplyTextView.text = reply
                mReplyTextView.visibility = View.VISIBLE
            }
        }
    }

}