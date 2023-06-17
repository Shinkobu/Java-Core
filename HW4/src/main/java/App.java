/*
Задача 1:


1 Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4. При
подаче массива другого размера необходимо бросить исключение MyArraySizeException.
2 Далее метод должен пройтись по всем элементам массива, преобразовать в int и
просуммировать. Если в каком-то элементе массива преобразование не удалось (например, в
ячейке лежит символ или текст вместо числа), должно быть брошено исключение
MyArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
3 В методе main() вызвать полученный метод, обработать возможные исключения
MyArraySizeException и MyArrayDataException и вывести результат расчета.
*/

import java.text.ParseException;

public class App {
    public static void main(String[] args) {

        String[][] testArray1 = new String[][]{
                {"0", "11", "22", "3"},
                {"0", "11", "22", "3"},
                {"0", "11", "22", "3"},
                {"0", "11", "22", "3"}};

        String[][] testArray2 = new String[][]{
                {"0", "ddd", "2", "3"},
                {"0", "1", "2", "3"},
                {"0", "1", "2", "3"},
        };

        String[][] testArray3 = new String[][]{
                {"0", "ddd", "2", "3"},
                {"0", "1", "2", "3"},
                {"0", "1", "2", "3"},
                {"0", "1", "2", "3"}};

        try {

            myMethod(testArray1);
            myMethod(testArray2);
            myMethod(testArray3);
        } catch (MyArraySizeException | MyArrayDataException exception) {
            exception.printStackTrace();
        }
    }

    public static void myMethod(String[][] someArray) throws MyArraySizeException, MyArrayDataException {
        int j = 0;
        int i = 0;
        try {
            if (!(someArray.length == 4 && someArray[0].length == 4)) {
                throw new MyArraySizeException("Неверная длина массива!");
            } else {
                System.out.println("Получен массив 4*4");

                int summ = 0;
                for (i = 0; i < someArray[0].length; i++) {
                    for (j = 0; j < someArray[1].length; j++) {
                        // проверка на числовое значение
                        char[] tempCharArray = someArray[i][j].toCharArray();
                        for (int c = 0; c < tempCharArray.length; c++) {
                            if (!Character.isDigit(tempCharArray[c])) {
                                throw new MyArrayDataException("Неверные данные в ячейке: " + i + " " + j);
                            }
                        }
                        summ += Integer.parseInt(someArray[i][j]);
                    }
                }
                System.out.println("Сумма элементов массива составляет " + summ);
            }
        } finally {
        }
    }
}

