package com.example.practicefromandroiddev

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class ChuseTextActivity : AppCompatActivity() {

    companion object{
        const val CHOICE ="package com.example.practicefromandroiddev.CHUSE"
        lateinit var intent: Intent
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chuse_text)
        intent = Intent (this, TextActivity::class.java)
    }

    fun launchOne(view: View) {
        intent.putExtra(CHOICE, "one")
        startActivity(intent)
    }
    fun launchTwo(view: View) {
        intent.putExtra(CHOICE, "two")
        startActivity(intent)
    }
    fun launchThree(view: View) {
        intent.putExtra(CHOICE, "three")
        startActivity(intent)
    }


}