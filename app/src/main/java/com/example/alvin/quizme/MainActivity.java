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

    // Initialize variables
    private int operand_1; //operand used for Q6
    private int operand_2; //operand used for Q6

    // Use correctAnswer to keep track of how many correct answers
    // Use TOTALSCORE for maximum possible score
    private int correctAnswer = 0;
    private String TOTALSCORE = "6";

    // Initialize selected answers and correct answers
    private RadioGroup selectedRadioButtonQ1;
    private RadioButton correctRadioButtonQ1;
    private RadioGroup selectedRadioButtonQ2;
    private RadioButton correctRadioButtonQ2;
    private RadioGroup selectedRadioButtonQ3;
    private RadioButton correctRadioButtonQ3;
    private RadioGroup selectedRadioButtonQ4;
    private RadioButton correctRadioButtonQ4;
    private CheckBox firstOptionQ5;
    private CheckBox secondOptionQ5;
    private CheckBox thirdOptionQ5;
    private CheckBox fourthOptionQ5;
    private EditText userAnswerQ6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declare views needed for the questions and the corresponding answers
        selectedRadioButtonQ1 = (RadioGroup) findViewById(R.id.q1_radio_group);
        correctRadioButtonQ1 = (RadioButton) findViewById(R.id.q1_option1);

        selectedRadioButtonQ2 = (RadioGroup) findViewById(R.id.q2_radio_group);
        correctRadioButtonQ2 = (RadioButton) findViewById(R.id.q2_option3);

        selectedRadioButtonQ3 = (RadioGroup) findViewById(R.id.q3_radio_group);
        correctRadioButtonQ3 = (RadioButton) findViewById(R.id.q3_option2);

        selectedRadioButtonQ4 = (RadioGroup) findViewById(R.id.q4_radio_group);
        correctRadioButtonQ4 = (RadioButton) findViewById(R.id.q4_option4);

        firstOptionQ5 = (CheckBox) findViewById(R.id.q5_option1);
        secondOptionQ5 = (CheckBox) findViewById(R.id.q5_option2);
        thirdOptionQ5 = (CheckBox) findViewById(R.id.q5_option3);
        fourthOptionQ5 = (CheckBox) findViewById(R.id.q5_option4);

        userAnswerQ6 = (EditText) findViewById(R.id.q6_answer);

        // Generate random operands for math problem in Q6
        generateOperands();
    }

    /**
     * This method displays a number for the 1st operand of a math problem,
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
     * This method displays a number for the 2nd operand of a math problem,
     *
     * @param number Second operand
     */
    private void displayOperand2(int number) {
        TextView operandTextView = (TextView) findViewById(R.id.q6_operand_2);
        operandTextView.setText(number + " = ");
    }

    /**
     * Generate random numbers (0-5) to display as the operands
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
     * @param view corresponding with onClickListener
     */
    public void checkAnswers(View view) {

        //Reset correct answers count
        correctAnswer = 0;

        checkQ1();
        checkQ2();
        checkQ3();
        checkQ4();
        checkQ5();
        checkQ6();

        // Determine if user PASS or FAIL
        CharSequence finalScore;
        if (correctAnswer > 3) {
           finalScore = "Pass!\n" + Integer.toString(correctAnswer)
                   + " out of " + TOTALSCORE;
        }
        else {
            finalScore = "FAIL, Try again! \n" + Integer.toString(correctAnswer)
                    + " out of " + TOTALSCORE;
        }

        // Making toast for the final score
        Context context = MainActivity.this;
        int scoreToastDuration = Toast.LENGTH_SHORT;

        Toast.makeText(context, finalScore, scoreToastDuration).show();

    }

    /**
     * Checks answer for Q1 which is a radio group with one answer
     */
    private void checkQ1() {
        int selectedChoiceQ1 = selectedRadioButtonQ1.getCheckedRadioButtonId();
        int correctChoiceQ1 = correctRadioButtonQ1.getId();

        if (selectedChoiceQ1 == correctChoiceQ1) {
            correctAnswer += 1;
        }
    }

    /**
     * Checks answer for Q2 which is a radio group with one answer
     */
    private void checkQ2() {
        int selectedChoiceQ2 = selectedRadioButtonQ2.getCheckedRadioButtonId();
        int correctChoiceQ2 = correctRadioButtonQ2.getId();

        if (selectedChoiceQ2 == correctChoiceQ2) {
            correctAnswer += 1;
        }
    }

    /**
     * Checks answer for Q3 which is a radio group with one answer
     */
    private void checkQ3() {
        int selectedChoiceQ3 = selectedRadioButtonQ3.getCheckedRadioButtonId();
        int correctChoiceQ3 = correctRadioButtonQ3.getId();

        if (selectedChoiceQ3 == correctChoiceQ3) {
            correctAnswer += 1;
        }
    }

    /**
     * Checks answer for Q4 which is a radio group with one answer
     */
    private void checkQ4() {
        int selectedChoiceQ4 = selectedRadioButtonQ4.getCheckedRadioButtonId();
        int correctChoiceQ4 = correctRadioButtonQ4.getId();

        if (selectedChoiceQ4 == correctChoiceQ4) {
            correctAnswer += 1;
        }
    }

    /**
     * Checks answer for Q5 which is a checkbox with multiple answers
     */
    private void checkQ5() {
        boolean selectedBox1 = firstOptionQ5.isChecked();
        boolean selectedBox2 = secondOptionQ5.isChecked();
        boolean selectedBox3 = thirdOptionQ5.isChecked();
        boolean selectedBox4 = fourthOptionQ5.isChecked();

        if (selectedBox2 && selectedBox4 && !selectedBox1 && !selectedBox3) {
            correctAnswer += 1;
        }
    }

    /**
     * Checks answer for Q6 which is an edit text number form field
     */
    private void checkQ6() {
        try {
            int userAnswer = Integer.parseInt(userAnswerQ6.getText().toString().trim());

            if (userAnswer == (operand_1 + operand_2)) {
                correctAnswer += 1;
            }
        }
        catch (NumberFormatException e) {
            //If answer is left blank, "" is unacceptable number format
            Log.v("checkQ6", getString(R.string.answerBlankQ6));
        }
    }
}
