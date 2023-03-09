package WorkWithFile;

import java.util.Scanner;
import WorkWithFile.FileWork;

/**
 * Класс main
 */
public class Main {
    /**
     * Создаём объект scanner
     */
    private static Scanner str = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Введите имя файла для чтения информации!");
        String fileNameIn = str.next();

        System.out.println("Введите имя файла для записи информации!");
        String fileNameOut = str.next();

        FileWork elem = new FileWork();
        elem.Processing(fileNameIn, fileNameOut);
    }
}