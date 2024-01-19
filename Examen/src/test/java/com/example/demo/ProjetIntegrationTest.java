package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class ProjetIntegrationTest {

    @Test
    public void testAjouterTacheAuProjet() {
        // Création d'un mock pour la classe GestionTaches
        GestionTaches gestionTachesMock = Mockito.mock(GestionTaches.class);

        // Création d'un projet avec le mock de GestionTaches
        Projet projet = new Projet("Projet Test", gestionTachesMock);

        // Ajout d'une tâche au projet
        projet.ajouterTacheAuProjet("Tâche Test", "Description de la tâche");

        // Vérification que la méthode ajouterTache de GestionTaches a été appelée avec les bons arguments
        Mockito.verify(gestionTachesMock, Mockito.times(1)).ajouterTache("Tâche Test", "Description de la tâche");
    }

    @Test
    public void testMiseAJourTachesDansGestionTaches() {
        // Création d'un double (mock) pour la classe GestionTaches
        GestionTaches gestionTachesMock = Mockito.mock(GestionTaches.class);

        // Création d'un projet avec le mock de GestionTaches
        Projet projet = new Projet("Projet Test", gestionTachesMock);

        // Ajout de tâches au projet
        projet.ajouterTacheAuProjet("Tâche 1", "Description de la tâche 1");
        projet.ajouterTacheAuProjet("Tâche 2", "Description de la tâche 2");

        // Vérification que les méthodes ajouterTache de GestionTaches ont été appelées avec les bons arguments
        Mockito.verify(gestionTachesMock, Mockito.times(1)).ajouterTache("Tâche 1", "Description de la tâche 1");
        Mockito.verify(gestionTachesMock, Mockito.times(1)).ajouterTache("Tâche 2", "Description de la tâche 2");

        // Vérification que la liste des tâches dans le projet correspond à celles ajoutées
        assertEquals(Arrays.asList("Tâche 1", "Tâche 2"), projet.getListeTaches());
    }
}
