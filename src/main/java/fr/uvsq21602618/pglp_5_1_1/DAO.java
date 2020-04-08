package fr.uvsq21602618.pglp_5_1_1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * Classe abstraite de DataAccessObject.
 * @author Nathalie
 *
 * @param <T>
 */
public abstract class DAO<T> {
    /**
     * Méthode de création.
     * @param obj L'objet à créer
     * @return T
     * @throws IOException Exceptions liées aux entrées/sorties 
     */
    public abstract T create(T obj) throws IOException;
    /**
     * Méthode pour effacer.
     * @param obj L'objet à effacer
     * @return T
     */
    public abstract void delete(T obj);
    /**
     * Méthode de mise à jour.
     * @param obj L'objet à mettre à jour
     * @throws IOException Exception liee aux entrees/sorties
     */
    public abstract T update(T obj) throws IOException;
    /**
     * Méthode de recherche des informations.
     * @param id de l'information 
     * @return T
     * @throws FileNotFoundException Exception si le fichier n'existe pas
     * @throws IOException Exception liee aux entrees/sorties
     * @throws ClassNotFoundException Exception si la classe n'existe pas
     */
    public abstract T find(int id) throws FileNotFoundException, ClassNotFoundException, IOException;
    /**
     * Méthode de désérialisation.
     * @param bytes le tableau d'octets à transformer en objet.
     * @return L'objet obtenu.
     * @throws ClassNotFoundException Exception si la classe n'existe pas
     * @throws IOException Exception liee aux entrees/sorties
     */
    public Object deserialize(final byte[] bytes) throws ClassNotFoundException, IOException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        return o.readObject();
    }
    /**
     * Méthode de sérialisation.
     * @param obj L'objet à transformer en flux d'octets.
     * @return flux d'octets de l'objet.
     * @throws IOException Exception liee aux entrees/sorties
     */
    public byte[] serialize(final Object obj) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(obj);
        return b.toByteArray();
    }
}