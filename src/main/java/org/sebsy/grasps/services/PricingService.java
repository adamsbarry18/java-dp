package org.sebsy.grasps.services;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.TypeReservation;

public class PricingService {

    public double calculerTotal(
            Client client,
            TypeReservation type,
            int nbPlaces
    ) {

        double total = type.getMontant() * nbPlaces;

        if (client.isPremium()) {

            return total *
                    (1 - type.getReductionPourcent() / 100.0);
        }

        return total;
    }
}
