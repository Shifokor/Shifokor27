package com.example.shifokor27

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FoydalanuvchiKirishActivity : AppCompatActivity() {
    private lateinit var etLoginName: EditText
    private lateinit var etLoginPhone: EditText
    private lateinit var btnLogin: Button
    private lateinit var btnGoToRegister: Button
    private lateinit var tvNoAccount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foydalanuvchi_kirish)

        // Viewlarni bog'lash
        etLoginName = findViewById(R.id.etLoginName1)
        etLoginPhone = findViewById(R.id.etLoginPhone1)
        btnLogin = findViewById(R.id.btnLogin1)
        btnGoToRegister = findViewById(R.id.btnGoToRegister1)
        tvNoAccount = findViewById(R.id.tvNoAccount)

        // Kirish tugmasini bosganda
        btnLogin.setOnClickListener {
            val name = etLoginName.text.toString().trim()
            val phone = etLoginPhone.text.toString().trim()

            if (name.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Iltimos, barcha maydonlarni to‘ldiring", Toast.LENGTH_SHORT).show()
            } else {
                // Bu yerda login tekshiruv yoki foydalanuvchini keyingi sahifaga o'tkazish mumkin
                val intent = Intent(this, FoydalanuvchiProfilActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        // Ro‘yxatdan o‘tish tugmasi bosilganda
        btnGoToRegister.setOnClickListener {
            val intent = Intent(this, FoydalanuvchiRoyhattanOtishActivity::class.java)
            startActivity(intent)
        }
    }
}