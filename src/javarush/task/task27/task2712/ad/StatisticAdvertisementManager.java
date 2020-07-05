package javarush.task.task27.task2712.ad;

import java.util.*;

public class StatisticAdvertisementManager {
    AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager(){ }

    private static StatisticAdvertisementManager instance;

    public static StatisticAdvertisementManager getInstance(){
        if (instance == null) { instance = new StatisticAdvertisementManager(); }
        return instance;
    }

    public Set<Advertisement> getActiveVideoSet(boolean activeVideo){
        Set<Advertisement> activeVideoSet = new TreeSet<Advertisement>(new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        for (Advertisement advertisement : advertisementStorage.list()){
                if (advertisement.getHits() > 0 && activeVideo) {
                    activeVideoSet.add(advertisement);
                }
                if (advertisement.getHits() == 0 && !activeVideo) {
                    activeVideoSet.add(advertisement);
                }
        }
        return activeVideoSet;
    }
}