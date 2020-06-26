package javarush.task.task29.task2908;

/* Argument and Value are generic types*/
 // Computable - исчислимый
 // compute - вычисление
/*
 */
public interface Computable<Argument, Value> {
    /**
     * Метод принимает параметр @argument и возвращает значение value
     * @param argument - некий принимаемый параметр
     */
    Value compute(Argument argument) throws InterruptedException;
}