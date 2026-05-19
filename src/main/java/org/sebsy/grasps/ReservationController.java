package org.sebsy.grasps;

import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.services.ReservationService;

/**
 * Contrôleur responsable de la réception des demandes de création de réservation.
 */
public class ReservationController {

    private ReservationService reservationService = new ReservationService();

    public Reservation creerReservation(Params params) {
        return reservationService.creerReservation(
                params.getIdentifiantClient(),
                params.getDateReservation(),
                params.getTypeReservation(),
                params.getNbPlaces()
        );
    }
}