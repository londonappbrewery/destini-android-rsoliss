package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mTopButton;
    private Button mBottomButton;
    private int mStoryIndex = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mTopButton = (Button) findViewById(R.id.buttonTop);
        mBottomButton = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1 || mStoryIndex == 2) {
                    nextStory(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
                    mStoryIndex = 3;
                } else if (mStoryIndex == 3) {
                    endStory(R.string.T6_End);
                    mStoryIndex = 6;
                }
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) {
                    nextStory(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2);
                    mStoryIndex = 2;
                } else if (mStoryIndex == 2) {
                    endStory(R.string.T4_End);
                    mStoryIndex = 4;
                } else if (mStoryIndex == 3) {
                    endStory(R.string.T5_End);
                    mStoryIndex = 5;
                }
            }
        });
    }

    private void nextStory(int storyId, int topId, int bottomId) {
        mStoryTextView.setText(storyId);
        mTopButton.setText(topId);
        mBottomButton.setText(bottomId);
    }

    private void endStory(int storyId) {
        mStoryTextView.setText(storyId);
        mTopButton.setVisibility(View.GONE);
        mBottomButton.setVisibility(View.GONE);
    }
}
