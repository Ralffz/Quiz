package com.example.opilane.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private Questions MyQuestions = new Questions();
    private Button choice1;
    private Button choice2;
    private Button choice3;
    private Button choice4;
    private TextView score;
    private TextView question;
    private String MyAnswer;
    private int MyScore = 0;
    private int MyQuestionNumber = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choice1 = (Button) findViewById(R.id.choice1);
        choice2 = (Button) findViewById(R.id.choice2);
        choice3 = (Button) findViewById(R.id.choice3);
        choice4 = (Button) findViewById(R.id.choice4);
        score = (TextView) findViewById(R.id.score);
        question = (TextView) findViewById(R.id.question);
        updateQuestion();
        updateScore(MyScore);
    }

    private void updateQuestion() {
        if (MyQuestionNumber < MyQuestions.getlenght()) {
            question.setText(MyQuestions.getQuestion(MyQuestionNumber));
            choice1.setText(MyQuestions.getChoice(MyQuestionNumber, 1));
            choice2.setText(MyQuestions.getChoice(MyQuestionNumber, 2));
            choice3.setText(MyQuestions.getChoice(MyQuestionNumber, 3));
            choice4.setText(MyQuestions.getChoice(MyQuestionNumber, 4));
            MyAnswer = MyQuestions.getCorrectAnswer(MyQuestionNumber);
            MyQuestionNumber++;
        }else{
            Toast.makeText(MainActivity.this,"This was the last question", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,HighestScoreActivity.class);
            intent.putExtra("score", MyScore);
            startActivity(intent);
        }
    }

    private void updateScore(int point) {
        score.setText("" +MyScore + "/" + MyQuestions.getlenght());
    }
    public void onClick(View view) {
        Button answer = (Button) view;
        if (answer.getText() == MyAnswer) {
            MyScore = MyScore + 1;
            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(MainActivity.this,"Wrong!",Toast.LENGTH_SHORT).show();
            updateScore(MyScore);
            updateQuestion();
        }
    }
