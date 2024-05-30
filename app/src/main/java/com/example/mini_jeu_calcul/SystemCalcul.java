package com.example.mini_jeu_calcul;
import java.util.Random;
import java.util.ArrayList;

public class SystemCalcul {
    private int ValeurMax ;
    private float Resultat;
    private int GenerateurAleatoire (int Max)
    {
        {
            Random random = new Random();
            return random.nextInt(Max);
        }
    }
    private String GenerateurOperateur (int Max)
    {
        // Définir les opérateurs disponibles
        char[] operateurs = {'+', '-', '*', '/'};

        // Générateur de nombres aléatoires
        Random random = new Random();

        // Sélection d'un opérateur aléatoire
        int randomIndex = random.nextInt(operateurs.length);

        // Retourner l'opérateur sélectionné sous forme de chaîne
        return String.valueOf(operateurs[randomIndex]);
    }

    public String GenererCalcul (int Taille)
    {
        String Calcul = "dqsd" ;
        ArrayList<Integer> TableauValeur = new ArrayList<>();
        for (int indexVal = 0; indexVal < Taille; indexVal++)
        {
            TableauValeur.add(GenerateurAleatoire(ValeurMax));
        }
        ArrayList<Integer> TableauOpérateur = new ArrayList<>();
        for (int indexOp = 0; indexOp < Taille; indexOp++)
        {
            TableauValeur.add(GenerateurAleatoire(ValeurMax));
        }

        return Calcul;
    }

}
