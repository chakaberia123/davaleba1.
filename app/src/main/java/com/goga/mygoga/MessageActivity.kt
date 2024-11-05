package com.goga.mygoga

import android.os.Bundle
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MessageActivity : AppCompatActivity() {
    private lateinit var etEmail: EditText
    private lateinit var etMessage: EditText
    private lateinit var btnClear: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_message)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }

    private fun init() {
        etEmail = findViewById(R.id.etEmail)
        etMessage = findViewById(R.id.etMessage)
        btnClear = findViewById(R.id.btnClear)

        btnClear.setOnClickListener {
            etEmail.text?.clear()
            etMessage.text?.clear()
        }

        val email = intent.getStringExtra("email")
        val message = intent.getStringExtra("message")

        etEmail.setText(email)
        etMessage.setText(message)
    }
}