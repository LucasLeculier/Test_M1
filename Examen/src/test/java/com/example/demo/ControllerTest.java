package com.example.demo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ControllerTest {

    private GestionTaches gestionTaches;
    private Controller controller;

    @BeforeEach
    public void setUp() {
        // Initialisation de GestionTaches avec Mockito pour simuler le comportement
        gestionTaches = mock(GestionTaches.class);

        // Initialisation du Controller avec la GestionTaches simulée
        controller = new Controller(gestionTaches);
    }

    @Test
    public void testAfficherListeTaches() {
        // Configuration du comportement simulé pour getListeTaches
        when(gestionTaches.getListeTaches())
                .thenReturn(new ArrayList<>(Arrays.asList(new Tache("Tâche 1", "Description de la tâche 1", 10),
                        new Tache("Tâche 2", "Description de la tâche 2", 20))));
        // Exécution de la méthode à tester
        String result = controller.afficherListeTaches();

        // Vérification des résultats attendus
        assertEquals("[Tache{titre='Tâche 1', description='Description de la tâche 1', completee=false, temps=10}, Tache{titre='Tâche 2', description='Description de la tâche 2', completee=false, temps=20}]", result);
    }

    @Test
    public void testAfficherTacheParNom() {
        // Configuration du comportement simulé pour getTache
        when(gestionTaches.getTache("Tâche existante"))
                .thenReturn(new Tache("Tâche existante", "Description de la tâche", 10));

        // Exécution de la méthode à tester
        String result = controller.afficherTacheParNom("Tâche existante");

        // Vérification des résultats attendus
        assertEquals("Tache{titre='Tâche existante', description='Description de la tâche', completee=false, temps=10}", result);
    }

    @Test
    public void testAfficherTacheParNomTacheInexistante() {
        // Configuration du comportement simulé pour getTache (tâche inexistante)
        when(gestionTaches.getTache("Tâche inexistante")).thenReturn(null);

        // Exécution de la méthode à tester
        String result = controller.afficherTacheParNom("Tâche inexistante");

        // Vérification des résultats attendus
        assertEquals("Tâche inexistante", result);
    }
}
