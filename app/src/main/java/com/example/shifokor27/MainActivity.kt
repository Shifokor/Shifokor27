package com.example.shifokor27

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDoctor = findViewById<Button>(R.id.btnDoctor)
        val btnUser = findViewById<Button>(R.id.btnUser)
        val flagUz = findViewById<ImageView>(R.id.flagUz)
        val flagRu = findViewById<ImageView>(R.id.flagRu)

        // Shifokor tugmasi bosilganda
        btnDoctor.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Foydalanuvchi tugmasi bosilganda
        btnUser.setOnClickListener {
            val intent = Intent(this, FoydalanuvchiKirishActivity::class.java)
            startActivity(intent)
        }

        // Til bayroqlari bosilganda
        flagUz.setOnClickListener {
            Toast.makeText(this, "O'zbek tili tanlandi", Toast.LENGTH_SHORT).show()
        }

        flagRu.setOnClickListener {
            Toast.makeText(this, "Выбран русский язык", Toast.LENGTH_SHORT).show()
        }

    }
}