package ru.geekbrains.lesson5;

import java.io.File;
import java.io.IOException;

public class ThreeBytes {
    public static void SaveBytes() throws IOException {
        File myFile = new File("./file.txt");
        myFile.createNewFile();

    }
}
