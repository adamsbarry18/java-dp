package org.sebsy.state;

import fr.sdv.builder.Produit;

public class DemoCommande {

    public static void main(String[] args) {

        Commande commande = new Commande();
        Produit p1 = new Produit.ProduitBuilder().withNom("Clavier").build();
        Produit p2 = new Produit.ProduitBuilder().withNom("Souris").build();
        Produit p3 = new Produit.ProduitBuilder().withNom("Écran").build();

        // ÉTAT : CREATION
        System.out.println("\n--- CREATION ---");
        commande.ajouterProduit(p1);
        commande.ajouterProduit(p2);

        // Passage à PAIEMENT
        System.out.println("\n--- PAIEMENT ---");
        commande.payer();

        // Tentative ajout produit après paiement (doit être refusé)
        commande.ajouterProduit(p3);

        // Passage à LIVRAISON
        System.out.println("\n--- LIVRAISON ---");
        commande.livrer("Paris, 10 rue de Rivoli");

        // Tentative annulation après livraison (doit échouer)
        System.out.println("\n--- ANNULATION ---");
        commande.annuler();

        // Tentative actions après annulation/livraison
        commande.payer();
    }
}
