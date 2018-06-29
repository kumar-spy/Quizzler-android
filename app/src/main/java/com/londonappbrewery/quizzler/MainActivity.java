package com.londonappbrewery.quizzler;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    // TODO: Declare constants here


    // TODO: Declare member variables here:
    Button false_button;
    Button true_button;
    TextView mQuestionTextView;
    int mIndex;
    int mQuestion;
    // TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, true),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, true),
            new TrueFalse(R.string.question_6, false),
            new TrueFalse(R.string.question_7, true),
            new TrueFalse(R.string.question_8, false),
            new TrueFalse(R.string.question_9, true),
            new TrueFalse(R.string.question_10, true),
            new TrueFalse(R.string.question_11, false),
            new TrueFalse(R.string.question_12, false),
            new TrueFalse(R.string.question_13,true)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        false_button = (Button)findViewById(R.id.false_button);
        true_button = (Button)findViewById(R.id.true_button);
        mQuestionTextView=(TextView)findViewById(R.id.question_text_view);
        mQuestionTextView.setText("Birds are dianasours");
        mQuestion = mQuestionBank[mIndex].getmQuestionId();
        mQuestionTextView.setText(mQuestion);
        true_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
                Toast.makeText(getApplicationContext(),"True Pressed", Toast.LENGTH_SHORT).show();
            }
        });
        false_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion();
                Toast mytoast = Toast.makeText(getApplicationContext(),"False pressed" ,Toast.LENGTH_SHORT);
                mytoast.show();
            }
        });



    }
    private void updateQuestion(){
        mIndex=(mIndex+1)%mQuestionBank.length;
        mQuestion=mQuestionBank[mIndex].getmQuestionId();
        mQuestionTextView.setText(mQuestion);
    }
}
