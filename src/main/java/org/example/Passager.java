package org.example;

import java.util.ArrayList;
import java.util.List;

public class Passager extends Personne {
    private String passport;
    private List<Reservation> reservations;

    public Passager(String identifiant, String nom, String adresse, String contact, String passport) {
        super(identifiant, nom, adresse, contact);
        this.passport = passport;
        this.reservations = new ArrayList<>();
    }

    // Réserver un vol : Ajouter une réservation pour ce passager
    public void reserverVol(Vol vol) {
        Reservation reservation = new Reservation(this, vol);
        reservations.add(reservation); // Ajoute la réservation à la liste
        // Affiche le numéro de réservation
        System.out.println("Réservation réussie ! Numéro de réservation : " + reservation.getNumeroReservation());
    }


    // Annuler une réservation : Supprimer la réservation avec le numéro donné
    public boolean annulerReservation(String numeroReservation) {
        for (Reservation reservation : reservations) {
            if (reservation.getNumeroReservation().equals(numeroReservation)) {
                reservations.remove(reservation);
                return true; // Réservation annulée
            }
        }
        return false; // Réservation non trouvée
    }

    // Modifier une réservation : Mettre à jour un vol pour une réservation donnée
    public void modifierReservation(String numeroReservation, Vol nouveauVol) {
        for (Reservation reservation : reservations) {
            if (reservation.getNumeroReservation().equals(numeroReservation)) {
                reservation.setVol(nouveauVol); // Met à jour le vol
                System.out.println("Réservation modifiée avec succès !");
                return;
            }
        }
        System.out.println("Réservation non trouvée !");
    }

    // Obtenir toutes les réservations du passager
    public List<Reservation> obtenirReservations() {
        return reservations;
    }

    @Override
    public String obtenirRole() {
        return "Passager";
    }

    @Override
    public String toString() {
        return "Passager [Nom=" + super.getNom() + ", Passport=" + passport + "]";
    }
}
