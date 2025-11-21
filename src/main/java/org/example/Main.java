package org.example;

import org.example.convertor.Length_convertor;
import org.example.convertor.Money_Convertor;
import org.example.convertor.Temp_convertor;
import org.example.convertor.Weight_convertor;
import org.example.data_convertor.DataComputingObj;
import org.example.data_convertor.Data_to_convert;
import org.example.interfaces.Convertor;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileAttribute;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("Что хотите сделать: загрузить, удалить, перевести?");
            String str = input.nextLine();
            switch (str) {
                case "загрузить": {
                    DataComputingObj.loadComputing();
                    break;
                }
                case "удалить": {
                    DataComputingObj.cleanComputing();
                    break;
                }
                case "перевести": {
                    convert(input);
                    break;
                }
            }

            System.out.println("Продолжим?");
            String not_pause = input.nextLine();
            if (!not_pause.equalsIgnoreCase("да")) {
                flag = false;
            }
        }


        input.close();
    }

    private static void convert(Scanner input) {
        try {
            ArrayList<String> computing = new ArrayList<>();
            LocalDateTime currentDateTime = LocalDateTime.now();

            boolean flag = true;
            while (flag) {
                System.out.println("Что хотите перевести: вес, длина, темп, валюта, история?");
                String str = input.nextLine();
                switch (str) {
                    case "вес": {
                        Convertor convertor = new Weight_convertor(dataObj(input));
                        computing.add("Тип: вес. Дата: " + currentDateTime + ". Вычисления: " + convertor.convert());
                        System.out.println(computing.getLast());
                        break;
                    }
                    case "длина": {
                        Convertor convertor = new Length_convertor(dataObj(input));
                        computing.add("Тип: длина. Дата: " + currentDateTime + ". Вычисления: " + convertor.convert());
                        System.out.println(computing.getLast());
                        break;
                    }
                    case "темп": {
                        Convertor convertor = new Temp_convertor(dataObj(input));
                        computing.add("Тип: темп. Дата: " + currentDateTime + ". Вычисления: " + convertor.convert());
                        System.out.println(computing.getLast());
                        break;
                    }
                    case "валюта": {
                        checkApiFile(input);
                        Convertor convertor = new Money_Convertor(dataObj(input));
                        computing.add("Тип: валюта. Дата: " + currentDateTime + ". Вычисления: " + convertor.convert());
                        System.out.println(computing.getLast());
                        break;
                    }
                    default:
                        System.out.println("Введите корректно!");
                        break;

                }

                System.out.println("Продолжим?");
                String not_pause = input.nextLine();
                if (!not_pause.equalsIgnoreCase("да")) {
                    flag = false;
                }

            }

            System.out.println("Сохранить данные?");
            String not_pause = input.nextLine();
            if (not_pause.equalsIgnoreCase("да")) {
                DataComputingObj dataComputingObj = new DataComputingObj(computing);
                dataComputingObj.saveComputing();
            }
        } catch (Exception e) {
            System.out.println("Ошибка выполнения программы: " + e.getMessage());
        }

    }

    private static void checkApiFile(Scanner input) {
        try {
            Path pathToApi = Path.of(".\\data_res\\api_key.txt");
            if (!Files.exists(pathToApi, LinkOption.NOFOLLOW_LINKS)) {
                Files.createFile(pathToApi);
                System.out.println("Введите свой api ключ с сайта: https://app.currencyapi.com/");
                String in = input.nextLine();
                Files.writeString(pathToApi, in);
            }
        } catch (Exception e) {
            System.out.println("Ошибка создания ApiFile: " + e.getMessage());
        }

    }

    private static Data_to_convert dataObj(Scanner input) {
        System.out.println("Введите единицы измерения 'откуда куда': ");
        String to_convert_to = input.nextLine();
        System.out.println("Введите число: ");
        String number = input.nextLine();

        return new Data_to_convert(to_convert_to, Integer.parseInt(number));
    }

}