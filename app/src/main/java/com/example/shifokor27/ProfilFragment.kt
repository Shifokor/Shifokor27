package com.example.shifokor27

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ProfilFragment : Fragment() {
    private lateinit var imgProfil: ImageView
    private lateinit var tvIsm: TextView
    private lateinit var tvEmail: TextView
    private lateinit var tvTelefon: TextView
    private lateinit var tvIshTajribasi: TextView
    private lateinit var btnEditProfil: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_profil11, container, false)

        imgProfil = root.findViewById(R.id.imgProfil)
        tvIsm = root.findViewById(R.id.tvIsm)
        tvEmail = root.findViewById(R.id.tvEmail)
        tvTelefon = root.findViewById(R.id.tvTelefon)
        tvIshTajribasi = root.findViewById(R.id.tvIshTajribasi)
        btnEditProfil = root.findViewById(R.id.btnEditProfil)

        // Misol uchun: ma'lumotlarni SharedPreferences yoki boshqa joydan o'qish mumkin

        btnEditProfil.setOnClickListener {
            val intent = Intent(requireContext(), FoydalanuvchiProfilEditActivity::class.java)
            startActivity(intent)
        }

        return root
    }
}