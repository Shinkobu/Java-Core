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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeBytes {

    public static void main(String[] args) {
        try {
            SaveBytes(new int[]{1, 2, 3, 0, 2, 1, 3, 0, 0});
//            SaveBytes(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3});
//            SaveBytes(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

    /**
     * Основной метод, вызывает внутри encode и decode. Записывает закодированные значения в файл и считывает их
     * @param data
     * @throws IOException
     */
    public static void SaveBytes(int[] data) throws IOException {

        System.out.println("Исходый массив данных: " + Arrays.toString(data));

        Byte[] myData = encode(data).toArray(new Byte[3]);
        System.out.println("Данные закодированы в byte массив: " + Arrays.toString(myData));

        File myFile = new File("./threeBytesFile.txt");
        myFile.createNewFile();
        System.out.println("Создан файл для выгрузки "  + myFile.getPath());

        try (FileOutputStream fileOutputStream = new FileOutputStream(myFile)) {
            for (Byte b : myData) {
                fileOutputStream.write(b);
            }
            System.out.println("Данные записаны в файл " + myFile.getPath());

        }

        try (FileInputStream fileInputStream = new FileInputStream(myFile)) {
            byte[] outputData = new byte[3];
            fileInputStream.read(outputData, 0, myData.length);
            System.out.println("Читаю данные из файла: " + Arrays.toString(outputData));
            System.out.println("Данные декодированы: " + Arrays.toString(decode(outputData)));
        }

    }

    /**
     * Кодирует числа из 4-ричной системы счисления в 10-ричную
     * @param data
     * @return на выходе имеем список из значений типа Byte
     */
    public static List<Byte> encode(int[] data) {
        if (!(data.length == 9)) throw new RuntimeException("Неверная длина входного массива!");

        List<Byte> fourDigitNumbersList = new ArrayList<>();
        int temp = 0;
        byte counter = 3;
        for (int i = 0; i < data.length; i++) {
            counter--;
            temp += data[i] * Math.pow(10, counter);

            if (counter == 0) {
//                System.out.println(temp);
//              конвертация из 4 ричной в 10 ричную систему счисления, чтобы впихнуть значение в тип данных byte
                BigInteger a = new BigInteger(String.valueOf(temp), 4);
                String s = a.toString(10);
                //        BigInteger b = new BigInteger(s,2);
                Byte b = Byte.valueOf(s);
//                System.out.println(b);
                fourDigitNumbersList.add(b);
                counter = 3;
                temp = 0;
            }

        }
//        System.out.println(fourDigitNumbersList);
        return fourDigitNumbersList;
    }

    /**
     * Декодирует числа из 10-ричной системы счисления в 4-ричную
     * @param data
     * @return
     */
    public static int[] decode(byte[] data) {
        if (!(data.length == 3)) throw new RuntimeException("Неверная длина входного массива!");

        int[] outputArray = new int[9];
        int temp = 0;
        for (int i = 0; i < data.length; i++) {
//            counter--;
            temp = data[i];
//          декодирование из 10-ричной в 4-ричную
            BigInteger a = new BigInteger(String.valueOf(temp), 10);
            String s = a.toString(4);
            int b = Integer.parseInt(s);
//            System.out.println(b);
            for (int j = 2; j >= 0; j--) {
                outputArray[j + 3 * i] = b % 10;
                b = b / 10;
//                System.out.println(Arrays.toString(outputArray));

            }
        }
        return outputArray;
    }


}