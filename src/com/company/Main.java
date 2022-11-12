package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.get();
        logger.log("Запускаем программу");
        Scanner scanner = new Scanner(System.in);
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.println("Введите размер списка:");
        int listSize = 0;
        while (listSize == 0) {
            try {
                listSize = scanner.nextInt();
            } catch (InputMismatchException ignored) {
                if (ignored != null) {
                    logger.log("Пользователь неправильно ввёл число (размер списка)");
                    scanner.nextLine();
                    logger.log("Повторяем запрос пользователю о размере списка");
                    System.out.println("Вы ошиблись! Введите правильный размер списка");
                }
            }
        }
        System.out.println("Введите верхнюю границу для значений списка:");
        int maxBorder = 0;
        while (maxBorder == 0) {
            try {
                maxBorder = scanner.nextInt();
            } catch (InputMismatchException ignored) {
                if (ignored != null) {
                    logger.log("Пользователь неправильно ввёл число (верхнюю границу списка)");
                    scanner.nextLine();
                    logger.log("Повторяем запрос пользователю о верхней границе списка");
                    System.out.println("Вы ошиблись! Введите правильную верхнюю границу списка");
                }
            }
        }
        Random random = new Random();
        logger.log("Создаём и заполняем список ");
        List myList = new ArrayList();
        for (int i = 0; i < listSize; i++) {
            myList.add(random.nextInt(maxBorder));
        }
        System.out.println("Вот такой получился список: \n" + myList);
        logger.log("Просим пользователя ввести данные для фильтрации");
        System.out.println("Введите порог для фильтра:");
        int filterBorder = -1;
        while (filterBorder == -1) {
            try {
                filterBorder = scanner.nextInt();
            } catch (InputMismatchException ignored) {
                if (ignored != null) {
                    logger.log("Пользователь неправильно ввёл число (порог для фильтра)");
                    scanner.nextLine();
                    logger.log("Повторяем запрос пользователю о пороге для фильтра");
                    System.out.println("Вы ошиблись! Введите число (порог для фильтра)");
                }
            }
        }
        Filter filter = new Filter(filterBorder);
        System.out.println("Отфильтрованный список: " + filter.filterOut(myList));
        // System.out.println(logger.getListLog());
    }
}
