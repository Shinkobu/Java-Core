package ru.geekbrains.lesson2;

/*
2. Переработать метод проверки победы, логика проверки победы должна работать для поля 5х5 и
количества фишек 4. Очень желательно не делать это просто набором условий для каждой из
возможных ситуаций! Используйте вспомогательные методы, используйте циклы!

3. Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.

*/

import java.util.Random;
import java.util.Scanner;

public class Program {


    private static final int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '•';

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field; // Двумерный массив хранит текущее состояние игрового поля
    private static int fieldSizeX; // Размерность игрового поля
    private static int fieldSizeY; // Размерность игрового поля


    public static void main(String[] args) {
        while (true) {
            initialize();
            printField();
            while (true) {
                int[] tempArr = new int[2];
                tempArr = humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "Вы победили!", tempArr))
                    break;
                tempArr = aiTurn();
                printField();
                if (gameCheck(DOT_AI, "Компьютер победил!", tempArr))
                    break;
            }
            System.out.println("Желаете сыграть еще раз? (Y - да)");
            if (!SCANNER.next().equalsIgnoreCase("Y"))
                break;
        }
    }

    /**
     * Инициализация игрового поля
     */
    private static void initialize() {
        // Установим размерность игрового поля
        fieldSizeX = 5;
        fieldSizeY = 5;


        field = new char[fieldSizeX][fieldSizeY];
        // Пройдем по всем элементам массива
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                // Проинициализируем все элементы массива DOT_EMPTY (признак пустого поля)
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     * //TODO: Поправить отрисовку игрового поля
     */
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);
        }
        System.out.println();

        for (int i = 0; i < fieldSizeX; i++) {
            System.out.print(i + 1 + "|");

            for (int j = 0; j < fieldSizeY; j++)
                System.out.print(field[i][j] + "|");

            System.out.println();
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();

    }

    /**
     * Обработка хода игрока (человек)
     */
    private static int[] humanTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты хода X и Y (от 1 до 3) через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
        return new int[]{x, y};
    }

    /**
     * Проверка, ячейка является пустой
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность массива, игрового поля)
     *
     * @param x
     * @param y
     * @return
     */
    static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    /**
     * Ход компьютера
     */
    private static int[] aiTurn() {
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        field[x][y] = DOT_AI;
        return new int[]{x, y};

    }

    /**
     * Проверка победы
     * TODO: Переработать метод в домашнем задании
     *
     * @param c
     * @return
     */
    static boolean checkWin(char c, int[] tempArr) {

        int x = tempArr[0];
        int y = tempArr[1];

        int j;

        // проверка по 8 сторонам

        if (    eightWaysCheck(c,x,y,0,1) ||
                eightWaysCheck(c,x,y,1,1) ||
                eightWaysCheck(c,x,y,1,0) ||
                eightWaysCheck(c,x,y,1,-1) ||
                eightWaysCheck(c,x,y,0,-1) ||
                eightWaysCheck(c,x,y,-1,-1) ||
                eightWaysCheck(c,x,y,-1,0) ||
                eightWaysCheck(c,x,y,-1,1)){
            return true;
        }

        return false;
}

    static boolean eightWaysCheck(char c, int x, int y, int xi, int yi) {
        int j = 0;
        for (int i = 0; i < WIN_COUNT; i++) {
            if (!isCellValid(x + i * xi, y + i * yi) || !(field[x + i * xi][y + i * yi] == c)) {
                return false;
            } else j++;
            if (j == WIN_COUNT) return true;
        }
        return false;
    }

    /**
     * Проверка на ничью
     *
     * @return
     */
    static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++)
                if (isCellEmpty(x, y)) return false;
        }
        return true;
    }

    /**
     * Метод проверки состояния игры
     *
     * @param c
     * @param str
     * @return
     */
    static boolean gameCheck(char c, String str, int[] tempArr) {
        if (checkWin(c, tempArr)) {
            System.out.println(str);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }

        return false; // Игра продолжается
    }

}
