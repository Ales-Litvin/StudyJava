package by_epam.introduction_to_java.programming_with_classes_4.aggregation_and_composition.task04;

/*
 * Условие задачи:
 * 4. Счета. Клиент может иметь несколько счетов в банке.
 *      Учитывать возможность блокировки/разблокировки счета.
 *      Реализовать поиск и сортировку счетов.
 *      Вычисление общей суммы по счетам.
 *      Вычисление суммы по всем счетам, имеющим положительный и отрицательный балансы отдельно.
 */

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    /**
     * Account lock status.
     */
    private boolean locked;

    /**
     * Account owner. Stores customer's data.
     */
    private Client client;

    /**
     * Account amount.
     */
    private BigDecimal amount;

    private long number;

    public Account(Client client, BigDecimal sum, long number) {
        this.client = client;
        this.amount = sum;
        this.number = number;
    }

    // getters
    public boolean isLocked() { return locked; }

    public Client getClient() { return client; }

    public BigDecimal getAmount() { return amount; }

    public long getNumber() { return number; }

    // setters


    public void setLocked(boolean locked) { this.locked = locked; }

    /**
     * Adds sum to account.
     * @param sum sum.
     */
    public void add(BigDecimal sum){
        this.amount = this.amount.add(sum);
    }

    /**
     * Subtracts sum from account, and returns subtracted sum.
     * @param subtrahend sum.
     * @return subtracted sum.
     */
    public BigDecimal subtract(BigDecimal subtrahend){
        if (!this.locked) {
            this.amount = this.amount.subtract(subtrahend);
            return subtrahend;
        }
        return new BigDecimal(0);
    }

    public boolean isPositiveBalance(){
        return this.amount.compareTo(BigDecimal.ZERO) > 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account: ");
        sb.append(number).append(" {");
        sb.append(client.toString());
        sb.append("; status: ");
        if (locked){
            sb.append("locked");
        } else{
            sb.append("unlocked");
        }
        sb.append("; amount: ").append(amount);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return getNumber() == account.getNumber();
    }

    @Override
    public int hashCode() { return Objects.hash(getNumber()); }
}
