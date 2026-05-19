package fr.sdv.builder;

/**
 * Représente un allergène présent dans un produit(ex: "Gluten", "Lactose")
 */
public class Allergene {

    private String nom;
    private double qteMilligrammes;

    public Allergene(String nom, double qteMilligrammes) {
        this.nom = nom;
        this.qteMilligrammes = qteMilligrammes;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getQteMilligrammes() { return qteMilligrammes; }
    public void setQteMilligrammes(double qteMilligrammes) {
        this.qteMilligrammes = qteMilligrammes;
    }
}