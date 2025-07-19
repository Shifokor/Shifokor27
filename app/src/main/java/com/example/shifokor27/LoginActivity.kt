package com.example.shifokor27

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Viewlarni aniqlash
        val etLoginName = findViewById<EditText>(R.id.etLoginName)
        val etLoginPhone = findViewById<EditText>(R.id.etLoginPhone)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnGoToRegister = findViewById<Button>(R.id.btnGoToRegister)

        // "Kirish" tugmasi bosilganda
        btnLogin.setOnClickListener {
            val name = etLoginName.text.toString().trim()
            val phone = etLoginPhone.text.toString().trim()

            if (name.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Iltimos, barcha maydonlarni to‘ldiring", Toast.LENGTH_SHORT).show()
            } else {
                // Bu yerda autentifikatsiya yoki boshqa amallar bo‘lishi mumkin
                Toast.makeText(this, "Kirish muvaffaqiyatli!", Toast.LENGTH_SHORT).show()

                // Misol uchun: Profilga o‘tish
                val intent = Intent(this, ProfilFragment::class.java)
                startActivity(intent)
                finish()
            }
        }

        // "Ro‘yxatdan o‘tish" tugmasi bosilganda
        btnGoToRegister.setOnClickListener {
            val intent = Intent(this, ShifokoruzRoyhatanOtishActivity::class.java)
            startActivity(intent)
        }
    }
}