package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Projet {

    private String nom;
    private GestionTaches gestionTaches;
    private ArrayList<String> listeTaches;

    public Projet(String nom, GestionTaches gestionTaches) {
        this.nom = nom;
        this.gestionTaches = gestionTaches;
        this.listeTaches = new ArrayList<>();
    }

    public void ajouterTacheAuProjet(String titre, String description) {
        // Vérifie si une tâche avec le même titre existe déjà dans le projet
        if (!tacheExisteDansProjet(titre)) {
            gestionTaches.ajouterTache(titre, description);
            listeTaches.add(titre);
        } else {
            // Gestion du cas où la tâche existe déjà dans le projet
            throw new IllegalArgumentException("Une tâche avec le titre '" + titre + "' existe déjà dans le projet.");
        }
    }
    
    // Méthode utilitaire pour vérifier si une tâche avec le même titre existe déjà dans le projet
    private boolean tacheExisteDansProjet(String titre) {
        return listeTaches.contains(titre);
    }
    

    public ArrayList<String> getListeTaches() {
        return listeTaches;
    }

    public int calculerDureeTotale(ArrayList<Tache> taches) {
        if (taches == null || taches.isEmpty()) {
            // Retourne 0 si la liste de tâches est vide ou null
            return 0;
        }

        int dureeTotale = 0;
        for (Tache tache : taches) {
            if (tache != null) {
                int tempsTache = tache.getTemps();

                // Vérifie que la durée de la tâche n'est pas négative
                if (tempsTache >= 0) {
                    dureeTotale += tempsTache;
                } else {
                    // Gestion du cas où la durée de la tâche est négative
                    throw new IllegalArgumentException("La durée de la tâche '" + tache.getTitre() + "' est négative.");
                }
            } else {
                // Gestion du cas où une tâche est null dans la liste
                throw new IllegalArgumentException("La liste de tâches contient une tâche null.");
            }
        }
        return dureeTotale;
    }

   
}
