package javarush.task.task27.task2712;

import javarush.task.task27.task2712.statistic.StatisticManager;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Map;

public class DirectorTablet {
    public void printAdvertisementProfit() {
        Long totalAmount = 0L;
        for (Map.Entry<LocalDate, Long> pair : StatisticManager.getInstance().getAmountForDay().entrySet()){
            LocalDate key = pair.getKey();
            Long value = pair.getValue();
            totalAmount += value;
            ConsoleHelper.writeMessage(String.format(Locale.ROOT,
                    "%1$td-%1$tb-%1$tY - %2$.2f", key, (double) value / 100));
        }
        ConsoleHelper.writeMessage(String.format(Locale.ROOT,
                "Total - %.2f",  (double) totalAmount / 100));
    }

    public void printCookWorkloading() {
        for (Map.Entry<LocalDate, Map<String, Integer>> pair : StatisticManager.getInstance().getCooksWorkStatistics().entrySet()){
            LocalDate key = pair.getKey();
            ConsoleHelper.writeMessage(String.format(Locale.ROOT,
                    "%1$td-%1$tb-%1$tY", key));

            Map<String, Integer> value = pair.getValue();
            for (Map.Entry<String, Integer> pairCook : value.entrySet()){
                String cookName = pairCook.getKey();
                Integer timeCook = pairCook.getValue();

                if (timeCook != null && timeCook != 0) {
                    ConsoleHelper.writeMessage(String.format(Locale.ROOT,
                            "%s - %d min", cookName, timeCook));
                }
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet() { }

    public void printArchivedVideoSet() { }
}