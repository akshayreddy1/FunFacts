package com.google.akshay.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class FunActivity extends AppCompatActivity {

    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";
    private TextView  mFactTextView;
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;
    ColorWheel mColorWheel = new ColorWheel();
    FactBook mFactBook = new FactBook();
    private String mFact = mFactBook.mFacts[0];
    private int mColor = Color.parseColor(mColorWheel.mColors[8]);

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(KEY_FACT, mFact);
        outState.putInt(KEY_COLOR, mColor);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mFact = savedInstanceState.getString(KEY_FACT);
        mColor = savedInstanceState.getInt(KEY_COLOR);

        mFactTextView.setText(mFact);
        mShowFactButton.setTextColor(mColor);
        mRelativeLayout.setBackgroundColor(mColor);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun);
        mFactTextView = (TextView) findViewById(R.id.factTextView2);
        mShowFactButton = (Button) findViewById(R.id.funFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.activity_fun);

        final View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFact = mFactBook.getFact();
                mColor = mColorWheel.getColor();

                mFactTextView.setText(mFact);
                mShowFactButton.setTextColor(mColor);
                mRelativeLayout.setBackgroundColor(mColor);
            }
        };


        mShowFactButton.setOnClickListener(listener);
        //Toast.makeText(this, "Yo bro!!", Toast.LENGTH_SHORT).show();
        Log.d("FunFactsActivity","We are logging from onCreate() Method");
    }
}
