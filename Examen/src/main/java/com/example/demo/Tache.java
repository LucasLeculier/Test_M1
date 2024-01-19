package com.example.demo;

public class Tache {
    private String titre;
    private String description;
    private boolean completee;
    private Integer temps;

    public Tache(String titre, String description) {
        this.titre = titre;
        this.description = description;
        this.completee = false;
    }
    public Tache(String titre, String description, Integer temps) {
        this.titre = titre;
        this.description = description;
        this.completee = false;
        this.temps = temps;
    }

    public void setCompleter(boolean b) {
        this.completee = b;
    }

    public String getTitre() {
        return titre;
    }
    public boolean getCompletee() {
        return completee;
    }
    public int getTemps() {
        return temps;
    }
    @Override
    public String toString() {
        return "Tache{" +
                "titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", completee=" + completee +
                ", temps=" + temps +
                '}';
    }
    
    
}
