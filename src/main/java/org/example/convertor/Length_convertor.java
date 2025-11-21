package org.example.convertor;

import org.example.data_convertor.Data_to_convert;
import org.example.interfaces.Convertor;

public class Length_convertor extends SupConvertor implements Convertor {

    public Length_convertor(Data_to_convert dataToConvert) {
        super(dataToConvert);
    }

    @Override
    public String convert() {
        int number = super.dataToConvert.enterNumber();
        String to_convert_to = super.dataToConvert.to_convert_to();
        String result = "";

        switch (to_convert_to) {
            case "мм в см": {
                var count = number / 10.0;
                result = count + " мм в см";
                break;
            }
            case "см в м": {
                var count = number / 100;
                result = count + " см в м";
                break;
            }
            case "м в км": {
                var count = number / 1000;
                result = count + " м в км";
                break;
            }
            case "км в м": {
                var count = number * 1000;
                result = count + " км в м";
                break;
            }
            case "м в см": {
                var count = number * 100;
                result = count + " м в см";
                break;
            }
            case "см в мм": {
                var count = number * 10;
                result = count + " см в мм";
                break;
            }
            default:
                System.out.println("Введите корректные символы");
                break;
        }

        return result;
    }
}
