package com.example.demo;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculDureeTest {

    @Test
    public void testCalculerDureeTotaleAvecTachesPositives() {
        //Vérification calcul basique d'addition de 3 taches positives
        Projet projet = new Projet("Projet Test", new GestionTaches());
        ArrayList<Tache> taches = new ArrayList<>();
        taches.add(new Tache("Tâche1","Description1", 10));
        taches.add(new Tache("Tâche2","Description2", 5));
        taches.add(new Tache("Tâche3","Description3", 8));

        int resultat = projet.calculerDureeTotale(taches);

        assertEquals(23, resultat);
    }

    @Test
    public void testCalculerDureeTotaleAvecListeVide() {
        //Vérifie que la liste vide renvoie 0
        Projet projet = new Projet("Projet Test", new GestionTaches());
        ArrayList<Tache> taches = new ArrayList<>();

        int resultat = projet.calculerDureeTotale(taches);

        assertEquals(0, resultat);
    }

    @Test
    public void testCalculerDureeTotaleAvecTacheNegative() {
        //Vérifie l'exception de la tache négative
        Projet projet = new Projet("Projet Test", new GestionTaches());
        ArrayList<Tache> taches = new ArrayList<>();
        taches.add(new Tache("Tâche1","Description1", 10));
        taches.add(new Tache("Tâche2","Description2", -5));

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            projet.calculerDureeTotale(taches);
        });

        assertEquals("La durée de la tâche 'Tâche2' est négative.", exception.getMessage());
    }

    @Test
    public void testCalculerDureeTotaleAvecTacheNull() {
        //Vérifie l'exception de la tache null
        Projet projet = new Projet("Projet Test", new GestionTaches());
        ArrayList<Tache> taches = new ArrayList<>();
        taches.add(new Tache("Tâche1","Description1", 10));
        taches.add(null);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            projet.calculerDureeTotale(taches);
        });

        assertEquals("La liste de tâches contient une tâche null.", exception.getMessage());
    }
}
