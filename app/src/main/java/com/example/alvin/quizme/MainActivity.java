package com.example.alvin.quizme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        generateOperands();
    }

    /**
     *  This method displays a number for the 1st operand of a math problem,
     *
     * @param number First operand
     */

    private void displayOperand_1(int number) {
        TextView operandTextView = findViewById(R.id.q6_operand_1);
        operandTextView.setText(number);
    }

    /**
     *  This method displays a number for the 2nd operand of a math problem,
     *
     * @param number Second operand
     */

    private void displayOperand_2(int number) {
        TextView operandTextView = findViewById(R.id.q6_operand_2);
        operandTextView.setText(number);
    }

    /**
     *  Generate random numbers to display as the operands
     *
     */

    public void generateOperands(View view) {
        Random rng = new Random();

        int operand_1 = rng.nextInt(6);
        Log.v("generateOperands", "Vslue is: " + operand_1);
        int operand_2 = rng.nextInt(6);

        displayOperand_1(operand_1);
        displayOperand_2(operand_2);
    }

}
