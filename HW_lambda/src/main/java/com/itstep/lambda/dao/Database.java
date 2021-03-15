package com.itstep.lambda.dao;

import com.itstep.lambda.entity.Money;

import java.util.ArrayList;
import java.util.List;

public class Database {

    static List<Money> currencyListForKzt = new ArrayList<>();

    static {
        currencyListForKzt.add(new Money(1, "RUR", 0.1754)); // Российский рубль
        currencyListForKzt.add(new Money(2, "USD", 0.0024)); // Доллар США
        currencyListForKzt.add(new Money(3, "EUR", 0.002)); // Евро
        currencyListForKzt.add(new Money(4, "BYN", 0.0062)); // Белорусский рубль
        currencyListForKzt.add(new Money(5, "INR", 0.1736)); // Индийская рупия
        currencyListForKzt.add(new Money(6, "CHF", 0.0022)); // Швейцарский франк
        currencyListForKzt.add(new Money(7, "UZS", 25.0836)); // Узбекский сум
        currencyListForKzt.add(new Money(8, "TRY", 0.0181)); // Турецкая лира
    }

    public static List<Money> getCurrencyListForKzt() {
        return currencyListForKzt;
    }
}
