package learn.bigdecimal;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
public class BigDecimalExample {

    public static void main(String[] args) {
        BigDecimal decimal = new BigDecimal("123.567");
        decimal = decimal.setScale(2, RoundingMode.HALF_DOWN);
        log.info(decimal.toString());
    }
}
