package com.example.shifokor27

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar


class ShifokoruzRoyhatanOtishActivity : AppCompatActivity() {
    private lateinit var etRegisterName: EditText
    private lateinit var etRegisterPhone: EditText
    private lateinit var tvBirthDate: TextView
    private lateinit var spSpecialty: Spinner
    private lateinit var spRegion: Spinner
    private lateinit var spCity: Spinner
    private lateinit var btnDoRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shifokoruz_royhatan_otish)

        // Viewlar bilan bog‘lanish
        etRegisterName = findViewById(R.id.etRegisterName)
        etRegisterPhone = findViewById(R.id.etRegisterPhone)
        tvBirthDate = findViewById(R.id.tvBirthDate)
        spSpecialty = findViewById(R.id.spSpecialty)
        spRegion = findViewById(R.id.spRegion)
        spCity = findViewById(R.id.spCity)
        btnDoRegister = findViewById(R.id.btnDoRegister)

        // Sana tanlash
        tvBirthDate.setOnClickListener {
            showDatePicker()
        }

        // Spinnerlarni to‘ldirish (misol uchun)
        val specialties = listOf("Terapevt", "Jarroh", "Pediatr", "Stomatolog")
        val regions = listOf("Toshkent", "Farg'ona", "Andijon", "Namangan")
        val cities = listOf("Shahar A", "Shahar B", "Shahar C", "Shahar D")

        spSpecialty.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, specialties)
        spRegion.adapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, regions)
        spCity.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, cities)

        // Ro‘yxatdan o‘tish tugmasi
        btnDoRegister.setOnClickListener {
            val name = etRegisterName.text.toString().trim()
            val phone = etRegisterPhone.text.toString().trim()
            val birthDate = tvBirthDate.text.toString().trim()
            val specialty = spSpecialty.selectedItem.toString()
            val region = spRegion.selectedItem.toString()
            val city = spCity.selectedItem.toString()

            if (name.isEmpty() || phone.isEmpty() || birthDate == "YYYY-MM-DD") {
                Toast.makeText(this, "Iltimos, barcha maydonlarni to‘ldiring!", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: Ma'lumotlarni saqlash yoki yuborish
                Toast.makeText(this, "Ro‘yxatdan o‘tish muvaffaqiyatli!", Toast.LENGTH_LONG).show()
                finish() // Orqaga qaytadi
            }
        }
        val intent = Intent(this , ProfilFragment::class.java )
        startActivity(intent)
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(this, { _, y, m, d ->
            val formatted = String.format("%04d-%02d-%02d", y, m + 1, d)
            tvBirthDate.text = formatted
        }, year, month, day)

        datePicker.show()
    }
}