package com.fouzia.tapwin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.logging.Logger;

import javax.xml.transform.ErrorListener;

import es.dmoral.toasty.Toasty;

//
public class MainActivity<flag> extends AppCompatActivity {

    TextView textViewAddScorep1, textviewP1, textViewTotalChancep1, textviewScoreP1, textviewScoreP2, textViewAddScorep2, textViewP2, textViewTotalChancep2;
    int result = 0;
    int result2 = 0;
    int p1, p2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewAddScorep1 = findViewById(R.id.addScoreP1);
        textViewAddScorep2 = findViewById(R.id.addScoreP2);
        textviewP1 = findViewById(R.id.p1);
        textViewP2 = findViewById(R.id.p2);
        textviewScoreP1 = findViewById(R.id.scoreP1);
        textviewScoreP2 = findViewById(R.id.scoreP2);
        textViewTotalChancep1 = findViewById(R.id.totalChanceP1);
        textViewTotalChancep2 = findViewById(R.id.totalChanceP2);

        textViewTotalChancep1.setText("10");
        textViewTotalChancep2.setText("10");
        p1 = 10;
        p2 = 10;

        Random random = new Random();


        textviewP1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                int randomNumber = random.nextInt(10 - 1) + 1;


                if (Integer.parseInt(textViewTotalChancep1.getText().toString()) == 0) {
                    Toasty.warning(MainActivity.this, "no chance to play").show();
                    winner();

                } else {
                    textViewAddScorep1.setText(String.valueOf(randomNumber));
                    result = Integer.parseInt(textviewScoreP1.getText().toString()) + randomNumber;
                    p1--;
                    textviewScoreP1.setText(String.valueOf(result));
                    textViewTotalChancep1.setText(String.valueOf(p1));
                }


            }


        });
        textViewP2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int randomNumber = random.nextInt(10 - 1) + 1;

                if (Integer.parseInt(textViewTotalChancep2.getText().toString()) == 0) {
                    Toasty.warning(MainActivity.this, "no chance to play").show();
                    winner();
                }
                else {
                    textViewAddScorep2.setText(String.valueOf(randomNumber));
                    result2 = Integer.parseInt(textviewScoreP2.getText().toString()) + randomNumber;
                    p2--;
                    textviewScoreP2.setText(String.valueOf(result2));

                    textViewTotalChancep2.setText(String.valueOf(p2));

                }

            }
        });


    }

    private void winner() {
        if (Integer.parseInt(textViewTotalChancep1.getText().toString()) == 0 && Integer.parseInt(textViewTotalChancep2.getText().toString()) == 0)
        {
            if(Integer.parseInt(textviewScoreP2.getText().toString())>Integer.parseInt(textviewScoreP1.getText().toString()))

            {
                Toasty.success(getApplicationContext(),"Player 2 won!").show();
            }
            else
            {
                Toasty.success(getApplicationContext(),"Player 1 won!").show();
            }
        }
    }
}