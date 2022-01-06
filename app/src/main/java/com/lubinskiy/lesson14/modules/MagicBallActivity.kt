package com.lubinskiy.lesson14.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.lubinskiy.lesson14.R

class MagicBallActivity : AppCompatActivity() {
    private var magicQuestion: EditText? = null
    private lateinit var magicAnswer: TextView
    private var answer = listOf(
        R.string.magicBallA_1st,
        R.string.magicBallA_2nd,
        R.string.magicBallA_3rd,
        R.string.magicBallA_4th,
        R.string.magicBallA_5th,
        R.string.magicBallA_6th,
        R.string.magicBallA_7th
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_magic_ball)
        init()
    }

    private fun init() {
        magicAnswer = findViewById(R.id.magicAnswerTV)
        magicQuestion = findViewById(R.id.magicQuestonET)
    }

    fun onClick(view: View?) {
        val randomAnswer = (answer.indices - 6).random()
        magicAnswer.text =
            if (magicQuestion!!.text.isNotEmpty()) getString(answer[randomAnswer]) else getString(answer[6])
    }
}
