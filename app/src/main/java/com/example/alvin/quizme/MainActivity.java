package com.example.alvin.quizme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateOperands();
    }

    /**
     *  This method displays a number for the 1st operand of a math problem,
     *
     * @param number First operand
     */

    private void displayOperand1(int number) {
        Log.v("displayOperand1", "Entering function");
        TextView operandTextView = (TextView) findViewById(R.id.q6_operand_1);
        Log.v("displayOperand1", "Found text view");
        operandTextView.setText(String.valueOf(number));
    }

    /**
     *  This method displays a number for the 2nd operand of a math problem,
     *
     * @param number Second operand
     */

    private void displayOperand2(int number) {
        TextView operandTextView = (TextView) findViewById(R.id.q6_operand_2);
        operandTextView.setText(" " + number);
    }

    /**
     *  Generate random numbers (0-5) to display as the operands
     *
     */

    private void generateOperands() {
        // Create rng object
        Random rng = new Random();

        // Call rng object and create random number
        int operand_1 = rng.nextInt(6);
        int operand_2 = rng.nextInt(6);

        // Display the 2 random operands for final question
        displayOperand1(operand_1);
        displayOperand2(operand_2);
    }
    /**
     * Checks submitted answers when user clicks Submit Answers button
     *
     * @param View corresponding with onClickListener
     */

    public void checkAnswers(View view) {
        // Check answer, RadioGroup only allows 1 checked so just check for
        // 1 radio button
        RadioGroup selectedRadioButton = (RadioGroup) findViewById(R.id.q1_radio_group);
        Log.v("CheckAnswers", "Selected answer is:"
                + selectedRadioButton.getCheckedRadioButtonId());

        RadioButton correctRadioButton = (RadioButton) findViewById(R.id.q1_option1);
        Log.v("CheckAnswers", "Correct answer is:"
                + correctRadioButton.getId());

        // Check Q1 which is a radio group
    }

     /**
     * Checks submitted answers when user clicks Submit Answers button
     *
     * @param selectedChoice
     */

    private void checkRadioAnswers(int selectedChoice, int correctChoice) {
        // Check answers for radio group style questions with only 1 allowed selection
        RadioGroup selectedRadioButton = (RadioGroup) findViewById(R.id.q1_radio_group);
        Log.v("CheckAnswers", "Selected answer is:"
                + selectedRadioButton.getCheckedRadioButtonId());

        RadioButton correctRadioButton = (RadioButton) findViewById(R.id.q1_option1);
        Log.v("CheckAnswers", "Correct answer is:"
                + correctRadioButton.getId());

    }

}
