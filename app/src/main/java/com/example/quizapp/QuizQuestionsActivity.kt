package com.example.quizapp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var questionOptionOne: TextView? = null
    private var questionOptionTwo: TextView? = null
    private var questionOptionThree: TextView? = null
    private var answerGiven = false
    private var questionOptionFour: TextView? = null
    private var submitBtn: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        questionOptionOne = findViewById(R.id.tv_option_one)
        questionOptionTwo = findViewById(R.id.tv_option_two)
        questionOptionThree = findViewById(R.id.tv_option_three)
        questionOptionFour = findViewById(R.id.tv_option_four)
        submitBtn = findViewById(R.id.btn_submit)
        mQuestionsList = Constants.getQuestions()
        setQuestion()
        questionOptionOne?.setOnClickListener(this)
        questionOptionTwo?.setOnClickListener(this)
        questionOptionThree?.setOnClickListener(this)
        questionOptionFour?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)
    }

    private fun setQuestion(){
        val progressBar = findViewById<ProgressBar>(R.id.progress_bar)
        val tvProgress = findViewById<TextView>(R.id.tv_progress)
        val questionText = findViewById<TextView>(R.id.tv_question_id)
        val questionImage = findViewById<ImageView>(R.id.iv_image)

        answerGiven = false
        val question = mQuestionsList!![mCurrentPosition - 1]
        setDefaultOptionsView()

        if(mCurrentPosition == mQuestionsList!!.size) {
            submitBtn!!.text = getString(R.string.finish)
        } else {
            submitBtn!!.text = getString(R.string.submit)
        }
        progressBar.progress = mCurrentPosition
        val progressText = resources.getString(R.string.progress, mCurrentPosition, progressBar.max)
        tvProgress.text = progressText
        questionText.text = question.question
        questionImage.setImageResource(question.image)
        questionOptionOne?.text = question.optionOne
        questionOptionTwo?.text = question.optionTwo
        questionOptionThree?.text = question.optionThree
        questionOptionFour?.text = question.optionFour
    }

    private fun setDefaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, questionOptionOne!!)
        options.add(1, questionOptionTwo!!)
        options.add(2, questionOptionThree!!)
        options.add(3, questionOptionFour!!)
        options.forEach { textView ->
            textView.setTextColor(ContextCompat.getColor(this, R.color.secondaryText))
            textView.typeface = Typeface.DEFAULT
            textView.background = ContextCompat.getDrawable(this, R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.tv_option_one ->  {
                setSelectedOptionView(questionOptionOne!!, 1)
            }
            R.id.tv_option_two ->  {
                setSelectedOptionView(questionOptionTwo!!, 2)
            }
            R.id.tv_option_three ->  {
                setSelectedOptionView(questionOptionThree!!, 3)
            }
            R.id.tv_option_four ->  {
                setSelectedOptionView(questionOptionFour!!, 4)
            }
            R.id.btn_submit -> {
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition++
                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            Toast.makeText(this, "You have successfully completed the Quiz", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if(question!!.correctAnswer != mSelectedOptionPosition) {
                        handleSubmit(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }
                    handleSubmit(question.correctAnswer, R.drawable.correct_option_border_bg)
                    if(mCurrentPosition == mQuestionsList!!.size) {
                       submitBtn!!.text = getString(R.string.finish)
                    }
                    else {
                        submitBtn!!.text = getString(R.string.go_to)
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun handleSubmit(answer: Int, drawableView: Int){
        when(answer){
            1 -> {
                questionOptionOne!!.background = ContextCompat.getDrawable(this, drawableView)
                questionOptionOne!!.setTextColor(ContextCompat.getColor(this, R.color.white))
            }
            2 -> {
                questionOptionTwo!!.background = ContextCompat.getDrawable(this, drawableView)
                questionOptionTwo!!.setTextColor(ContextCompat.getColor(this, R.color.white))
            }
            3 -> {
                questionOptionThree!!.background = ContextCompat.getDrawable(this, drawableView)
                questionOptionThree!!.setTextColor(ContextCompat.getColor(this, R.color.white))
            }
            4 -> {
                questionOptionFour!!.background = ContextCompat.getDrawable(this, drawableView)
                questionOptionFour!!.setTextColor(ContextCompat.getColor(this, R.color.white))
            }
        }
        answerGiven = true
    }

    private fun setSelectedOptionView(tv: TextView, selectedOptionNumber: Int){
        if(answerGiven) return
        setDefaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber
        tv.setTextColor(ContextCompat.getColor(this, R.color.darkBlack))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border_bg)
    }
}