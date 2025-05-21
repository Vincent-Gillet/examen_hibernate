package com.exemple.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exemple.model.Reservation;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 * DAO pour la gestion des entités Reservation.
 * 
 * Elle comprend également une méthode pour les tier en 
 * fonction de leur date de départ.
 * 
 * Hérite des opérations CRUD génériques de GenericDaoImpl.
 * 
 * @author Vincent
 * @version 1.0
 */

public class ReservationDao extends GenericDaoImpl<Reservation, Long> {
    public ReservationDao (SessionFactory sessionFactory) {
        super(sessionFactory, Reservation.class);
    }

    // 2. 📅 Lister toutes les réservations faites par un utilisateur donné, triées par date.
    public List<Reservation> triParDate(Long id) {
        try (Session s = sessionFactory.openSession()) {
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<Reservation> cq = cb.createQuery(Reservation.class);
            Root<Reservation> root = cq.from(Reservation.class);
            cq.select(root)
                .where(cb.equal(root.get("utilisateur").get("id"), id))
                .orderBy(cb.desc(root.get("dateDebut"))); 
            return s.createQuery(cq).getResultList();
        }
    }
    
}