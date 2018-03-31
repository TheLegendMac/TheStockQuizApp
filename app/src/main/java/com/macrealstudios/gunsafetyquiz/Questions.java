package com.macrealstudios.gunsafetyquiz;


/**
 * Created by termi on 3/24/2018.
 */

public class Questions {


    private String mQuestionNumber;
    private String mQuestionText;
    private String mAnswerExample1;
    private String mAnswerExample2;
    private String mAnswerExample3;
    private boolean selected;


    //constructor for making a question object
    public Questions(String questionNumber,
                     String questionText,
                     String answerExample1,
                     String answerExample2,
                     String answerExample3) {
        mQuestionNumber = questionNumber;
        mQuestionText = questionText;
        mAnswerExample1 = answerExample1;
        mAnswerExample2 = answerExample2;
        mAnswerExample3 = answerExample3;
    }

    //accessor. allows question number to be accessed
    String getQuestionNumber() {
        return mQuestionNumber;
    }

    //accessor. allows question text to be accessed
    String getQuestionText() {
        return mQuestionText;
    }

    //accessor. allows answer example 1 to be accessed
    public String getAnswerExample1() {
        return mAnswerExample1;
    }

    //accessor. allows answer example 2 to be accessed
    String getAnswerExample2() {
        return mAnswerExample2;
    }

    //accessor. allows answer example 3 to be accessed
    String getAnswerExample3() {
        return mAnswerExample3;
    }
}
