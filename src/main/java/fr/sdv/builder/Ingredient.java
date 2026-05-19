package fr.sdv.builder;


/**
 * Représente un ingrédient présent dans un produit(ex: "Farine de blé", "Sucre")
 */
public class Ingredient {

    private String nom;
    private double qteMilligrammes;

    public Ingredient(String nom, double qteMilligrammes) {
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
