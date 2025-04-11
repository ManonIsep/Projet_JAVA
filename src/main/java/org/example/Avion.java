package org.example;

import java.util.List;

public class Avion {
    private String immatriculation;
    private String modele;
    private int capacite;

    public Avion(String immatriculation, String modele, int capacite) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.capacite = capacite;
    }

    public boolean verifierDisponibilite(String dateHeure) {
        // Logic to verify availability of the plane at a given time
        return true;
    }
}
