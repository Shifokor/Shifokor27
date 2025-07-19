package com.example.shifokor27

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DiagnostikaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnostika)
        val btnBack = findViewById<Button>(R.id.btnDiagBack)
        btnBack.setOnClickListener {
            finish() // Aktivlikni yopish, ya'ni ortga qaytish
        }

    }
}