package cuncurent.ru.java.online.cuncurent.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * Пакет java.util.concurrent.atomic включает девять атомарных классов для
 * выполнения, так называемых, атомарных операций.
 * Операция является атомарной, если её можно безопасно выполнять при
 * параллельных вычислениях в нескольких потоках, не используя при этом ни
 * блокировок, ни синхронизацию synchronized.
 *
 * Атомарный класс включает метод compareAndSet, реализующий механизм
 * оптимистичной блокировки и позволяющий изменить значение только в том случае,
 * если оно равно ожидаемому значению.
 * Т.е. если значение атомарного класса было изменено в другом потоке, то оно не
 * будет равно ожидаемому значению, и метод compareAndSet не позволит изменить
 * значение.
 *
 * Ряд архитектур процессоров имеют инструкцию Compare-And-Swap (CAS),
 * которая реализует операцию compareAndSet.
 * Таким образом, на уровне инструкций процессора имеется поддержка необходимой
 * атомарной операции. В архитектурах процессоров, где инструкция не поддерживается,
 * операции реализованы иными низкоуровневыми средствами.
 */
public class AtomicIntegerExample {

    public static void main(String[] args) {
        AtomicInteger atomicInt = new AtomicInteger(0);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, 1000)
                .forEach(i -> executor.submit(atomicInt::incrementAndGet));

        System.out.println(atomicInt.get());    // => 1000
    }
}
