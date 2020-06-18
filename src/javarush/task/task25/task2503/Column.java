package javarush.task.task25.task2503;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum Column implements Columnable {
    Customer("Customer"),
    BankName("Bank Name"),
    AccountNumber("Account Number"),
    Amount("Available Amount");

    private String columnName;

    private static int[] realOrder;

    private Column(String columnName) {
        this.columnName = columnName;
    }

    /**
     * Задает новый порядок отображения колонок, который хранится в массиве realOrder.
     * realOrder[индекс в энуме] = порядок отображения; -1, если колонка не отображается.
     *
     * @param newOrder новая последовательность колонок, в которой они будут отображаться в таблице
     * @throws IllegalArgumentException при дубликате колонки
     */
    public static void configureColumns(Column... newOrder) {
        // инициализирует realOrder массивом длинной констант Column
        realOrder = new int[values().length];
        // перебор констант
        for (Column column : values()) {
            //realOrder[индекс в энуме] = -1, колонка не отображается
            realOrder[column.ordinal()] = -1;
            boolean isFound = false;

            //перебора переданных параметров newOrder
            for (int i = 0; i < newOrder.length; i++) {
                if (column == newOrder[i]) {
                    if (isFound) {
                        throw new IllegalArgumentException("Column '" + column.columnName + "' is already configured.");
                    }
                    //realOrder[индекс в энуме] = i - порядок элемента в newOrder, порядок отображения
                    realOrder[column.ordinal()] = i;
                    isFound = true;
                }
            }
        }
    }

    /**
     * Вычисляет и возвращает список отображаемых колонок в сконфигурированом порядке (см. метод configureColumns)
     * Используется поле realOrder.
     *
     * @return список колонок
     */
    public static List<Column> getVisibleColumns() {
        List<Column> result = new LinkedList<>();
        // код по заполнению result в порядке в соотвествии с realOrder
        Column[] columns = new Column[4];
        Column[] arrayColumns = values();
        for (int i = 0; i < arrayColumns.length; i++){
            if (arrayColumns[i].isShown()){
                columns[realOrder[i]] = arrayColumns[i];
            }
        }
        result.addAll(Arrays.asList(columns));
        // Цикл while удаляет null из списка
        while (result.indexOf(null) != -1) {
            result.remove(null);
        }
        return result;
    }

    /**
     * @return полное имя колонки
     */
    @Override
    public String getColumnName() {
        return this.columnName;
    }

    /**
     * Возвращает true, если колонка видимая, иначе false
     */
    @Override
    public boolean isShown() {
        return realOrder[this.ordinal()] != -1;
    }

    /**
     * Скрывает колонку - маркирует колонку -1 в массиве realOrder.
     * Сдвигает индексы отображаемых колонок, которые идут после скрытой
     */
    @Override
    public void hide() {
        int indexThis = realOrder[this.ordinal()];
        realOrder[this.ordinal()] = -1;
        /*
         * Следующий цикл сдвигает индексы отображаемых колонок,
         * которые идут после скрытой indexThis
         */
        for (int i = 0; i < realOrder.length; i++){
            if (realOrder[i] != -1 && realOrder[i] > indexThis) realOrder[i] = realOrder[i] - 1;
        }
    }
}