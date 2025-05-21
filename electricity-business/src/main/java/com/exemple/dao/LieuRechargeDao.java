package com.exemple.dao;

import org.hibernate.SessionFactory;

import com.exemple.model.LieuRecharge;

/**
 * DAO pour la gestion des entités LieuRecharge.
 * 
 * Hérite des opérations CRUD génériques de GenericDaoImpl.
 * 
 * @author Vincent
 * @version 1.0
 */

public class LieuRechargeDao extends GenericDaoImpl<LieuRecharge, Long> {
    public LieuRechargeDao (SessionFactory sessionFactory) {
        super(sessionFactory, LieuRecharge.class);
    }
}