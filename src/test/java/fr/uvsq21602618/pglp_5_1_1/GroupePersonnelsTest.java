package fr.uvsq21602618.pglp_5_1_1;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/**
 * Classe contenant les tests de la classe GroupePersonnels.
 * @author Nathalie
 *
 */
public class GroupePersonnelsTest {
    /**
     * Instances de GroupePersonnels.
     */
    GroupePersonnels g, g2, g3;
    /**
     * Initialisation des instances pour les tests.
     */
    @Before
    public void setUp() {
        g = new GroupePersonnels("groupe perso");
        g2 = new GroupePersonnels("groupe perso2");
        g3 = new GroupePersonnels("groupe perso3");
    }
    /**
     * Test de la méthode add.
     */
    @Test
    public void addTest() {

        g.add(g2);
        assertEquals(g.getList().get(0), g2);
    }
    /**
     * Test de la méthode remove.
     */
    @Test
    public void removeTest() {
        g.add(g2);
        g.add(g3);
        g.remove(g2);
        assertEquals(g.getList().get(0), g3);
    }
    /**
     * Méthode de désérialisation.
     * @param bytes le tableau d'octets à transformer en objet.
     * @return L'objet obtenu.
     * @throws ClassNotFoundException Exception si la classe n'existe pas.
     * @throws IOException Exception liee aux entreés/sorties
     */
    private Object deserialize(final byte[] bytes) throws ClassNotFoundException, IOException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        return o.readObject();
    }
    /**
     * Méthode de sérialisation.
     * @param obj L'objet à transformer en flux d'octets.
     * @return flux d'octets de l'objet.
     * @throws IOException Exception liee aux entreés/sorties
     */
    private byte[] serialize(final Object obj) throws IOException {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        ObjectOutputStream o = new ObjectOutputStream(b);
        o.writeObject(obj);
        return b.toByteArray();
    }

    /**
     * Tests sur la transformation dans les deux sens.
     * @throws IOException Exception liee aux entreés/sorties
     * @throws ClassNotFoundException Exception si la classe n'existe pas
     */
    @Test
    public void ConsistencyTest() throws IOException, ClassNotFoundException {
        byte[] serialized1 = serialize(g);
        byte[] serialized2 = serialize(g);

        Object deserialized1 = deserialize(serialized1);
        Object deserialized2 = deserialize(serialized2);
        Assert.assertEquals(deserialized1, deserialized2);
        Assert.assertEquals(g, deserialized1);
        Assert.assertEquals(g, deserialized2);
    }
}
