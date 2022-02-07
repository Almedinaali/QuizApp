package com.example.quizapp

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class PlayActivity : AppCompatActivity() {

    lateinit var choice1 : Button
    lateinit var choice2 : Button
    lateinit var choice3 : Button
    lateinit var choice4 : Button

    lateinit var question : TextView
    var score : Int = 0

    var mainQuestions : Questions = Questions()
    lateinit var answer : String
    var mainQuestionsLength : Int = mainQuestions.easyQuestions.size

    lateinit var difficultyLevel : String

    var questionNumber : Int = 0
    lateinit var numberOfQuestionsString : String
    var numberOfQuestions : Int = 0

    var brojacLako : Int = 0
    var brojacSrednje : Int = 0
    var brojacTesko : Int = 0

    var brojLakih : Int = 0
    var brojSrednjih : Int = 0
    var brojTeskih : Int = 0

    lateinit var r : Random

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        numberOfQuestionsString = intent.getStringExtra("NUMBER")
        numberOfQuestions = numberOfQuestionsString.toInt()
        difficultyLevel = intent.getStringExtra("DIFFICULTY_LEVEL")

        /*
        * Lako: 60% iz kategorije lakih, 20% iz kategorije srednjih, 20% iz kategorije teskih pitanja
        * Srednje: 20% iz kategorije lakih, 60% iz kategorije srednjih, 20% iz kategorije teskih pitanja
        * Tesko: 20% iz kategorije lakih, 20% iz kategorije srednjih, 60% iz kategorije teskih pitanja
        * */
        brojLakih = when (difficultyLevel) {
            "Lako" -> (60 * numberOfQuestions) / 100
            "Srednje" -> (20 * numberOfQuestions) / 100
            "Teško" -> (20 * numberOfQuestions) / 100
            else -> 0
        }
        brojSrednjih = when (difficultyLevel) {
            "Lako" -> (20 * numberOfQuestions) / 100
            "Srednje" -> (60 * numberOfQuestions) / 100
            "Teško" -> (20 * numberOfQuestions) / 100
            else -> 0
        }
        brojTeskih = when (difficultyLevel) {
            "Lako" -> (20 * numberOfQuestions) / 100
            "Srednje" -> (20 * numberOfQuestions) / 100
            "Teško" -> (60 * numberOfQuestions) / 100
            else -> 0
        }

        r = Random()

        choice1 = findViewById(R.id.choice1)
        choice2 = findViewById(R.id.choice2)
        choice3 = findViewById(R.id.choice3)
        choice4 = findViewById(R.id.choice4)

        question = findViewById(R.id.question)

        updateQuestion(r.nextInt(mainQuestionsLength))

        choice1.setOnClickListener {
            if (choice1.getText() == answer) {
                score++
                updateQuestion(r.nextInt(mainQuestionsLength))
            }
            else {
                updateQuestion(r.nextInt(mainQuestionsLength))
            }
        }

        choice2.setOnClickListener {
            if (choice2.getText() == answer) {
                score++
                updateQuestion(r.nextInt(mainQuestionsLength))
            }
            else {
                updateQuestion(r.nextInt(mainQuestionsLength))
            }
        }

        choice3.setOnClickListener {
            if (choice3.getText() == answer) {
                score++
                updateQuestion(r.nextInt(mainQuestionsLength))
            }
            else {
                updateQuestion(r.nextInt(mainQuestionsLength))
            }
        }

        choice4.setOnClickListener {
            if (choice4.getText() == answer) {
                score++
                updateQuestion(r.nextInt(mainQuestionsLength))
            }
            else {
                updateQuestion(r.nextInt(mainQuestionsLength))
            }
        }
    }

    private fun updateQuestion(n : Int) {
        questionNumber++

        if (questionNumber <= numberOfQuestions) {
                if (brojacLako < brojLakih) {
                    brojacLako++

                    question.setText(mainQuestions.getEasyQuestion(n))
                    choice1.setText(mainQuestions.getEasyChoice1(n))
                    choice2.setText(mainQuestions.getEasyChoice2(n))
                    choice3.setText(mainQuestions.getEasyChoice3(n))
                    choice4.setText(mainQuestions.getEasyChoice4(n))
                    answer = mainQuestions.getEasyAnswer(n)

                    return
                }
                else if (brojacSrednje < brojSrednjih) {
                    brojacSrednje++

                    question.setText(mainQuestions.getMediumQuestion(n))
                    choice1.setText(mainQuestions.getMediumChoice1(n))
                    choice2.setText(mainQuestions.getMediumChoice2(n))
                    choice3.setText(mainQuestions.getMediumChoice3(n))
                    choice4.setText(mainQuestions.getMediumChoice4(n))
                    answer = mainQuestions.getMediumAnswer(n)

                    return
                }
                else if (brojacTesko < brojTeskih) {
                    brojacTesko++

                    question.setText(mainQuestions.getHardQuestion(n))
                    choice1.setText(mainQuestions.getHardChoice1(n))
                    choice2.setText(mainQuestions.getHardChoice2(n))
                    choice3.setText(mainQuestions.getHardChoice3(n))
                    choice4.setText(mainQuestions.getHardChoice4(n))
                    answer = mainQuestions.getHardAnswer(n)

                    return
                }
        }
        else {
            gameOver()
        }
    }

    private fun gameOver() {
        var alertDialogBuilder = AlertDialog.Builder(this@PlayActivity)
        alertDialogBuilder
            .setMessage("Kraj kviza! Broj tačnih odgovora: " + score)
            .setCancelable(false)
            .setPositiveButton("New Game", DialogInterface.OnClickListener() { dialogInterface: DialogInterface, i : Int ->
                startActivity(Intent(getApplicationContext(), MainActivity::class.java))
                finish()
            })
            .setNegativeButton("Exit", DialogInterface.OnClickListener() { dialogInterface: DialogInterface, i : Int ->
                val intent = Intent(applicationContext, MainActivity::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("EXIT", true);
                startActivity(intent)
            })

        var alertDialog : AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    override fun onWindowFocusChanged(hasFocus: Boolean): Unit {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("SCORE", score)
        outState.putInt("BROJAC_LAKO", brojacLako)
        outState.putInt("BROJAC_SREDNJE", brojacSrednje)
        outState.putInt("BROJAC_TESKO", brojacTesko)
        outState.putInt("QUESTION_NUMBER", questionNumber)
        outState.putCharSequence("QUESTION_TEXT", question.getText())
        outState.putCharSequence("CHOICE1", choice1.getText())
        outState.putCharSequence("CHOICE2", choice2.getText())
        outState.putCharSequence("CHOICE3", choice3.getText())
        outState.putCharSequence("CHOICE4", choice4.getText())
        outState.putString("ANSWER", answer)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        score = savedInstanceState.getInt("SCORE")
        brojacLako = savedInstanceState.getInt("BROJAC_LAKO")
        brojacSrednje = savedInstanceState.getInt("BROJAC_SREDNJE")
        brojacTesko = savedInstanceState.getInt("BROJAC_TESKO")
        questionNumber = savedInstanceState.getInt("QUESTION_NUMBER")
        question.setText(savedInstanceState.getCharSequence("QUESTION_TEXT"))
        choice1.setText(savedInstanceState.getCharSequence("CHOICE1"))
        choice2.setText(savedInstanceState.getCharSequence("CHOICE2"))
        choice3.setText(savedInstanceState.getCharSequence("CHOICE3"))
        choice4.setText(savedInstanceState.getCharSequence("CHOICE4"))
        answer = savedInstanceState.getString("ANSWER")!!
    }
}