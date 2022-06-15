package com.example.motivation.data

import com.example.motivation.infra.MotivationConstants
import java.util.*
import kotlin.random.Random

data class Phrase(val description: String, val categoryId: Int)

class Mock {

    private val all = MotivationConstants.FILTER.ALL
    private val emoticon = MotivationConstants.FILTER.EMOTICON
    private val sunny = MotivationConstants.FILTER.SUNNY

    private val mListPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era possivel,foi la e fez", emoticon),
        Phrase("Você não e derrotado quanto perde,você e derrotado quando desiste", emoticon),
        Phrase("Se você nao onde quer ir,qualquer caminho serve", sunny),
        Phrase("A melhor maneira de prever o futuro é inventa-lo", sunny)
    )

    fun getPhrase(value: Int) : String {

        val filtered = mListPhrase.filter { it.categoryId == value || value == all }
       return filtered[Random.nextInt(filtered.size)].description
//
    }
}