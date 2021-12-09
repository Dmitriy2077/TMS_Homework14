package com.lubinskiy.lesson14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lubinskiy.lesson14.modules.TextActivity
import com.lubinskiy.lesson14.modules.MagicBallActivity
import com.lubinskiy.lesson14.modules.RiddlesActivity
import com.lubinskiy.lesson14.modules.CalculatorActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onClickText(view: View?) {
        val intent = Intent(this, TextActivity::class.java)
        startActivity(intent)
    }

    fun onClickMagicBall(view: View?) {
        val intent = Intent(this, MagicBallActivity::class.java)
        startActivity(intent)
    }

    fun onClickRiddles(view: View?) {
        val intent = Intent(this, RiddlesActivity::class.java)
        startActivity(intent)
    }

    fun onClickCalculator(view: View?) {
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }
}
