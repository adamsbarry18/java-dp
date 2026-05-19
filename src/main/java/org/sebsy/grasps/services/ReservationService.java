package org.sebsy.grasps.services;

import org.sebsy.grasps.Params;
import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;
import org.sebsy.grasps.daos.ClientDao;
import org.sebsy.grasps.daos.TypeReservationDao;
import org.sebsy.grasps.factories.ReservationFactory;
import org.sebsy.grasps.utils.DateUtils;

import java.time.LocalDateTime;

/**
 * Service métier responsable de la gestion des réservations :
 * récupération des données, calcul du montant
 * et orchestration des traitements.
 */
public class ReservationService {

    private ClientDao clientDao = new ClientDao();
    private TypeReservationDao typeReservationDao = new TypeReservationDao();
    private ReservationFactory reservationFactory = new ReservationFactory();

    public Reservation creerReservation(String identifiantClient,
                                        String dateReservationStr,
                                        String typeReservationStr,
                                        int nbPlaces) {

        LocalDateTime dateReservation = DateUtils.toDate(dateReservationStr);
        Client client = clientDao.extraireClient(identifiantClient);
        TypeReservation type = typeReservationDao.extraireTypeReservation(typeReservationStr);

        Reservation reservation = reservationFactory.create(dateReservation, nbPlaces, client);

        client.addReservation(reservation);

        reservation.calculerTotal(type);

        return reservation;
    }
}