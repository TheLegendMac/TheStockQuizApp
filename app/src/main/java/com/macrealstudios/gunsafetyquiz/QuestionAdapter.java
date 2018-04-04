package com.macrealstudios.gunsafetyquiz;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

class QuestionsAdapter extends ArrayAdapter<Questions> {

    String[] questions_text;

    public QuestionsAdapter(Activity context, ArrayList<Questions> questions) {
        super(context, 0, questions);

    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view

        View listItemView = convertView;

        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.question_card, parent, false);
        }


        // Get the current question object located at this position in the list

        Questions currentQuestionPosition = getItem(position);


        // Find the question text in the list_item.xml layout set the text to getQuestionText

        TextView questionText = listItemView.findViewById(R.id.questionText);
        questionText.setText(currentQuestionPosition.getQuestionText());


        // Find the RadioBtnOne in the list_item.xml and set the text to getAnswerExample1
        RadioButton radioBtnOne = listItemView.findViewById(R.id.radioButton);
        radioBtnOne.setText(currentQuestionPosition.getAnswerExample1());

        /*Block of code where I am getting the error. It thought the way I would go about this would be by trying to get the current Radio Group and and checking which radio button was clicked within that radio group. I am getting an error though with the findViewById
        RadioGroup radioGroup = currentQuestionPosition.getRadioGroup();
        int checkedRadioId = radioGroup.getCheckedRadioButtonId();
        RadioButton checkedRadioBtn = findViewById(checkedRadioId);
        if(checkedRadioId == currentQuestionPosition.getAnswerExample1()){

        }
        */


        // Find the RadioBtnTwo in the list_item.xml and set the text to getAnswerExample2
        RadioButton radioBtnTwo = listItemView.findViewById(R.id.radioButton2);
        radioBtnTwo.setText(currentQuestionPosition.getAnswerExample2());


        // Find the RadioBtnThree in the list_item.xml and set the text to getAnswerExample3
        RadioButton radioBtnThree = listItemView.findViewById(R.id.radioButton3);
        radioBtnThree.setText(currentQuestionPosition.getAnswerExample3());

        return listItemView;

    }
}