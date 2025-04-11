package org.example;

import java.util.UUID;

public class Reservation {
    private String numeroReservation;
    private Passager passager;
    private Vol vol;

    public Reservation(Passager passager, Vol vol) {
        this.passager = passager;
        this.vol = vol;
        this.numeroReservation = "R" + UUID.randomUUID().toString(); // Utilisation de UUID pour générer un identifiant unique
    }

    public String getNumeroReservation() {
        return numeroReservation;
    }

    public Vol getVol() {
        return vol;
    }

    public Passager getPassager() {
        return passager;
    }

    // Setter pour modifier le vol d'une réservation
    public void setVol(Vol vol) {
        this.vol = vol;
    }

    @Override
    public String toString() {
        return "Réservation [Numéro: " + numeroReservation + ", Passager: " + passager.getNom() + ", Vol: " + vol.getNumeroVol() + "]";
    }
}
