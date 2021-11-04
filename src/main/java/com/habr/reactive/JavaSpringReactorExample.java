package com.habr.reactive;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

public class JavaSpringReactorExample {
    public static void main(String[] args) {
        Flux<String> flux = Flux.just("Minsk", "Krakow", "Moscow", "Kiev", "Sofia");

        flux.map(String::length).filter(l -> l >= 5).subscribe(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("Length: " + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                throwable.printStackTrace();
            }

            @Override
            public void onComplete() {
                System.out.println("Done.");
            }
        });
    }
}
