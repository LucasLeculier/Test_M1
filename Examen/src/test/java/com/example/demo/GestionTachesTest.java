package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GestionTachesTest {

    @Test
    public void testAjouterTache() {
        //On crée une gestion tache, on met une tache et on vérifie qu'on en a bien qu'une
        GestionTaches gestionProjet = new GestionTaches();
        gestionProjet.ajouterTache("Tâche 1", "Description de la tâche 1");

        assertEquals(1, gestionProjet.getListeTaches().size());
    }

    @Test
    public void testCompleterTacheExistante() {
        //On crée une gestion tache, on met une tache, on la complète et on vérifie qu'elle est bien complétée
        GestionTaches gestionProjet = new GestionTaches();
        gestionProjet.ajouterTache("Tâche existante", "Description de la tâche");

        assertTrue(gestionProjet.completerTache("Tâche existante"));
        assertTrue((boolean) gestionProjet.verifierTache("Tâche existante"));
    }

    @Test
    public void testCompleterTacheInexistante() {
        //On crée une gestion tache, on complète une tache inexistante et on vérifie qu'elle n'est pas complétée
        GestionTaches gestionProjet = new GestionTaches();

        assertFalse(gestionProjet.completerTache("Tâche inexistante"));
    }

    @Test
    public void testVerifierTacheExistante() {
        //On crée une gestion tache, on met une tache, on vérifie qu'elle n'est pas complétée
        GestionTaches gestionProjet = new GestionTaches();
        gestionProjet.ajouterTache("Tâche existante", "Description de la tâche");

        assertFalse((boolean) gestionProjet.verifierTache("Tâche existante"));
    }

    @Test
    public void testVerifierTacheInexistante() {
        GestionTaches gestionProjet = new GestionTaches();
        //on vérifie que le cas où l'on vérifie une tache qui n'existe pas renvoie bien "Tâche inexistante"

        assertEquals("Tâche inexistante", gestionProjet.verifierTache("Tâche inexistante"));
    }
}
