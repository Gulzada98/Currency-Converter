package com.itstep.lambda;

import com.itstep.lambda.dao.Database;
import com.itstep.lambda.entity.Money;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        *   Лямбда представляет набор инструкций, которые можно выделить в отдельную переменную
            и затем многократно вызвать в различных местах программы.

            Основу лямбда-выражения составляет лямбда-оператор, который представляет стрелку ->.
            Синтаксис лямбда-выражения имеет вид:
            параметры -> {тело функции}.
            Правила использования лямбд:
            Выведение типов:
            В списке аргументов можно пренебречь указанием типов
            Общий вид λ-выражения
            (тип1 var1, тип2 var2 ...) -> { тело метода }
            λ-выражение с выведением типов
            (var1, var2 ...) -> { тело метода }

            Скобки:
            Если метод зависит от одного аргумента, скобки можно опустить.
            В таком случае тип аргумента не указывается.

            Лямбда-выражения используют статические области действия переменных. Выводы:
            Ключевое слово this ссылается на внешний класс, а не на анонимный (тот, в который
            преобразуется лямбда-выражение).
            Лямбда не может создавать новые переменные с такими же именами, как у метода,
            вызвавшего лямбда.
            Лямбда может ссылаться (но не изменять) локальные переменные из окружающего кода.
            Лямбда может обращаться (и изменять) переменные экземпляра окружающего класса.

            Задание
            Напишите калькулятор конвертора валют, используя лямбда-выражения.

            Рекомендуемые ресурсы
            Oracle: Lambda-expressions
            https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
        */

        Scanner input = new Scanner(System.in);
        // лямбда
        Operation multiple = (x, y) -> x * y;

        List<Money> currencyListForKzt = Database.getCurrencyListForKzt();
        // Вывод валют в которые можно конвертировать тг
        System.out.println("Хочу приобрести:");
        for (Money m : currencyListForKzt) {
            System.out.println(m.getId() + " - " + m.getName());
        }

        int choice;
        choice = input.nextInt();

        for (Money m : currencyListForKzt) {
            if (m.getId() == choice) {
                System.out.println("Введите сумму: ");
                double tenge = input.nextDouble();

                double resultMultiple = multiple.calculate(tenge, m.getRate());
                System.out.println("KZT       " + m.getName());
                System.out.println(tenge + "     " + resultMultiple);
            }
        }
    }
}

@FunctionalInterface
interface Operation {
    double calculate(double x, double y);
}
