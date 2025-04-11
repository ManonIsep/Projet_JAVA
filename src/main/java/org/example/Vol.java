package org.example;

import java.util.List;

public class Vol {
    private String numeroVol;
    private String origine;
    private String destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private List<Passager> passagers;
    private Avion avion;

    public Vol(String numeroVol, String origine, String destination, String dateHeureDepart, String dateHeureArrivee) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;
    }

    public void affecterVol(Avion avion) {
        this.avion = avion;
    }

    public void annulerVol() {
        // Logic to cancel the flight
    }

    public void planifierVol() {
        // Logic to plan the flight
    }
}
