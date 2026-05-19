package org.sebsy.grasps.factories;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;

import java.time.LocalDateTime;

/**
 * Factory responsable de la création des objets Reservation.
 */
public class ReservationFactory {

    /**
     * Construit et retourne une instance de Reservation.
     *
     * @param date      date de la réservation
     * @param nbPlaces  nombre de places réservées
     * @param client    client associé à la réservation
     * @return Reservation construite
     */
    public Reservation create(LocalDateTime date, int nbPlaces, Client client) {
        Reservation reservation = new Reservation(date);
        reservation.setNbPlaces(nbPlaces);
        reservation.setClient(client);
        return reservation;
    }
}
