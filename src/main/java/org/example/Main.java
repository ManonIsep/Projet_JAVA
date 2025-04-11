package org.example;

public class Main {
    public static void main(String[] args) {
        // Création des objets de test
        Passager passager = new Passager("001", "Dupont", "Paris", "0123456789", "12345");
        Avion avion = new Avion("A123", "Boeing 747", 300);
        Vol vol = new Vol("V123", "Paris", "New York", "2025-05-01 14:00", "2025-05-01 16:00");

        // Réserver un vol
        passager.reserverVol(vol);

        // Afficher les informations du passager
        passager.obtenirInfos();
    }
}
