package fr.uvsq21602618.pglp_5_1_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
/**
 * Classe pour le DAO de GroupePersonnels.
 * @author Nathalie
 *
 */
public class GroupePersonnelsDAO extends DAO<GroupePersonnels> {
    /**
     * Méthode de création.
     * @param obj L'objet à créer
     * @return obj qui vient d'etre cree
     * @throws IOException Exceptions liees aux entrees/sorties 
     */
    @Override
    public GroupePersonnels create(GroupePersonnels obj) throws IOException {
        String nomDir = "Groupes";
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
     * Méthode pour effacer.
     * @param obj L'objet à effacer
     */
    public void delete(GroupePersonnels obj) {
        String nomDir = "Groupes";
        File dir = new File(nomDir);
        if(dir.exists()) {
            File file = new File(nomDir + "\\" + obj.getId() + ".txt");
            if(file.exists()) {
                file.delete();
                System.out.println("Le fichier est supprimé!");
            } else {
                System.out.println("Le fichier à supprimer n'existe pas!");
            }
        } else {
            System.out.println("Le dossier contenant le fichier n'existe pas!");
        }
    }
    /**
     * Méthode de mise à jour.
     * @param obj L'objet à mettre à jour
     * @throws IOException Exceptions liees aux entrees/sorties 
     */
    public GroupePersonnels update(GroupePersonnels obj) throws IOException { 
        String nomDir = "Groupes";
        File dir = new File(nomDir);
        if(dir.exists()) {
            File file = new File(nomDir + "\\" + obj.getId() + ".txt");
            if(file.exists()) {
                file.delete();
                obj.maj();
                this.create(obj);
            } else {
                System.out.println("Le fichier à mettre à jour n'existe pas!");
            }
        } else {
            System.out.println("Le dossier contenant le fichier n'existe pas!");
        }
        return obj;
    }
    /**
     * Méthode de recherche des informations.
     * @param id de l'information 
     * @return gp le GroupePersonnel du fichier, null sinon
     * @throws IOException liee aux entreés/sorties
     * @throws ClassNotFoundException Exception lié à une classe inexistante
     */
    public GroupePersonnels find(int id) throws IOException, ClassNotFoundException {
        String nomDir = "Groupes";
        File dir = new File(nomDir);
        File search = new File(nomDir + "\\" + id + ".txt");
        Object deserialized = null;
        
        if(dir.exists()) {
            if(search.exists()) {
                byte[] fileContent = Files.readAllBytes(search.toPath());
                deserialized = deserialize(fileContent);
            } else {
                System.out.println("Le fichier n'existe pas!");
            }
            
            GroupePersonnels gp = (GroupePersonnels) deserialized;
            gp.hierarchie();
    
            return gp;
        } else {
            System.out.println("Le dossier n'existe pas!");
        }
        return null;
    }
}
