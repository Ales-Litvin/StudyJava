/*
 * Copyright (c) 2020, Rachko and/or its affiliates. All rights reserved.
 * RACHKO PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package by_epam.introduction_to_java.basics_of_OOP_5.task02;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Условие задачи:
 * Задача 2.
 * Создать класс Payment с внутренним классом,
 * с помощью объектов которого можно сформировать покупку из нескольких товаров.
 */

/**
 * Class payment with list of <b>products</b>.
 * @autor Rachko Aliaksandr
 * @version 1.0
 */
public class Payment {
    private List<Product> products;

    public Payment(List<Product> products) { this.products = products; }

    public Payment() { this.products = new ArrayList<>(); }

    public List<Product> getProducts() { return products; }

    public void setProducts(List<Product> products) { this.products = products; }

    public double getTotalPrice() {
        double result = 0;
        for (Product product : products){
            result += product.getPrice();
        }
        return result;
    }

    /**
     * Adds new the product in the list with products.
     * @return <tt>true</tt> if this collection changed as a result of the call
     */
    public boolean add(String name, double price){
        return products.add(new Product(name, price));
    }

    /**
     * Removes product
     */
    public void remove(String name){
        products.removeIf(product -> product.getName().equals(name));
    }

    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    public void clear(){
        products.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;
        Payment payment = (Payment) o;
        return Objects.equals(getProducts(), payment.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProducts());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Payment{");
        sb.append("products=").append(products);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Class product with <b>name</b> and <b>price</b>.
     */
    static class Product{
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() { return name; }

        public void setName(String name) { this.name = name; }

        public double getPrice() { return price; }

        public void setPrice(double price) { this.price = price; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Product)) return false;
            Product product = (Product) o;
            return Double.compare(product.getPrice(), getPrice()) == 0 &&
                    Objects.equals(getName(), product.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getName(), getPrice());
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Product{");
            sb.append("name='").append(name).append('\'');
            sb.append(", price=").append(price);
            sb.append('}');
            return sb.toString();
        }
    }
}
