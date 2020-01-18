//Ben Jokela
//2020-01-15
//Android Programming Assignment 1
package com.example.rickmortyquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    private val questionBank = listOf(
        Question(R.string.question_1, false),
        Question(R.string.question_2, true),
        Question(R.string.question_3, true),
        Question(R.string.question_4, false),
        Question(R.string.question_5, false),
        Question(R.string.question_6, true),
        Question(R.string.question_7, false),
        Question(R.string.question_8, true),
        Question(R.string.question_9, false),
        Question(R.string.question_10, false),
        Question(R.string.question_11, false),
        Question(R.string.question_12, true),
        Question(R.string.question_13, false),
        Question(R.string.question_14, true),
        Question(R.string.question_15, false),
        Question(R.string.question_16, false),
        Question(R.string.question_17, true),
        Question(R.string.question_18, false),
        Question(R.string.question_19, false),
        Question(R.string.question_20, true))

    private var questionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize variables for components
        var questionView: TextView = findViewById(R.id.question_view)
        var nextButton: ImageButton = findViewById(R.id.next_button)
        var prevButton: ImageButton = findViewById(R.id.prev_button)
        var trueButton: Button = findViewById(R.id.true_button)
        var falseButton: Button = findViewById(R.id.false_button)
        questionView.setText(questionBank[questionIndex].textResId)

        //set listeners for buttons
        nextButton.setOnClickListener{
            questionIndex = (questionIndex+1)%(questionBank.size)
            questionView.setText(questionBank[questionIndex].textResId)
        }
        prevButton.setOnClickListener{
            questionIndex = if(questionIndex==0) questionBank.size-1 else questionIndex-1

            questionView.setText(questionBank[questionIndex].textResId)
        }
        trueButton.setOnClickListener{
            val toastText = if(questionBank[questionIndex].answer) getString(R.string.you_got_it) else getString(
                            R.string.wrong)
            Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show()
        }
        falseButton.setOnClickListener{
            val toastText = if(questionBank[questionIndex].answer) getString(R.string.wrong) else getString(
                            R.string.you_got_it)
            Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show()
        }


    }}

