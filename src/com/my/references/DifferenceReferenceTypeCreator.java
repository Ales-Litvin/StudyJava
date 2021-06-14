package com.my.references;

import com.my.reflection.Car;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class DifferenceReferenceTypeCreator {
    public static void main(String[] args) {
        // string
        Car car = new Car();
        // soft
        SoftReference<Car> softReference = new SoftReference(car);
        // weak
        WeakReference<Car> weakReference = new WeakReference(car);
        // phantom
        PhantomReference<Car> phantomReference = new PhantomReference<>(car,
                new ReferenceQueue<>());
        car = null;

    }
}
