package com.example.demo;

import java.util.ArrayList;

public class GestionTaches {

    private ArrayList<Tache> taches;

    public GestionTaches() {
        taches = new ArrayList<Tache>();
    }
    
    public void ajouterTache(String titre, String description) {
        // Vérifie si une tâche avec le même titre existe déjà
        if (!tacheExiste(titre)) {
            Tache tache = new Tache(titre, description);
            taches.add(tache);
        } else {
            // Gestion du cas où la tâche existe déjà
            throw new IllegalArgumentException("Une tâche avec le titre '" + titre + "' existe déjà.");
        }
    }
    
    // Méthode utilitaire pour vérifier si une tâche avec le même titre existe déjà
    private boolean tacheExiste(String titre) {
        for (Tache tache : taches) {
            if (tache.getTitre().equals(titre)) {
                return true; // La tâche existe déjà
            }
        }
        return false; // La tâche n'existe pas
    }

    public boolean completerTache(String titre) {
        Tache tache = getTache(titre);
        if(tache!=null) {
            tache.setCompleter(true);
            return true;
        }else{
            return false;
        }
    }

    public Tache getTache(String titre) {
        for (Tache tache : taches) {
            if (tache.getTitre().equals(titre)) {
                return tache;
            }
        }
        return null;
    }
    public Object verifierTache(String titre) {
        Tache tache = getTache(titre);

        if (tache != null) {
            return tache.getCompletee();
        } else {
            // Retourne quelque chose pour indiquer que la tâche n'existe pas
            return "Tâche inexistante";
        }
    }
    public ArrayList<Tache> getListeTaches() {
        return taches;
    }

}
