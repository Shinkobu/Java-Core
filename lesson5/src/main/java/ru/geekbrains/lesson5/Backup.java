package ru.geekbrains.lesson5;

//1. Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий)
// во вновь созданную папку ./backup

import java.io.*;


public class Backup {

    /**
     * Создает бэкап получаемой папки
     *
     * @param fileToBackup Папка, которая бэкапится
     * @throws IOException Проблема при предварительном удалении уже существующего бэкапа
     */
    public static void backup(File fileToBackup) throws IOException {

        File backupDir = new File("backup");
        if (!backupDir.exists()) {
            backupDir.mkdirs();
        } else {
            try {
                delete(backupDir);
//                System.out.println("Папка была удалена !");
            } catch (IOException e) {
                System.out.println("Проблема при удалении папки : " + backupDir.getPath());
                e.printStackTrace();
            }
            backupDir.mkdirs();
        }

        for (File targetFile : fileToBackup.listFiles()) {
            try {
                copyFileUsingStream(targetFile, new File(backupDir, targetFile.getName()));
            }catch (NullPointerException exception){
                System.out.println("Директория пуста, backup не сделан");
            }

        }
    }


    /**
     * Delete a file or a directory and its children.
     *
     * @param file The directory to delete.
     * @throws IOException Exception when problem occurs during deleting the directory.
     */
    private static void delete(File file) throws IOException {

        for (File childFile : file.listFiles()) {

            if (childFile.isDirectory()) {
                delete(childFile);
            } else {
                if (!childFile.delete()) {
                    throw new IOException();
                }
            }
        }
        if (!file.delete()) {
            throw new IOException();
        }
    }

    /**
     * Копирует содержание файла
     *
     * @param source файл-источник
     * @param dest файл-назначение
     * @throws IOException
     */
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }
}

