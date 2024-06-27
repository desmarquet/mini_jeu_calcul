package com.example.mini_jeu_calcul;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView monTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonCalcul = findViewById(R.id.button_calcul); // Corrected ID
        Button buttonHighscore = findViewById(R.id.button_highscore); // Corrected ID
        monTextView = findViewById(R.id.titre); // Initialized TextView

        buttonCalcul.setOnClickListener(view -> {
            Toast.makeText(this, "j'affiche un toast", Toast.LENGTH_SHORT).show();
            monTextView.setText(getString(R.string.text_mon_textview));
            Intent intent = new Intent(this, activityCalcul.class);
            startActivity(intent);
        });

        buttonHighscore.setOnClickListener(view -> {
            Toast.makeText(this, "j'affiche un toast", Toast.LENGTH_SHORT).show();
            monTextView.setText(getString(R.string.text_mon_textview));
            Intent intent = new Intent(this, tableauscore.class);
            startActivity(intent);
        });
    }
}