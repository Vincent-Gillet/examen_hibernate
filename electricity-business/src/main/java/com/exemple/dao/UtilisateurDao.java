package com.exemple.dao;

import org.hibernate.SessionFactory;

import com.exemple.model.Utilisateur;

/**
 * DAO pour la gestion des entités Utilisateur.
 * 
 * Hérite des opérations CRUD génériques de GenericDaoImpl.
 * 
 * @author Vincent
 * @version 1.0
 */

public class UtilisateurDao extends GenericDaoImpl<Utilisateur, Long> {
    public UtilisateurDao (SessionFactory sessionFactory) {
        super(sessionFactory, Utilisateur.class);
    }
}