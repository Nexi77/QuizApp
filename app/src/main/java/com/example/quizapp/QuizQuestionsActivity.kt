package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val questionsList = Constants.getQuestions()
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val tvProgress = findViewById<TextView>(R.id.tv_progress)
        val questionText = findViewById<TextView>(R.id.tv_question_id)
        val questionImage = findViewById<ImageView>(R.id.iv_image)
        val questionOptionOne = findViewById<TextView>(R.id.tv_option_one)
        val questionOptionTwo = findViewById<TextView>(R.id.tv_option_two)
        val questionOptionThree = findViewById<TextView>(R.id.tv_option_three)
        val questionOptionFour = findViewById<TextView>(R.id.tv_option_four)
        val currentPosition = 1
        val question: Question = questionsList[currentPosition - 1]

        progressBar.progress = currentPosition
        val progressText = resources.getString(R.string.progress, currentPosition, progressBar.max)
        tvProgress.text = progressText
        questionText.text = question.question
        questionImage.setImageResource(question.image)
        questionOptionOne.text = question.optionOne
        questionOptionTwo.text = question.optionTwo
        questionOptionThree.text = question.optionThree
        questionOptionFour.text = question.optionFour
    }
}