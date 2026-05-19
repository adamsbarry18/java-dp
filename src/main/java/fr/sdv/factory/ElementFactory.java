package fr.sdv.factory;

import fr.sdv.factory.beans.Additif;
import fr.sdv.factory.beans.Allergene;
import fr.sdv.factory.beans.Element;
import fr.sdv.factory.beans.Ingredient;
import fr.sdv.factory.enums.TypeElement;
import fr.sdv.factory.enums.Unite;

public class ElementFactory {

    /**
     * Crée et retourne une instance de Element en fonction du type demandé.
     *
     * @param type   type d'élément à créer (enum TypeElement)
     * @param nom    nom de l'élément
     * @param valeur quantité présente dans le produit
     * @param unite  unité de mesure
     * @return une instance concrète de Element
     * @throws IllegalArgumentException si le type est inconnu
     */
    public Element createElement(TypeElement type,
                                 String nom,
                                 double valeur,
                                 Unite unite) {
        switch (type) {
            case INGREDIENT:
                return new Ingredient(nom, valeur, unite);
            case ADDITIF:
                return new Additif(nom, valeur, unite);
            case ALLERGENE:
                return new Allergene(nom, valeur, unite);
            default:
                throw new IllegalArgumentException("Type d'élément inconnu : " + type);
        }
    }
}