package com.example.shifokor27

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.FileNotFoundException

class FoydalanuvchiProfilEditActivity : AppCompatActivity() {

    private lateinit var imgProfile: ImageView
    private lateinit var btnSelectImage: Button
    private lateinit var etName: EditText
    private lateinit var etPhone: EditText
    private lateinit var btnSave: Button

    private val IMAGE_PICK_CODE = 1000
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foydalanuvchi_profil_edit)

        imgProfile = findViewById(R.id.imgProfile)
        btnSelectImage = findViewById(R.id.btnSelectImage)
        etName = findViewById(R.id.etName)
        etPhone = findViewById(R.id.etPhone)
        btnSave = findViewById(R.id.btnSave)

        // Ma'lumotlarni yuklash
        loadProfileData()

        btnSelectImage.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, IMAGE_PICK_CODE)
        }

        btnSave.setOnClickListener {
            saveProfileData()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == IMAGE_PICK_CODE && resultCode == Activity.RESULT_OK && data != null) {
            imageUri = data.data
            try {
                val inputStream = contentResolver.openInputStream(imageUri!!)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                imgProfile.setImageBitmap(bitmap)

                // Uri'ni saqlaymiz
                val sharedPref = getSharedPreferences("UserProfile", Context.MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("profileImageUri", imageUri.toString())
                    apply()
                }

            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }
    }

    private fun saveProfileData() {
        val name = etName.text.toString()
        val phone = etPhone.text.toString()

        val sharedPref = getSharedPreferences("UserProfile", Context.MODE_PRIVATE)
        with(sharedPref.edit()) {
            putString("name", name)
            putString("phone", phone)
            apply()
        }

        Toast.makeText(this, "Profil saqlandi", Toast.LENGTH_SHORT).show()
        btnSave.setOnClickListener {
            val intent = Intent(this , FoydalanuvchiProfilActivity ::class.java)
            startActivity(intent)
        }
        finish()
    }

    private fun loadProfileData() {
        val sharedPref = getSharedPreferences("UserProfile", Context.MODE_PRIVATE)
        etName.setText(sharedPref.getString("name", ""))
        etPhone.setText(sharedPref.getString("phone", ""))

        val imageUriString = sharedPref.getString("profileImageUri", null)
        if (imageUriString != null) {
            imageUri = Uri.parse(imageUriString)
            try {
                val inputStream = contentResolver.openInputStream(imageUri!!)
                val bitmap = BitmapFactory.decodeStream(inputStream)
                imgProfile.setImageBitmap(bitmap)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }
    }
}
