package org.sebsy.grasps.factories;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;

import java.time.LocalDateTime;

/**
 * Factory responsable de la création des objets Reservation.
 */
public class ReservationFactory {

    public Reservation create(
            LocalDateTime dateReservation,
            int nbPlaces,
            Client client
    ) {

        Reservation reservation =
                new Reservation(dateReservation);

        reservation.setNbPlaces(nbPlaces);
        reservation.setClient(client);

        return reservation;
    }
}
