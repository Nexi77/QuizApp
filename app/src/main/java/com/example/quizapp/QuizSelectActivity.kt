package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.text.AllCapsTransformationMethod
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import com.example.quizapp.Constants.getCategories


class QuizSelectActivity : AppCompatActivity() {
    private var mUserName: String? = null

    private fun handleClick(categoryId: Int) {
        val intent = Intent(this, QuizQuestionsActivity::class.java)
        intent.putExtra(Constants.USER_NAME, mUserName)
        intent.putExtra(Constants.CATEGORY_ID, categoryId)
        startActivity(intent)
        finish()
    }

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        mUserName = intent.getStringExtra(Constants.USER_NAME)
        supportActionBar?.title = "Quiz Select"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_select)
        val categories = getCategories()
        val containerLayout: LinearLayout = findViewById(R.id.quizSelectGridLayout)

        for (category in categories) {
            val card = CardView(this)
            val layoutParams = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
            )
            layoutParams.setMargins(20)
            card.layoutParams = layoutParams
            val cornerRadius = resources.getDimensionPixelSize(androidx.cardview.R.dimen.cardview_default_radius)
            card.radius = cornerRadius.toFloat()
            val linearLayout = LinearLayout(this)
            linearLayout.orientation = LinearLayout.VERTICAL
            linearLayout.gravity = Gravity.CENTER
            val color = ContextCompat.getColor(this, R.color.white)
            linearLayout.setBackgroundColor(color)
            val id = View.generateViewId()
            linearLayout.id = id
            linearLayout.setPadding(20)
            linearLayout.setOnClickListener {
                handleClick(category.id)
            }

            val imageView = ImageView(this)
            imageView.setImageResource(category.image)
            val imageLayoutParams = ViewGroup.LayoutParams(400, 400)
            imageView.layoutParams = imageLayoutParams
            imageView.scaleType = ImageView.ScaleType.FIT_CENTER

            val textView = TextView(this)
            textView.text = category.text
            val textColor = ContextCompat.getColor(this, R.color.purple_500)
            textView.setTypeface(null, Typeface.BOLD)
            textView.setTextColor(textColor)
            textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
            textView.transformationMethod = AllCapsTransformationMethod(this)
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
            textView.setPadding(40)
            linearLayout.addView(imageView)
            linearLayout.addView(textView)
            card.addView(linearLayout)
            containerLayout.addView(card)
        }
    }
}