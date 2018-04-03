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
    public static ArrayList<String> selectedAnswers;


    public QuestionsAdapter(Activity context, ArrayList<Questions> questions) {
        super(context, 0, questions);

        selectedAnswers = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            selectedAnswers.add("Not Attempted");
        }
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view

        View listItemView = convertView;

        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.question_card, parent, false);
        }


        // Get the {@link AndroidFlavor} object located at this position in the list

        Questions currentQuestionPosition = getItem(position);


        // Find the TextView in the list_item.xml layout with the ID version_name

        TextView questionText = listItemView.findViewById(R.id.questionText);
        questionText.setText(currentQuestionPosition.getQuestionText());


        // Find the RadioBtn in the list_item.xml layout with the ID version_number

        RadioButton radioBtnOne = listItemView.findViewById(R.id.radioButton);
        radioBtnOne.setText(currentQuestionPosition.getAnswerExample1());


        RadioGroup radioGroup = currentQuestionPosition.getRadioGroup();

        int checkedRadioId = radioGroup.getCheckedRadioButtonId();

        //The findViewById is where I am getting the error message and then then whole line of the if statement has the red squiggly line
        RadioButton checkedRadioBtn = (RadioButton) findViewById(checkedRadioId);



        RadioButton radioBtnTwo = listItemView.findViewById(R.id.radioButton2);
        radioBtnTwo.setText(currentQuestionPosition.getAnswerExample2());


        // Find the RadioBtn in the list_item.xml layout with the ID version_number

        RadioButton radioBtnThree = listItemView.findViewById(R.id.radioButton3);
        radioBtnThree.setText(currentQuestionPosition.getAnswerExample3());

        return listItemView;

    }
}