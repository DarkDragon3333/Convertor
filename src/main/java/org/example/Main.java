package org.example;

import org.example.convertor.Length_convertor;
import org.example.convertor.Temp_convertor;
import org.example.convertor.Weight_convertor;
import org.example.data_convertor.Data_to_convert;
import org.example.interfaces.Convertor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Что хотите перевести: вес, длина, темп?");
            String str = input.nextLine();
            switch (str) {
                case "вес": {
                    Convertor convertor = new Weight_convertor(dataObj(input));
                    System.out.println(convertor.convert());
                    break;
                }
                case "длина": {
                    Convertor convertor = new Length_convertor(dataObj(input));
                    System.out.println(convertor.convert());
                    break;
                }
                case "темп": {
                    Convertor convertor = new Temp_convertor(dataObj(input));
                    System.out.println(convertor.convert());
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
        input.close();
    }

    private static Data_to_convert dataObj(Scanner input) {
        System.out.println("Введите единицы измерения 'откуда куда': ");
        String to_convert_to = input.nextLine();
        System.out.println("Введите число: ");
        String number = input.nextLine();

        return new Data_to_convert(to_convert_to, Integer.parseInt(number));
    }

}