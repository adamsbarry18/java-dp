package fr.sdv.factory.beans;

import fr.sdv.factory.enums.Unite;

public abstract class Element {

    private String nom;
    private double valeur;
    private Unite unite;

    /**
     * Constructeur
     *
     * @param nom    nom de l'élément
     * @param valeur quantité présente dans le produit
     * @param unite  unité de mesure
     */
    public Element(String nom, double valeur, Unite unite) {
        this.nom = nom;
        this.valeur = valeur;
        this.unite = unite;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getValeur() { return valeur; }
    public void setValeur(double valeur) { this.valeur = valeur; }

    public Unite getUnite() { return unite; }
    public void setUnite(Unite unite) { this.unite = unite; }
}
