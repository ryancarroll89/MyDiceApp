package com.example.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imgDice1 = findViewById(R.id.imgDice1);
        ImageView imgDice2 = findViewById(R.id.imgDice2);

        int[] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        int myBox = 10;
        float myFloatBox = 4.2f;
        double myDoubleBox = 3.34578923;

        ArrayList<Integer> valsList = new ArrayList<Integer>();
        Integer d = new Integer(1);
        valsList.remove(d);

        HashMap<Integer, Integer> valsMap = new HashMap<Integer, Integer>();
        valsMap.get(1);


        MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);

        Button btnRollTheDice = findViewById(R.id.btnRollTheDice);

        btnRollTheDice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("MyDiceApp", "btnRoll was tapped");
                Random randObj = new Random();

                imgDice1.setImageResource(diceImages[randObj.nextInt(6)]);
                imgDice2.setImageResource(diceImages[randObj.nextInt(6)]);

                YoYo.with(Techniques.Shake)
                        .duration(500)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice1));

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(findViewById(R.id.imgDice2));

                mp.start();
            }
        });
    }
}