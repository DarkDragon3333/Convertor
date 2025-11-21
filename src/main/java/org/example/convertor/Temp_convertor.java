package org.example.convertor;

import org.example.data_convertor.Data_to_convert;
import org.example.interfaces.Convertor;

public class Temp_convertor extends SupConvertor implements Convertor {
    public Temp_convertor(Data_to_convert dataToConvert) {
        super(dataToConvert);
    }

    @Override
    public String convert() {
        int number = super.dataToConvert.enterNumber();
        String to_convert_to = super.dataToConvert.to_convert_to();
        String result = "";
        switch (to_convert_to){
            case "с в ф": {
                var count = (number * 9.0 / 5.0) + 32;
                result = count + " с в ф";
                break;
            }
            case "ф в с": {
                var count = (number - 32) * 5.0 / 9.0;
                result = count + " ф в с";
                break;
            }
            default:
                System.out.println("Введите корректные символы");
                break;
        }
        return result;
    }
}
