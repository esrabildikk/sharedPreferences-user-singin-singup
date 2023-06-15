package com.example.kullanicigirisi

import android.content.Intent
import android.content.SharedPreferences
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kullanicigirisi.databinding.ActivityMainBinding


private lateinit var binding: ActivityMainBinding
 private lateinit var preferences: SharedPreferences
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val kullaniciAdi = intent.getStringExtra("kullaniciAdi")
        binding.textView.text="Have a nice day, ${kullaniciAdi}"

        //referans bir sharedpreference tanımla yukarda.
        //sharedpreferences'ten bilgileri alalım
        //bilgileri nerden alacağımızı gösterelim
        preferences = getSharedPreferences("informations", MODE_PRIVATE)


    }
    fun signin(view: View){
        val kullaniciKaydi = preferences.getString("username","")
        val kullaniciSifreKaydi = preferences.getString("password","")

        val recordUsername = binding.editTextUsernameCreate.text.toString()
        val recordPassword = binding.editTextPasswordCreate.text.toString()

        if (recordUsername.isNotEmpty() && recordPassword.isNotEmpty()){
            if (recordUsername == kullaniciKaydi && recordPassword== kullaniciSifreKaydi){
                val intent = Intent(this@MainActivity,HomeActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this@MainActivity,"Enter username and password",Toast.LENGTH_LONG).show()
            }

        }else{
            Toast.makeText(this@MainActivity,"Enter username and password",Toast.LENGTH_LONG).show()
        }


    }

    fun signUp(view: View){
        val intent = Intent(this@MainActivity,MainLogOnActivity::class.java)
        startActivity(intent)

    }
}