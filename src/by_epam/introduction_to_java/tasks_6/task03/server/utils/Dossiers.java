package by_epam.introduction_to_java.tasks_6.task03.server.utils;

import by_epam.introduction_to_java.tasks_6.task03.entity.Dossier;
import by_epam.introduction_to_java.tasks_6.task03.server.loader.ObjectLoader;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Data base dossiers.xml.
 * Class is 'Singleton'. It uses data from xml file,
 * and writes data to xml file if element {@code dossier} added.
 *
 * @see Dossier
 * @see ObjectLoader
 *
 * @author Aliaksandr Rachko
 * @version 1.0
 */
@XmlRootElement(name = "dossiers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dossiers {

    @XmlElementWrapper(name = "dossiersList")
    @XmlElement(name = "dossier")
    private final List<Dossier> list;

    @XmlTransient
    private static volatile Dossiers instance;

    public static Dossiers getInstance(){
        Dossiers localInstance = instance;
        if (localInstance == null) {
            synchronized (Users.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = loader.load();
                }
            }
        }
        return localInstance;
    }

    @XmlTransient
    private static final ObjectLoader<Dossiers> loader = new ObjectLoader<>(
            "./src/by_epam/introduction_to_java/tasks_6/task03/server/resources/",
            Dossiers.class);

    private Dossiers() {
        this.list = new ArrayList<>();
        list.add(new Dossier("Jon", "Billi", "Jon's life history", 1));
    }

    /**
     * Returns the dossier by {@code id} if it exists.
     * @param id dossier's id
     * @return the dossier by {@code id} if it exists,
     *         or {@code null} if dossier with giving {@code id}
     *         doesn't exist.
     */
    public synchronized Dossier get(long id){
        for (Dossier dossier : list) {
            if (dossier.getId() == id) {
                return dossier;
            }
        }
        return null;
    }

    /**
     * Adds new the Dossier in the list of dossiers.xml if it doesn't contain its.
     * @param dossier the dossier for adding.
     * @return <tt>true</tt> if this collection changed as a result of the
     *        call
     */
    public synchronized boolean add(Dossier dossier){
        if (!list.contains(dossier)){
            list.add(dossier);
            loader.store(instance);
            return true;
        }
        return false;
    }

    /**
     * Changes the dosser by {@code id}, if list contains it.
     * @param dossier new the dossier for changing.
     * @return <tt>true</tt> if the dossier with giving {@code id} changed.
     */
    public synchronized boolean change(Dossier dossier){
        for (Iterator<Dossier> iterator = list.iterator(); iterator.hasNext();){
            Dossier dossier1 = iterator.next();
            if (dossier1.getId() == dossier.getId()) {
                iterator.remove();
                list.add(dossier);
                loader.store(instance);
                return true;
            }
        }

        return false;
    }

    /**
     * Returns all dossiers.xml.
     */
    public synchronized List<Dossier> getAll() {
        return list;
    }
}