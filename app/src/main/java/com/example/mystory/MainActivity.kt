package com.example.mystory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var textviewEmail: TextView?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)
        val email= intent.getStringExtra("email")//
        connectviews()
        textviewEmail?.text=email
    }
    private fun connectviews(){
        textviewEmail= findViewById(R.id.textviewEmail)

    }
}