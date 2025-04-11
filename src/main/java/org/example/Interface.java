package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Interface {
    private Passager passager;
    private Vol vol1;
    private Vol vol2;

    private JTextArea reservationsArea;
    private JComboBox<String> volSelector;
    private JTextField nomField, adresseField, contactField, passeportField;
    private JTextField annulationField;

    public Interface() {
        // Création de vols et d'un avion
        Avion avion = new Avion("A123", "Boeing 747", 300);
        vol1 = new Vol("V123", "Paris", "New York", "2025-05-01 14:00", "2025-05-01 16:00");
        vol2 = new Vol("V124", "Paris", "Tokyo", "2025-06-01 10:00", "2025-06-01 12:00");
        vol1.affecterVol(avion);
        vol2.affecterVol(avion);

        // Fenêtre principale
        JFrame frame = new JFrame("Compagnie Aérienne - Réservation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        // Onglets
        JTabbedPane tabbedPane = new JTabbedPane();

        // === Onglet 1 : Créer un passager ===
        JPanel creationPanel = new JPanel(new GridLayout(6, 2));
        nomField = new JTextField();
        adresseField = new JTextField();
        contactField = new JTextField();
        passeportField = new JTextField();
        JButton createButton = new JButton("Créer le passager");

        creationPanel.add(new JLabel("Nom :"));
        creationPanel.add(nomField);
        creationPanel.add(new JLabel("Adresse :"));
        creationPanel.add(adresseField);
        creationPanel.add(new JLabel("Contact :"));
        creationPanel.add(contactField);
        creationPanel.add(new JLabel("Passeport :"));
        creationPanel.add(passeportField);
        creationPanel.add(new JLabel());
        creationPanel.add(createButton);

        createButton.addActionListener(e -> {
            if (nomField.getText().isEmpty() || passeportField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs.");
                return;
            }
            passager = new Passager("001", nomField.getText(), adresseField.getText(), contactField.getText(), passeportField.getText());
            JOptionPane.showMessageDialog(frame, "Passager créé avec succès !");
        });

        // === Onglet 2 : Réserver un vol ===
        JPanel reservationPanel = new JPanel(new BorderLayout());
        volSelector = new JComboBox<>(new String[]{"Vol Paris-New York", "Vol Paris-Tokyo"});
        JButton reserverButton = new JButton("Réserver");

        reservationPanel.add(volSelector, BorderLayout.CENTER);
        reservationPanel.add(reserverButton, BorderLayout.SOUTH);

        reserverButton.addActionListener(e -> {
            if (passager == null) {
                JOptionPane.showMessageDialog(frame, "Veuillez créer un passager d'abord.");
                return;
            }
            if (volSelector.getSelectedIndex() == 0) {
                passager.reserverVol(vol1);
            } else {
                passager.reserverVol(vol2);
            }
            JOptionPane.showMessageDialog(frame, "Réservation réussie !");
            afficherReservations();  // Mettre à jour l'affichage des réservations
        });

        // === Onglet 3 : Afficher & annuler réservations ===
        JPanel affichagePanel = new JPanel(new BorderLayout());
        reservationsArea = new JTextArea();
        reservationsArea.setEditable(false);
        annulationField = new JTextField();
        JButton annulerButton = new JButton("Annuler réservation");

        JPanel annulationPanel = new JPanel(new GridLayout(2, 1));
        annulationPanel.add(new JLabel("Numéro de réservation à annuler :"));
        annulationPanel.add(annulationField);

        affichagePanel.add(new JScrollPane(reservationsArea), BorderLayout.CENTER);
        affichagePanel.add(annulationPanel, BorderLayout.SOUTH);
        affichagePanel.add(annulerButton, BorderLayout.NORTH);

        annulerButton.addActionListener(e -> {
            if (passager != null) {
                passager.annulerReservation(annulationField.getText());
                afficherReservations();
            }
        });

        // Ajout des onglets
        tabbedPane.addTab("Créer un passager", creationPanel);
        tabbedPane.addTab("Réserver un vol", reservationPanel);
        tabbedPane.addTab("Mes réservations", affichagePanel);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }

    private void afficherReservations() {
        if (passager != null) {
            List<Reservation> reservations = passager.obtenirReservations();
            StringBuilder sb = new StringBuilder("Réservations du passager :\n");
            for (Reservation r : reservations) {
                sb.append("- ID: ").append(r.getNumeroReservation())
                        .append(" | Vol: ").append(r.getVol().getNumeroVol())
                        .append(" | Destination: ").append(r.getVol().getDestination())
                        .append(" | Date de départ: ").append(r.getVol().getDateHeureDepart())
                        .append("\n");
            }
            reservationsArea.setText(sb.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Interface::new);
    }
}
