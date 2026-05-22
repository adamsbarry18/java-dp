package org.sebsy.strategy;

/**
 * Classe responsable de l'exécution d'un tri.
 */
public class Tri {

    public void exec(TypeTri typeTri, Integer[] arr) {

        Strategy strategy = StrategyFactory.getStrategy(typeTri);

        strategy.trier(arr);
    }
}