package fr.uvsq21602618.pglp_5_1_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Classe PersonnelDAO.
 * @author Nathalie
 *
 */
public class PersonnelDAO extends DAO<Personnel>{
    /**
     * Constructeur de PersonnelDAO.
     * @throws IOException
     */
    public PersonnelDAO() throws IOException {
        super();
        this.name = "Personnels";
        f = new File(name + ".txt");      
        fileOut = new FileOutputStream(f);
        objOut = new ObjectOutputStream(fileOut);
    }
    /**
     * Méthode de création.
     * @param obj L'objet à créer
     * @return p
     */
    @Override
    public Personnel create(Personnel obj) {
        Personnel p = null;
        return p;
    }
    /**
     * Méthode pour effacer.
     * @param obj L'objet à effacer
     * @return p
     */
    public void delete(Personnel obj) {
        ;
    }
    /**
     * Méthode de mise à jour.
     * @param obj L'objet à mettre à jour
     */
    public Personnel update(Personnel obj) { 
        Personnel p = null;
        return p;
    }
    /**
     * Méthode de recherche des informations.
     * @param id de l'information 
     * @return p
     */
    public Personnel find(int id) {
        Personnel p = null;
        return p;
    }
}
