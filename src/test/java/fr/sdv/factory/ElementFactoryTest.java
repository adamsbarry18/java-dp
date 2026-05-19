package fr.sdv.factory;

import fr.sdv.factory.beans.Additif;
import fr.sdv.factory.beans.Allergene;
import fr.sdv.factory.beans.Element;
import fr.sdv.factory.beans.Ingredient;
import fr.sdv.factory.enums.TypeElement;
import fr.sdv.factory.enums.Unite;
import junit.framework.TestCase;
import org.junit.Test;

public class ElementFactoryTest extends TestCase {

    private ElementFactory factory = new ElementFactory();

    // Tests sur le type retourné
    @Test
    public void testCreerIngredient() {
        Element element = factory.createElement(
                TypeElement.INGREDIENT, "Farine", 50.0, Unite.MILLI_GRAMMES
        );
        // La Factory doit retourner une instance de Ingredient
        assertTrue("Doit être une instance de Ingredient",
                element instanceof Ingredient);
    }

    @Test
    public void testCreerAdditif() {
        Element element = factory.createElement(
                TypeElement.ADDITIF, "E150", 2.5, Unite.MICRO_GRAMMES
        );
        // La Factory doit retourner une instance de Additif
        assertTrue("Doit être une instance de Additif",
                element instanceof Additif);
    }

    @Test
    public void testCreerAllergene() {
        Element element = factory.createElement(
                TypeElement.ALLERGENE, "Gluten", 10.0, Unite.MILLI_GRAMMES
        );
        // La Factory doit retourner une instance de Allergene
        assertTrue("Doit être une instance de Allergene",
                element instanceof Allergene);
    }

    // Tests sur les données de l'objet créé
    @Test
    public void testIngredientNom() {
        Element element = factory.createElement(
                TypeElement.INGREDIENT, "Sucre", 30.0, Unite.MILLI_GRAMMES
        );
        assertEquals("Sucre", element.getNom());
    }

    @Test
    public void testIngredientValeur() {
        Element element = factory.createElement(
                TypeElement.INGREDIENT, "Sucre", 30.0, Unite.MILLI_GRAMMES
        );
        assertEquals(30.0, element.getValeur(), 0.0000001);
    }

    @Test
    public void testIngredientUnite() {
        Element element = factory.createElement(
                TypeElement.INGREDIENT, "Sucre", 30.0, Unite.MILLI_GRAMMES
        );
        assertEquals(Unite.MILLI_GRAMMES, element.getUnite());
    }

    @Test
    public void testAdditifUnite() {
        Element element = factory.createElement(
                TypeElement.ADDITIF, "E150", 2.5, Unite.MICRO_GRAMMES
        );
        assertEquals(Unite.MICRO_GRAMMES, element.getUnite());
    }

    // Test sur le type retourné (abstraction)
    @Test
    public void testRetourneElement() {
        // Le code client reçoit un Element (abstraction),
        // pas une classe concrète — c'est l'intérêt du pattern Factory.
        Element element = factory.createElement(
                TypeElement.INGREDIENT, "Sel", 5.0, Unite.MILLI_GRAMMES
        );
        assertNotNull("La Factory ne doit pas retourner null", element);
    }
}
