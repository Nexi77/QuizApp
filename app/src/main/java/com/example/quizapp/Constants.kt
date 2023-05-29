package com.example.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val CATEGORY_ID: String = "category_id"

    fun getCategories(): ArrayList<Category> {
        val categoryList = ArrayList<Category>();
        val categoryOne = Category(0, R.drawable.ic_flag_of_argentina, "Flags")
        val categoryTwo = Category(1, R.drawable.animal_questions, "What is this animal?")
        val categoryThree = Category(2, R.drawable.proverb_category, "Fill the gap in proverb")
        categoryList.add(categoryOne)
        categoryList.add(categoryTwo)
        categoryList.add(categoryThree)
        return categoryList;
    }
    fun getQuestions(): ArrayList<ArrayList<Question>> {
        val questionsList = ArrayList<ArrayList<Question>>()
        val categoryOne = ArrayList<Question>();
        val categoryTwo = ArrayList<Question>();
        val categoryThree = ArrayList<Question>();
        // 1
        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina", "Australia",
            "Armenia", "Austria", 1
        )
        categoryOne.add(que1)
        // 2
        val que2 = Question(
            2, "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola", "Austria",
            "Australia", "Armenia", 3
        )
        categoryOne.add(que2)
        // 3
        val que3 = Question(
            3, "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus", "Belize",
            "Brunei", "Brazil", 4
        )
        categoryOne.add(que3)
        // 4
        val que4 = Question(
            4, "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas", "Belgium",
            "Barbados", "Belize", 2
        )
        categoryOne.add(que4)
        // 5
        val que5 = Question(
            5, "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon", "France",
            "Fiji", "Finland", 3
        )
        categoryOne.add(que5)
        // 6
        val que6 = Question(
            6, "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany", "Georgia",
            "Greece", "none of these", 1
        )
        categoryOne.add(que6)
        // 7
        val que7 = Question(
            7, "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica", "Egypt",
            "Denmark", "Ethiopia", 3
        )
        categoryOne.add(que7)
        // 8
        val que8 = Question(
            8, "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland", "Iran",
            "Hungary", "India", 4
        )
        categoryOne.add(que8)
        // 9
        val que9 = Question(
            9, "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Australia", "New Zealand",
            "Tuvalu", "United States of America", 2
        )
        categoryOne.add(que9)
        // 10
        val que10 = Question(
            10, "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Kuwait", "Jordan",
            "Sudan", "Palestine", 1
        )
        categoryOne.add(que10)
        questionsList.add(categoryOne);

        val cat2q1 = Question(
            1, "What animal is known for its black and white fur?",
            R.drawable.animal_main,
            "Lion", "Penguin",
            "Giraffe", "Tiger", 2
        )
        val cat2q2 = Question(
            2, "What is the largest land animal?",
            R.drawable.animal_main,
            "Lion", "Giraffe",
            "Elephant", "Tiger", 3
        )
        val cat2q3 = Question(
            3, "Which animal is known for its black and white stripes?",
            R.drawable.animal_main,
            "Zebra", "Cheetah",
            "Kangaroo", "Gorilla", 1
        )
        val cat2q4 = Question(
            4, "What is the national bird of the United States?",
            R.drawable.animal_main,
            "Peacock", "Bald Eagle",
            "Ostrich", "Flamingo", 2
        )
        val cat2q5 = Question(
            5, "Which animal is known for its ability to camouflage?",
            R.drawable.animal_main,
            "Penguin", "Hippopotamus",
            "Koala", "Chameleon ", 4
        )
        categoryTwo.add(cat2q1)
        categoryTwo.add(cat2q2)
        categoryTwo.add(cat2q3)
        categoryTwo.add(cat2q4)
        categoryTwo.add(cat2q5)
        questionsList.add(categoryTwo)

        val cat3q1 = Question(1, "Actions speak louder than ________", R.drawable.proverb_writing,
        "words", "music", "silence", "thoughts", 1)
        val cat3q2 = Question(2, "The early bird catches ________", R.drawable.proverb_writing,
            "the worm", "the wind", "the sun", "the rain", 1)
        val cat3q3 = Question(3, "Don't put all your eggs in one ________", R.drawable.proverb_writing,
            "pot", "bag", "bowl", "basket", 4)
        val cat3q4 = Question(4, "When in Rome, ________", R.drawable.proverb_writing,
            "go with the flow", "seize the day", "do as the Romans do", "follow your heart", 3)
        val cat3q5 = Question(5, "A picture is worth a ________ words", R.drawable.proverb_writing,
            "million", "thousand", "hundred", "dozen", 2)
        categoryThree.add(cat3q1)
        categoryThree.add(cat3q2)
        categoryThree.add(cat3q3)
        categoryThree.add(cat3q4)
        categoryThree.add(cat3q5)
        questionsList.add(categoryThree)
        return questionsList
    }
}