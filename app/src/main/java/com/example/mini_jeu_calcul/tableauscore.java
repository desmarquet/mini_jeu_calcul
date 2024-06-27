package com.example.mini_jeu_calcul;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tableauscore extends AppCompatActivity {
    private TextView textViewTop1, textViewTop2, textViewTop3;
    private TableauScores tableauScores;

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

        tableauScores = new TableauScores(this); // Initialisation de la classe TableauScores

        // Récupération des meilleurs scores et affichage dans les TextViews
        afficherMeilleursScores();
    }

    // Méthode pour afficher les meilleurs scores dans les TextViews
    private void afficherMeilleursScores() {
        // Récupérer les 3 meilleurs scores
        // Si le tableau n'a pas encore 3 scores (par exemple au premier lancement de l'application),
        // il pourrait renvoyer null pour certaines valeurs. Dans ce cas, vérifiez et affichez correctement.
        Integer score1 = tableauScores.getTopScores().size() > 0 ? tableauScores.getTopScores().get(0) : null;
        Integer score2 = tableauScores.getTopScores().size() > 1 ? tableauScores.getTopScores().get(1) : null;
        Integer score3 = tableauScores.getTopScores().size() > 2 ? tableauScores.getTopScores().get(2) : null;

        // Affichage des scores dans les TextViews
        if (score1 != null) {
            textViewTop1.setText(String.valueOf(score1));
        }
        if (score2 != null) {
            textViewTop2.setText(String.valueOf(score2));
        }
        if (score3 != null) {
            textViewTop3.setText(String.valueOf(score3));
        }
    }
}