package com.my.reflection;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car implements Cloneable, Externalizable {

    private int maxSpeed;
    private double width;

    public Car(int maxSpeed, double width) {
        this.maxSpeed = maxSpeed;
        this.width = width;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("maxSpeed=").append(maxSpeed);
        sb.append(", width=").append(width);
        sb.append('}');
        return sb.toString();
    }

    public Car() {
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        if (maxSpeed != car.maxSpeed) return false;
        return Double.compare(car.width, width) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = maxSpeed;
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Car car = new Car();
        car.maxSpeed = this.maxSpeed;
        car.width = this.width;
        return car;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.maxSpeed);
        out.writeObject(this.width);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        maxSpeed = in.readInt();
        width = in.readDouble();
    }
}
