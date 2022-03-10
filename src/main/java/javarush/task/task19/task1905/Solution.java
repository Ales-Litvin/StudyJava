package javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/*
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements  RowItem{
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            for (Map.Entry<String, String> pair: countries.entrySet()){
                if (pair.getValue().equals(this.customer.getCountryName())){
                    return pair.getKey();
                }
            }
            return null;
        }

        @Override
        public String getCompany() {
            return this.customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] args = this.contact.getName().split(" ");
            return args[1];
        }

        @Override
        public String getContactLastName() {
            String[] args = this.contact.getName().split(",");
            return args[0];
        }

        @Override
        public String getDialString() {
            char[] chars = this.contact.getPhoneNumber().toCharArray();
            String phoneNumber = "callto://" + String.valueOf(chars[0]);
            for (int i = 1; i < chars.length; i++){
                Character character = chars[i];
                if (character.equals('(') || character.equals(')') || character.equals('-')){
                }
                else
                    phoneNumber = phoneNumber + chars[i];
            }
            return phoneNumber;
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}