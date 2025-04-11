package org.example;

public class Employé extends Personne {
    private String numeroEmploye;
    private String dateEmbauche;

    public Employé(String identifiant, String nom, String adresse, String contact, String numeroEmploye, String dateEmbauche) {
        super(identifiant, nom, adresse, contact);
        this.numeroEmploye = numeroEmploye;
        this.dateEmbauche = dateEmbauche;
    }

    @Override
    public String obtenirRole() {
        return "Employé";
    }
}
