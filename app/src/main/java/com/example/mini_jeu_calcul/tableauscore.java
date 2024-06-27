package com.example.mini_jeu_calcul;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.IllegalFormatCodePointException;

public class tableauscore extends AppCompatActivity{
    private TextView textViewTop1,textViewTop2,textViewTop3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tableau_score);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textViewTop1 = findViewById(R.id.textViewTop1);
        textViewTop2 = findViewById(R.id.textViewTop2);
        textViewTop3 = findViewById(R.id.textViewTop3);

        /*if (SysCalcul.Getscore1() == null){
            textViewTop1.setText(SysCalcul.Getscore1());
            textViewTop2.setText(SysCalcul.Getscore2());
            textViewTop3.setText(SysCalcul.Getscore3());
        }*/

    }

}
