package com.example.shifokor27

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FoydalanuvchiProfilActivity : AppCompatActivity() {
    private lateinit var imgUser: ImageView
    private lateinit var tvUserName: TextView
    private lateinit var btnEditProfile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foydalanuvchi_profil)

        imgUser = findViewById(R.id.imgUser)
        tvUserName = findViewById(R.id.tvUserName)
        btnEditProfile = findViewById(R.id.btnEditProfile)

        // Foydalanuvchi ma’lumotlarini olish va chiqarish (agar mavjud bo‘lsa)
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val userName = sharedPreferences.getString("user_name", "Ismingiz")
        tvUserName.text = userName

        // Tahrirlash tugmasi bosilganda tahrirlash oynasiga o‘tadi
        btnEditProfile.setOnClickListener {
            val intent = Intent(this, FoydalanuvchiProfilEditActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Har safar qaytishda yangi foydalanuvchi ismini yangilash
        val sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE)
        val updatedName = sharedPreferences.getString("user_name", "Ismingiz")
        tvUserName.text = updatedName
    }
}