package com.example.mini_jeu_calcul;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    private Button buttonCalcul;

    private TextView monTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonCalcul = findViewById(R.id.button_calcul);


        buttonCalcul.setOnClickListener(view -> {
            Toast.makeText(this, "j'affiche un toast", Toast.LENGTH_SHORT).show();
            monTextView.setText(getString(R.string.text_mon_textview));
            Intent intent = new Intent(this, activityCalcul.class);
            startActivity(intent);

        });
    }

}