package org.example.convertor;

import org.example.api.GetRequestMoney;
import org.example.data_convertor.Data_to_convert;
import org.example.interfaces.Convertor;

import java.io.IOException;
import java.util.ArrayList;

public class Money_Convertor extends SupConvertor implements Convertor {

    public Money_Convertor(Data_to_convert dataToConvert) {
        super(dataToConvert);
    }

    @Override
    public String convert() throws IOException, InterruptedException {
        int number = super.dataToConvert.getNumber();
        ArrayList<String> to_convert_to = parseConvertTypes(super.dataToConvert.getStr());
        String result;

        GetRequestMoney getRequestMoney = new GetRequestMoney();
        result = getRequestMoney.HttpRequest(to_convert_to.getFirst(), to_convert_to.getLast());

        return String.valueOf(Double.parseDouble(parseJsonAnswer(result)) * number);
    }

    private static String parseJsonAnswer(String json){
        StringBuilder result = new StringBuilder();
        for (int i = json.length() - 1; i != 0; i--){
            if (json.charAt(i) == ':'){
                return result.toString();
            }
            char ch = json.charAt(i);
            if (Character.isDigit(ch) || ch =='.'){
                result.insert(0, ch);
            }
        }
        return result.toString();
    }

    private static ArrayList<String> parseConvertTypes(String convertTypes){
        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add(convertTypes.substring(0, 3).toUpperCase());
        stringArrayList.add(convertTypes.substring((convertTypes.length() - 3)).toUpperCase());

        return stringArrayList;
    }
}
