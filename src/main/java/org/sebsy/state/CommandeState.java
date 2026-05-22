package org.sebsy.state;

import fr.sdv.builder.Produit;

public interface CommandeState {

    void ajouterProduit(Commande commande, Produit p);

    void payer(Commande commande);

    void livrer(Commande commande, String adresse);

    void annuler(Commande commande);
}
