package com.staggarlee.mancala.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.staggarlee.mancala.R;
import com.staggarlee.mancala.models.Mancala;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends ActionBarActivity {

    @InjectView(R.id.startButton) Button mStartButton;

    Mancala game = new Mancala();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame();
            }
        });

    }

    private void startGame() {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }


}
