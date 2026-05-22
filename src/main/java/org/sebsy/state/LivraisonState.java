package org.sebsy.state;

import fr.sdv.builder.Produit;

public class LivraisonState implements CommandeState {

    @Override
    public void ajouterProduit(Commande commande, Produit p) {
        System.out.println("Impossible : commande en livraison");
    }

    @Override
    public void payer(Commande commande) {
        System.out.println("Impossible : déjà payée");
    }

    @Override
    public void livrer(Commande commande, String adresse) {
        System.out.println("Déjà en livraison vers : " + commande.getAdresse());
    }

    @Override
    public void annuler(Commande commande) {
        System.out.println("Erreur : commande en livraison, annulation impossible");
    }
}
