package org.example.convertor;

import org.example.data_convertor.Data_to_convert;
import org.example.interfaces.Convertor;

public class Length_convertor extends SupConvertor implements Convertor{

    public Length_convertor(Data_to_convert dataToConvert) {
        super(dataToConvert);
    }

    @Override
    public String convert() {
        int number = super.dataToConvert.getNumber();
        String to_convert_to = super.dataToConvert.getStr();
        String result = "";

        switch (to_convert_to){
            case "мм в см": {
                var count = number / 10.0;
                result = String.valueOf(count);
                break;
            }
            case "см в м": {
                var count = number / 100;
                result = String.valueOf(count);
                break;
            }
            case "м в км": {
                var count = number / 1000;
                result = String.valueOf(count);
                break;
            }
            case "км в м": {
                var count = number * 1000;
                result = String.valueOf(count);
                break;
            }
            case "м в см": {
                var count = number * 100;
                result = String.valueOf(count);
                break;
            }
            case "см в мм": {
                var count = number * 10;
                result = String.valueOf(count);
                break;
            }
            default:
                System.out.println("Введите корректные символы");
                break;
        }

        return result;
    }
}
