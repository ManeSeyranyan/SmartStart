package com.example.smartstart

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val registrationButton: Button = findViewById(R.id.Registration)
        registrationButton.setOnClickListener {
            val intent = Intent(this@MainActivity,RegistrationActivity::class.java)
            startActivity(intent)
        }

        val loginButton:Button = findViewById(R.id.Login)
        loginButton.setOnClickListener {
            val intent = Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}