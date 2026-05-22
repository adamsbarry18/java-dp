package org.sebsy.state;

import fr.sdv.builder.Produit;

public class CreationState implements CommandeState {

    @Override
    public void ajouterProduit(Commande commande, Produit p) {
        commande.addProduitInternal(p);
        System.out.println("Produit ajouté");
    }

    @Override
    public void payer(Commande commande) {
        commande.setTotal(commande.calculTotal());
        commande.setEtat(commande.getPAIEMENT());
        System.out.println("Commande payée : " + commande.getTotal());
    }

    @Override
    public void livrer(Commande commande, String adresse) {
        System.out.println("Erreur : commande non payée");
    }

    @Override
    public void annuler(Commande commande) {
        commande.setEtat(commande.getANNULEE());
        System.out.println("Commande annulée");
    }
}
