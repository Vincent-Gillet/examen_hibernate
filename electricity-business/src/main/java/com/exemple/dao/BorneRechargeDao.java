package com.exemple.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.exemple.model.BorneRecharge;
import com.exemple.model.EtatBorne;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

/**
 * DAO pour la gestion des entités BorneRecharge.
 * 
 * Elle comprend également une méthode pour rechercher les 
 * bornes qui ont un tarif supérieure à un montant choisi. 
 * Mais également une méthode pour les tier en fonction 
 * de leur état.
 * 
 * Hérite des opérations CRUD génériques de GenericDaoImpl.
 * 
 * @author Vincent
 * @version 1.0
 */

public class BorneRechargeDao extends GenericDaoImpl<BorneRecharge, Long> {
    public BorneRechargeDao (SessionFactory sessionFactory) {
        super(sessionFactory, BorneRecharge.class);
    }


    // 1. 🔍 Rechercher toutes les bornes disponibles pour un créneau horaire donné (non déjà réservées à ce moment).


    // 4. 🧾 Rechercher les bornes dont le tarif horaire dépasse une certaine valeur.
    public List<BorneRecharge> tarifSperieurA(double tarifHoraire) {
        try (Session s = sessionFactory.openSession()) {
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<BorneRecharge> cq = cb.createQuery(BorneRecharge.class);
            Root<BorneRecharge> root = cq.from(BorneRecharge.class);
            cq.select(root)
                .where(cb.gt(root.get("tarifHoraire"), tarifHoraire))
                .orderBy(cb.desc(root.get("tarifHoraire"))); 
            return s.createQuery(cq).getResultList();
        }
    }

    // 5. 🛠️ Trouver les bornes actuellement en maintenance ou inactives (filtrage sur l'état).
    public List<BorneRecharge> triParEtat(EtatBorne etat) {
        try (Session s = sessionFactory.openSession()) {
            CriteriaBuilder cb = s.getCriteriaBuilder();
            CriteriaQuery<BorneRecharge> cq = cb.createQuery(BorneRecharge.class);
            Root<BorneRecharge> root = cq.from(BorneRecharge.class);
            cq.select(root)
                .where(cb.equal(root.get("etat"), etat));
            return s.createQuery(cq).getResultList();
        }
    }
}
