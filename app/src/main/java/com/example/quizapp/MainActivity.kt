package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var checkedDifficultyLevelId : Int = 0
    lateinit var checkedDifficultyLevel : Button
    lateinit var difficultyLevel : String

    var checkedNumberOfQuestionsId : Int = 0
    lateinit var checkedNumberOfQuestions : Button
    lateinit var numberOfQuestions : String

    lateinit var start : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        start = findViewById(R.id.start)

        start.setOnClickListener {

            checkedDifficultyLevelId = tezina.getCheckedRadioButtonId()
            checkedDifficultyLevel = findViewById(checkedDifficultyLevelId)
            difficultyLevel = checkedDifficultyLevel.getText().toString()

            checkedNumberOfQuestionsId = brojPitanja.getCheckedRadioButtonId()
            checkedNumberOfQuestions = findViewById(checkedNumberOfQuestionsId)
            numberOfQuestions = checkedNumberOfQuestions.getText().toString()

            val intent = Intent(this,  PlayActivity::class.java)
            intent.putExtra("NUMBER", numberOfQuestions)
            intent.putExtra("DIFFICULTY_LEVEL", difficultyLevel)
            startActivity(intent)
        }

        if (getIntent().getBooleanExtra("EXIT", false)) {
            finish();
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean): Unit {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }

}
