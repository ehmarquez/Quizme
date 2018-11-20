package com.example.alvin.quizme;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Generate random operands for math problem in Q6
        generateOperands();
    }

    // Initialize variables
    int operand_1; //operand used for Q6
    int operand_2; // operand used for Q6

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
        operandTextView.setText(number + " = ");
    }

    /**
     *  Generate random numbers (0-5) to display as the operands
     *
     */

    private void generateOperands() {
        // Create rng object
        Random rng = new Random();

        // Call rng object and create random number
        operand_1 = rng.nextInt(6);
        operand_2 = rng.nextInt(6);

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
        // Use correctAnswer to keep track of how many correct answers
        // Use totalScore for maximum possible score
        int correctAnswer = 0;
        String totalScore = "6";

        // Check Q1 which is a radio group
        RadioGroup selectedRadioButtonQ1 = (RadioGroup) findViewById(R.id.q1_radio_group);
        RadioButton correctRadioButtonQ1 = (RadioButton) findViewById(R.id.q1_option1);

        int selectedChoiceQ1 = selectedRadioButtonQ1.getCheckedRadioButtonId();
        int correctChoiceQ1 = correctRadioButtonQ1.getId();

        if (selectedChoiceQ1 == correctChoiceQ1) {
            correctAnswer += 1;
        }

        //Check Q2 which is a radio group
        RadioGroup selectedRadioButtonQ2 = (RadioGroup) findViewById(R.id.q2_radio_group);
        RadioButton correctRadioButtonQ2 = (RadioButton) findViewById(R.id.q2_option3);

        int selectedChoiceQ2 = selectedRadioButtonQ2.getCheckedRadioButtonId();
        int correctChoiceQ2 = correctRadioButtonQ2.getId();

        if (selectedChoiceQ2 == correctChoiceQ2) {
            correctAnswer += 1;
        }

        //Check Q3 which is a radio group
        RadioGroup selectedRadioButtonQ3 = (RadioGroup) findViewById(R.id.q3_radio_group);
        RadioButton correctRadioButtonQ3 = (RadioButton) findViewById(R.id.q3_option2);

        int selectedChoiceQ3 = selectedRadioButtonQ3.getCheckedRadioButtonId();
        int correctChoiceQ3 = correctRadioButtonQ3.getId();
        if (selectedChoiceQ3 == correctChoiceQ3) {
            correctAnswer += 1;
        }

        //Check Q4 which is a radio group
        RadioGroup selectedRadioButtonQ4 = (RadioGroup) findViewById(R.id.q4_radio_group);
        RadioButton correctRadioButtonQ4 = (RadioButton) findViewById(R.id.q4_option4);

        int selectedChoiceQ4 = selectedRadioButtonQ4.getCheckedRadioButtonId();
        int correctChoiceQ4 = correctRadioButtonQ4.getId();
        if (selectedChoiceQ4 == correctChoiceQ4) {
            correctAnswer += 1;
        }

        //Check Q5 which is a checkbox question with possible multiple answers

        CheckBox firstOptionQ5 = (CheckBox) findViewById(R.id.q5_option1);
        CheckBox secondOptionQ5 = (CheckBox) findViewById(R.id.q5_option2);
        CheckBox thirdOptionQ5 = (CheckBox) findViewById(R.id.q5_option3);
        CheckBox fourthOptionQ5 = (CheckBox) findViewById(R.id.q5_option4);

        boolean selectedBox1 = firstOptionQ5.isChecked();
        boolean selectedBox2 = secondOptionQ5.isChecked();
        boolean selectedBox3 = thirdOptionQ5.isChecked();
        boolean selectedBox4 = fourthOptionQ5.isChecked();

        if (selectedBox2 == true && selectedBox4 == true && selectedBox1 == false
                && selectedBox3 == false) {
            correctAnswer += 1;
        }

        //Check Q6 which is an EditText number question

        EditText userAnswerQ6 = (EditText) findViewById(R.id.q6_answer);

        //Check if number exists in EditText field and calculate score accordingly
        try {
            int userAnswer = Integer.parseInt(userAnswerQ6.getText().toString());
            if (userAnswer == (operand_1 + operand_2)) {
                correctAnswer += 1;
            }
        }
        catch (NumberFormatException e) {
            Log.v("checkAnswers", "Q6 answer was left blank! Don't crash!");
        }

        // Making toast for the final score
        Context context = getApplicationContext();
        CharSequence finalScore = Integer.toString(correctAnswer) + " out of " + totalScore;
        int scoreToastDuration = Toast.LENGTH_SHORT;

        Toast.makeText(context, finalScore, scoreToastDuration).show();

    }

}
