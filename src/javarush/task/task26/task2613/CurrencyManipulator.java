package javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator {
    private final String currencyCode;

    private final Map<Integer, Integer> denominations;

    public String getCurrencyCode() { return currencyCode; }

    public CurrencyManipulator(String currencyCode) {
        this.denominations = new HashMap<>();
        this.currencyCode = currencyCode;
    }

    //DEPOSIT
    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) {
            sum += pair.getKey() * pair.getValue();
        }
        return sum;
    }


}