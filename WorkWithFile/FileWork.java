package WorkWithFile;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Класс для для работы с файлами
 */
public class FileWork
{
    /**
     * Метод для обрадотки файлов на чтение/запись
     * @param fileNameIn - имя файла на чтение
     * @param fileNameOut - имя файла на запись
     */
    public void Processing(String fileNameIn, String fileNameOut)
    {
        int upperCase = 0, lowerCase = 0;
        try (BufferedReader fileForRead = new BufferedReader(new FileReader(fileNameIn)))
        {
            try(BufferedWriter fileWrite = new BufferedWriter(new FileWriter(fileNameOut)))
            {
                String line;
                char[] arrLine;
                Map<Character, Integer> letters = new HashMap<Character, Integer>();
                while ((line = fileForRead.readLine()) != null) {
                    arrLine = line.toCharArray();
                    for (char symbol : arrLine)
                    {
                        if (symbol >= 'A' && symbol <= 'Z')
                        {
                            upperCase++;
                        }
                        else if (symbol >= 'a' && symbol <= 'z')
                        {
                            lowerCase++;
                        }

                        if ((symbol >= 'a' && symbol <= 'z') || (symbol >= 'A' && symbol <= 'Z'))
                        {
                            if (!letters.containsKey(symbol))
                            {
                                letters.put(symbol, 1);
                            }
                            else
                            {
                                letters.replace(symbol, letters.get(symbol) + 1);
                            }
                        }
                    }
                }
                fileWrite.write("Количество английских символов в верхнем регистре = " + upperCase + "\n");
                fileWrite.write("Количество английских символов в нижнем регистре = " + lowerCase + "\n\n");

                fileWrite.write("Количество вхождений различных английских букв:" + "\n\n");

                for (Map.Entry<Character, Integer> item:letters.entrySet())
                {
                    fileWrite.write(" " + item.getKey() + " = " + item.getValue() + "\n\n");
                }
            }
            catch (IOException e)
            {
                System.out.println("Ошибка при работе с файлом!");
            }
        }
        catch (FileNotFoundException fe)
        {
            System.out.println("Ошибка, файл не найден!");
        }
        catch (IOException e)
        {
            System.out.println("Ошибка при работе с файлом!");
        }
    }
}
