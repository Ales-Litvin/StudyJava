package javarush.task.task27.task2712.statistic;

import javarush.task.task27.task2712.kitchen.Cook;
import javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import javarush.task.task27.task2712.statistic.event.EventDataRow;
import javarush.task.task27.task2712.statistic.event.EventType;
import javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.time.LocalDate;
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

        // Возвращате лист для key к EventType
        public List<EventDataRow> getEventDataRowForEventType(EventType eventType) {
            return storage.get(eventType);
        }
    }

    private Set<Cook> cooks = new HashSet<Cook>();

    public void register(Cook cook){ cooks.add(cook); }

    public Set<Cook> getCooks() { return cooks; }

    public Map<LocalDate, Long> getAmountForDay(){
        // Map с обратым порядком
        Map<LocalDate, Long> amountListForDay = new TreeMap<LocalDate, Long>(Collections.reverseOrder());
        for (EventDataRow data : statisticStorage.getEventDataRowForEventType(EventType.SELECTED_VIDEOS)){
            VideoSelectedEventDataRow videoSelectedEventDataRow = (VideoSelectedEventDataRow) data;
            LocalDate localDate = convertToLocalDateViaSqlDate(data.getDate());
            // Прикол в том что getAmount() - возвращает количество показов
            if (amountListForDay.containsKey(localDate)) {
                amountListForDay.put(localDate, amountListForDay.get(localDate) +
                        videoSelectedEventDataRow.getAmount());
            }
            else {amountListForDay.put(localDate, videoSelectedEventDataRow.getAmount()); }
        }
        return amountListForDay;
    }

    // Конвертирует Date to LocalDate
    public static LocalDate convertToLocalDateViaSqlDate(Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime()).toLocalDate();
    }

    public Map<LocalDate, Map<String, Integer>> getCooksWorkStatistics(){
        Map<LocalDate, Map<String, Integer>> workingHoursCooksDaily =
                new TreeMap<>(Collections.reverseOrder());
        for (EventDataRow data : statisticStorage.getEventDataRowForEventType(EventType.COOKED_ORDER)){
            CookedOrderEventDataRow cookedOrderEventDataRow = (CookedOrderEventDataRow) data;
            LocalDate localDate = convertToLocalDateViaSqlDate(data.getDate());

            if (workingHoursCooksDaily.containsKey(localDate)){
                Map<String, Integer> workingHoursCook = workingHoursCooksDaily.get(localDate);
                String cookName = cookedOrderEventDataRow.getCookName();

                if (workingHoursCook.containsKey(cookName)){
                    workingHoursCook.put(cookName, workingHoursCook.get(cookName) +
                            cookedOrderEventDataRow.getTime());
                    workingHoursCooksDaily.put(localDate, workingHoursCook);
                } else {
                    workingHoursCook.put(cookName, cookedOrderEventDataRow.getTime());
                }
            } else {
                Map<String, Integer> workingHoursCook = new TreeMap<>();
                workingHoursCook.put(cookedOrderEventDataRow.getCookName(),
                        cookedOrderEventDataRow.getTime()); // продолжительность в секундах
                workingHoursCooksDaily.put(localDate, workingHoursCook);
            }
        }
        return workingHoursCooksDaily;
    }
}