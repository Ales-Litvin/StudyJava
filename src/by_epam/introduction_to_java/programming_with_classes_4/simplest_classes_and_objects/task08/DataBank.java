package by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task08;

/*
 * Условие задачи см. class
 * by_epam.introduction_to_java.programming_with_classes_4.simplest_classes_and_objects.task08.Customer
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataBank{
    private final List<Customer> customers;

    public DataBank() {
        this.customers = new ArrayList<>();
    }

    // getter
    public List<Customer> getCustomers() { return customers; }

    /**
     * Returns Customers with number of credit card in a givens interval
     * @param from from number of credit card
     * @param to to number of credit card
     * @return Customers with number of credit card in a givens interval
     */
    public List<Customer> getCustomersByNumberCreditCard(long from, long to){
        List<Customer> result = new ArrayList<>();

        for (Customer customer : customers){
            if (customer.getNumberCreditCard() >= from &&
            customer.getNumberCreditCard() <= to){
                result.add(customer);
            }
        }
        return result;
    }

    public void add(Customer customer){ customers.add(customer); }

    public boolean remove(Customer customer){ return customers.remove(customer); }

    /**
     * Removes customers by id
     * @param id id of Customer
     * @return <tt>true</tt> if this list contained the specified element
     */
    public boolean remove(int id){
        Iterator<Customer> itr = customers.iterator();

        while (itr.hasNext()){
            if (itr.next().getId() == id){
                itr.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Sorts this list according to surname
     */
    public void sortBySurname(){
        customers.sort((o1, o2) -> o1.getSurname().compareTo(o2.getSurname()));
    }
}