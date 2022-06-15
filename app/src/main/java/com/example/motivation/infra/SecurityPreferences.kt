package com.example.motivation.infra

import android.content.Context
import android.content.SharedPreferences

class SecurityPreferences(context: Context) {

    private val shared: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key: String,str: String) {

        shared.edit().putString(key,str).apply()

    }

    fun getString(key: String) : String? {

       return shared.getString(key,"") ?: ""

    }
}





