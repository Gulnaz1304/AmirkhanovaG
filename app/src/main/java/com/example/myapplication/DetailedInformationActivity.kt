package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detailed_information.*

class DetailedInformationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_information)
        textView.text = intent.getStringExtra("name").toString()
        textView2.text = intent.getStringExtra("date").toString()
        textView3.text = intent.getStringExtra("description").toString()
        image_iv.setImageResource(intent.getIntExtra("image", R.mipmap.ic_launcher))

    }
}
