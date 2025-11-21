package org.example.data_convertor;

import java.nio.file.*;
import java.util.ArrayList;

public class DataComputingObj {
    private final ArrayList<String> computing;

    public DataComputingObj(ArrayList<String> computing) {
        this.computing = computing;
    }

    public static void loadComputing() {
        try {
            if (Files.exists(pathToComputingFile(), LinkOption.NOFOLLOW_LINKS)) {
                for (var line : Files.readAllLines(pathToComputingFile())) {
                    System.out.println(line);
                }
            }
        } catch (Exception e) {
            System.err.println("Ошибка загрузки файла: " + e.getMessage());
        }
    }

    public void saveComputing() {
        Path path = Path.of(".\\data_res\\Computing.txt");

        try {
            for (var data : computing) {
                Files.writeString(path, data + "\n", StandardOpenOption.APPEND);
            }
            System.out.println("Данные успешно сохранены");

        } catch (Exception e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static void cleanComputing() {
        try {
            if (Files.exists(pathToComputingFile(), LinkOption.NOFOLLOW_LINKS)) {
                Files.delete(pathToComputingFile());
            }
        } catch (Exception e) {
            System.err.println("Ошибка удаления файла: " + e.getMessage());
        }

    }

    private static Path pathToComputingFile() {
        return Paths.get(".\\data_res\\", "Computing.txt");
    }
}
