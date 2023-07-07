package ru.geekbrains.lesson5;

import java.io.File;

public class Tree {

    /**
     * DONE: Доработать метод print, необходимо распечатывать директории и файлы -
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast){
        System.out.print(indent); // рисуем отступ
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());
// создаётся массив files состоящий из файлов/папок внутри целевого каталога
        File[] files = file.listFiles();
        if (files == null)
            return;
// счётчик считает подкаталоги
        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++){
//           if (files[i].isDirectory())
               subDirTotal++;
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++){
//            if (files[i].isDirectory()){
                print(files[i], indent, subDirCounter  == subDirTotal - 1);
                subDirCounter++;
//            }
        }


    }

}
