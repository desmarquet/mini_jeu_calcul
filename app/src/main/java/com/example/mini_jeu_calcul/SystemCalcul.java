package com.example.mini_jeu_calcul;

import java.util.Random;
import java.util.ArrayList;


public class SystemCalcul {
    private String Calcul ;
    private final int ValeurMax = 100 ;
    private double Resultat;
    private ArrayList<Double> TableauValeur = new ArrayList<>();
    private ArrayList<String> TableauOperateur = new ArrayList<>();

    private ArrayList<Double> TableauValeurTemp = new ArrayList<>();
    private ArrayList<String> TableauOperateurTemp = new ArrayList<>();


    private double GenerateurAleatoire(int Max) {
        Random random = new Random();
        int valeurAleatoire = random.nextInt(Max); // Génère un nombre aléatoire entre 0 (inclus) et Max (exclus)
        double valeurDouble = (double) valeurAleatoire; // Convertit l'int en double
        return valeurDouble;
    }
    private String GenerateurOperateur ()
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
            TableauOperateur.add(GenerateurOperateur());
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

    private void UpdateTabTemp(int index , double ResTemp) {
        TableauValeurTemp.set(index,ResTemp);
        TableauValeurTemp.remove(index+1);
        TableauOperateurTemp.remove(index);
    }


    private void CalculerResultat(int Taille) {
        Resultat = 0;
        double ResTemp ;
        TableauValeurTemp = TableauValeur;
        TableauOperateurTemp = TableauOperateur;
        for (int index = 0; index < Taille-1; index++)
        {
            switch (TableauOperateurTemp.get(index)) {
                case "*":
                    ResTemp =TableauValeurTemp.get(index) * TableauValeurTemp.get(index+1);
                    Resultat = Resultat +  ResTemp;
                    UpdateTabTemp(index, ResTemp);
                    break;
                case "/":
                    ResTemp =TableauValeurTemp.get(index) / TableauValeurTemp.get(index+1);
                    Resultat = Resultat + ResTemp;
                    UpdateTabTemp(index, ResTemp);
                    break;
                default:
                    break;
            }
        }
        Taille = TableauValeurTemp.size();
        for (int index = 0; index < Taille-1; index++)
        {
            switch (TableauOperateurTemp.get(index)) {
                case "+":
                    ResTemp =TableauValeurTemp.get(index) + TableauValeurTemp.get(index+1);
                    Resultat = Resultat + ResTemp;
                    UpdateTabTemp(index, ResTemp);
                    break;
                case "-":
                    ResTemp =TableauValeurTemp.get(index) /-TableauValeurTemp.get(index+1);
                    Resultat = Resultat + ResTemp;
                    UpdateTabTemp(index, ResTemp);
                    break;
                default:
                    break;
            }
        }
    }

    public void GenererCalcul (int Taille)
    {

        GenererTableauValeur(Taille);
        GenererTableauOperateur(Taille);
        Calcul = ConcatenerTableau();
        CalculerResultat(Taille);
    }

public boolean TestReponse (double Reponse)
{
        if (Reponse == Resultat){
            return true;
        }else {
            return false;
        }
}

public String GetCalcul()
{
        return Calcul;
}



}
