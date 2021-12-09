package com.lubinskiy.lesson14.modules

class Number(private val firstNumber: Float, private val secondNumber: Float) {

    fun add() = (firstNumber + secondNumber).toString()

    fun subtract() = (firstNumber - secondNumber).toString()

    fun multiply() = (firstNumber * secondNumber).toString()

    fun divide(): String {
        return if (secondNumber != 0f) {
            (firstNumber / secondNumber).toString()
        } else {
            "You cannot divide by 0!!!"
        }
    }
}
