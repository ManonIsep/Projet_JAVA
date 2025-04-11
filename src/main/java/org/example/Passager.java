package org.example;
import java.util.ArrayList;
import java.util.List;

public class Passager extends Personne {
    private String passport;
    private List<Reservation> reservations;

    public Passager(String identifiant, String nom, String adresse, String contact, String passport) {
        super(identifiant, nom, adresse, contact);
        this.passport = passport;
        this.reservations = new ArrayList<>(); // Initialisation de la liste
    }

    public void reserverVol(Vol vol) {
        Reservation reservation = new Reservation(this, vol);
        reservations.add(reservation); // Maintenant, la liste est initialisée, donc cela ne causera plus de NullPointerException
    }

    public void annulerReservation(String numeroReservation) {
        reservations.removeIf(r -> r.getNumeroReservation().equals(numeroReservation));
    }

    public List<Reservation> obtenirReservations() {
        return reservations;
    }

    @Override
    public String obtenirRole() {
        return "Passager";
    }
}
