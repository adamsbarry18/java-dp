package org.sebsy.strategy;

/**
 * Factory responsable de retourner la bonne stratégie de tri.
 */
public class StrategyFactory {

    public static Strategy getStrategy(TypeTri typeTri) {

        switch (typeTri) {

            case BUBBLE:
                return new BubbleSortStrategy();

            case INSERTION:
                return new InsertionSortStrategy();

            case SELECTION:
                return new SelectionSortStrategy();

            default:
                throw new IllegalArgumentException("Type de tri inconnu");
        }
    }
}
