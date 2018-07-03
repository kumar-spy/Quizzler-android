package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare member variables here:
    Button false_button;
    Button true_button;
    TextView mScoreTextView;
    TextView mQuestionTextView;
    ProgressBar mProgress;
    int mIndex,mQuestion;
    int mScore;
    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, false),
            new TrueFalse(R.string.question_3, false),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, false),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, false),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, true),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };
    //TODO: Declare constants here
    final int PROGRESS_INCREMENT = (int)Math.ceil(100.0/mQuestionBank.length);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        false_button = (Button)findViewById(R.id.false_button);
        true_button = (Button)findViewById(R.id.true_button);
        mQuestionTextView=(TextView)findViewById(R.id.question_text_view);
        mQuestion = mQuestionBank[mIndex].getmQuestionId();
        mQuestionTextView.setText(mQuestion);
        mScoreTextView=(TextView)findViewById(R.id.score);
        mProgress =(ProgressBar)findViewById(R.id.progress_bar);
        true_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                updateQuestion();

            }
        });
        false_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                updateQuestion();

            }
        });
    }
    private void updateQuestion() {

            mIndex = (mIndex + 1)%mQuestionBank.length;
            mQuestion = mQuestionBank[mIndex].getmQuestionId();
            mQuestionTextView.setText(mQuestion);
            mProgress.incrementProgressBy(PROGRESS_INCREMENT);
            if (mIndex == 0) {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setCancelable(false);
                alert.setMessage("You scored " + mScore + " Points");
                alert.setPositiveButton("Bhag BhosdiKe", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                alert.show();
            }
        }
    private void checkAnswer(boolean userInput){
        boolean correctAnswer = mQuestionBank[mIndex].ismAnswer();
        if (userInput==correctAnswer) {
            mScore=mScore+1;
            mScoreTextView.setText("Score"+mScore+"/13");
            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
        }else{
            mScore=mScore-1;
            mScoreTextView.setText("Score"+mScore+"/13");
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }

    }
}
