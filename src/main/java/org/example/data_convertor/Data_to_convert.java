package org.example.data_convertor;

public class Data_to_convert {
    private int number = 0;
    private String str = "";


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Data_to_convert(String str, int number) {
        this.str = str;
        this.number = number;
    }

}
