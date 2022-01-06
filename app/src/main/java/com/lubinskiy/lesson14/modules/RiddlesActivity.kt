package com.lubinskiy.lesson14.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.lubinskiy.lesson14.R

class RiddlesActivity : AppCompatActivity() {
    private lateinit var riddleQuestion: TextView
    private lateinit var riddleAnswer: TextView
    private lateinit var startBtn: Button
    private lateinit var answerBtnLT: Button
    private lateinit var answerBtnRT: Button
    private lateinit var answerBtnLB: Button
    private lateinit var answerBtnRB: Button
    private lateinit var answerBtn: List<Button?>
    private lateinit var riddles: List<Riddle>

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
        val sequence = riddles.let {
            listOf(0, 1, 2, 3).asSequence().shuffled().take(it.size).toList()
        }

        riddleQuestion.text = riddles.random().question

        var counter = 0
        answerBtn.forEach {
            it?.text = riddles[sequence[counter]].answer
            it?.visibility = Button.VISIBLE
            counter++
        }
        counter = 0

        startBtn.text = getString(R.string.riddles_btn_restart)
        riddleAnswer.text = getString(R.string.empty_string)
    }

    fun onClickAnswer(view: View?) {
        when (view!!.id) {
            answerBtnLT.id -> buttonController(answerBtnLT)
            answerBtnLB.id -> buttonController(answerBtnLB)
            answerBtnRT.id -> buttonController(answerBtnRT)
            answerBtnRB.id -> buttonController(answerBtnRB)
        }
    }

    private fun buttonController(button: Button?) {
        riddles.forEach {
            if (it.answer == button?.text &&
                it.question == riddleQuestion.text
            ) {
                riddleAnswer.text = getString(R.string.riddles_answer_true)
                buttonVisibility(button.id)
                return
            }
        }
        buttonVisibility(button!!.id)
        riddleAnswer.text = getString(R.string.riddles_answer_false)
    }

    private fun buttonVisibility(buttonId: Int) {
        answerBtn.forEachIndexed {
            index, v -> v?.visibility = if (v?.id == buttonId) Button.VISIBLE else Button.INVISIBLE
        }
    }
}
