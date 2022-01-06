package com.lubinskiy.lesson14.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.lubinskiy.lesson14.R

class CalculatorActivity : AppCompatActivity() {
    private lateinit var firstNumber: EditText
    private lateinit var secondNumber: EditText
    private lateinit var expressionResult: TextView
    private lateinit var operatorButton: List<Button>
    private var operand: Number? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        init()
    }

    private fun init() {
        firstNumber = findViewById(R.id.editTextFirstNumber)
        secondNumber = findViewById(R.id.editTextSecondNumber)
        expressionResult = findViewById(R.id.textViewResult)
        operatorButton = listOf(
            findViewById(R.id.buttonAdd),
            findViewById(R.id.buttonSubtract),
            findViewById(R.id.buttonMultiply),
            findViewById(R.id.buttonDivide)
        )
    }

    fun onClickOperator(view: View?) {
        if (firstNumber.text.isNotEmpty() && secondNumber.text.isNotEmpty()) {
            operand = Number(
                firstNumber.text.toString().toFloat(),
                secondNumber.text.toString().toFloat()
            )

            expressionResult.text = when (view!!.id) {
                operatorButton[0].id -> operand!!.add()
                operatorButton[1].id -> operand!!.subtract()
                operatorButton[2].id -> operand!!.multiply()
                operatorButton[3].id -> operand!!.divide()
                else -> getString(R.string.calc_info_error)
            }
        } else {
            expressionResult.text = getString(R.string.calc_info_empty)
        }
    }

    fun onClickClear(view: View?) {
        firstNumber.text.clear()
        secondNumber.text.clear()
        expressionResult.text = getString(R.string.calc_info_result)
    }
}
