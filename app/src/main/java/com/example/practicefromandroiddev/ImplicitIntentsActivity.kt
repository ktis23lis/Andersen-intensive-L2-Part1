package com.example.practicefromandroiddev

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.KeyEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat

class ImplicitIntentsActivity : AppCompatActivity() {
    lateinit var websiteEditText: EditText
    lateinit var locationEditText: EditText
    lateinit var shareEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intents)
        websiteEditText = findViewById(R.id.website_edittext)
        locationEditText = findViewById(R.id.location_edittext)
        shareEditText = findViewById(R.id.share_edittext)
    }

    fun shareText(view: View) {
        val text = shareEditText.text.toString()
        val mimeType = "text/plan"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle(getString(R.string.share_text_with))
            .setText(text)
            .startChooser()
    }

    fun openLocation(view: View) {
        val loc: String = locationEditText.text.toString()
        val addressUri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    fun openWebsite(view: View) {
        val uri = websiteEditText.text.toString()
        val webPage = Uri.parse(uri)
        val intent = Intent(Intent.ACTION_VIEW, webPage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    fun takePicture(view: View) {
        val intent  = Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }





    }
}