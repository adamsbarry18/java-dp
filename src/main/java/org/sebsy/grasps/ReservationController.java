package org.sebsy.grasps;

import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.services.ReservationService;

public class ReservationController {

    private ReservationService reservationService =
            new ReservationService();

    public Reservation creerReservation(Params params) {

        return reservationService.creerReservation(params);
    }
}