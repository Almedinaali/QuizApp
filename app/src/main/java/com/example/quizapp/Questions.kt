package com.example.quizapp

class Questions {

    val easyQuestions = arrayOf<String>(
        "Koje su osnove programiranja?",
        "Koji su tipovi podataka?",
        "Koje kontrolne strukture podataka postoje?",
        "Šta je rekurzija?",
        "Osnove objektno-orijentisanog programiranja?",
        "Koje su osnovne strukture podataka?"
    )

    val easyChoices = arrayOf(
        arrayOf("osnova1", "osnova2", "osnova3", "osnova4"),
        arrayOf("tip1", "tip2", "tip3", "tip4"),
        arrayOf("str1", "str2", "str3", "str4"),
        arrayOf("rek1", "rek2", "rek3", "rek4"),
        arrayOf("osnovaoop1", "osnovaoop2", "osnovaoop3", "osnovaoop4"),
        arrayOf("osnovasp1", "osnovasp2", "osnovasp3", "osnovasp4")
    )

    val easyCorrectAnswers = arrayOf<String>(
        "osnova3",
        "tip1",
        "str4",
        "rek2",
        "osnovaoop1",
        "osnovasp2"
    )

    val mediumQuestions = arrayOf<String>(
        "srednjetesko-Koje su osnove programiranja?",
        "srednjetesko-Koji su tipovi podataka?",
        "srednjetesko-Koje kontrolne strukture podataka postoje?",
        "srednjetesko-Šta je rekurzija?",
        "srednjetesko-Osnove objektno-orijentisanog programiranja?",
        "srednjetesko-Koje su osnovne strukture podataka?"
    )

    val mediumChoices = arrayOf(
        arrayOf("srednjetesko-osnova1", "srednjetesko-osnova2", "srednjetesko-osnova3", "srednjetesko-osnova4"),
        arrayOf("srednjetesko-tip1", "srednjetesko-tip2", "srednjetesko-tip3", "srednjetesko-tip4"),
        arrayOf("srednjetesko-str1", "srednjetesko-str2", "srednjetesko-str3", "srednjetesko-str4"),
        arrayOf("srednjetesko-rek1", "srednjetesko-rek2", "srednjetesko-rek3", "srednjetesko-rek4"),
        arrayOf("srednjetesko-osnovaoop1", "srednjetesko-osnovaoop2", "srednjetesko-osnovaoop3", "srednjetesko-osnovaoop4"),
        arrayOf("srednjetesko-osnovasp1", "srednjetesko-osnovasp2", "srednjetesko-osnovasp3", "srednjetesko-osnovasp4")
    )

    val mediumCorrectAnswers = arrayOf<String>(
        "srednjetesko-osnova3",
        "srednjetesko-tip1",
        "srednjetesko-str4",
        "srednjetesko-rek2",
        "srednjetesko-osnovaoop1",
        "srednjetesko-osnovasp2"
    )

    val hardQuestions = arrayOf<String>(
        "tesko-Koje su osnove programiranja?",
        "tesko-Koji su tipovi podataka?",
        "tesko-Koje kontrolne strukture podataka postoje?",
        "tesko-Šta je rekurzija?",
        "tesko-Osnove objektno-orijentisanog programiranja?",
        "tesko-Koje su osnovne strukture podataka?"
    )

    val hardChoices = arrayOf(
        arrayOf("tesko-osnova1", "tesko-osnova2", "tesko-osnova3", "tesko-osnova4"),
        arrayOf("tesko-tip1", "tesko-tip2", "tesko-tip3", "tesko-tip4"),
        arrayOf("tesko-str1", "tesko-str2", "tesko-str3", "tesko-str4"),
        arrayOf("tesko-rek1", "tesko-rek2", "tesko-rek3", "tesko-rek4"),
        arrayOf("tesko-osnovaoop1", "tesko-osnovaoop2", "tesko-osnovaoop3", "tesko-osnovaoop4"),
        arrayOf("tesko-osnovasp1", "tesko-osnovasp2", "tesko-osnovasp3", "tesko-osnovasp4")
    )

    val hardCorrectAnswers = arrayOf<String>(
        "tesko-osnova3",
        "tesko-tip1",
        "tesko-str4",
        "tesko-rek2",
        "tesko-osnovaoop1",
        "tesko-osnovasp2"
    )

    public fun getEasyQuestion(s : Int) : String {
        val question : String = easyQuestions[s]
        return question
    }

    public fun getEasyChoice1(s : Int) : String {
        val choice : String = easyChoices[s][0]
        return choice
    }

    public fun getEasyChoice2(s : Int) : String {
        val choice : String = easyChoices[s][1]
        return choice
    }

    public fun getEasyChoice3(s : Int) : String {
        val choice : String = easyChoices[s][2]
        return choice
    }

    public fun getEasyChoice4(s : Int) : String {
        val choice : String = easyChoices[s][3]
        return choice
    }

    public fun getEasyAnswer(s : Int) : String {
        val answer : String = easyCorrectAnswers[s]
        return answer
    }

    public fun getMediumQuestion(s : Int) : String {
        val question : String = mediumQuestions[s]
        return question
    }

    public fun getMediumChoice1(s : Int) : String {
        val choice : String = mediumChoices[s][0]
        return choice
    }

    public fun getMediumChoice2(s : Int) : String {
        val choice : String = mediumChoices[s][1]
        return choice
    }

    public fun getMediumChoice3(s : Int) : String {
        val choice : String = mediumChoices[s][2]
        return choice
    }

    public fun getMediumChoice4(s : Int) : String {
        val choice : String = mediumChoices[s][3]
        return choice
    }

    public fun getMediumAnswer(s : Int) : String {
        val answer : String = mediumCorrectAnswers[s]
        return answer
    }

    public fun getHardQuestion(s : Int) : String {
        val question : String = hardQuestions[s]
        return question
    }

    public fun getHardChoice1(s : Int) : String {
        val choice : String = hardChoices[s][0]
        return choice
    }

    public fun getHardChoice2(s : Int) : String {
        val choice : String = hardChoices[s][1]
        return choice
    }

    public fun getHardChoice3(s : Int) : String {
        val choice : String = hardChoices[s][2]
        return choice
    }

    public fun getHardChoice4(s : Int) : String {
        val choice : String = hardChoices[s][3]
        return choice
    }

    public fun getHardAnswer(s : Int) : String {
        val answer : String = hardCorrectAnswers[s]
        return answer
    }
}