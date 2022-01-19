package com.lubinskiy.lesson14.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.lubinskiy.lesson14.R

class CalculatorActivity : AppCompatActivity() {
    private lateinit var firstNumber: EditText
    private lateinit var secondNumber: EditText
    private lateinit var expressionResult: TextView
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
    }

    fun onClickOperator(view: View?) {
        if (errorsChecking(firstNumber.text, secondNumber.text)) {
            operand = Number(
                firstNumber.text.toString().toFloat(),
                secondNumber.text.toString().toFloat()
            )

            expressionResult.text = when (view!!.id) {
                R.id.buttonAdd -> operand!!.add()
                R.id.buttonSubtract -> operand!!.subtract()
                R.id.buttonMultiply -> operand!!.multiply()
                R.id.buttonDivide -> operand!!.divide()
                else -> getString(R.string.calc_info_error)
            }
        }
    }

    private fun errorsChecking(first: Editable, second: Editable): Boolean {
        val digits = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
        val result1 = getString(numberCheck(first, digits))
        val result2 = getString(numberCheck(second, digits))
        return if (result1 == getString(R.string.calc_info_numbers) && result1 == result2) {
            true
        } else {
            expressionResult.text = ("Number 1->$result1\nNumber 2->$result2")
            false
        }
    }

    private fun numberCheck(number: Editable, digits: CharArray) = when (true) {
        number.isEmpty() -> R.string.calc_info_empty_number
        number.indexOfAny(charArrayOf('.', ',')) >= 0 -> R.string.calc_info_not_a_digit
        number.indexOfAny(charArrayOf('-')) > 0 -> R.string.calc_info_minus
        number.indexOfAny(digits) >= 0 -> R.string.calc_info_numbers
        else -> R.string.calc_info_error
    }

    fun onClickClear(view: View?) {
        firstNumber.text.clear()
        secondNumber.text.clear()
        expressionResult.text = getString(R.string.calc_info_result)
    }
}
