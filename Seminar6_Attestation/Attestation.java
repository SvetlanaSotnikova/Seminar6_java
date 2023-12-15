package Seminar6_Attestation;

import java.util.Scanner;

public class Attestation {
    // Реализуйте структуру телефонной книги с помощью HashMap.
    // Программа также должна учитывать, что в во входной структуре будут
    // повторяющиеся имена с разными телефонами, их необходимо считать, как одного
    // человека с разными телефонами. Вывод должен быть отсортирован по убыванию
    // числа телефонов.

    public static void main(String[] args) {
        
        // признаюсь, программа не работает с русским языком
        Phonebook phonebook = new Phonebook();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Заплните телефонную книгу :D");
        System.out.println("Для завершения программы введите \"\\\" и два раза нажмите enter 2 раза");
        try {

            boolean whileFlag = true;
            while (whileFlag) {

                System.out.print("Введите ФИ: ");
                String name = scanner.nextLine().trim();

                System.out.print("Введите номер телефона: ");
                String phoneNumber = scanner.nextLine().trim();
                
                if (("\\".equals(name) || "\\".equals(phoneNumber))) {
                    whileFlag = false;
                    break;
                } else {
                    phonebook.add(phoneNumber, name);
                }
                
            }
            System.out.println("Ваша телефонная книга: ");
            System.out.println(phonebook.getAll());

            System.out.println("Теперь вы можете выбрать тип поиска");
            boolean swithFlag = true;

            while (swithFlag) {
                System.out.println("Выберите критерий поиска:\r\n" +
                        "1 - Поиск по имени\r\n" +
                        "2 - Поиск по номеру телефона\r\n" +
                        "3 - Выход");
                System.out.print("Введите критерий: ");

                if (scanner.hasNextInt()) {
                    int choice = scanner.nextInt();
                    if (choice == 3) { // почему бы и нет
                        System.out.println("Ну пока :(");
                        swithFlag = false;
                    } else {
                        switch (choice) {
                            case 1:
                                scanner.nextLine(); // я не знаю как по другому буфер очистить
                                System.out.print("\nВведите имя: ");
                                String FindName = scanner.nextLine().trim();
                                System.out.println(phonebook.getByLastName(FindName));
                                break;
                            case 2:
                                scanner.nextLine();
                                System.out.print("Введите номер телефона: ");
                                String FindPhone = scanner.nextLine().trim();
                                System.out.println(phonebook.getByPhoneNumber(FindPhone));
                                break;
                            case 3: // нууу мало ли доп. баги будут
                                break;

                            default:
                                System.out.println("неккоректный ввод :(");
                                return;
                        }
                    }
                } else {
                    System.out.println("Некорректный ввод. Пожалуйста, введите цифру.");
                    scanner.nextLine(); 
                }
            }
        } catch (Exception e) {
            System.out.println("о нет, что-то пошло не так");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
