package fr.sdv.builder;

/**
 * Représente la marque d'un produit (ex: "Nestlé", "Danone").
 */
public class Marque {

    private String nom;

    public Marque(String nom) {
        this.nom = nom;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}
