package com.exemple.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Classe abstraite qui implémente les opérations CRUD de base
 * définies dans GenericDao en utilisant Hibernate.
 * 
 * Elle permet de centraliser la logique commune à tous les DAO
 * et de réduire la duplication de code.
 * 
 * @param <T>  le type de l'entité
 * @param <ID> le type de l'identifiant de l'entité
 *  
 * @author Vincent
 * @version 1.0
 */

public abstract class GenericDaoImpl<T, ID> implements GenericDao<T, ID> {
    protected final SessionFactory sessionFactory;
    private final Class<T> entityClass;

    public GenericDaoImpl(SessionFactory sessionFactory, Class<T> entityClass) {
        this.entityClass = entityClass;
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void creer(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(entity);
            session.getTransaction().commit();
        }
    }

    @Override
    public T lire(ID id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(entityClass, id);
        }
    }

    @Override
    public List<T> tout() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM " + entityClass.getName();
            return session.createQuery(hql, entityClass).getResultList();
        }
    }

    @Override
    public void mettreAJour(T entity) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(entity); 
            session.getTransaction().commit();
        }
    }

    @Override
    public void supprimer(ID id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            T entity = session.get(entityClass, id);
            if (entity != null) {
                session.remove(entity);
            }
            session.getTransaction().commit();
        }
    }

}
