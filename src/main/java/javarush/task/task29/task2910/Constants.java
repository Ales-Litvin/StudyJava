package javarush.task.task29.task2910;

import java.math.BigDecimal;

public class Constants {
    // беговая дистанция
    public static final Double RACE_LENGTH = new Double(20.0);
    // количестов огневых рубежей
    public static final int NUMBER_OF_FIRE_LINES = 4;
    // штраф за каждый промах
    public static final int PENALTY_TIME_PER_ONE_MISS = 20;
    // мин и мак вероятность поподания в мешень
    public static final BigDecimal MIN_CHANCE_TO_HIT_IN_TARGET = new BigDecimal("0.815");
    public static final BigDecimal MAX_CHANCE_TO_HIT_IN_TARGET = new BigDecimal("0.900");
    // количество спортсменов
    public static final int SPORTSMAN_COUNT = 30;
}