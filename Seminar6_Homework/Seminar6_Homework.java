package Seminar6_Homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Seminar6_Homework {
    public static void main(String[] args) {
        // Подумать над структурой класса Ноутбук для магазина техники - выделить поля и
        // методы. Реализовать в java.
        // Создать множество ноутбуков.
        // Написать метод, который будет запрашивать у пользователя критерий (или
        // критерии)
        // фильтрации и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно
        // хранить в Map. Например:
        // “Введите цифру, соответствующую необходимому критерию:
        // 1 - ОЗУ
        // 2 - Объем ЖД
        // 3 - Операционная система
        // 4 - Цвет …
        // Далее нужно запросить минимальные значения для указанных критериев -
        // сохранить
        // параметры фильтрации можно также в Map.
        // Отфильтровать ноутбуки их первоначального множества и вывести проходящие по
        // условиям

        Set<Laptops> set = new HashSet<>();
        set.add(new Laptops("Model1", 8, 256, "Windows", "Gray"));
        set.add(new Laptops("Model2", 8, 256, "Windows", "Gray"));
        set.add(new Laptops("Model3", 16, 512, "MacOS", "Space Gray"));
        set.add(new Laptops("Model4", 16, 1000, "MacOS", "Golden"));
        set.add(new Laptops("Model5", 4, 256, "Lenovo", "Black"));

        displayAndFilterLaptop(set);

    }

    static void displayAndFilterLaptop(Set<Laptops> laptops) {
        Scanner scanner = new Scanner(System.in);

        try {
            boolean flag = true;
            Map<String, Object> map = new HashMap<>();

            while (flag) {

                System.out.println("\nВведите цифру, соответствующую необходимому критерию:\n" +
                        " 1 - ОЗУ\r\n" +
                        " 2 - Объем ЖД\r\n" +
                        " 3 - Операционная система\r\n" +
                        " 4 - Цвет\r\n" +
                        " 5 - Показать все модели\r\n" +
                        " 6 - Выход");
                System.out.print("Введите критерий: ");
                
                if (scanner.hasNextInt()) {

                    int choice = scanner.nextInt();
                    map.clear();
                    if (choice == 6) {
                        System.out.println("Ну пока :(");
                        flag = false;
                    } else {
                        switch (choice) {
                            case 1:
                                System.out.println("Введите значение ОЗУ (в GB):");
                                int minRAM = scanner.nextInt();
                                map.put("ram", minRAM);
                                break;
                            case 2:
                                System.out.println("Введите объем жесткого диска (в GB): ");
                                int minStorage = scanner.nextInt();
                                map.put("storage", minStorage);
                                break;
                            case 3:
                                System.out
                                        .println("Введите операционную систему (например \"Windows\" - без ковычек): ");
                                String os = scanner.next();
                                map.put("os", os);
                                break;
                            case 4:
                                System.out.println("Введите цвет вашего ноутбука: ");
                                String color = scanner.next();
                                map.put("color", color);
                                break;
                            case 5:

                                break;

                            default:
                                System.out.println("неккоректный ввод :(");
                                return;
                        }
                        laptops.stream()
                                .filter(laptop -> meetsChoice(laptop, map))
                                .forEach(Laptops::displayInfo);
                    }
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите цифру.");
                    scanner.next(); 
                }
            }
        } finally {
            scanner.close();
        }
    }

    static boolean meetsChoice(Laptops laptop, Map<String, Object> map) {
        return map.entrySet().stream()
                .allMatch(entry -> {
                    String key = entry.getKey();
                    Object value = entry.getValue();

                    switch (key) {
                        case "ram":
                            return laptop.getRam() >= (int) value;
                        case "storage":
                            return laptop.getStorage() >= (int) value;
                        case "os":
                            return laptop.getOs().equalsIgnoreCase((String) value);
                        case "color":
                            return laptop.getColor().equalsIgnoreCase((String) value);
                        default:
                            return false;
                    }
                });
    }
}