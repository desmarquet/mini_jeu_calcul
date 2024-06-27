package com.example.mini_jeu_calcul;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class activityCalcul extends AppCompatActivity {

    private Button bouton0;
    private Button bouton1;
    private Button bouton2;
    private Button bouton3;
    private Button bouton4;
    private Button bouton5;
    private Button bouton6;
    private Button bouton7;
    private Button bouton8;
    private Button bouton9;
    private TextView textViewCalcul;
    private TextView textViewEntrer;

    private Integer premierTerme = 0;
    private Integer deuxiemeTerme = 0;
    private Integer resultat;

    private SystemCalcul SysCalcul = new SystemCalcul();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calcul);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bouton0 = findViewById(R.id.button0);
        bouton1 = findViewById(R.id.button1);
        bouton2 = findViewById(R.id.button_calcul);
        bouton3 = findViewById(R.id.button3);
        bouton4 = findViewById(R.id.button4);
        bouton5 = findViewById(R.id.button5);
        bouton6 = findViewById(R.id.button6);
        bouton7 = findViewById(R.id.button7);
        bouton8 = findViewById(R.id.button8);
        bouton9 = findViewById(R.id.button9);
        textViewCalcul = findViewById(R.id.textview_entrer);
        textViewEntrer = findViewById(R.id.textview_calcul);

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

    }
    //private TypeOperation typeOperation;

    private void appuieBoutonChiffre(Button bouton) {
        ajouterCaractere(bouton);
    }

    private void ajouterCaractere(Button bouton) {
        // TODO AJOUTER LE CARACTERE DANS LE TEXTVIEW
        textViewCalcul.setText(String.format("%s%s", textViewCalcul.getText().toString(), bouton.getText().toString()));
    }

    /*private void verifCalcul{

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.monmenu, menu);
        //MenuItem boutonScore = menu.findItem(R.id.bouton_score);
        MenuItem boutonReset = menu.findItem(R.id.bouton_reset);
        MenuItem boutonCalculer = menu.findItem(R.id.bouton_calculer);
        // JE RAJOUTE UN ITEM DANS MON MENU QUI AFFICHE UN TOAST QUAND JE CLIQUE DESSUS
        // IL AURA COMME CONTENU "CALCULER"

        boutonReset.setOnMenuItemClickListener(menuItem -> {
            textViewCalcul.setText("");
            textViewEntrer.setText("");
            premierTerme = 0;
            deuxiemeTerme = 0;
            //typeOperation = null;
            resultat = 0;
            return true;
        });
        boutonCalculer.setOnMenuItemClickListener(menuItem -> {
            if(SysCalcul.TestReponse(Integer.parseInt(textViewEntrer.getText().toString()) ))
            {
                boutonReset();
                SysCalcul.GenererCalcul(2);
                textViewCalcul.setText(SysCalcul.GetCalcul());
                return true;
            }
            else
                return false;
        });
        return super.onCreateOptionsMenu(menu);
    };

}