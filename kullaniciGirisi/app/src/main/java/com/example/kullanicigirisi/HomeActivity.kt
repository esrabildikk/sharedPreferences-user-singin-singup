package com.example.kullanicigirisi

import android.content.Intent
import android.content.SharedPreferences
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kullanicigirisi.databinding.ActivityHomeBinding
import com.example.kullanicigirisi.databinding.ActivityMainBinding

private lateinit var binding: ActivityHomeBinding
private lateinit var preferences: SharedPreferences
class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        preferences = getSharedPreferences("informations", MODE_PRIVATE)

        val username = preferences.getString("username","")
        val password = preferences.getString("password","")

        binding.textViewKullanici.text ="username: ${username}"
        binding.textViewPassword.text="password: ${password}"


    }
    fun LogOut(view : View){
        val intent = Intent(this@HomeActivity,MainActivity::class.java)
        startActivity(intent)
    }
}