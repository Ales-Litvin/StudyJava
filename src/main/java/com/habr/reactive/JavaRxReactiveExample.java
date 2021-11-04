package com.habr.reactive;


import rx.Observable;
import rx.Observer;

public class JavaRxReactiveExample {
    public static void main(String[] args) {
        Observable<String> location = Observable.just("Minsk", "Krakow", "Moscow", "Kiev", "Sofia");
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onCompleted() {
                System.out.println("Done.");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Length: " + integer);
            }
        };

        location.map(String::length).filter(l -> l >= 5).subscribe(observer);


    }
}
