package com.example.mini_jeu_calcul;
import java.util.Random;
import java.util.ArrayList;


public class SystemCalcul {
    private int ValeurMax = 100 ;
    private double Resultat;
    private ArrayList<Integer> TableauValeur = new ArrayList<>();
    ArrayList<String> TableauOperateur = new ArrayList<>();


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

    private void GenererTableauValeur (int Taille){
        for (int index = 0; index < Taille; index++)
        {
            TableauValeur.add(GenerateurAleatoire(ValeurMax));
        }
    }
    private void GenererTableauOperateur (int Taille){
        Taille--;
        for (int index = 0; index < Taille; index++)
        {
            TableauValeur.add(GenerateurAleatoire(ValeurMax));
        }
    }

    private String ConcatenerTableau() {
        StringBuilder builder = new StringBuilder(); // Utilisation d'un StringBuilder pour concaténer les chaînes de manière efficace

        // Parcours des tableaux de valeurs et d'opérateurs en alternance
        int indexValeur = 0;
        int indexOperateur = 0;
        boolean estPremierElement = true;

        while (indexValeur < TableauValeur.size() || indexOperateur < TableauOperateur.size()) {
            // Ajout de la valeur si elle existe
            if (indexValeur < TableauValeur.size()) {
                if (!estPremierElement) {
                    builder.append(" "); // Ajout d'un espace avant la valeur sauf si c'est le premier élément
                }
                builder.append(TableauValeur.get(indexValeur));
                indexValeur++;
                estPremierElement = false;
            }

            // Ajout de l'opérateur si il existe
            if (indexOperateur < TableauOperateur.size()) {
                builder.append(" ").append(TableauOperateur.get(indexOperateur));
                indexOperateur++;
                estPremierElement = false;
            }
        }

        return builder.toString(); // Retourner la chaîne concaténée
    }




    public double evaluerExpression(String expressionString) {

        return Resultat ;
    }


    public String GenererCalcul (int Taille)
    {
        String Calcul;

        GenererTableauValeur(Taille);
        GenerateurOperateur(Taille);
        Calcul = ConcatenerTableau();


        return Calcul;
    }

}
