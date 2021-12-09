package com.lubinskiy.lesson14.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.lubinskiy.lesson14.R

class RiddlesActivity : AppCompatActivity() {
    private var riddleQuestion: TextView? = null
    private var riddleAnswer: TextView? = null
    private var startBtn: Button? = null
    private var answerBtnLT: Button? = null
    private var answerBtnRT: Button? = null
    private var answerBtnLB: Button? = null
    private var answerBtnRB: Button? = null
    private var answerBtn: List<Button?>? = null
    private var riddles: List<Riddle>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_riddles)
        init()
    }

    private fun init() {
        riddleQuestion = findViewById(R.id.riddles_Q_TV)
        riddleAnswer = findViewById(R.id.riddles_A_TV)
        startBtn = findViewById(R.id.riddles_btn_restart)
        answerBtnLT = findViewById(R.id.riddles_btn_aLT)
        answerBtnRT = findViewById(R.id.riddles_btn_aRT)
        answerBtnLB = findViewById(R.id.riddles_btn_aLB)
        answerBtnRB = findViewById(R.id.riddles_btn_aRB)
        riddles = listOf(
            Riddle(getString(R.string.riddle_first_Q), getString(R.string.riddle_first_A)),
            Riddle(getString(R.string.riddle_second_Q), getString(R.string.riddle_second_A)),
            Riddle(getString(R.string.riddle_third_Q), getString(R.string.riddle_third_A)),
            Riddle(getString(R.string.riddle_fourth_Q), getString(R.string.riddle_fourth_A))
        )
        answerBtn = listOf(answerBtnLT, answerBtnRT, answerBtnLB, answerBtnRB)
    }

    fun onClickStart(view: View?) {
        val sequence = riddles?.let {
            listOf(0, 1, 2, 3).asSequence().shuffled().take(it.size).toList()
        }

        riddleQuestion!!.text = riddles!!.random().question

        var counter = 0
        answerBtn!!.forEach {
            it!!.text = riddles!![sequence!![counter]].answer
            it.visibility = Button.VISIBLE
            counter++
        }
        counter = 0

        startBtn!!.text = getString(R.string.riddles_btn_restart)
        riddleAnswer!!.text = getString(R.string.empty_string)
    }

    fun onClickAnswer(view: View?) {
        when (view!!.id) {
            answerBtnLT!!.id -> buttonController(answerBtnLT)
            answerBtnLB!!.id -> buttonController(answerBtnLB)
            answerBtnRT!!.id -> buttonController(answerBtnRT)
            answerBtnRB!!.id -> buttonController(answerBtnRB)
        }
    }

    private fun buttonController(button: Button?) {
        riddles!!.forEach {
            if (it.answer == button!!.text &&
                it.question == riddleQuestion!!.text
            ) {
                riddleAnswer!!.text = getString(R.string.riddles_answer_true)
                buttonVisibility(button)
                return
            }
        }
        buttonVisibility(button)
        riddleAnswer!!.text = getString(R.string.riddles_answer_false)
    }

    private fun buttonVisibility(button: Button?) {
        when (button) {
            answerBtnLT -> {
                answerBtn!!.forEach {
                    it!!.visibility = if (it == answerBtnLT) Button.VISIBLE else Button.INVISIBLE
                }
            }
            answerBtnLB -> {
                answerBtn!!.forEach {
                    it!!.visibility = if (it == answerBtnLB) Button.VISIBLE else Button.INVISIBLE
                }
            }
            answerBtnRT -> {
                answerBtn!!.forEach {
                    it!!.visibility = if (it == answerBtnRT) Button.VISIBLE else Button.INVISIBLE
                }
            }
            answerBtnRB -> {
                answerBtn!!.forEach {
                    it!!.visibility = if (it == answerBtnRB) Button.VISIBLE else Button.INVISIBLE
                }
            }
        }
    }
}
