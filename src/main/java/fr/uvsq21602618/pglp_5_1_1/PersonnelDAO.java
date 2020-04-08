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
        String nomDir = "NumeroTels";
        File dir = new File(nomDir);
        FileOutputStream fileOut;
        ObjectOutputStream objOut;

        File file = new File(nomDir + "\\" + obj.getId() + ".txt");
        if (!dir.exists()) {
            if (dir.mkdir()) {
                System.out.println("Le dossier est créé!");
            } else {
                System.out.println("le dossier n'a pas pu être créé!");
            }
        }
        
        fileOut = new FileOutputStream(file);
        objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(obj);
        objOut.close();
        System.out.println("Le fichier est créé!");
        
        return obj;
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
