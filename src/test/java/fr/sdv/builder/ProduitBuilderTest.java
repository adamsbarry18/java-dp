package fr.sdv.builder;

import junit.framework.TestCase;
import org.junit.Test;

public class ProduitBuilderTest extends TestCase {

    private static final double DELTA = 0.0000001;

    // Cas nominal : produit complet avec tous les champs
    @Test
    public void testCasNominalProduitComplet() {
        Produit produit = new Produit.ProduitBuilder()
                .withNom("Oreo")
                .withGrade("C")
                .withCategorie("Biscuit")
                .withMarque("Nabisco")
                .withIngredient("Farine de blé", 50.0)
                .withIngredient("Sucre", 30.0)
                .withAdditif("E150", 2.5)
                .withAllergene("Gluten", 50.0)
                .withAllergene("Lait", 10.0)
                .build();

        // Vérification des champs simples
        assertEquals("Oreo", produit.getNom());
        assertEquals("C", produit.getGrade());
        assertEquals("Biscuit", produit.getCategorie().getNom());
        assertEquals("Nabisco", produit.getMarque().getNom());

        // Vérification des listes
        assertEquals(2, produit.getIngredients().size());
        assertEquals(1, produit.getAdditifs().size());
        assertEquals(2, produit.getAllergenes().size());
    }

    @Test
    public void testIngredientNomEtQuantite() {
        Produit produit = new Produit.ProduitBuilder()
                .withNom("Oreo")
                .withCategorie("Biscuit")
                .withMarque("Nabisco")
                .withIngredient("Farine de blé", 50.0)
                .build();

        assertEquals("Farine de blé", produit.getIngredients().get(0).getNom());
        assertEquals(50.0, produit.getIngredients().get(0).getQteMilligrammes(), DELTA);
    }

    @Test
    public void testAdditifNomEtQuantite() {
        Produit produit = new Produit.ProduitBuilder()
                .withNom("Coca-Cola")
                .withCategorie("Boisson")
                .withMarque("Coca-Cola Company")
                .withAdditif("E150d", 1.5)
                .build();

        assertEquals("E150d", produit.getAdditifs().get(0).getNom());
        assertEquals(1.5, produit.getAdditifs().get(0).getQteMilligrammes(), DELTA);
    }

    @Test
    public void testAllergeneNomEtQuantite() {
        Produit produit = new Produit.ProduitBuilder()
                .withNom("Pain de mie")
                .withCategorie("Pain")
                .withMarque("Harry's")
                .withAllergene("Gluten", 100.0)
                .build();

        assertEquals("Gluten", produit.getAllergenes().get(0).getNom());
        assertEquals(100.0, produit.getAllergenes().get(0).getQteMilligrammes(), DELTA);
    }

    // Cas alternatif : produit sans champs optionnels
    @Test
    public void testProduitSansAdditifNiAllergene() {
        Produit produit = new Produit.ProduitBuilder()
                .withNom("Eau minérale")
                .withGrade("A")
                .withCategorie("Boisson")
                .withMarque("Evian")
                .build();

        assertEquals("Eau minérale", produit.getNom());
        assertTrue("La liste d'additifs doit être vide",
                produit.getAdditifs().isEmpty());
        assertTrue("La liste d'allergènes doit être vide",
                produit.getAllergenes().isEmpty());
        assertTrue("La liste d'ingrédients doit être vide",
                produit.getIngredients().isEmpty());
    }

    @Test
    public void testProduitSansGrade() {
        Produit produit = new Produit.ProduitBuilder()
                .withNom("Sel")
                .withCategorie("Condiment")
                .withMarque("La Baleine")
                .build();

        assertNull("Le grade doit être null si non renseigné",
                produit.getGrade());
    }

    @Test
    public void testPlusieursIngredients() {
        Produit produit = new Produit.ProduitBuilder()
                .withNom("Cake")
                .withCategorie("Pâtisserie")
                .withMarque("Bonne Maman")
                .withIngredient("Farine", 80.0)
                .withIngredient("Sucre", 40.0)
                .withIngredient("Beurre", 30.0)
                .build();

        assertEquals(3, produit.getIngredients().size());
    }

    // Cas alternatifs : validation des champs obligatoires
    @Test
    public void testBuildSansNomLeveException() {
        try {
            new Produit.ProduitBuilder()
                    .withCategorie("Biscuit")
                    .withMarque("Nabisco")
                    .build();
            fail("Doit lever une IllegalStateException si nom absent");
        } catch (IllegalStateException e) {
            // Comportement attendu
            assertTrue(e.getMessage().contains("nom"));
        }
    }

    /*
    @Test
    public void testBuildSansCategorieLeveException() {
        try {
            new Produit.ProduitBuilder()
                    .withNom("Oreo")
                    .withMarque("Nabisco")
                    .build();
            fail("Doit lever une IllegalStateException si catégorie absente");
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().contains("catégorie"));
        }
    }

    @Test
    public void testBuildSansMarqueLeveException() {
        try {
            new Produit.ProduitBuilder()
                    .withNom("Oreo")
                    .withCategorie("Biscuit")
                    .build();
            fail("Doit lever une IllegalStateException si marque absente");
        } catch (IllegalStateException e) {
            assertTrue(e.getMessage().contains("marque"));
        }
    }*/
}
