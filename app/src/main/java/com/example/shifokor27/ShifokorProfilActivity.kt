package com.example.shifokor27

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.shifokor27.fragment.KurslarFragment
import com.example.shifokor27.fragment.ReytingFragment
import com.example.shifokor27.fragment.TibiyHujjatlarFragment
import com.example.shifokor27.fragment.YangiIshOrinlariFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ShifokorProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shifokor_profil)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        // Default holatda birinchi fragmentni o‘rnatamiz
        loadFragment(TibiyHujjatlarFragment())

        // Navigatsiya tanlovini tinglaymiz
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_documents -> loadFragment(TibiyHujjatlarFragment())
                R.id.nav_jobs -> loadFragment(YangiIshOrinlariFragment())
                R.id.nav_reting -> loadFragment(ReytingFragment())
                R.id.nav_courses -> loadFragment(KurslarFragment())
                R.id.nav_profile -> loadFragment(ProfilFragment())
            }
            true
        }
    }

    // Fragmentni yuklash funksiyasi
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}