package com.macrealstudios.gunsafetyquiz;

import android.app.Activity;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;


class QuestionsAdapter extends ArrayAdapter<Questions> {

    private static final String LOG_TAG = QuestionsAdapter.class.getSimpleName();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context   The current context. Used to inflate the layout file.
     * @param questions A List of AndroidFlavor objects to display in a list
     */
    public QuestionsAdapter(Activity context, ArrayList<Questions> questions) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, questions);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.question_card, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Questions currentRadioBtn = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView questionTitle = listItemView.findViewById(R.id.questionText);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        questionTitle.setText(currentRadioBtn.getQuestionText());

        RadioGroup radioGroup = listItemView.findViewById(R.id.radioGroup);

        // Find the TextView in the list_item.xml layout with the ID version_name
        RadioButton radioButton1 = listItemView.findViewById(R.id.radioButton);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        radioButton1.setText(currentRadioBtn.getAnswerExample1());

        // Find the TextView in the list_item.xml layout with the ID version_name
        RadioButton radioButton2 = listItemView.findViewById(R.id.radioButton2);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        radioButton2.setText(currentRadioBtn.getAnswerExample2());

        // Find the TextView in the list_item.xml layout with the ID version_name
        RadioButton radioButton3 = listItemView.findViewById(R.id.radioButton3);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        radioButton3.setText(currentRadioBtn.getAnswerExample3());


        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}