package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        verfyUserName()

        binding.buttonSave.setOnClickListener {
            handlerSave()
        }
    }

    private fun handlerSave() {

        val name = binding.yourName.text.toString()

        if (name != "") {

            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)

            startActivity(Intent(this, MainActivity::class.java))
            finish()

        } else {

            Toast.makeText(this, R.string.validation_name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun verfyUserName() {

        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)

        if (name != "") {

            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }


    }
}