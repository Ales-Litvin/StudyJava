package javarush.task.task27.task2712.statistic;

import javarush.task.task27.task2712.kitchen.Cook;
import javarush.task.task27.task2712.statistic.event.EventDataRow;
import javarush.task.task27.task2712.statistic.event.EventType;

import java.util.*;

public class StatisticManager {
    private static StatisticManager instance;

    private StatisticManager() { }

    public static StatisticManager getInstance(){
        if (instance == null) { instance = new StatisticManager(); }
        return instance;
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    private StatisticStorage statisticStorage = new StatisticStorage();

    private class StatisticStorage{
        Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
            this.storage = new HashMap<>();
            for (EventType eventType : EventType.values()){
                storage.put(eventType, new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data){
            storage.get(data.getType()).add(data);
        }
    }

    private Set<Cook> cooks = new HashSet<Cook>();

    public void register(Cook cook){
        cooks.add(cook);
    }


}