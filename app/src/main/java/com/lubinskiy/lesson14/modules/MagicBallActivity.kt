package com.lubinskiy.lesson14.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.lubinskiy.lesson14.R

class MagicBallActivity : AppCompatActivity() {
    var magicQuestion: EditText? = null
    var magicAnswer: TextView? = null
    var answer = listOf(
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
        val randomAnswer = (1..6).random()
        magicAnswer!!.text =
            if (magicQuestion!!.text.isNotEmpty()) findAnswer(randomAnswer) else getString(answer[6])
    }

    private fun findAnswer(i: Int): String {
        val message = when (i) {
            1 -> getString(answer[0])
            2 -> getString(answer[1])
            3 -> getString(answer[2])
            4 -> getString(answer[3])
            5 -> getString(answer[4])
            else -> getString(answer[5])
        }
        return message
    }
}