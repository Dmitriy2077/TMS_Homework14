package com.lubinskiy.lesson14.modules

class Riddle(val question: String, val answer: String) {
    override fun toString(): String {
        return "$question -> $answer"
    }
}