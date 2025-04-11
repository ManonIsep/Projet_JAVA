package org.example;

public class Vol {
    private String numeroVol;
    private String origine;
    private String destination;
    private String dateHeureDepart;
    private String dateHeureArrivee;
    private Avion avion;  // L'avion affecté au vol

    public Vol(String numeroVol, String origine, String destination, String dateHeureDepart, String dateHeureArrivee) {
        this.numeroVol = numeroVol;
        this.origine = origine;
        this.destination = destination;
        this.dateHeureDepart = dateHeureDepart;
        this.dateHeureArrivee = dateHeureArrivee;

        // Validation des dates : la date d'arrivée doit être après la date de départ
        if (dateHeureArrivee.compareTo(dateHeureDepart) <= 0) {
            throw new IllegalArgumentException("La date d'arrivée doit être après la date de départ.");
        }
    }

    public void affecterVol(Avion avion) {
        this.avion = avion;  // Affecte l'avion à ce vol
    }

    public String getNumeroVol() {
        return numeroVol;
    }

    public Avion getAvion() {
        return avion;  // Retourne l'avion associé à ce vol
    }

    // Ajoutez cette méthode
    public String getDateHeureDepart() {
        return dateHeureDepart;
    }
    public String getDestination(){
        return destination;
    }

    @Override
    public String toString() {
        return "Vol [Numéro: " + numeroVol + ", Origine: " + origine + ", Destination: " + destination +
                ", Départ: " + dateHeureDepart + ", Arrivée: " + dateHeureArrivee + "]";
    }
}
