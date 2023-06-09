package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)
        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvScore = findViewById<TextView>(R.id.tv_score)
        val btnFinish = findViewById<Button>(R.id.btn_finish)
        val congrats = findViewById<TextView>(R.id.tv_congratulations)

        val username = intent.getStringExtra(Constants.USER_NAME)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val percent = ((correctAnswers.toFloat() / totalQuestions) * 100).toInt()
        
        if(percent >= 75) {
            congrats.text = resources.getString(R.string.congratulations, "Congratulations!")
        }
        else if (percent >= 50){
            congrats.text = resources.getString(R.string.congratulations, "Not bad!")
        }
        else {
            congrats.text = resources.getString(R.string.congratulations, "You can improve!")
        }
        btnFinish.setOnClickListener {
            val intent = Intent(this, QuizSelectActivity::class.java)
            intent.putExtra(Constants.USER_NAME, username)
            startActivity(intent)
        }

        tvName.text = username
        tvScore.text = resources.getString(R.string.resultScore, correctAnswers, totalQuestions)
    }
}