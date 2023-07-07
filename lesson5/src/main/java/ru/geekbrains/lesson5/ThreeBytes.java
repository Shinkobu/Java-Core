/*
3***. Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3],
и представляют собой, например, состояния ячеек поля для игры в крестикинолики, где
0 – это пустое поле,
1 – это поле с крестиком,
2 – это поле с ноликом,
3 – резервное значение.

Такое предположение позволит хранить в одном числе типа int всё поле 3х3.
Записать в файл 9 значений так, чтобы они заняли три байта
 */

package ru.geekbrains.lesson5;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeBytes {

    public static void main(String[] args) {
        try {
//            SaveBytes(new int[]{1, 2, 3, 0, 2, 1, 3, 0, 0});
//            SaveBytes(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3});
            SaveBytes(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    public static void SaveBytes(int[] data) throws IOException {

        File myFile = new File("./threeBytesFile.txt");
        myFile.createNewFile();


        Byte[] mydata = convert(data).toArray(new Byte[3]);
        System.out.println(Arrays.toString(mydata));

        try (FileOutputStream fileOutputStream = new FileOutputStream(myFile)) {
            for (Byte b: mydata) {
                fileOutputStream.write(b);
            }

        }



//        File inputFile = new File(filePath);
//        byte[] data = new byte[inputFile.length()];
//        FileInputStream fis = new FileInputStream(inputFile);
//        fis.read(data, 0, data.length);
//        fis.close();
    }

    public static List<Byte> convert(int[] data) {
        if (!(data.length == 9)) throw new RuntimeException("Неверная длина входного массива!");

        List<Byte> fourDigitNumbersList = new ArrayList<>();
        int temp = 0;
        byte counter = 3;
        for (int i = 0; i < data.length; i++) {
            counter--;
            temp += data[i] * Math.pow(10, counter);

            if (counter == 0) {
                System.out.println(temp);

                BigInteger a = new BigInteger(String.valueOf(temp), 4);
                String s = a.toString(10);
                //        BigInteger b = new BigInteger(s,2);
                Byte b = Byte.valueOf(s);
                System.out.println(b);
                fourDigitNumbersList.add(b);
                counter = 3;
                temp = 0;
            }

        }
        System.out.println(fourDigitNumbersList);
        return fourDigitNumbersList;
    }
}
