package org.sebsy.state;

import fr.sdv.builder.Produit;

import java.util.ArrayList;
import java.util.List;

public class Commande {

    private CommandeState etat;

    private List<Produit> produits = new ArrayList<>();
    private String adresse;
    private double total;

    // états
    public final CommandeState CREATION = new CreationState();
    public final CommandeState PAIEMENT = new PaiementState();
    public final CommandeState EN_LIVRAISON = new LivraisonState();
    public final CommandeState ANNULEE = new AnnuleeState();

    public Commande() {
        this.etat = CREATION;
    }

    // --- delegation State ---
    public void ajouterProduit(Produit p) {
        etat.ajouterProduit(this, p);
    }

    public void payer() {
        etat.payer(this);
    }

    public void livrer(String adresse) {
        etat.livrer(this, adresse);
    }

    public void annuler() {
        etat.annuler(this);
    }

    void addProduitInternal(Produit p) {
        produits.add(p);
    }

    int getNombreProduits() {
        return produits.size();
    }

    double calculTotal() {
        return produits.size() * 0.5;
    }

    void setEtat(CommandeState etat) {
        this.etat = etat;
    }

    CommandeState getCREATION() { return CREATION; }
    CommandeState getPAIEMENT() { return PAIEMENT; }
    CommandeState getEN_LIVRAISON() { return EN_LIVRAISON; }
    CommandeState getANNULEE() { return ANNULEE; }

    void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresse() {
        return adresse;
    }

    void setTotal(double total) {
        this.total = total;
    }

    public double getTotal() {
        return total;
    }
}
