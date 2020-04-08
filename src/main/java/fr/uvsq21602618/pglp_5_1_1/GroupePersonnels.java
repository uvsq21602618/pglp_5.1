package fr.uvsq21602618.pglp_5_1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Iterator;
/**
 * Représente un groupe de composant.
 * @author Nathalie
 */
public class GroupePersonnels implements Composant, Serializable {
    /**
     * SerialVersion.
     */
    private static final long serialVersionUID = 1L;
    /**
     * Liste de composants appartenant à ce groupe de personnels.
     */
    private List<Composant> children = new ArrayList<Composant>();
    /**
     * Nom du groupe de personnels.
     */
    private String nomGroupe;
    /**
     * Id de l'instance.
     */
    private int id;
    /**
     * Constructeur qui créé un groupe de personnels
     * à partir d'un nom.
     * @param nom le nom du groupe de personnels
     * @param id2 l'id du groupe
     */
    public GroupePersonnels(final String nom, final int id2) {
        this.nomGroupe = nom;
        this.setId(id2);
    }
    /**
     * Méthode qui récupère le nom du groupe.
     * @return le nom du groupe
     */
    public String getName() {
        return this.nomGroupe;
    }
    /**
     * Méthode qui affiche le nom de chaque composant.
     */
    public void print() {
        System.out.println("-------" + this.getName() + "-------");
        for (Composant composant: children) {
            composant.print();
        }
    }
    /**
     * Méthode qui retourne la liste des composants du groupe.
     * Cette liste ne peut être modifiée.
     * @return la liste des composants non modifiable
     */
    public List<Composant> getList() {
        return Collections.unmodifiableList(children);
    }
    /**
     * Méthode qui ajoute un composant au groupe.
     * @param composant le composant à ajouter
     */
    public void add(final Composant composant) {
        children.add(composant);
    }
    /**
     * Méthode qui retire un composant du groupe.
     * @param composant le composant à retirer
     */
    public void remove(final Composant composant) {
        children.remove(composant);
    }
    /**
     * Affiche une représentation en profondeur de l'annuaire.
     * Utilisation d'un itérateur.
     */
    public void hierarchie() {
        Iterator<Composant> ite = children.iterator();
        System.out.println("-------" + this.getName() + "-------");
        while (ite.hasNext()) {
            Composant c = ite.next();
            c.print();
        }

    }
    /**
     * Méthode de comparaison.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        GroupePersonnels other = (GroupePersonnels) obj;
        if (children == null) {
            if (other.children != null) {
                return false;
            }
        } else if (!children.equals(other.children)) {
            return false;
        }
        if (nomGroupe == null) {
            if (other.nomGroupe != null) {
                return false;
            }
        } else if (!nomGroupe.equals(other.nomGroupe)) {
            return false;
        }
        return true;
    }
    /**
     * Méthode de hachage.
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((children == null) ? 0 : children.hashCode());
        result = prime * result + id;
        result = prime * result
                + ((nomGroupe == null) ? 0 : nomGroupe.hashCode());
        return result;
    }
    /**
     * Méthode qui récupère l'id.
     * @return l'id du groupe
     */
    public int getId() {
        return id;
    }
    /**
     * Méthode qui définit l'id du groupe.
     * @param id2 du groupe
     */
    public void setId(final int id2) {
        this.id = id2;
    }
    /**
     * Méthode pour la mise à jour.
     */
    public void maj() {
       System.out.println("Maj faites!");
    }
}
