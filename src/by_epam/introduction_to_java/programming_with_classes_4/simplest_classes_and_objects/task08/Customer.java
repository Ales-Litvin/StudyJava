package by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task08;

/*
 * Условие задачи:
 * 8. Создать класс Customer, спецификация которого приведена ниже.
 *    Определить конструкторы, set- и get- методы и метод toString().
 *    Создать второй класс, агрегирующий массив типа Customer, с подходящими конструкторами и методами.
 *    Задать критерии выбора данных и вывести эти данные на консоль.
 *
 *    Класс Customer: id, фамилия, имя, отчество, адрес, номер кредитной карточки, номер банковского счета.
 *    Найти и вывести:
 *    а) список покупателей в алфавитном порядке;
 *    б) список покупателей, у которых номер кредитной карточки находится в заданном интервале
 */
public class Customer {
    private int id;
    private String surname;
    private String firstName;
    private String patronymic;

    private long numberCreditCard;
    private long bankAccountNumber;

    public Customer(int id, String surname, String firstName, String patronymic, long numberCreditCard, long bankAccountNumber) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.numberCreditCard = numberCreditCard;
        this.bankAccountNumber = bankAccountNumber;
    }

    public Customer(int id, String surname, String firstName, long numberCreditCard, long bankAccountNumber) {
        this.id = id;
        this.surname = surname;
        this.firstName = firstName;
        this.numberCreditCard = numberCreditCard;
        this.bankAccountNumber = bankAccountNumber;
    }

    // getters and setters
    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getSurname() { return surname; }

    public void setSurname(String surname) { this.surname = surname; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getPatronymic() { return patronymic; }

    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public long getNumberCreditCard() { return numberCreditCard; }

    public void setNumberCreditCard(long numberCreditCard) { this.numberCreditCard = numberCreditCard; }

    public long getBankAccountNumber() { return bankAccountNumber; }

    public void setBankAccountNumber(long bankAccountNumber) { this.bankAccountNumber = bankAccountNumber; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("id=").append(id).append(", ");
        sb.append(surname).append(" ");
        sb.append(firstName).append(" ");
        sb.append(patronymic).append(" ");
        sb.append('}');
        return sb.toString();
    }
}
