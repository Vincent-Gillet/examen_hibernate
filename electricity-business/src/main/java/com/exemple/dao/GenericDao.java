package com.exemple.dao;

import java.util.List;

/**
 * Interface permettant de définir les méthodes CRUD essentiel 
 * à la gestion première des Entités.
 * 
 * @param <T>  le type de l'entité
 * @param <ID> le type de l'identifiant de l'entité
 *  
 * @author Vincent
 * @version 1.0
 */

public interface GenericDao<T, ID> {
    void creer(T entity);
    T lire(ID id);
    List<T> tout();
    void mettreAJour(T entity);
    void supprimer(ID id);
}
