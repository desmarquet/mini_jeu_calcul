package com.example.mini_jeu_calcul;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableauScores {
    private static final String SHARED_PREFS_FILE = "scores_prefs";
    private static final String SCORES_KEY = "scores";
    private static final int MAX_SCORES_COUNT = 3; // Nombre maximum de meilleurs scores à conserver

    private SharedPreferences sharedPreferences;
    private List<Integer> scoresList;

    public TableauScores(Context context) {
        sharedPreferences = context.getSharedPreferences(SHARED_PREFS_FILE, Context.MODE_PRIVATE);
        scoresList = loadScores();
    }

    // Charge la liste des scores depuis SharedPreferences
    private List<Integer> loadScores() {
        List<Integer> scores = new ArrayList<>();
        String scoresJson = sharedPreferences.getString(SCORES_KEY, null);
        if (scoresJson != null && !scoresJson.isEmpty()) {
            String[] scoreArray = scoresJson.split(",");
            for (String scoreStr : scoreArray) {
                scores.add(Integer.parseInt(scoreStr));
            }
        }
        return scores;
    }

    // Sauvegarde la liste des scores dans SharedPreferences
    private void saveScores() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        StringBuilder scoresJson = new StringBuilder();
        for (int i = 0; i < scoresList.size(); i++) {
            scoresJson.append(scoresList.get(i));
            if (i < scoresList.size() - 1) {
                scoresJson.append(",");
            }
        }
        editor.putString(SCORES_KEY, scoresJson.toString());
        editor.apply();
    }

    // Ajoute un nouveau score à la liste et met à jour les meilleurs scores si nécessaire
    public void addScore(int newScore) {
        scoresList.add(newScore);
        Collections.sort(scoresList, Collections.reverseOrder()); // Tri décroissant
        while (scoresList.size() > MAX_SCORES_COUNT) {
            scoresList.remove(scoresList.size() - 1); // Supprime le score le moins élevé s'il y en a plus de 3
        }
        saveScores(); // Sauvegarde la liste mise à jour
    }

    // Récupère la liste des 3 meilleurs scores
    public List<Integer> getTopScores() {
        return scoresList;
    }
}