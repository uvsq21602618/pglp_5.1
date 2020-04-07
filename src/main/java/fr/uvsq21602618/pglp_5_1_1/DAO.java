package fr.uvsq21602618.pglp_5_1_1;

import java.sql.Connection;

public abstract class DAO<T> {
    /**
     * La source de la base de données.
     */
    protected Connection connect = null;
    /**
     * Constructeur de la classe abstraite DAO.
     * @param conn La source de la base de données
     *
    public DAO(Connection conn){
        this.connect = conn;
    }
    */
    /**
     * Méthode de création.
     * @param obj L'objet à créer
     * @return T
     */
    public abstract T create(T obj);
    /**
     * Méthode pour effacer.
     * @param obj L'objet à effacer
     * @return T
     */
    public abstract void delete(T obj);
    /**
     * Méthode de mise à jour.
     * @param obj L'objet à mettre à jour
     */
    public abstract T update(T obj);
    /**
     * Méthode de recherche des informations.
     * @param id de l'information 
     * @return T
     */
    public abstract T find(int id);
}