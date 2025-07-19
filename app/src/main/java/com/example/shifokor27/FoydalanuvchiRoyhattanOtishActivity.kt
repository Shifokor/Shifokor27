package com.example.shifokor27

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FoydalanuvchiRoyhattanOtishActivity : AppCompatActivity() {
    private lateinit var fullNameEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var regionSpinner: Spinner
    private lateinit var citySpinner: Spinner
    private lateinit var registerButton: Button

    private val regions = arrayOf("Toshkent", "Farg'ona", "Samarqand", "Andijon")
    private val citiesMap = mapOf(
        "Toshkent" to arrayOf("Chilonzor", "Yunusobod", "Olmazor"),
        "Farg'ona" to arrayOf("Qo'qon", "Marg'ilon", "Farg'ona shahri"),
        "Samarqand" to arrayOf("Urgut", "Ishtixon", "Samarqand shahri"),
        "Andijon" to arrayOf("Andijon shahri", "Asaka", "Xonabod")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foydalanuvchi_royhattan_otish)

        fullNameEditText = findViewById(R.id.etFullName)
        phoneEditText = findViewById(R.id.etPhone)
        regionSpinner = findViewById(R.id.spinnerRegion)
        citySpinner = findViewById(R.id.spinnerCity)
        registerButton = findViewById(R.id.btnRegister)

        val regionAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, regions)
        regionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        regionSpinner.adapter = regionAdapter

        regionSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                val selectedRegion = regions[position]
                val cities = citiesMap[selectedRegion] ?: emptyArray()
                val cityAdapter =
                    ArrayAdapter(this@FoydalanuvchiRoyhattanOtishActivity, android.R.layout.simple_spinner_item, cities)
                cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                citySpinner.adapter = cityAdapter
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        registerButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString().trim()
            val phone = phoneEditText.text.toString().trim()
            val region = regionSpinner.selectedItem?.toString()
            val city = citySpinner.selectedItem?.toString()

            if (fullName.isEmpty() || phone.isEmpty() || region == null || city == null) {
                Toast.makeText(this, "Iltimos, barcha maydonlarni to‘ldiring", Toast.LENGTH_SHORT).show()
            } else {
                // Ro'yxatdan o'tish jarayoni (bu yerda serverga yuborish, yoki local database)
                Toast.makeText(this, "Ro‘yxatdan muvaffaqiyatli o‘tildi!", Toast.LENGTH_SHORT).show()
                // Istasangiz: finish() yoki boshqa Activityga o'tish
            }
            val intent = Intent(this , FoydalanuvchiProfilActivity::class.java)
            startActivity(intent)
        }
    }
}