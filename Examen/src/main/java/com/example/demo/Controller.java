package com.example.demo;

public class Controller {
    private GestionTaches gestionTaches;

    public Controller(GestionTaches gestionTaches) {
        this.gestionTaches = gestionTaches;
    }

    public String afficherListeTaches() {
        return gestionTaches.getListeTaches().toString();
    }

    public String afficherTacheParNom(String nom) {
        if(gestionTaches.getTache(nom) == null){
            return "Tâche inexistante";
        }
        return gestionTaches.getTache(nom).toString();
    }
}
