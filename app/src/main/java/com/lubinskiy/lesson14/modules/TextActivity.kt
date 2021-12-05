package com.lubinskiy.lesson14.modules

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import android.widget.EditText
import android.view.View
import com.lubinskiy.lesson14.R

class TextActivity : AppCompatActivity() {
    var textInput: EditText? = null
    var textOutput: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text)
        init()
    }

    private fun init() {
        textInput = findViewById(R.id.textInput)
        textOutput = findViewById(R.id.textOutput)
    }

    fun onClick(view: View?) {
        textOutput!!.text = textInput!!.text.toString()
            .replace('a', 'o')
            .replace('A', 'O')
            .replace('А', 'О')
            .replace('а', 'о')
    }
}