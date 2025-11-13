package org.example.data_convertor;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class ConvertorsComputing {
    private final ArrayList<String> computing = new ArrayList<>();

    public void saveComputing(final ArrayList<String> computing) {
        this.computing.addAll(computing);

        String name_provider =
                "C:\\Users\\darkd\\IdeaProjects\\Convertor\\src\\main\\java\\org\\example\\data_convertor\\";
        String name_file = "Computing.txt";
        String path = name_provider + name_file;
        Path pathToFile = Paths.get(path);

        try {
            Files.writeString(pathToFile, this.computing + "\n", StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        } catch (Exception e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }

    }

    public void cleanComputing() {

    }
}
