package org.sebsy.state;

import fr.sdv.builder.Produit;

public class AnnuleeState implements CommandeState {

    @Override
    public void ajouterProduit(Commande commande, Produit p) {
        System.out.println("Erreur : commande déjà annulée");
    }

    @Override
    public void payer(Commande commande) {
        System.out.println("Erreur : commande déjà annulée");
    }

    @Override
    public void livrer(Commande commande, String adresse) {
        System.out.println("Erreur : commande déjà annulée");
    }

    @Override
    public void annuler(Commande commande) {
        System.out.println("Erreur : commande déjà annulée");
    }
}
