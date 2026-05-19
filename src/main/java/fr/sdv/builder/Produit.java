package fr.sdv.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Représente un produit
 */
public class Produit {

    private String nom;
    private String grade;
    private Categorie categorie;
    private Marque marque;
    private List<Additif> additifs = new ArrayList<>();
    private List<Ingredient> ingredients = new ArrayList<>();
    private List<Allergene> allergenes = new ArrayList<>();


    private Produit() {}

    // --- Getters ---

    public String getNom() { return nom; }
    public String getGrade() { return grade; }
    public Categorie getCategorie() { return categorie; }
    public Marque getMarque() { return marque; }
    public List<Additif> getAdditifs() { return additifs; }
    public List<Ingredient> getIngredients() { return ingredients; }
    public List<Allergene> getAllergenes() { return allergenes; }

    // Pattern Builder : classe interne statique
    public static class ProduitBuilder {

        private Produit produit;

        // constructeur
        public ProduitBuilder() {
            this.produit = new Produit();
        }

        /**
         * Définit le nom du produit.
         *
         * @param nom nom du produit
         * @return this (pour le chaînage fluent)
         */
        public ProduitBuilder withNom(String nom) {
            this.produit.nom = nom;
            return this;
        }

        /**
         * Définit le grade Nutriscore du produit (A, B, C, D, E).
         *
         * @param grade grade nutriscore
         * @return this (pour le chaînage fluent)
         */
        public ProduitBuilder withGrade(String grade) {
            this.produit.grade = grade;
            return this;
        }

        /**
         * Définit la catégorie du produit.
         * Le Builder crée lui-même l'instance de Categorie
         *
         * @param nomCategorie nom de la catégorie
         * @return this (pour le chaînage fluent)
         */
        public ProduitBuilder withCategorie(String nomCategorie) {
            this.produit.categorie = new Categorie(nomCategorie);
            return this;
        }

        /**
         * Définit la marque du produit.
         *
         * @param nomMarque nom de la marque
         * @return this (pour le chaînage fluent)
         */
        public ProduitBuilder withMarque(String nomMarque) {
            this.produit.marque = new Marque(nomMarque);
            return this;
        }

        /**
         * Ajoute un ingrédient au produit.
         *
         * @param nom             nom de l'ingrédient
         * @param qteMilligrammes quantité en milligrammes
         * @return this (pour le chaînage fluent)
         */
        public ProduitBuilder withIngredient(String nom, double qteMilligrammes) {
            this.produit.ingredients.add(new Ingredient(nom, qteMilligrammes));
            return this;
        }

        /**
         * Ajoute un additif au produit.
         *
         * @param nom             nom de l'additif
         * @param qteMilligrammes quantité en milligrammes
         * @return this (pour le chaînage fluent)
         */
        public ProduitBuilder withAdditif(String nom, double qteMilligrammes) {
            this.produit.additifs.add(new Additif(nom, qteMilligrammes));
            return this;
        }

        /**
         * Ajoute un allergène au produit.
         *
         * @param nom             nom de l'allergène
         * @param qteMilligrammes quantité en milligrammes
         * @return this (pour le chaînage fluent)
         */
        public ProduitBuilder withAllergene(String nom, double qteMilligrammes) {
            this.produit.allergenes.add(new Allergene(nom, qteMilligrammes));
            return this;
        }

        /**
         * Finalise la construction et retourne le Produit construit.
         *
         * @return Produit construit
         * @throws IllegalStateException si un champ obligatoire est manquant
         */
        public Produit build() {
            if (this.produit.nom == null || this.produit.nom.isEmpty()) {
                throw new IllegalStateException("Le nom du produit est obligatoire.");
            }
            if (this.produit.categorie == null) {
                throw new IllegalStateException("La catégorie du produit est obligatoire.");
            }
            if (this.produit.marque == null) {
                throw new IllegalStateException("La marque du produit est obligatoire.");
            }
            return this.produit;
        }
    }
}
