package org.example.convertor;

import org.example.data_convertor.Data_to_convert;
import org.example.interfaces.Convertor;

public class Weight_convertor extends SupConvertor implements Convertor {
    public Weight_convertor(Data_to_convert dataToConvert) {
        super(dataToConvert);
    }

    @Override
    public String convert() {
        int number = super.dataToConvert.getNumber();
        String to_convert_to = super.dataToConvert.getStr();
        String result = "";

        switch (to_convert_to){
            case "гр в кг": {
                var count = number / 10.0;
                result = String.valueOf(count);
                break;
            }
            case "кг в ц": {
                var count = number / 100;
                result = String.valueOf(count);
                break;
            }
            case "ц в т": {
                var count = number / 1000;
                result = String.valueOf(count);
                break;
            }
            case "т в ц": {
                var count = number * 1000;
                result = String.valueOf(count);
                break;
            }
            case "ц в кг": {
                var count = number * 100;
                result = String.valueOf(count);
                break;
            }
            case "кг в гр": {
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
