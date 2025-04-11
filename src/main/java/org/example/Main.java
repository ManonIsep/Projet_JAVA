package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Passager passager = null;
        Vol vol1 = new Vol("V123", "Paris", "New York", "2025-05-01 14:00", "2025-05-01 16:00");
        Vol vol2 = new Vol("V124", "Paris", "Tokyo", "2025-06-01 10:00", "2025-06-01 12:00");

        Avion avion = new Avion("A123", "Boeing 747", 300);
        vol1.affecterVol(avion);
        vol2.affecterVol(avion);

        // Menu principal
        while (true) {
            System.out.println("=== Système de gestion de compagnie aérienne ===");
            System.out.println("1. Créer un passager");
            System.out.println("2. Réserver un vol");
            System.out.println("3. Modifier une réservation");
            System.out.println("4. Annuler une réservation");
            System.out.println("5. Afficher les réservations");
            System.out.println("6. Quitter");
            System.out.print("Choisissez une option (1-6) : ");

            // Lecture de l'option choisie par l'utilisateur
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consomme la ligne vide restante après nextInt()

            switch (choix) {
                case 1:
                    // Créer un passager
                    System.out.print("Entrez le nom du passager : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez l'adresse du passager : ");
                    String adresse = scanner.nextLine();
                    System.out.print("Entrez le contact du passager : ");
                    String contact = scanner.nextLine();
                    System.out.print("Entrez le numéro de passeport du passager : ");
                    String passport = scanner.nextLine();
                    passager = new Passager("001", nom, adresse, contact, passport);
                    System.out.println("Passager créé avec succès !");
                    break;

                case 2:
                    // Réserver un vol
                    if (passager == null) {
                        System.out.println("Veuillez créer un passager d'abord.");
                    } else {
                        System.out.println("Choisissez un vol :");
                        System.out.println("1. Vol Paris-New York");
                        System.out.println("2. Vol Paris-Tokyo");
                        System.out.print("Votre choix (1 ou 2) : ");
                        int volChoisi = scanner.nextInt();
                        scanner.nextLine();  // Consomme la ligne vide après nextInt()

                        if (volChoisi == 1) {
                            passager.reserverVol(vol1);
                            System.out.println("Réservation réussie pour le vol Paris-New York !");
                        } else if (volChoisi == 2) {
                            passager.reserverVol(vol2);
                            System.out.println("Réservation réussie pour le vol Paris-Tokyo !");
                        } else {
                            System.out.println("Choix invalide.");
                        }
                    }
                    break;

                case 3:
                    // Modifier une réservation
                    if (passager == null || passager.obtenirReservations().isEmpty()) {
                        System.out.println("Aucune réservation trouvée pour ce passager.");
                    } else {
                        System.out.print("Entrez le numéro de réservation à modifier : ");
                        String numeroReservation = scanner.nextLine();

                        // Demander à l'utilisateur de choisir un nouveau vol
                        System.out.println("Choisissez un nouveau vol :");
                        System.out.println("1. Vol Paris-New York");
                        System.out.println("2. Vol Paris-Tokyo");
                        System.out.print("Votre choix (1 ou 2) : ");
                        int volChoisi = scanner.nextInt();
                        scanner.nextLine();  // Consomme la ligne vide après nextInt()

                        Vol volChoisiPourModification = (volChoisi == 1) ? vol1 : vol2;
                        passager.modifierReservation(numeroReservation, volChoisiPourModification); // Modification de la réservation
                    }
                    break;

                case 4:
                    // Annuler une réservation
                    if (passager == null || passager.obtenirReservations().isEmpty()) {
                        System.out.println("Aucune réservation à annuler.");
                    } else {
                        System.out.print("Entrez le numéro de réservation à annuler : ");
                        String numeroReservation = scanner.nextLine();
                        passager.annulerReservation(numeroReservation); // Annulation de la réservation
                    }
                    break;

                case 5:
                    // Afficher les réservations
                    if (passager == null || passager.obtenirReservations().isEmpty()) {
                        System.out.println("Aucune réservation disponible.");
                    } else {
                        System.out.println("Réservations :");
                        for (Reservation reservation : passager.obtenirReservations()) {
                            System.out.println("Numéro de réservation : " + reservation.getNumeroReservation());
                            System.out.println("Vol réservé : " + reservation.getVol().getNumeroVol());
                        }
                    }
                    break;

                case 6:
                    // Quitter
                    System.out.println("Merci d'avoir utilisé le système de gestion des vols !");
                    scanner.close();
                    return;

                default:
                    System.out.println("Choix invalide. Essayez à nouveau.");
            }
        }
    }
}
