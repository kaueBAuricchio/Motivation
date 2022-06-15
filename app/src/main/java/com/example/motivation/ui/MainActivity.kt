package com.example.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.motivation.R
import com.example.motivation.data.Mock
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var categoryid : Int = 0
    private val clicked: Boolean = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        handlerUserName()
        handlerNextPhrase()

        binding.imageAllInclusive.setOnClickListener {
            if (!clicked){
                binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this,R.color.dark_purple))
            } else {
                binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this,R.color.white))
                categoryid = MotivationConstants.FILTER.ALL
            }
        }

        binding.imageEmoticon.setOnClickListener {
            if (!clicked){
                binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this,R.color.dark_purple))
            } else {
                binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this,R.color.white))
                categoryid = MotivationConstants.FILTER.EMOTICON
            }
        }

        binding.imageSunny.setOnClickListener {
            if (!clicked){
                binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this,R.color.dark_purple))
            } else {
                binding.imageAllInclusive.setColorFilter(ContextCompat.getColor(this,R.color.white))
                categoryid = MotivationConstants.FILTER.SUNNY
            }
        }

        binding.buttonPhrase.setOnClickListener {
            handlerNextPhrase()
        }
    }



    private fun handlerUserName() {

        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textName.text = "Ola,$name"

    }

    private fun handlerNextPhrase(){
        binding.textMotivation.text = Mock().getPhrase(categoryid)
    }


}