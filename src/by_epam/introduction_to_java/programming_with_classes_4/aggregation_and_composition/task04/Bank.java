package by_epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task04;

import java.math.BigDecimal;
import java.util.*;

/*
 * Условие задачи:
 * 4. Счета. Клиент может иметь несколько счетов в банке.
 *      Учитывать возможность блокировки/разблокировки счета.
 *      Реализовать поиск и сортировку счетов.
 *      Вычисление общей суммы по счетам.
 *      Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */
public class Bank {
    /**
     * List for accounts.
     */
    private List<Account> accounts;

    public Bank(List<Account> accounts) { this.accounts = accounts; }

    public Bank() { this.accounts = new ArrayList<>(); }

    public void add(Account account){ accounts.add(account); }

    /**
     * Returns all accounts for client.
     * @param client a client of account.
     * @return all accounts for client.
     */
    public Set<Account> getAll(Client client){
        Set<Account> result = new HashSet<>();
        for (Account account : accounts){
            if (account.getClient().equals(client)){
                result.add(account);
            }
        }
        return result;
    }

    /**
     * Returns account by number.
     * @param number number of account.
     * @return account by number.
     */
    public Account get(long number){
        for (Account account : accounts){
            if (account.getNumber() == number){
                return account;
            }
        }
        return null;
    }

    /**
     * Locks account.
     * @param number number of account.
     */
    public void lockedAccount(long number){
        for (Account account : accounts){
            if (account.getNumber() == number) {
                account.setLocked(true);
            }
        }
    }

    /**
     * Unlocks account.
     * @param number number of account.
     */
    public void unLockedAccount(long number){
        for (Account account : accounts){
            if (account.getNumber() == number) {
                account.setLocked(false);
            }
        }
    }

    /**
     * Sorts accounts by sum.
     */
    public void sortAccountsBySum(){
        accounts.sort(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getAmount().compareTo(o2.getAmount());
            }
        });
    }

    /**
     * Sorts accounts by clients' name.
     */
    public void sortAccountsByClientName(){
        accounts.sort(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getClient().getName().compareTo(o2.getClient().getName());
            }
        });
    }

    /**
     * Sorts accounts by number.
     */
    public void sortAccountByNumber(){
        accounts.sort(new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return Long.compare(o1.getNumber(), o2.getNumber());
            }
        });
    }

    /**
     * Amounts in the bank.
     * @return  amount in the bank.
     */
    public BigDecimal getAllSum(){
        BigDecimal result = new BigDecimal(0);
        for (Account account : accounts){
            result = result.add(account.getAmount());
        }
        return result;
    }

    /**
     * Amount in the bank for client.
     * @return  amount in the bank for client.
     */
    public BigDecimal getAllSum(Client client){
        BigDecimal result = new BigDecimal(0);
        for (Account account : accounts){
            if (account.getClient().equals(client)) {
                result = result.add(account.getAmount());
            }
        }
        return result;
    }

    /**
     * Positive amount in the bank.
     * @return positive amount in the bank.
     */
    public BigDecimal getPositiveSum(){
        BigDecimal result = new BigDecimal(0);
        for (Account account : accounts){
            if (account.isPositiveBalance()) {
                result = result.add(account.getAmount());
            }
        }
        return result;
    }

    /**
     * Negative amount in the bank.
     * @return negative amount in the bank.
     */
    public BigDecimal getNegativeSum(){
        BigDecimal result = new BigDecimal(0);
        for (Account account : accounts){
            if (!account.isPositiveBalance()) {
                result = result.add(account.getAmount());
            }
        }
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bank{");
        sb.append("accounts=").append(accounts);
        sb.append('}');
        return sb.toString();
    }
}
