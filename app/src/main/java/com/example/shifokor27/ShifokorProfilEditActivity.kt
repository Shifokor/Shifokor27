package com.example.shifokor27

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.InputStream

class ShifokorProfilEditActivity : AppCompatActivity() {
    private lateinit var imgDoctor: ImageView
    private lateinit var btnUploadImage: Button
    private lateinit var etName: EditText
    private lateinit var etSurname: EditText
    private lateinit var etFatherName: EditText
    private lateinit var etPhone: EditText
    private lateinit var spinnerSpecialty: AutoCompleteTextView
    private lateinit var spinnerCategory: Spinner
    private lateinit var btnUploadCategory: Button
    private lateinit var etExperience: EditText
    private lateinit var etWorkplace: EditText
    private lateinit var actvBakalavr: AutoCompleteTextView
    private lateinit var btnUploadBakalavr: Button
    private lateinit var actvMagistr: AutoCompleteTextView
    private lateinit var btnUploadMagistr: Button
    private lateinit var languageContainer: LinearLayout
    private lateinit var btnAddLanguage: Button
    private lateinit var btnUploadLanguage: Button
    private lateinit var btnSaveProfile: Button

    private val REQUEST_CODE_IMAGE_PICK = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shifokor_profil_edit)

        imgDoctor = findViewById(R.id.imgDoctor)
        btnUploadImage = findViewById(R.id.btnUploadImage)
        etName = findViewById(R.id.etName)
        etSurname = findViewById(R.id.etSurname)
        etFatherName = findViewById(R.id.etFatherName)
        etPhone = findViewById(R.id.etPhone)
        spinnerSpecialty = findViewById(R.id.spinnerSpecialty)
        spinnerCategory = findViewById(R.id.spinnerCategory)
        btnUploadCategory = findViewById(R.id.btnUploadCategory)
        etExperience = findViewById(R.id.etExperience)
        etWorkplace = findViewById(R.id.etWorkplace)
        actvBakalavr = findViewById(R.id.actvBakalavr)
        btnUploadBakalavr = findViewById(R.id.btnUploadBakalavr)
        actvMagistr = findViewById(R.id.actvMagistr)
        btnUploadMagistr = findViewById(R.id.btnUploadMagistr)
        languageContainer = findViewById(R.id.languageContainer)
        btnAddLanguage = findViewById(R.id.btnAddLanguage)
        btnUploadLanguage = findViewById(R.id.btnUploadLanguage)
        btnSaveProfile = findViewById(R.id.btnSaveProfile)

        btnUploadImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, REQUEST_CODE_IMAGE_PICK)
        }

        btnAddLanguage.setOnClickListener {
            val languageEditText = EditText(this)
            languageEditText.hint = "Til va daraja (masalan: Ingliz tili - B2)"
            languageContainer.addView(languageEditText)
        }

        btnSaveProfile.setOnClickListener {
            val name = etName.text.toString()
            val surname = etSurname.text.toString()
            val phone = etPhone.text.toString()
            val intent = Intent (this , ProfilFragment::class.java)
            startActivity(intent)

            if (name.isEmpty() || surname.isEmpty() || phone.isEmpty()) {
                Toast.makeText(this, "Iltimos, barcha majburiy maydonlarni to‘ldiring!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Ma'lumotlar saqlandi", Toast.LENGTH_SHORT).show()
                // TODO: ma'lumotlarni backend serverga yuborish
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_CODE_IMAGE_PICK && resultCode == Activity.RESULT_OK && data != null) {
            val imageUri: Uri? = data.data
            try {
                val inputStream: InputStream? = imageUri?.let { contentResolver.openInputStream(it) }
                val selectedImage = BitmapFactory.decodeStream(inputStream)
                imgDoctor.setImageBitmap(selectedImage)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
