Метод логорифмфа

public static int getCountsOfDigits(long number) {
return(number == 0) ? 1 : (int) Math.ceil(Math.log10(Math.abs(number) + 0.5));
}

Метод деления

public int getCountsOfDigits(long number) {
    int count = (number == 0) ? 1 : 0; while (number != 0) {
    count++; number /= 10;
    }
return count;
}

Метод сравнения
public static int getCountsOfDigits(int n) {
 if (n < 100000) { if (n < 100) { if (n < 10) { return 1; } else { return 2; } } else { if (n < 1000) { return 3; } else { if (n < 10000) { return 4; } else { return 5; } } } } else { if (n < 10000000) { if (n < 1000000) { return 6; } else { return 7; } } else { if (n < 100000000) { return 8; } else { if (n < 1000000000) { return 9; } else { return 10; } } } } }
}


    // нахождение длинны числа
    public static int getCountsOfDigits(Long n) {
        if (n < 100000L) {
            if (n < 100L) {
                if (n < 10L) {
                    return 1;
                }
                else {
                    return 2;
                }
            }
            else {
                if (n < 1000L) {
                    return 3;
                }
                else {
                    if (n < 10000L) {
                        return 4;
                    }
                    else {
                        return 5;
                    }
                }
            }
        }
        else {
            if (n < 10000000L) {
                if (n < 1000000L) {
                    return 6;
                }
                else {
                    return 7;
                }
            }
            else {
                if (n < 100000000L) {
                    return 8;
                }
                else {
                    if (n < 1000000000L) {
                        return 9;
                    }
                    else {
                        return 10;
                    }
                }
            }
        }
    }


Рейтинг нахождения длинны числа в зависимости от скорости выглядит так:
1. Сравнения (показывают лучший результат)
2. Логарифм
3. Деление
4. String (наихудший результат)

Сам же перебор осуществляется довольно просто : рассматриваются все числа, у которых любая цифра не меньше предыдущей и не больше последующей. Например: 12, 1557, 333 и т.д.