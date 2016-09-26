package com.example.ashwin.fullscrollview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    private ScrollView mScrollView;
    private boolean mScrolledToBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mScrollView = (ScrollView) findViewById(R.id.scrollView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScrolledToBottom = false;
    }

    public void next(View view)
    {
        //check if already scrolled to bottom
        if(mScrolledToBottom)
        {
            //go to next activity
            Intent intent = new Intent(this, NextActivity.class);
            startActivity(intent);
        }
        else
        {
            //check if scrollable
            if (mScrollView.fullScroll(View.FOCUS_DOWN))
            {
                mScrolledToBottom = true;
            }
            else
            {
                //go to next activity
                Intent intent = new Intent(this, NextActivity.class);
                startActivity(intent);
            }
        }

    }
}
