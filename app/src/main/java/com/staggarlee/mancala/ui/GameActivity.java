package com.staggarlee.mancala.ui;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.staggarlee.mancala.R;
import com.staggarlee.mancala.models.Mancala;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class GameActivity extends ActionBarActivity {

    @InjectView(R.id.cupText0) TextView mCupText0;
    @InjectView(R.id.cupText1) TextView mCupText1;
    @InjectView(R.id.cupText2) TextView mCupText2;
    @InjectView(R.id.cupText3) TextView mCupText3;
    @InjectView(R.id.cupText4) TextView mCupText4;
    @InjectView(R.id.cupText5) TextView mCupText5;
    @InjectView(R.id.cupText6) TextView mCupText6;
    @InjectView(R.id.cupText7) TextView mCupText7;
    @InjectView(R.id.cupText8) TextView mCupText8;
    @InjectView(R.id.cupText9) TextView mCupText9;
    @InjectView(R.id.cupText10) TextView mCupText10;
    @InjectView(R.id.cupText11) TextView mCupText11;
    @InjectView(R.id.cupText12) TextView mCupText12;
    @InjectView(R.id.cupText13) TextView mCupText13;

    @InjectView(R.id.cupButton1) ImageButton mCupButton1;
    @InjectView(R.id.cupButton2) ImageButton mCupButton2;
    @InjectView(R.id.cupButton3) ImageButton mCupButton3;
    @InjectView(R.id.cupButton4) ImageButton mCupButton4;
    @InjectView(R.id.cupButton5) ImageButton mCupButton5;
    @InjectView(R.id.cupButton6) ImageButton mCupButton6;

    @InjectView(R.id.cupButton8) ImageButton mCupButton8;
    @InjectView(R.id.cupButton9) ImageButton mCupButton9;
    @InjectView(R.id.cupButton10) ImageButton mCupButton10;
    @InjectView(R.id.cupButton11) ImageButton mCupButton11;
    @InjectView(R.id.cupButton12) ImageButton mCupButton12;
    @InjectView(R.id.cupButton13) ImageButton mCupButton13;

    Mancala game = new Mancala();
    String mStartCup;
    String mPlayer;
    int mIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.inject(this);



        Intent intent = getIntent();



        mCupButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeMove(1);
            }
        });

        mCupButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeMove(2);
            }
        });

        mCupButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               makeMove(3);
            }
        });

        mCupButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeMove(4);
            }
        });

        mCupButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               makeMove(5);
            }
        });

        mCupButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeMove(6);
            }
        });

        mCupButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeMove(8);
            }
        });

        mCupButton9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeMove(9);
            }
        });

        mCupButton10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeMove(10);
            }
        });

        mCupButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               makeMove(11);
            }
        });

        mCupButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               makeMove(12);
            }
        });

        mCupButton13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               makeMove(13);
            }
        });




    }


        // do {


        // } while (game.winOrLose() == 0);

    // outputs the string value of each mBead value in the cups to the display
    // also inserts a one second wait between processes
    public void updateDisplay() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mCupText0.setText(String.valueOf(game.getBoard().getCup(0).getBeads()));
                mCupText1.setText(String.valueOf(game.getBoard().getCup(1).getBeads()));
                mCupText2.setText(String.valueOf(game.getBoard().getCup(2).getBeads()));
                mCupText3.setText(String.valueOf(game.getBoard().getCup(3).getBeads()));
                mCupText4.setText(String.valueOf(game.getBoard().getCup(4).getBeads()));
                mCupText5.setText(String.valueOf(game.getBoard().getCup(5).getBeads()));
                mCupText6.setText(String.valueOf(game.getBoard().getCup(6).getBeads()));
                mCupText7.setText(String.valueOf(game.getBoard().getCup(7).getBeads()));
                mCupText8.setText(String.valueOf(game.getBoard().getCup(8).getBeads()));
                mCupText9.setText(String.valueOf(game.getBoard().getCup(9).getBeads()));
                mCupText10.setText(String.valueOf(game.getBoard().getCup(10).getBeads()));
                mCupText11.setText(String.valueOf(game.getBoard().getCup(11).getBeads()));
                mCupText12.setText(String.valueOf(game.getBoard().getCup(12).getBeads()));
                mCupText13.setText(String.valueOf(game.getBoard().getCup(13).getBeads()));
            }
        });

        SystemClock.sleep(1000);
    }

    // Combines steps 1 through 4 in Mancala.class into a single turn
    public void makeMove(final int index)  {
        //    grabs the chosen cups beads
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    game.chooseCup(index);
                    updateDisplay();
                    do {
                        game.getNextCup();
                        game.settleCup();
                        updateDisplay();
                        // until all the beads are gone
                    } while (game.getBeadsInHand() > 0);
                    game.endTurn();
                    updateDisplay();
                } catch (InterruptedException e) {
                    Toast.makeText(GameActivity.this,"A Process Was Interrupted", Toast.LENGTH_LONG).show();
                }

            }
        });
        thread.start();


    }

}
