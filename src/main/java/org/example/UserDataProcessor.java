package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserDataProcessor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные: ");
        String userData = scanner.nextLine();

        String[] userDataArray = userData.split(" ");

        if (userDataArray.length != 6) {
            System.out.println("Ошибка: Неверное количество данных. Введите Фамилию Имя Отчество дата рождения номер телефона пол");
            return;
        }

        String surname = userDataArray[0];
        String name = userDataArray[1];
        String patronymic = userDataArray[2];
        String birthDate = userDataArray[3];
        String phoneNumber = userDataArray[4];
        String gender = userDataArray[5];

        try {

            File file = new File(surname + ".txt");
            FileWriter writer = new FileWriter(file);
            writer.write(surname + name + patronymic + birthDate + " " + phoneNumber + gender);
            writer.close();
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: Недостаточно данных для обработки. Введите Фамилию Имя Отчество дата рождения номер телефона пол");
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Неверный формат числа. Проверьте правильность ввода номера телефона или даты рождения");
        } catch (Exception e) {
            System.out.println("Произошла неизвестная ошибка: " + e.getMessage());
        }
    }
}
