package com.example.mini_jeu_calcul;


import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.appcompat.app.AppCompatActivity;


public class activityCalcul extends AppCompatActivity {

    private Button bouton0, bouton1, bouton2, bouton3, bouton4, bouton5, bouton6, bouton7, bouton8, bouton9;
    private TextView textViewCalcul, textViewEntrer, textClock; // Ajout de textClock
    private Integer score = 0;
    private SystemCalcul SysCalcul = new SystemCalcul();
    private CountDownTimer countDownTimer; // Déclaration du CountDownTimer

    private TableauScores TabScores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcul);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main),(v, insets)-> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            textViewCalcul.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setContentView(R.layout.activity_calcul);


        bouton0 = findViewById(R.id.button0);
        bouton1 = findViewById(R.id.button1);
        bouton2 = findViewById(R.id.button2);
        bouton3 = findViewById(R.id.button3);
        bouton4 = findViewById(R.id.button4);
        bouton5 = findViewById(R.id.button5);
        bouton6 = findViewById(R.id.button6);
        bouton7 = findViewById(R.id.button7);
        bouton8 = findViewById(R.id.button8);
        bouton9 = findViewById(R.id.button9);
        textViewCalcul = findViewById(R.id.textview_calcul);
        textViewEntrer = findViewById(R.id.textview_entrer);
        textClock = findViewById(R.id.textClock); // Initialisation de textClock

        TabScores = new TableauScores(this); // Initialisation de TableauScores avec le contexte


        bouton0.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton1.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton2.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton3.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton4.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton5.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton6.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton7.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton8.setOnClickListener(view -> appuieBoutonChiffre((Button) view));
        bouton9.setOnClickListener(view -> appuieBoutonChiffre((Button) view));

        SysCalcul.GenererCalcul(2);
        textViewCalcul.setText(SysCalcul.GetCalcul());

        // Démarrage du chronomètre
        startTimer();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                // Mise à jour du TextView à chaque seconde
                textClock.setText(String.valueOf(millisUntilFinished / 1000));
            }

            public void onFinish() {
                // Actions à effectuer lorsque le chronomètre atteint zéro
                textClock.setText("0");
                Toast.makeText(activityCalcul.this, "Temps écoulé !", Toast.LENGTH_SHORT).show();
                // Ici vous pouvez ajouter des actions supplémentaires lorsque le temps est écoulé
            }
        };

        countDownTimer.start(); // Démarrage du chronomètre
    }

    private void appuieBoutonChiffre(Button bouton) {
        ajouterCaractere(bouton);
    }

    private void ajouterCaractere(Button bouton) {
        textViewEntrer.setText(String.format("%s%s", textViewEntrer.getText().toString(), bouton.getText().toString()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.monmenu, menu);
        MenuItem boutonReset = menu.findItem(R.id.bouton_reset);
        MenuItem boutonCalculer = menu.findItem(R.id.bouton_calculer);

        boutonReset.setOnMenuItemClickListener(menuItem -> {
            textViewCalcul.setText("");

            textViewEntrer.setText("");
            return true;
        });

        boutonCalculer.setOnMenuItemClickListener(menuItem -> {
            if (SysCalcul.TestReponse(Double.parseDouble(textViewEntrer.getText().toString()))) {
                SysCalcul.GenererCalcul(2);
                textViewCalcul.setText(SysCalcul.GetCalcul());
                score++;
                return true;
            } else {
                TabScores.addScore(score);
                score = 0;
                startTimer();
                SysCalcul.GenererCalcul(2);
                textViewCalcul.setText(SysCalcul.GetCalcul());
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
