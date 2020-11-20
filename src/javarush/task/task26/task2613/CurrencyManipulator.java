package javarush.task.task26.task2613;

import javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;


public class CurrencyManipulator {
    private final String currencyCode;

    private final Map<Integer, Integer> denominations;

    public String getCurrencyCode() { return currencyCode; }

    public CurrencyManipulator(String currencyCode) {
        this.denominations = new HashMap<>();
        this.currencyCode = currencyCode;
    }

    public  boolean hasMoney(){
        return !denominations.isEmpty();
    }

    public boolean isAmountAvailable(int expectedAmount){
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount)
            throws NotEnoughMoneyException {
        Map<Integer, Integer> removedBills = new HashMap<>();

        Set<Integer> bills = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });

        bills.addAll(denominations.keySet());

        int num;
        for (int bill : bills) {
            if (bill <= expectedAmount) {

                num = expectedAmount / bill;

                if (denominations.get(bill) < num) {
                    num = denominations.get(bill);
                }

                removedBills.put(bill, num);
                expectedAmount -= num * bill;
            }
        }

        if (expectedAmount > 0) throw new NotEnoughMoneyException();

        removeBills(removedBills);

        return removedBills;
    }

    private void removeBills(Map<Integer, Integer> removedBills) {
        for (Map.Entry<Integer, Integer> pair : removedBills.entrySet()){
            int denomination = pair.getKey();
            int count = pair.getValue();

            if (denominations.get(denomination) == count){
                denominations.remove(denomination);
            } else {
                denominations.put(denomination, denominations.get(denomination) - count);
            }
        }
    }

    //DEPOSIT
    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    //INFO
    public int getTotalAmount() {
        int sum = 0;
        for (Map.Entry<Integer, Integer> pair : denominations.entrySet()) {
            sum += pair.getKey() * pair.getValue();
        }
        return sum;
    }
}