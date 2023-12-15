package Seminar6_Lesson;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Seminar6_Lesson {
    public static void main(String[] args) {
        task0();
        task1(createRandomArray(10000, 0, 100));
        task2_and_task3_and_task4();
    }

    static void task0() {
        // 1. Создайте HashSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6,
        // 3}. Распечатайте содержимое данного множества.
        // 2. Создайте LinkedHashSet, заполните его следующими числами: {1, 2, 3, 2, 4,
        // 5, 6, 3}. Распечатайте содержимое данного множества.
        // 3. Создайте TreeSet, заполните его следующими числами: {1, 2, 3, 2, 4, 5, 6,
        // 3}. Распечатайте содержимое данного множества.

        String[] arr = { "1/, 4/, 3/, 7/, 6/, 32/, 9/", "1", "5", "3", "34", "3434", "5", "df", "g6" };

        Set<String> set1 = new HashSet<>(Arrays.asList(arr));
        Set<String> set2 = new LinkedHashSet<>(Arrays.asList(arr));
        Set<String> set3 = new TreeSet<>(Arrays.asList(arr));

        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);

    }

    static void task1(Integer[] arr) {
        // 1. Напишите метод, который заполнит массив из 1000 элементов случайными
        // цифрами от 0 до 24.
        // 2. Создайте метод, в который передайте заполненный выше массив и с
        // помощью Set вычислите процент уникальных значений в данном массиве и
        // верните его в виде числа с плавающей запятой.
        // Для вычисления процента используйте формулу:
        // процент уникальных чисел = количество уникальных чисел * 100 / общее
        // количество чисел в массиве.

        Set<Integer> set = new HashSet<>(Arrays.asList(arr));
        double percent = set.size() * 100 / arr.length;
        System.out.println(percent);
    }

    static Integer[] createRandomArray(int size, int min, int max) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(min, max + 1);
        }
        return arr;
    }

    static void task2_and_task3_and_task4() {
        // 1. Продумайте структуру класса Кот. Какие поля и методы будут актуальны для
        // приложения, которое является
        // а) информационной системой ветеринарной клиники
        // б) архивом выставки котов
        // в) информационной системой Театра кошек Ю. Д. Куклачёва
        // Можно записать в текстовом виде, не обязательно реализовывать в java.

        // 1. Реализуйте 1 из вариантов класса Cat из предыдущего задания, можно
        // использовать не все придуманные поля и методы. Создайте несколько
        // экземпляров этого класса, выведите их в консоль.
        // 2. Добейтесь того, чтобы при выводе в консоль объекта типа Cat, выводилась
        // его кличка, цвет и возраст (или другие параметры на ваше усмотрение)

        // 1. Создайте множество, в котором будут храниться экземпляры класса Cat -
        // HashSet<Cat>.
        // Поместите в него некоторое количество объектов.
        // 2. Создайте 2 или более котов с одинаковыми параметрами в полях. Поместите их
        // во множество.
        // Убедитесь, что все они сохранились во множество.
        // 3. Создайте метод public boolean equals(Object o)
        // Пропишите в нём логику сравнения котов по параметрам, хранимым в полях. То
        // есть, метод
        // должен возвращать true, только если значения во всех полях сравниваемых
        // объектов равны.
        // 4. Создайте метод public int hashCode()
        // который будет возвращать hash, вычисленный на основе полей класса Cat. (Можно
        // использовать
        // Objects.hash(...))
        // 5. Выведите снова содержимое множества из пункта 2, убедитесь, что дубликаты
        // удалились.

        Cat cat1 = new Cat("Valea", "Shunea", 1, "Scottish");
        Cat cat2 = new Cat("Valea", "Vasea", 3, "Scottish");
        Cat cat3 = new Cat("Valea", "Vasea", 3, "Scottish");
        Set<Cat> set = new HashSet<>();
        set.add(cat1);
        set.add(cat2);
        set.add(cat3);
        System.out.println(cat2.equals(cat3));
        System.out.println(set);
    }
}
