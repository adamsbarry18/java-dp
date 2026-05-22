package org.sebsy.state;

import fr.sdv.builder.Produit;

public class PaiementState implements CommandeState {

    @Override
    public void ajouterProduit(Commande commande, Produit p) {
        System.out.println("Erreur : commande déjà en paiement");
    }

    @Override
    public void payer(Commande commande) {
        System.out.println("Déjà payée");
    }

    @Override
    public void livrer(Commande commande, String adresse) {
        commande.setAdresse(adresse);
        commande.setEtat(commande.getEN_LIVRAISON());
        System.out.println("Commande en livraison vers : " + adresse);
    }

    @Override
    public void annuler(Commande commande) {
        commande.setEtat(commande.getANNULEE());
        System.out.println("Commande annulée après paiement");
    }
}
