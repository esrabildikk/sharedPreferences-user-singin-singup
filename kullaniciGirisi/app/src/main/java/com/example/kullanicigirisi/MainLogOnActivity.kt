package com.example.kullanicigirisi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kullanicigirisi.databinding.ActivityMainLogOnBinding

private lateinit var binding: ActivityMainLogOnBinding
class MainLogOnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainLogOnBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.textView.text = "Have a nice day"
    }
    fun signUp(view : View){
        val username = binding.editTextUsernameCreate.text.toString()
        val password = binding.editTextPasswordCreate.text.toString()

        if (username.isNotEmpty() && password.isNotEmpty()){
            //sharedpreferences başlatalım:
            var sharedPreferences = this.getSharedPreferences("informations", MODE_PRIVATE)
            var editor = sharedPreferences.edit()
            //veri ekleme:
            editor.putString("username","${username}").apply()
            editor.putString("password","${password}").apply()
            binding.editTextUsernameCreate.text.clear()
            binding.editTextPasswordCreate.text.clear()
        }else{
            Toast.makeText(this@MainLogOnActivity,"Enter username and password",Toast.LENGTH_LONG).show()
            }

        val intent = Intent(this@MainLogOnActivity,MainActivity::class.java)
        intent.putExtra("kullaniciAdi","${username}")
        startActivity(intent)
        finish()
    }
    fun previous (view : View){
        val intent = Intent(this@MainLogOnActivity,MainActivity::class.java)
        startActivity(intent)
    }
}