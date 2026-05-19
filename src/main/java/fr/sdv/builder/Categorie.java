package fr.sdv.builder;

/**
 * Représente la catégorie d'un produit (ex: "Biscuit", "Boisson").
 */
public class Categorie {

    private String nom;

    public Categorie(String nom) {
        this.nom = nom;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}
